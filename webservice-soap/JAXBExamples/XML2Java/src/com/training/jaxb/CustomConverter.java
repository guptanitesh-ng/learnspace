package com.training.jaxb;


public class CustomConverter {

	public static double parseDecimal(String decimal) {		
		return Double.parseDouble(decimal);
	}
	
	public static String printDecimal(double number) {
		return String.valueOf(number);
	}
}
