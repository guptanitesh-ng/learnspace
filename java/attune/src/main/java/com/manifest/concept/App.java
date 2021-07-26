package com.manifest.concept;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		printArray(new String[] { "Text", "To", "Print" });
		printArray(new Integer[] { 1, 2, 3, 4, 5 });

		Character[] elements = new Character[] { 'A', 'B', 'C', 'D' };
		new PermutationGenerator<Character>(elements).permute(0);

	}

	private static <T> void printArray(T[] elements) {
		Arrays.stream(elements).forEach(e -> System.out.println(e));
	}
}
