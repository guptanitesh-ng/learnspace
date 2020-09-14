package com.concepts.finance;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CalculatorCachingConfiguration extends CachingConfigurerSupport {

    @Bean(name = "ehcache")
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
        factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factory.setShared(true);
        return factory;
    }

    @Bean(name = "ehcacheManager")
    public EhCacheCacheManager ehCacheManager() {
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
        cacheManager.setCacheManager(ehcache().getObject());
        return cacheManager;
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return ehCacheManager();
    }
}
