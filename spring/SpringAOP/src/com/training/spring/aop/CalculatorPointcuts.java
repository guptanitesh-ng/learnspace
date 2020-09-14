package com.training.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorPointcuts {

	@Pointcut("within(com.training.spring.aop.BasicArithmeticCalculator)")
	public void arithmeticOperation() {
	}
	
	@Pointcut("within(com.training.spring.aop.UnitConversionCalculator)")
	public void unitConversionOperation() {
	}
	
	@Pointcut("arithmeticOperation() || unitConversionOperation()")
	public void loggingOperation() {
	}
	
	@Pointcut("arithmeticOperation() && args(arg1, arg2)")
	public void validateArithmeticInput(double arg1, double arg2) {		
	}
}
