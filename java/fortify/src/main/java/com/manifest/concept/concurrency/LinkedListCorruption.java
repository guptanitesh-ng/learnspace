package com.manifest.concept.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Write a program in which multiple threads add and remove elements from a
 * java.util.LinkedList. Demonstrate that the list is being corrupted. Shows
 * that LinkedList is not safe to use for concurrent usage. This main method
 * implementation may need several executions before the problem shows up.
 * 
 * @author nitesh.gupta
 *
 * @param <T>
 */
public class LinkedListCorruption<T> {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> linkedList = new LinkedList<>();
		Runtime.getRuntime().availableProcessors();
		int origin = 1;
		int end = 100;
		int threads = 10;
		IntStream.range(1, threads).forEach((t) -> {
			Runnable runnable = () -> {
				IntStream.range((t - 1) * end + origin, t * end + 1).forEach((i) -> linkedList.add(i));
			};
			Thread thread = new Thread(runnable);
			thread.start();
		});

		Thread.sleep(1000);
		linkedList.forEach((e) -> System.out.println(e));
	}

}
