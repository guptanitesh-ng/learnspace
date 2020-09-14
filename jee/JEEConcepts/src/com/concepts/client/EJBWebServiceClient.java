package com.concepts.client;

import com.concept.ejb.webservice.InterestCalculator;
import com.concept.ejb.webservice.InterestCalculatorService;

public class EJBWebServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterestCalculatorService service = new InterestCalculatorService();
		InterestCalculator calculator = service.getPort(InterestCalculator.class);
		double result = calculator.calculateSimpleInterest(10000, 10, 365);
		System.out.println(result);
	}

}
