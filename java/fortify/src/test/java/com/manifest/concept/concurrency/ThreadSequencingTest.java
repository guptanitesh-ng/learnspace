package com.manifest.concept.concurrency;

import org.junit.Test;

public class ThreadSequencingTest {

	@Test
	public void testThreeThreadSequencing() {
		new Thread(new ThreadSequencing(2, 3, 21)).start();
		new Thread(new ThreadSequencing(1, 3, 21)).start();
		new Thread(new ThreadSequencing(0, 3, 21)).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
