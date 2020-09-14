package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class AnnotationBasedWiring {

	@Autowired
	@CustomQualifier
	private Employee employee;
	
	@Autowired(required=false)
	@Value("#{employee.name}")
	private String value;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
