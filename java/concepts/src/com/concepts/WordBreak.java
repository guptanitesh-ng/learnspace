package com.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {

		testMethod();

		// scanAndFindSentences();
	}

	private static void scanAndFindSentences() {
		try (Scanner sc = new Scanner(System.in)) {
			int numberOfTestCases = sc.nextInt();
			Set<String> dict = new HashSet<>();
			int dictLength = sc.nextInt();
			for (int i = 1; i <= numberOfTestCases; i++) {
				for (int j = 1; j <= dictLength; j++)
					dict.add(sc.next());
				String key = sc.next();
				List<List<String>> sentences = new ArrayList<>();
				wordBreaker(key, dict, 0, new ArrayList<String>(), sentences, new StringBuilder());
				decorateResult(sentences);
			}
		}
	}

	private static void testMethod() {
		List<List<String>> sentences = new ArrayList<>();

		String[] dict1 = { "lr", "m", "lrm", "hcdar", "wk" };
		wordBreaker("hcdarlrm", new HashSet<>(Arrays.asList(dict1)), 0, new ArrayList<>(), sentences,
				new StringBuilder());
		decorateResult(sentences);

		sentences.clear();
		String[] dict2 = { "snake", "snakes", "and", "sand", "ladder" };
		wordBreaker("snakesandladder", new HashSet<>(Arrays.asList(dict2)), 0, new ArrayList<>(), sentences,
				new StringBuilder());
		decorateResult(sentences);

		sentences.clear();
		String[] dict3 = { "cats", "cat", "and", "sand", "dog" };
		wordBreaker("catsanddog", new HashSet<>(Arrays.asList(dict3)), 0, new ArrayList<>(), sentences,
				new StringBuilder());
		decorateResult(sentences);

		sentences.clear();
		String[] dict4 = { "cats", "cat", "and", "sand", "dog" };
		wordBreaker("catsandog", new HashSet<>(Arrays.asList(dict4)), 0, new ArrayList<>(), sentences,
				new StringBuilder());
		decorateResult(sentences);
	}

	private static List<String> decorateResult(List<List<String>> sentences) {
		List<String> result = new ArrayList<>();
		sentences.forEach(s -> {
			StringBuilder sentenceBuilder = new StringBuilder();
			// sentenceBuilder.append("(");
			s.forEach(w -> sentenceBuilder.append(w + " "));
			sentenceBuilder.deleteCharAt(sentenceBuilder.length() - 1);
			// sentenceBuilder.append(")");
			result.add(sentenceBuilder.toString());
		});
		// System.out.println(result);
		return result;
	}

	private static void wordBreaker(String key, Set<String> dict, int current, List<String> sentence,
			List<List<String>> sentences, StringBuilder currentWord) {
		String[] tokens = key.split("");
		for (int i = current; i <= tokens.length - 1; i++) {
			currentWord.append(tokens[i]);
			if (dict.contains(currentWord.toString())) {
				// found a match ..
				// add it as a word and continue with next token
				if (i < tokens.length - 1) {
					List<String> currentSentence = new ArrayList<>(sentence);
					currentSentence.add(currentWord.toString());
					wordBreaker(key, dict, i + 1, currentSentence, sentences, new StringBuilder());
				} else {
					sentence.add(currentWord.toString());
					sentences.add(sentence);
				}
			}
		}
	}
}