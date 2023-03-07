package com.manifest.concept;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.manifest.concept.concurrency.WordCounter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// printArray(new String[] { "Text", "To", "Print" });
		// printArray(new Integer[] { 1, 2, 3, 4, 5 });

		/*
		 * ZonedDateTime atZone = LocalDateTime.now().atZone(ZoneOffset.of("+09:30"));
		 * ZonedDateTime now = ZonedDateTime.now(ZoneOffset.of("-04:00"));
		 * System.out.println(atZone + "\t" + now);
		 * 
		 * ZoneId.getAvailableZoneIds().forEach(e -> System.out.println(e));
		 * 
		 * getAllZoneIdsAndItsOffSet().entrySet().stream().sorted(Map.Entry.<String,
		 * String>comparingByValue().reversed()) .forEach(e ->
		 * System.out.println(e.getKey() + "\t" + e.getValue()));
		 */

		// new DefaultMethodDiamondProblem().print();
		// new DefaultMethodDiamondProblem().triggerDiamondBehavior();

		Counter counter = new Counter();
		IntStream.range(0, 10).forEach(i -> new Thread(() -> {
			IntStream.range(0, 100).forEach(c -> counter.inc());
		}).start());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(counter.getCount());
	}

	private static class Counter {
		private AtomicInteger count = new AtomicInteger(0);

		private void inc() {
			count.incrementAndGet();
		}

		private int getCount() {
			return count.get();
		}
	}

	private static <T> void printArray(T[] elements) {
		Arrays.stream(elements).forEach(e -> System.out.println(e));
	}

	private static Map<String, String> getAllZoneIdsAndItsOffSet() {

		Map<String, String> result = new HashMap<>();

		LocalDateTime localDateTime = LocalDateTime.now();

		for (String zoneId : ZoneId.getAvailableZoneIds()) {

			ZoneId id = ZoneId.of(zoneId);

			// LocalDateTime -> ZonedDateTime
			ZonedDateTime zonedDateTime = localDateTime.atZone(id);

			// ZonedDateTime -> ZoneOffset
			ZoneOffset zoneOffset = zonedDateTime.getOffset();

			// replace Z to +00:00
			String offset = zoneOffset.getId().replaceAll("Z", "+00:00");

			result.put(id.toString(), offset);

		}

		return result;

	}
}
