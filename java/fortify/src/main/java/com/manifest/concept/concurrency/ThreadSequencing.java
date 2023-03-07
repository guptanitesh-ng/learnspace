package com.manifest.concept.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.manifest.concept.LoggerFactory;

/**
 * This problem is frequently asked in the interview to check your understanding
 * on threads and your programming skills. Problem statement might change for
 * e.g.
 * 
 * Print ping pong using two threads. Print alternate number using two threads.
 * Print even numbers by one thread and odd numbers by another thread. Print
 * sequence of numbers using several threads.
 * 
 * This implementation is provides a generic way to print numbers in a sequence
 * with any number of threads as initialized at the time of construction.
 * 
 * @author nitesh.gupta
 *
 */
public class ThreadSequencing implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(ThreadSequencing.class.getName());

	private static Long counter = 1L;

	private static Object lock = new Object();

	private int threadSequence;

	private int totalThreads;

	private int maxSequence;

	public ThreadSequencing(int threadSequence, int totalThreads, int maxSequence) {
		this.threadSequence = threadSequence;
		this.totalThreads = totalThreads;
		this.maxSequence = maxSequence;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (true) {
				while (counter % totalThreads != threadSequence) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				}
				if (counter > maxSequence)
					break;
				logger.log(Level.INFO, "Sequencer: " + threadSequence + "---> " + counter);
				// System.out.println("Sequencer: " + threadSequence + "---> " + counter.get());
				counter++;
				lock.notifyAll();
			}
			// lock.notifyAll();
		}

	}

}
