package com.manifest.concept.concurrency;

import java.util.Arrays;

import org.junit.Test;

public class DiningPhilosopherTest {

	//@Test
	public void testDingingPhilosopher() {
		int philosopherCount = 5;
		Runnable[] philosophers = new DiningPhilosopher[philosopherCount];
		Object[] forks = new Object[philosopherCount];
		Arrays.fill(forks, new Object());
		for (int i = 1; i <= philosopherCount; i++) {
			if (i == 1)
				philosophers[i - 1] = new DiningPhilosopher("Philosopher " + i, forks[i % philosopherCount],
						forks[i - 1]);
			else
				philosophers[i - 1] = new DiningPhilosopher("Philosopher " + i, forks[i - 1],
						forks[i % philosopherCount]);
		}

		Arrays.stream(philosophers).forEach(p -> new Thread(p).start());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDingingPhilosopherDeadlock() {
		int philosopherCount = 5;
		Runnable[] philosophers = new DiningPhilosopher[philosopherCount];
		Object[] forks = new Object[philosopherCount];
		Arrays.fill(forks, new Object());
		for (int i = 1; i <= philosopherCount; i++) {
				philosophers[i - 1] = new DiningPhilosopher("Philosopher " + i, forks[i - 1],
						forks[i % philosopherCount]);
		}

		Arrays.stream(philosophers).forEach(p -> new Thread(p).start());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
