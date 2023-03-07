package com.manifest.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class GenerateStringWithGivenCharacters {

	public static <T> boolean perform(T[] input) {

		Map<T, Integer> inputFrequencyMap = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			inputFrequencyMap.merge(input[i], 1, (v, w) -> v + 1);
		}
		Map<Integer, List<T>> frequencyInputMap = new TreeMap<>(Collections.reverseOrder());
		inputFrequencyMap.entrySet()
				.forEach(e -> frequencyInputMap.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey()));

		List<T> output = new ArrayList<>();
		for (Entry<Integer, List<T>> entry : frequencyInputMap.entrySet()) {
			for (int i = 0; i < entry.getKey(); i++) {
				output.addAll(entry.getValue());
			}
		}

		boolean stringPossible = false;
		List<List<T>> allPermutations = getAllPermutations(input);
		for (List<T> p : allPermutations) {
			T previousElement = null;
			boolean consecutiveElementFound = false;
			for (int i = 0; i < p.size(); i++) {
				if (previousElement == p.get(i)) {
					consecutiveElementFound = true;
					break;
				} else {
					previousElement = p.get(i);
				}
			}
			if (!consecutiveElementFound) {
				stringPossible = true;
				break;
			}
		}
		return stringPossible;
	}

	private static <T> List<List<T>> getAllPermutations(T[] input) {
		List<List<T>> output = new ArrayList<List<T>>();
		permute(input, output, 0);
		return output;
	}

	private static <T> void permute(T[] input, List<List<T>> output, int currentIndex) {
		if (currentIndex == input.length - 1) {
			output.add(Arrays.asList(Arrays.copyOf(input, input.length)));
		}

		for (int i = currentIndex; i < input.length; i++) {
			swap(input, currentIndex, i);
			permute(input, output, currentIndex + 1);
			swap(input, currentIndex, i);
		}
	}

	private static <T> void swap(T[] elements, int i, int j) {
		if (i != j) {
			T temp = elements[i];
			elements[i] = elements[j];
			elements[j] = temp;
		}
	}
}
