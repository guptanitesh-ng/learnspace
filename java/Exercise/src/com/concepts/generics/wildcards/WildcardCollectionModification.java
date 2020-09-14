package com.concepts.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

class Animal {
	
}

class Dog extends Animal {
	
}

public class WildcardCollectionModification {
	
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Dog());
		addAnimal(animals);
		
		List<Object> objects = new ArrayList<>();
		objects.add("");
		objects.add(3);
	}
	
	private static <T> void addAnimal(List<T> animals) {				
		//animals.add(animals.get(0));
	}
	
	
}
