package com.manifest.concept;

import java.util.Arrays;

public class PermutationGenerator<T> {

	T[] elements;
	
	public PermutationGenerator(T[] elements) {
		this.elements = elements;
	}

	public void permute(int current_index) {
		if (current_index == elements.length - 1) {
			System.out.println(Arrays.toString(elements));
		}
		for (int i = current_index; i < elements.length; i++) {
			swap(elements, current_index, i);
			permute(current_index + 1);
			swap(elements, i, current_index);
		}
	}

	private void swap(T[] elements, int i, int j) {
		T temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}

}