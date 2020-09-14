package com.training.spring;

public class AutowireByConstructor {

	public AutowireByConstructor() {
		System.out.println("Check successful");
	}
	
	public AutowireByConstructor(Employee employee) {
		System.out.println("Picks up the parametrized constructor");
	}	
	
}
