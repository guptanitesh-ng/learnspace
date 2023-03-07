package com.manifest.concept.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.LongStream;

import com.manifest.concept.LoggerFactory;
import com.manifest.concept.generics.Pair;

/**
 * Find the integer in the range 1 to 10000 that has the largest number of
 * divisors. Now write a program that uses multiple threads to solve the same
 * problem, but for the range 1 to 100000. By using threads, your program will
 * take less time to do the computation when it is run on a multiprocessor
 * computer. At the end of the program, output the elapsed time, the integer
 * that has the largest number of divisors, and the number of divisors that it
 * has. For this exercise, you should simply
 * divide up the problem into parts and create one thread to do each part.
 * 
 * @author nitesh.gupta
 *
 */
public class DivisorsCalculator {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public Pair<Long, Long> findNumberWithMaxDivisorsUsingConcurrency(long minNum, long maxNum) {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		ExecutorCompletionService<Pair<Long, Long>> completionService = new ExecutorCompletionService<Pair<Long, Long>>(
				executor);
		List<Pair<Long, Long>> pairs = new ArrayList<>();
		long totalNums = maxNum - minNum + 1;
		int taskSize = 1000;
		long taskCount = (totalNums + taskSize - 1) / taskSize;
		long futuresCount = taskCount;
		for (int i = 0; i < taskCount; i++) {
			long rangeStart = minNum;
			long rangeEnd = rangeStart + taskSize - 1;
			completionService.submit(() -> {
				return findNumberWithMaxDivisors(rangeStart, rangeEnd <= maxNum ? rangeEnd : maxNum);
			});
			minNum += taskSize;
		}

		while (futuresCount > 0) {
			try {
				Future<Pair<Long, Long>> result = completionService.take();
				pairs.add(result.get());
				futuresCount--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// logger.log(Level.INFO, "Result from multithreaded computation: "
		// + Collections.max(pairs, (p1, p2) ->
		// p1.getSecond().compareTo(p2.getSecond())));
		// logger.log(Level.INFO, "Result from serial computation: " + extracted(minNum,
		// maxNum));
		return Collections.max(pairs, (p1, p2) -> p1.getSecond().compareTo(p2.getSecond()));
	}

	public Pair<Long, Long> findNumberWithMaxDivisors(long minNum, long maxNum) {
		Optional<Pair<Long, Long>> max = LongStream.range(minNum, maxNum + 1).boxed().map(n -> {
			long divisorCount = LongStream.range(1, n / 2 + 1).filter(i -> n % i == 0).count();
			return new Pair<Long, Long>(n, divisorCount + 1);
		}).max((p1, p2) -> p1.getSecond().compareTo(p2.getSecond()));
		// max.ifPresent(e -> logger.log(Level.INFO, "Result: " + e));
		return max.orElse(null);
	}
}
