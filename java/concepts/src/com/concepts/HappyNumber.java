package com.concepts;

import java.util.*;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(findNextHappyNumber(41));
	}

	private static int findNextHappyNumber(int number) {
		int happyNumber = 0;
		while (true) {
			int bet = ++number;
			if (computeSumOfSquareOfDigits(bet) == 1) {
				happyNumber = bet;
				break;
			}
		}
		return happyNumber;
	}

	private static int computeSumOfSquareOfDigits(int number) {
		List<Integer> digits = findDigitsOfNumber(number);
		Integer result = digits.stream().map(d -> d*d).reduce(0, Integer::sum);

		if (result > 9)
			result = computeSumOfSquareOfDigits(result);
		return result.intValue();
	}

	private static List<Integer> findDigitsOfNumber(int number) {
		List<Integer> digits = new ArrayList<>();
		int divisor = 10;
		while (number != 0) {
			digits.add(Math.floorMod(number, divisor));
			number = Math.floorDiv(number, divisor);
		}
		return digits;
	}
}
