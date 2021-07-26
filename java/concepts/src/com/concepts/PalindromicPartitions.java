package com.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PalindromicPartitions {

	public static void main(String[] args) {
		PalindromicPartitions pp = new PalindromicPartitions();
		// System.out.println(pp.isPalindrome("a"));
		// System.out.println(pp.isPalindrome("eke"));
		// System.out.println(pp.isPalindrome("geek"));

		 pp.generatePartitions("ababa");
		// pp.generatePartitions("google");
		// pp.generatePartitions("madam");
		 pp.generatePartitions("wwwzz");

	}

	private void generatePartitions(String s) {
		String[] chars = s.split("");
		Set<List<String>> partitions = new LinkedHashSet<>();
		// partitions.add(Arrays.asList(chars));
		// List<String> partition = new ArrayList<>();

		// palindromicPartitions(s, chars, partitions, partition);

		partition(chars, partitions, new ArrayList<>(), 0, new StringBuilder(), 0);

		new ArrayList<>(partitions);
		new ArrayList<>(partitions).forEach(e -> {
			e.forEach(p -> System.out.print(p + "\t"));
			System.out.println();
		});
	}

	private void partition(String[] chars, Set<List<String>> partitions, List<String> partition, int current,
			StringBuilder currentString, int length) {
		for (int i = current; i < chars.length; i++) {
			if ((length + currentString.length()) >= chars.length)
				continue;

			currentString.append(chars[i]);

			if (isPalindrome(currentString.toString())) {

				// Add the palindrome
				List<String> palindromePartition = new ArrayList<>(partition);
				palindromePartition.add(currentString.toString());
				palindromePartition.addAll(Arrays.asList(Arrays.copyOfRange(chars, i + 1, chars.length)));
				partitions.add(palindromePartition);

				// find more palindromes
				List<String> subPartition = new ArrayList<>(partition);
				subPartition.add(currentString.toString());
				partition(chars, partitions, subPartition, i + 1, new StringBuilder(), length + currentString.length());

			}

			// find longer palindrome
			partition(chars, partitions, partition, i + 1, currentString, length);

		}
	}

	public boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();
		int length = chars.length;
		for (int i = 0; i < length / 2; i++) {
			if (chars[i] == chars[length - i - 1])
				continue;
			return false;
		}
		return true;
	}
}