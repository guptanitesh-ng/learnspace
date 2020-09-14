package com.concept.ejb.webservice;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Stateless
public class InterestCalculator {

	@WebMethod
	public double calculateSimpleInterest(double principal, float ratePerAnnum, int days) {
		return principal * ratePerAnnum * (days / 365);
	}
}
