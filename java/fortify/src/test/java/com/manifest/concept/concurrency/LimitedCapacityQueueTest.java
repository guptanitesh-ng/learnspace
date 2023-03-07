package com.manifest.concept.concurrency;

import java.util.stream.IntStream;

import org.junit.Test;

public class LimitedCapacityQueueTest {

	@Test
	public void testMultipleProducerConsumer() {
		LimitedCapacityQueue<String> limitedCapacityQueue = new LimitedCapacityQueue<>(10);

		Runnable producer = () -> {
			IntStream.range(0, 100).forEach((i) -> {
				limitedCapacityQueue.add(Thread.currentThread().getName() + "->" + i);
			});
		};

		Runnable consumer = () -> {
			IntStream.range(0, 100).forEach((i) -> {
				limitedCapacityQueue.remove();
			});
		};

		IntStream.range(0, 10).forEach((t) -> new Thread(producer, "producer#" + t).start());
		IntStream.range(0, 10).forEach((t) -> new Thread(consumer, "consumer#" + t).start());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
