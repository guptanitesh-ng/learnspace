package com.concepts.multithreading;

import java.util.ArrayList;
import java.util.Collection;

public class ConcurrentUpdateUnsyncCounter implements Runnable {

	Counter counter = new Counter();

	public static void main(String[] args) throws Exception {
		ConcurrentUpdateUnsyncCounter counter = new ConcurrentUpdateUnsyncCounter();
		Collection<Thread> threadCollection = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			Thread thread = new Thread(counter);
			threadCollection.add(thread);			
		}

		for (Thread thread : threadCollection) {
			thread.start();		
		}
		
		for (Thread thread : threadCollection) {
			thread.join();
		}
		System.out.println(counter.counter.getCount());
	}

	class Counter {
		int count;

		synchronized void inc() {
			count = count + 1;
		}

		int getCount() {
			return count;
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++)
			counter.inc();
	}
}
