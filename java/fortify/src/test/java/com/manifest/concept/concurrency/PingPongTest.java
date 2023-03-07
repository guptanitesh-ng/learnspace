package com.manifest.concept.concurrency;

import org.junit.Test;

public class PingPongTest {

	@Test
	public void testPingPongPlay() {
		Object lock = new Object();
		PingPong ping = new PingPong("ping", lock);
		PingPong pong = new PingPong("pong", lock);
		new Thread(ping).start();
		new Thread(pong).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
