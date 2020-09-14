package com.concepts.sort;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Start {

	public static void main(String[] args) {
		Random random = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}

		int[] heap = new int[numbers.length];	
		
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("Nitesh");
		linkedHashSet.add("Gupta");
		linkedHashSet.add("Nitesh");
		Iterator<String> iterator = linkedHashSet.iterator();
		while(iterator.hasNext())
		System.out.println(iterator.next());
	}

	
}
