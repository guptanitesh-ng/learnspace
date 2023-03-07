package com.manifest.concept.concurrency;

import java.util.LinkedList;

/**
 * Implement a stack as a linked list in which the push, pop, and isEmpty
 * methods can be safely accessed from multiple threads.
 * 
 * @author nitesh.gupta
 *
 * @param <T>
 */
public class StackUsingLinkedList<T> {

	private LinkedList<T> store = new LinkedList<>();

	public synchronized void push(T t) {
		store.addFirst(t);
	}

	public synchronized T pop() {
		return store.remove();
	}

	public synchronized boolean isEmpty() {
		return store.isEmpty();
	}
}
