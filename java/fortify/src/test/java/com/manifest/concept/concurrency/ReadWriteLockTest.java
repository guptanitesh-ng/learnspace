package com.manifest.concept.concurrency;

import org.junit.Test;

public class ReadWriteLockTest {

	private static final int SLEEP_TIME = 2000;

	@Test
	public void testReadReadWrite() {
		ReadWriteLock lock = new ReadWriteLock();
		
		Runnable reader = () -> {
			
			lock.acquireReadLock();
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.releaseReadLock();
			
		};
		
		Runnable writer = () -> {
			
			lock.acquireWriteLock();
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.releaseWriteLock();
			
		};
		
		new Thread(reader, "Reader 1").start();
		new Thread(reader, "Reader 2").start();
		
		new Thread(writer, "Writer 1").start();
		try {
			Thread.sleep(SLEEP_TIME*2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(reader, "Reader 3").start();
		try {
			Thread.sleep(SLEEP_TIME*2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
