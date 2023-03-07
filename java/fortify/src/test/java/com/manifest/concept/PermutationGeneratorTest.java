package com.manifest.concept;

import java.util.Random;

import org.junit.Test;

public class PermutationGeneratorTest {

	@Test
	public void testGetPermutations() {
		Character[] elements = new Character[] { '1', '2', '3' };
		new PermutationGenerator<Character>(elements).getPermutations();
	}
	
	@Test
	public void testGetPermutationsForIntegers() {
		Integer[] elements = new Random().ints(5, 0, 9).distinct().boxed().toArray(Integer[]::new);
		new PermutationGenerator<Integer>(elements).getPermutations();
	}
	
}
