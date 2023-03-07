package com.manifest.concept;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SelfExpiringHashMap<K, V> implements Map<K, V>, Runnable {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	private Map<K, V> entryMap = new ConcurrentHashMap<K, V>();

	private Map<K, ExpiringKey> expiringKeyMap = new ConcurrentHashMap<K, ExpiringKey>();

	private long minimumTimeToExpiry = 100;

	public SelfExpiringHashMap(boolean withAutoCleanup) {
		super();
		if (withAutoCleanup)
			scheduler.schedule(this, 500, TimeUnit.MILLISECONDS);
	}

	public SelfExpiringHashMap() {
		super();
	}

	public V put(K key, V value, long ttl) {
		expiringKeyMap.remove(key);
		expiringKeyMap.put(key, new ExpiringKey(key, System.currentTimeMillis(), ttl));
		return entryMap.put(key, value);
	}

	@Override
	public int size() {
		cleanup();
		return entryMap.size();
	}

	@Override
	public boolean isEmpty() {
		cleanup();
		return entryMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		cleanup();
		return entryMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		cleanup();
		return entryMap.containsValue(value);
	}

	@Override
	public V get(Object key) {
		cleanup();
		renewKey(key);
		return entryMap.get(key);
	}

	@Override
	public V put(K key, V value) {
		expiringKeyMap.remove(key);
		expiringKeyMap.put(key, new ExpiringKey(key, System.currentTimeMillis(), Long.MAX_VALUE));
		return entryMap.put(key, value);
	}

	@Override
	public V remove(Object key) {
		cleanup();
		expiringKeyMap.remove(key);
		return entryMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		m.entrySet().forEach(e -> put(e.getKey(), e.getValue()));
	}

	@Override
	public void clear() {
		expiringKeyMap.clear();
		entryMap.clear();
	}

	@Override
	public Set<K> keySet() {
		cleanup();
		return entryMap.keySet();
	}

	@Override
	public Collection<V> values() {
		cleanup();
		return entryMap.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		cleanup();
		return entryMap.entrySet();
	}

	private void cleanup() {
		Iterator<Entry<K, SelfExpiringHashMap<K, V>.ExpiringKey>> iterator = expiringKeyMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<K, SelfExpiringHashMap<K, V>.ExpiringKey> entry = iterator.next();
			if (entry.getValue().isExpired()) {
				entryMap.remove(entry.getKey());
				iterator.remove();
			} else {
				minimumTimeToExpiry = entry.getValue().getTimeToExpire();
			}
		}
	}

	private boolean renewKey(Object key) {
		ExpiringKey expiringKey = expiringKeyMap.get(key);
		if (Objects.nonNull(expiringKey)) {
			expiringKey.timeOfInsertion = System.currentTimeMillis();
			return true;
		} else {
			return false;
		}
	}

	private class ExpiringKey {
		private Object key;
		private long timeOfInsertion;
		private long timeToLive;

		public ExpiringKey(Object key, long timeOfInsertion, long timeToLive) {
			this.key = key;
			this.timeOfInsertion = timeOfInsertion;
			this.timeToLive = timeToLive;
		}

		public boolean isExpired() {
			return System.currentTimeMillis() - timeOfInsertion > timeToLive;
		}

		private long getTimeToExpire() {
			return (timeOfInsertion + timeToLive) - System.currentTimeMillis();
		}

		@Override
		public String toString() {
			return "ExpiringKey [key=" + key + ", timeOfInsertion=" + timeOfInsertion + ", timeToLive=" + timeToLive
					+ "]";
		}

	}

	@Override
	public void run() {
		this.cleanup();
		scheduler.schedule(this, minimumTimeToExpiry, TimeUnit.MILLISECONDS);
	}
}
