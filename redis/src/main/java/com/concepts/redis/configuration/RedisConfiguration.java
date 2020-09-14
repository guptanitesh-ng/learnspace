package com.concepts.redis.configuration;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.AbstractCacheResolver;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.StreamMessageListenerContainer.StreamMessageListenerContainerOptions;

import com.concepts.redis.client.RedisStreamListener;
import com.concepts.redis.client.RedisSubscriber;
import com.concepts.redis.properties.ApplicationProperties;

@Configuration
public class RedisConfiguration {

	@Autowired
	private ApplicationProperties applicationProperties;

	@Bean
	public RedisStandaloneConfiguration standaloneConfiguration() {
		String[] hostPort = applicationProperties.getHostsConfig().split(":");
		return new RedisStandaloneConfiguration(hostPort[0], Integer.valueOf(hostPort[1]));
	}

	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory(standaloneConfiguration());
	}

	@Bean
	public RedisCacheConfiguration defaultCacheConfiguration() {
		RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
		return defaultCacheConfig.computePrefixWith(cacheKeyPrefix()).disableCachingNullValues().serializeValuesWith(
				RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	@Bean
	public RedisCacheKeyPrefix cacheKeyPrefix() {
		return new RedisCacheKeyPrefix(applicationProperties.getRealm());
	}

	@Bean
	public KeyGenerator methodNameKeyGenerator() {
		return new KeyGenerator() {

			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuffer keyPrefix = new StringBuffer(method.getName());
				Arrays.asList(params).forEach(e -> keyPrefix.append(":").append(e.toString()));
				return method.getName();
			}
		};
	}

	@Bean
	public CacheResolver dynamicCacheResolver() {
		return new AbstractCacheResolver(cacheManager()) {

			@Override
			protected Collection<String> getCacheNames(CacheOperationInvocationContext<?> context) {
				String simpleName = context.getTarget().getClass().getSimpleName();
				String cacheName = applicationProperties.getDynamicCacheMapping().get(simpleName);
				return Collections.singleton(cacheName);
			}
		};
	}

	@Bean
	public RedisCacheManager cacheManager() {
		RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(connectionFactory());
		builder.cacheDefaults(defaultCacheConfiguration());
		Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
		applicationProperties.getCacheTTLMapping().entrySet().forEach(e -> {
			cacheConfigurations.put(e.getKey(),
					defaultCacheConfiguration().entryTtl(Duration.ofSeconds(Long.valueOf(e.getValue()))));
		});
		builder.withInitialCacheConfigurations(cacheConfigurations);
		return builder.build();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return redisTemplate;
	}

	@Bean
	public MessageListenerAdapter messageListenerAdapter() {
		MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new RedisSubscriber());
		return messageListenerAdapter;
	}

	@Bean
	public Topic channelTopic() {
		return new ChannelTopic("ChannelO");
	}

	@Bean
	public Topic patternTopic() {
		return new PatternTopic("Channel*");
	}

	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer() {
		RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
		redisMessageListenerContainer.setConnectionFactory(connectionFactory());
		redisMessageListenerContainer.addMessageListener(messageListenerAdapter(),
				Collections.singleton(patternTopic()));
		return redisMessageListenerContainer;
	}

	@Bean("streaming")
	public RedisTemplate<String, ?> redisStreamingTemplate() {
		RedisTemplate<String, ?> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return redisTemplate;
	}

	@Bean
	public StreamListener<String, MapRecord<String, String, String>> streamListener() {
		return new RedisStreamListener();
	}

	@Bean
	public StreamMessageListenerContainer<String, MapRecord<String, String, String>> streamListenerContainer() {
		StreamMessageListenerContainerOptions<String, MapRecord<String, String, String>> containerOptions = StreamMessageListenerContainerOptions
				.builder().pollTimeout(Duration.ofMillis(100)).build();
		StreamMessageListenerContainer<String, MapRecord<String, String, String>> container = StreamMessageListenerContainer
				.create(connectionFactory(), containerOptions);
		container.receive(StreamOffset.fromStart("log-stream"), streamListener());
		return container;
	}
}
