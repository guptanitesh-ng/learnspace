package com.manifest.concept.fp;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author nitesh.gupta
 *
 */
public class RelativePrimeCalculator {

	/**
	 * Finds the first integer from <code>relativePrimeCandidates</code> which is relatively
	 * prime to the given <code>numbers</code>
	 * 
	 * @param relativePrimeCandidates
	 * @param numbers
	 * @return
	 */
	public Optional<Integer> findRelativePrime(List<Integer> relativePrimeCandidates, Collection<Integer> numbers) {
		Optional<Integer> first = relativePrimeCandidates.stream().filter(rpc -> {

			return numbers.stream().allMatch(num -> {
				BigInteger b1 = BigInteger.valueOf(num);
				BigInteger b2 = BigInteger.valueOf(rpc);
				return (b1.gcd(b2).intValue() == 1);
			});

		}).findFirst();

		return first;
	}
}
