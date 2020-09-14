package com.concepts.redis.configuration;

import org.springframework.data.redis.cache.CacheKeyPrefix;

public class RedisCacheKeyPrefix implements CacheKeyPrefix {

    private String realmName = "";

    private final static String DELIMITER = ":";

    public RedisCacheKeyPrefix(String realmName) {
        this.realmName = realmName;
    }

    @Override
    public String compute(String cacheName) {
        return realmName + DELIMITER + cacheName + DELIMITER;
    }

}
