package com.concepts.multithreading;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberPublisher implements Runnable {

	private AtomicInteger number;
	private Semaphore semaphore;

	public NumberPublisher(AtomicInteger start, Semaphore latch) {
		this.number = start;
		this.semaphore = latch;
	}

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1,true);
		CyclicBarrier barrier = new CyclicBarrier(2);
		AtomicInteger start = new AtomicInteger(0);
		NumberPublisher oddPublisher = new NumberPublisher(start, semaphore);
		NumberPublisher evenPublisher = new NumberPublisher(start, semaphore);
		new Thread(oddPublisher, "Odd").start();
		new Thread(evenPublisher, "Even").start();
	}

	@Override
	public void run() {
		while (true) {
			try {				
				semaphore.acquire();
				int value = number.incrementAndGet();
				if (value > 10) {
					semaphore.release();
					break;
				}					
				System.out.println(value);				
				semaphore.release();				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Exiting Thread " + Thread.currentThread().getName());
	}

}
