package com.training.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = 
	            new ClassPathXmlApplicationContext("META-INF/springaop.xml");

		BasicArithmeticCalculator arithmeticCalculator = context.getBean(BasicArithmeticCalculator.class);
		System.out.println(arithmeticCalculator.add(2, 2));
		
	}

}
