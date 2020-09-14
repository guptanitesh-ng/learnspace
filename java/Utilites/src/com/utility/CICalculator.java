package com.utility;

public class CICalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double rate = 8;
		double installment = 100000;
		double principle = 0;
		for (int year = 1; year <= 15; year++) {
			principle += installment;
			principle += principle * rate / 100;
		}
		System.out.println(principle);
	}

}
