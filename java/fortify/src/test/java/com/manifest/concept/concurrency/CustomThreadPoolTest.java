package com.manifest.concept.concurrency;

import org.junit.Test;

public class CustomThreadPoolTest {

	@Test
	public void testCustomThreadPool() {
		CustomThreadPool customThreadPool = new CustomThreadPool(4);
		Runnable r1 = () -> System.out.println("I am runnable 1 " + Thread.currentThread());
		Runnable r2 = () -> System.out.println("I am runnable 2 " + Thread.currentThread());
		customThreadPool.execute(r1);
		customThreadPool.execute(r2);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
