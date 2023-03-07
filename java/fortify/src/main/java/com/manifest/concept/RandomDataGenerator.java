package com.manifest.concept;

import java.util.Random;

public class RandomDataGenerator {

	private static final Random random = new Random();
	
	public static <T> T[] generateNumberArray(int size, Class<T> clazz) {
		size = size > 0 ? size : 10;
		switch (clazz.getSimpleName()) {
		case "Integer":
			return (T[])random.ints(size, 0, 100).boxed().toArray(Integer[]::new);
		default:
			return null;
		}
	}
	
	public static String generateRandomString(int length) {
		//char[] randomChars = new char[length];
		StringBuilder builder = new StringBuilder();
		random.ints(length, 65, 91).forEach((e) -> builder.append((char)e));
		return builder.toString();
	}
	
	
}
