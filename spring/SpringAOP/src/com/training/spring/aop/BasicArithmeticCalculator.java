package com.training.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class BasicArithmeticCalculator {

	public double add(double num1, double  num2) {
		return num1 + num2;
	}
	
	public double subtract(double num1, double  num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1, double  num2) {
		return num1 * num2;
	}
	
	public double divide(double num1, double  num2) {
		return num1 / num2;
	}
}
