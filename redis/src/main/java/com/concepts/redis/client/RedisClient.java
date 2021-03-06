package com.concepts.redis.client;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.connection.stream.StringRecord;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions.ScanOptionsBuilder;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import com.concepts.redis.configuration.RedisCacheKeyPrefix;
import com.concepts.redis.connection.RedisConnectionManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

@Component
public class RedisClient {

	private static final String TRANSACTION_LIST = "transaction_list";

	private static final String WILDCARD = "*";

	private static final String DELIMITER = ":";

	private static final String CURSOR_POS = "0";

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	@Qualifier("streaming")
	private RedisTemplate<String, ?> streamingRedisTemplate;

	@Autowired
	private RedisCacheKeyPrefix cacheKeyPrefix;

	@Autowired
	private RedisConnectionManager redisConnectionManager;

	private JdkSerializationRedisSerializer serializer = new JdkSerializationRedisSerializer();

	@Cacheable(cacheNames = { "cache1", "cache2", "cache3" }, key = "#login", unless = "#result == null")
	public String getCacheValue(String login) {
		System.out.println("Not found in cache");
		return login;
	}

	@CacheEvict("cache2")
	public String evictCacheValue() {
		System.out.println("Cache eviction done.");
		return "Spring Boot Archived";
	}
	
	@CachePut("cache2")
	public String updateCacheValue(String newLogin) {
		return "Spring Boot Current";
	}

	@Cacheable(cacheResolver = "dynamicCacheResolver", keyGenerator = "methodNameKeyGenerator")
	public String tryCustomKeyAndDynamicCache() {
		System.out.println("Not found in custom cache");
		return "Determined cache name dynamically and updated cache using a custom key";
	}

	@Cacheable(cacheNames = "customCache", keyGenerator = "methodNameKeyGenerator")
	public Entity tryCustomSerialization() {
		Entity entity = new Entity();
		entity.setEntityId(1L);
		entity.setName("Serialization Check Entity");
		entity.setLastUpdated(Calendar.getInstance().getTime());
		System.out.println("Not found in custom cache");
		return entity;
	}

	// Interesting finding with serialization leading to duplicate elements with
	// sorted sets in redis.
	public String thinkingRedisSortedSets() {
		ZSetOperations<String, Object> opsForZSet = redisTemplate.opsForZSet();
		Set<TypedTuple<Object>> tuples = new HashSet<>();
		tuples.add(new DefaultTypedTuple<Object>(new Entity(100000, "Big Number"), 0.5));
		tuples.add(new DefaultTypedTuple<Object>(new Entity(10, "Ten"), 1.0));
		tuples.add(new DefaultTypedTuple<Object>(new Entity(20, "Twenty"), 1.0));
		tuples.add(new DefaultTypedTuple<Object>(new Entity(-2, "A negative two"), -1.0));
		tuples.add(new DefaultTypedTuple<Object>(new Entity(0, "The zero"), 0.0));
		opsForZSet.add("entities", tuples);

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode dataNode = mapper.createObjectNode();

		Long count = opsForZSet.count("entities", Double.MIN_VALUE, Double.MAX_VALUE);
		dataNode.put("Positive Score Element Count", count);

		ScanOptionsBuilder optionsBuilder = new ScanOptionsBuilder();
		optionsBuilder.match(WILDCARD);
		Cursor<TypedTuple<Object>> cursor = opsForZSet.scan("entities", optionsBuilder.build());

		final ArrayNode positiveScoresNode = mapper.createArrayNode();
		cursor.forEachRemaining(e -> positiveScoresNode.add(e.getScore() + ":" + e.getValue()));
		dataNode.set("All elements", positiveScoresNode);

		Set<TypedTuple<Object>> rangeTuples = opsForZSet.rangeByScoreWithScores("entities", Double.NEGATIVE_INFINITY,
				Double.MAX_VALUE);
		final ArrayNode orderedScoresNode = mapper.createArrayNode();
		rangeTuples.forEach(e -> orderedScoresNode.add(e.getScore() + ";" + e.getValue()));
		dataNode.set("Ordered scores", orderedScoresNode);

		ObjectNode rootNode = mapper.createObjectNode();
		rootNode.set("data", dataNode);
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	// Interesting finding with hash key and value serializer getting defaulted to
	// JDK serializer causing chaos in the code.
	public Object pipelining() {
		redisTemplate.setHashKeySerializer(RedisSerializer.byteArray());
		redisTemplate.setHashValueSerializer(RedisSerializer.byteArray());
		List<Object> pipelineResponses = redisTemplate.executePipelined(new RedisCallback<Object>() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Map<byte[], byte[]> hashes = new HashMap<>();
				hashes.put("val".getBytes(), "1".getBytes());
				connection.hMSet("pipe".getBytes(), hashes);
				connection.hIncrBy("pipe".getBytes(), "val".getBytes(), 10);
				connection.hMGet("pipe".getBytes(), "val".getBytes());
				return null;
			}

		});

		return pipelineResponses;
	}

	public void publish(Entity entity) {
		redisTemplate.convertAndSend("Channel1", new Entity(29, "published entity"));
		redisTemplate.convertAndSend("Channel1v2", new Entity(100, "published new entity version"));
		redisTemplate.convertAndSend("ChannelO", entity);
	}

	public void appendStream() {
		Map<String, String> logLine = new HashMap<>();
		logLine.put(Calendar.getInstance().getTime().toString(), "A sample log statement.");
		StringRecord record = StreamRecords.string(logLine).withStreamKey("log-stream");
		streamingRedisTemplate.opsForStream().add(record);
	}
	
	public List<Object> handleTransactions() {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		opsForList.trim(TRANSACTION_LIST, 0, 0);
		Entity entity = new Entity(121, "first element");
		opsForList.leftPush(TRANSACTION_LIST, entity);
		
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.watch(TRANSACTION_LIST);
		redisTemplate.multi();
		double pow = Math.pow(entity.getEntityId(), 3);
		opsForList.rightPush(TRANSACTION_LIST, new Entity((long)pow,"cubed element"));
		double log = Math.log(pow);
		opsForList.rightPush(TRANSACTION_LIST, new Entity(Math.round(log),"exponential power of the element"));
		double tan = Math.tan(log);
		opsForList.rightPush(TRANSACTION_LIST, new Entity(Math.round(tan),"tangent computed element"));
		redisTemplate.exec();
		
		return opsForList.range(TRANSACTION_LIST, 1,opsForList.size(TRANSACTION_LIST));
	}

	public Set<String> getKeys(String cacheName) throws Exception {
		return redisTemplate.keys(cacheKeyPrefix.compute(cacheName) + WILDCARD);
	}

	public Map<Object, Object> getEntries(String cacheName, String key) {
		String prefixedKey = cacheKeyPrefix.compute(cacheName) + key;
		return Collections.singletonMap(prefixedKey, redisTemplate.opsForValue().get(prefixedKey));
	}

	public Map<Object, Object> getEntriesUsingJedis(String cache, String key) {
		Map<Object, Object> entries = new HashMap<>();

		JdkSerializationRedisSerializer serializer = new JdkSerializationRedisSerializer();
		byte[] rawKey = serializer.serialize(key);

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		byte[] prefix = stringRedisSerializer.serialize(cache + DELIMITER);

		byte[] prefixedKey = Arrays.copyOf(prefix, prefix.length + rawKey.length);
		System.arraycopy(rawKey, 0, prefixedKey, prefix.length, rawKey.length);

		JedisCluster cluster = getRedisConnectionManager().getRedisCluster();

		if (cluster.exists(prefixedKey)) {
			Object value = serializer.deserialize(cluster.get(prefixedKey));
			entries.put(prefixedKey + DELIMITER + key, value);
			System.out.println(key + "\t" + value);
		} else if (NumberUtils.isCreatable(key)) {
			Number numKey = NumberUtils.createNumber(key);
			rawKey = serializer.serialize(numKey);
			prefixedKey = Arrays.copyOf(prefix, prefix.length + rawKey.length);
			System.arraycopy(rawKey, 0, prefixedKey, prefix.length, rawKey.length);
			if (cluster.exists(prefixedKey)) {
				Object value = serializer.deserialize(cluster.get(prefixedKey));
				entries.put(prefixedKey + DELIMITER + key, value);
				System.out.println(key + "\t" + value);
			} else {
				System.out.println("Could not find key: " + key);
			}
		} else {
			System.out.println("Could not find key: " + key);
		}

		return entries;
	}

	private ScanParams createScanParams(String cache) {
		ScanParams params = new ScanParams();
		params.match(cache + WILDCARD);
		// params.count(10);
		return params;
	}

	public Set<String> getAllKeysUsingJedis(String cache) {
		Set<String> keys = new HashSet<>();
		Collection<JedisPool> clusterNodes = getRedisConnectionManager().getClusterNodes();
		for (JedisPool pool : clusterNodes) {
			Jedis jedis = pool.getResource();
			ScanParams params = createScanParams(cache);
			ScanResult<String> result = jedis.scan(CURSOR_POS, params);
			ScanResult<byte[]> byteResult = jedis.scan(CURSOR_POS.getBytes(), params);

			for (int i = 0; i < result.getResult().size(); i++) {
				String key = result.getResult().get(i);
				byte[] byteKey = byteResult.getResult().get(i);

				int separatorIndex = StringUtils.ordinalIndexOf(key, DELIMITER, 3) + 1;
				int endIndex = separatorIndex;
				String prefixKey = key.substring(0, endIndex);

				int length = byteKey.length - endIndex;
				byte[] rawKeyBytes = new byte[length];
				System.arraycopy(byteKey, endIndex, rawKeyBytes, 0, length);
				try {
					Object rawKey = serializer.deserialize(rawKeyBytes);
					keys.add(prefixKey + rawKey);
				} catch (Exception e) {
					System.out.println("=====" + key + "\t" + e.getMessage());
				}
			}
		}
		return keys;
	}

	public RedisConnectionManager getRedisConnectionManager() {
		return redisConnectionManager;
	}

	public void setRedisConnectionManager(RedisConnectionManager redisConnectionManager) {
		this.redisConnectionManager = redisConnectionManager;
	}

}