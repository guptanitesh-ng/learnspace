package com.concepts.finance.service;

import com.concepts.finance.model.Result;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class TTLCacheEventListener implements CacheEventListener {

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyElementEvicted(Ehcache arg0, Element arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyElementExpired(Ehcache cache, Element element) {
        System.out.println("Expired element pair: " + element.getObjectKey() + "\t"
                + element.getObjectValue());
    }

    @Override
    public void notifyElementPut(Ehcache cache, Element element) throws CacheException {
        System.out.println("Inserted element pair:" + element.getObjectKey() + "\t"
                + element.getObjectValue());
        Result result = (Result)element.getObjectValue();
        element.setTimeToLive(result.getDuration());
    }

    @Override
    public void notifyElementRemoved(Ehcache arg0, Element arg1) throws CacheException {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyElementUpdated(Ehcache arg0, Element arg1) throws CacheException {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyRemoveAll(Ehcache arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
