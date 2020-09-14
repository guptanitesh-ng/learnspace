package com.concepts;

import java.util.Scanner;

public class SpecialKeyboard {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int numberOfTestCases = sc.nextInt();
			for (int i = 0; i < numberOfTestCases; i++) {
				System.out.println(solution(sc.nextInt()));
			}
		}
	}

	public static int solution(int numOfKeyPress) {
		if (numOfKeyPress - 5 < 1)
			return numOfKeyPress;

		//int value = 2 * solution(numOfKeyPress - 2);
		int value1 = 3 * solution(numOfKeyPress - 4);
		int value2 = 4 * solution(numOfKeyPress - 5);
		return value1 > value2 ? value1 : value2;

	}
}
