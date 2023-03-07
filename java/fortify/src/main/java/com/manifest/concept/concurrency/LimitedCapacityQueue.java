package com.manifest.concept.concurrency;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.manifest.concept.LoggerFactory;

/**
 * Implement a Queue class whose add and remove methods are synchronized. Supply
 * one thread, called the producer, which keeps inserting strings into the queue
 * as long as there are fewer than 10 elements in it. When the queue gets too
 * full, the thread waits. As sample strings, simply use time stamps new
 * Date().toString(). Supply a second thread, called the consumer, that keeps
 * removing and printing strings from the queue as long as the queue is not
 * empty. When the queue is empty, the thread waits. Both the consumer and
 * producer threads should run for 100 iterations.
 * 
 * This provides a implementation similar to a blocking queue from java
 * concurrency API. It supports an initial capacity (provided at the of
 * construction). If there are message to be put and the queue is full the
 * producer is blocked until space is available. Similarly if the consumer tries
 * to read form the queue when it's empty it blocks until a message becomes
 * available.
 * 
 * @author nitesh.gupta
 *
 * @param <T>
 */
public class LimitedCapacityQueue<T> {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	private LinkedList<T> store = new LinkedList<>();

	private int capacity;

	public LimitedCapacityQueue(int capacity) {
		this.capacity = capacity;

	}

	public synchronized void add(T t) {
		while (isFull()) {
			try {
				logger.log(Level.INFO, "Queue is full. Will wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.log(Level.INFO, "Adding " + t);
		store.add(t);
		notifyAll();
	}

	public synchronized T remove() {
		while (isEmpty()) {
			try {
				logger.log(Level.INFO, "Queue is empty. Will wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		T t = store.remove();
		logger.log(Level.INFO, "Fetching " + t);
		notifyAll();
		return t;
	}

	private boolean isFull() {
		return store.size() == capacity;
	}

	private boolean isEmpty() {
		return store.size() == 0;
	}

}
