package com.concepts.ehcache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import net.sf.ehcache.config.CacheConfiguration;

public class CustomCacheManager extends EhCacheCacheManager {

    private Map<String, Long> ttlMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        ttlMap.forEach((k, v) -> {
            Cache cache = getCache(k);
            if (cache == null) {
                System.out.println("No cache found for given key: " + k);
                return;
            }
            if (!(cache instanceof EhCacheCache)) {
                System.out.println("Cache instance not of type EhCacheCache " + cache);
                return;
            }

            CacheConfiguration cacheConfiguration = ((EhCacheCache) cache).getNativeCache()
                    .getCacheConfiguration();
            System.out.println("Time to live " + cacheConfiguration.getTimeToLiveSeconds());
            cacheConfiguration.setTimeToLiveSeconds(v);
            System.out.println("New Time to live " + cacheConfiguration.getTimeToLiveSeconds());
        });

    }

    public void setTtlMap(Map<String, Long> ttlMap) {
        this.ttlMap = ttlMap;
    }
}
