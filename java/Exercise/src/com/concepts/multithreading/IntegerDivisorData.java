package com.concepts.multithreading;

public class IntegerDivisorData {
	public int integerWithMostDivisor;
	public int divisorCount;

	public synchronized void setData(int currentDivisorCount, int currentInteger) {
		if (currentDivisorCount > divisorCount) {
			divisorCount = currentDivisorCount;
			integerWithMostDivisor = currentInteger;
		}
	}

	public void printData() {
		System.out.println(integerWithMostDivisor + "\t" + divisorCount);
	}
}