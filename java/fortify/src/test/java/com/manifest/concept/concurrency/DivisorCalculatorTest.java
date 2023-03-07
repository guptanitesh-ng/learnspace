package com.manifest.concept.concurrency;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class DivisorCalculatorTest {

	//@Test
	public void testDivisorCalculatorUsingConcurrency() {
		LocalDateTime start = LocalDateTime.now();
		System.out.println(new DivisorsCalculator().findNumberWithMaxDivisorsUsingConcurrency(1, 4999999));
		System.out.println("Time taken in secs: " + ChronoUnit.SECONDS.between(start, LocalDateTime.now()));
	}

	@Test
	public void testDivisorCalculator() {
		LocalDateTime start = LocalDateTime.now();
		System.out.println(new DivisorsCalculator().findNumberWithMaxDivisors(1, 32));
		System.out.println("Time taken in seconds: " + ChronoUnit.SECONDS.between(start, LocalDateTime.now()));
	}
}
