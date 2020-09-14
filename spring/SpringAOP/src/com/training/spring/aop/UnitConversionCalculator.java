package com.training.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class UnitConversionCalculator {

	public double convertToPound(double kilograms) {
		return kilograms * 4.52;
	}
	
	public double convertToMiles(double kilometers) {
		return kilometers / 1.73;
	}
}