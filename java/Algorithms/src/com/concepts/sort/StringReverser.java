package com.concepts.sort;

public class StringReverser {

	public String reverseBySwapping(String input) {
		if (input == null || input.trim().length() == 0) {
			return input;
		}
		char[] inputChars = input.toCharArray();
		for (int start = 0, end = (inputChars.length - 1); start < end; start++, end--) {
			char head = inputChars[start];
			char tail = inputChars[end];
			inputChars[start] = tail;
			inputChars[end] = head;
		}
		return new String(inputChars);
	}

	private String reverseByIteration(String input) {
		if (input == null || input.trim().length() < 2) {
			return input;
		}
		StringBuilder reverseStringBuilder = new StringBuilder();
		for (int end = input.length() - 1; end >= 0; end--) {
			reverseStringBuilder.append(input.charAt(end));
		}
		return reverseStringBuilder.toString();
	}
	
	public String reverseByRecursion(String input) {
		if (input == null || input.trim().length() < 2) {
			return input;
		}
		StringBuilder reverseStringBuilder = new StringBuilder();
		for (int end = input.length() - 1; end >= 0; end--) {
			reverseStringBuilder.append(input.charAt(end));
		}
		return reverseStringBuilder.toString();
	}

	public static void main(String[] args) {
		StringReverser reverser = new StringReverser();
		long l = System.currentTimeMillis();
		String reversedString = null;
		for (int i = 0; i < 10000; i++) {
			reversedString = reverser
					.reverseBySwapping("Data Structures and Algorithms");
		}
		System.out.println(System.currentTimeMillis() - l);
		l = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			reversedString = reverser
					.reverseByIteration("Data Structures and Algorithms");
		}
		System.out.println(System.currentTimeMillis() - l);
	}
}
