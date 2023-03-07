package com.manifest.concept.fp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class RelativePrimeCalculatorTest {

	private RelativePrimeCalculator relativePrimeCalculator = new RelativePrimeCalculator();

	@Test
	public void testFindRelativePrime() {
		List<Integer> relativePrimeCandidates = Arrays.asList(3, 4, 13, 6, 8, 15, 28, 32);
		Collection<Integer> numbers = Arrays.asList(7, 18, 19, 25);
		Optional<Integer> result = relativePrimeCalculator.findRelativePrime(relativePrimeCandidates, numbers);
		assertTrue("Result not present", result.isPresent());
		assertEquals(Integer.valueOf(13), result.get());
	}
}
