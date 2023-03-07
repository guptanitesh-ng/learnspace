package com.manifest.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationGenerator<T> {

	private T[] elements;

	public PermutationGenerator(T[] elements) {
		this.elements = elements;
	}

	public PermutationGenerator(List<T> elements) {
		this.elements = elements.toArray(this.elements);
	}

	private void permute(int current_index, List<List<T>> permutations) {
		if (current_index == elements.length - 1) {
			System.out.println(Arrays.toString(elements));
			permutations.add(Arrays.asList(Arrays.copyOf(elements, elements.length)));
		}
		for (int i = current_index; i < elements.length; i++) {
			// exchange elements to bring a new element at starting position i. e.g.
			// {1,2,3,4}, {2,1,3,4}, {3,2,1,4}, {4,2,3,1}
			swap(elements, current_index, i);
			// now do the same for remaining elements in the array starting with next
			// position i.e. i+1 e.g. {2,3,4} from {1,2,3,4}, {1,3,4} from {2,1,3,4}
			permute(current_index + 1, permutations);
			// reverse the swap to bring in i+1th, i+2th element in starting position
			swap(elements, i, current_index);
		}
	}

	public List<List<T>> getPermutations() {
		List<List<T>> permutations = new ArrayList<List<T>>();
		permute(0, permutations);
		return permutations;
	}

	private void swap(T[] elements, int i, int j) {
		if (i != j) {
			T temp = elements[i];
			elements[i] = elements[j];
			elements[j] = temp;
		}
	}

}