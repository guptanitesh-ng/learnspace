package com.manifest.concept;

import org.junit.Test;

public class GenerateStringWithGivenCharactersTest {

	@Test
	public void testStringGeneration() {
		Character[] c = {'a', 'b', 'c', 'd', 'c', 'c'};
		System.out.println(GenerateStringWithGivenCharacters.perform(c));
		
		Character[] c1 = {'a', 'c', 'c', 'c'};
		System.out.println(GenerateStringWithGivenCharacters.perform(c1));
	}
}
