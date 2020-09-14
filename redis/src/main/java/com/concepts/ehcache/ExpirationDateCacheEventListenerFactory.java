package com.concepts.ehcache;

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

public class ExpirationDateCacheEventListenerFactory extends CacheEventListenerFactory {

    /**
     * @see net.sf.ehcache.event.CacheEventListenerFactory#createCacheEventListener(java.util.Properties)
     */
    @Override
    public CacheEventListener createCacheEventListener(Properties properties) {
        return new ExpirationDateCacheEventListener();
    }
}