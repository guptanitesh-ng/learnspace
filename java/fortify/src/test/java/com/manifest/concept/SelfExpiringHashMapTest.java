package com.manifest.concept;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SelfExpiringHashMapTest {

	private static int MILLISEC_FACTOR = 1000;

	@Test
	public void testPresence() throws InterruptedException {
		SelfExpiringHashMap<String, String> map = new SelfExpiringHashMap<String, String>();
		map.put("A", "test");
		Thread.sleep(1 * MILLISEC_FACTOR);
		assertTrue(map.containsKey("A"));
	}

	@Test
	public void testPresenceWithExpiry() throws InterruptedException {
		SelfExpiringHashMap<String, String> map = new SelfExpiringHashMap<String, String>();
		map.put("A", "testA", 1 * MILLISEC_FACTOR);
		map.put("B", "testB", 5 * MILLISEC_FACTOR);
		Thread.sleep(2 * MILLISEC_FACTOR);
		assertTrue(map.containsKey("B"));
		assertFalse(map.containsKey("A"));
	}

	@Test
	public void testBasicGetWithExpiry() throws InterruptedException {
		SelfExpiringHashMap<String, String> map = new SelfExpiringHashMap<String, String>();
		map.put("A", "testA", 3 * MILLISEC_FACTOR);
		map.put("B", "testB", 4 * MILLISEC_FACTOR);
		Thread.sleep(2 * MILLISEC_FACTOR);
		assertEquals("testA", map.get("A"));
		Thread.sleep(2 * MILLISEC_FACTOR);
		assertFalse(map.containsKey("B"));
		assertEquals("testA", map.get("A"));
	}

	@Test
	public void testScheduledCleanup() throws InterruptedException {
		SelfExpiringHashMap<String, String> map = new SelfExpiringHashMap<String, String>(true);
		map.put("A", "testA", 1 * MILLISEC_FACTOR);
		Thread.sleep(2 * MILLISEC_FACTOR);
		map.put("B", "testB", 2 * MILLISEC_FACTOR);
		//Thread.sleep(2 * MILLISEC_FACTOR);
		assertFalse(map.containsKey("A"));
		assertTrue(map.containsKey("B"));
	}

}
