package com.concepts.redis.configuration;

import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

public class DynamicCacheResolver implements CacheResolver {

	@Override
	public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
		
		return null;
	}

}
