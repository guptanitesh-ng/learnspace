package com.concepts.multithreading;

import java.util.ArrayList;
import java.util.Collection;

public class FindIntegerWithMostDivisors implements Runnable {
	
	private int rangeMin;
	private int rangeMax;
	private IntegerDivisorData integerDivisorData;

	public FindIntegerWithMostDivisors(IntegerDivisorData integerDivisorData, int rangeMin, int rangeMax) {
		this.integerDivisorData = integerDivisorData;
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
	}
	
	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();		
		int rangeMin = 1;
		int rangeMax = 100000;
		IntegerDivisorData integerDivisorData = new IntegerDivisorData();
		int threadCount = 5;
		Collection<Thread> threadCollection = new ArrayList<>();
		for (int i=1;i<=threadCount;i++) {			
			FindIntegerWithMostDivisors findIntegerWithMostDivisors = new FindIntegerWithMostDivisors(integerDivisorData, rangeMin, ((i*rangeMax)/threadCount));
			threadCollection.add(new Thread(findIntegerWithMostDivisors));
			rangeMin = ((i*rangeMax)/threadCount) +1;
		}				
		for (Thread thread : threadCollection) {
			thread.start();		
		}
		
		for (Thread thread : threadCollection) {
			thread.join();
		}
		integerDivisorData.printData();
		System.out.println("Total execution time in ms: " + ((System.currentTimeMillis() - startTime)) + " with " + Runtime.getRuntime().availableProcessors() + " processors");
	}

	private void calculate() {
		for (int i = rangeMin; i <= rangeMax; i++) {
			int currentDivisorCount = 0;
			for (int j = i / 2; j > 1; j--) {
				if (i % j == 0)
					currentDivisorCount++;
			}
			integerDivisorData.setData(currentDivisorCount, i);
		}
	}

	@Override
	public void run() {
		calculate();
		
	}
}
