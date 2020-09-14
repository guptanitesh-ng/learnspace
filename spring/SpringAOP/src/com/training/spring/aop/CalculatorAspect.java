package com.training.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class CalculatorAspect {

	@Before("com.training.spring.aop.CalculatorPointcuts.loggingOperation()")
	public void logBefore() {		
		System.out.println("Inside Log Before");
	}
	
	@After("com.training.spring.aop.CalculatorPointcuts.loggingOperation()")
	public void logAfter() {		
		System.out.println("Inside Log After");
	}
	
	@AfterReturning("com.training.spring.aop.CalculatorPointcuts.loggingOperation()")
	public void logAfterReturning() {		
		System.out.println("Inside Log After Returning");
	}
	
	@AfterThrowing("com.training.spring.aop.CalculatorPointcuts.loggingOperation()")
	public void logAfterThrowing() {
		System.out.println("Inside Log After Throwing");
	}
	
	@Around("com.training.spring.aop.CalculatorPointcuts.loggingOperation()")
	public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Inside Around");
		try {
			return proceedingJoinPoint.proceed();
		} catch (Throwable e) {			
			e.printStackTrace();
			throw e;
		}		
	}
	
	@Before("com.training.spring.aop.CalculatorPointcuts.validateArithmeticInput(num1, num2)")
	public void validate(double num1, double num2) {
		System.out.println("Lets validate");
	}

}
