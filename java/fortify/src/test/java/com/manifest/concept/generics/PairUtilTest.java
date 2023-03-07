package com.manifest.concept.generics;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import com.manifest.concept.RandomDataGenerator;

public class PairUtilTest {

	private static final Random random = new Random();
	
	@Test
	public void testMinMax() {
		Integer[] generateNumberArray = RandomDataGenerator.generateNumberArray(20, Integer.class);
		System.out.println(Arrays.toString(generateNumberArray));
		System.out.println(PairUtil.computeMinMax(random.ints(10,0,100).boxed().toArray(Integer[]::new)));
	}

}
