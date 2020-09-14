package com.concepts.ehcache;

import static org.joda.time.Seconds.secondsBetween;

import org.joda.time.DateTime;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class ExpirationDateCacheEventListener implements CacheEventListener {

    /**
     * @see net.sf.ehcache.event.CacheEventListener#notifyElementPut(net.sf.ehcache.Ehcache,
     *      net.sf.ehcache.Element)
     */
    @Override
    public void notifyElementPut(Ehcache cache, Element element) throws CacheException {
        System.out.println(
                "&&&&&&&&&&&&&&&&&&&&&&" + cache.getName() + " " + element.getObjectValue());
        handleExpiration(cache, element);
    }

    /**
     * @see net.sf.ehcache.event.CacheEventListener#notifyElementUpdated(net.sf.ehcache.Ehcache,
     *      net.sf.ehcache.Element)
     */
    @Override
    public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException {
        handleExpiration(cache, element);
    }

    /**
     * Changes the expiration time of the cache element to the number of seconds until midnight.
     * 
     * @param cache The cache the element belongs to
     * @param element The element to change
     */
    private void handleExpiration(Ehcache cache, Element element) {
        DateTime expirationDateTime = new DateTime(element.getExpirationTime());

        DateTime midnightTonight = new DateTime().withTimeAtStartOfDay().plusDays(1);
        if (expirationDateTime.isAfter(midnightTonight)) {
            int seconds = secondsBetween(new DateTime(), midnightTonight).getSeconds();
            element.setTimeToLive(seconds);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void notifyElementEvicted(Ehcache cache, Element element) {
        System.out.println(
                "^^^^^^^^^^^^^^^^^^^^^^^" + cache.getName() + " " + element.getObjectValue());
    }

    @Override
    public void notifyElementExpired(Ehcache cache, Element element) {
        System.out.println(
                "!!!!!!!!!!!!!!!!!!!!!!!!" + cache.getName() + " " + element.getObjectValue());
    }

    @Override
    public void notifyElementRemoved(Ehcache arg0, Element arg1) throws CacheException {
    }

    @Override
    public void notifyRemoveAll(Ehcache arg0) {
    }
}