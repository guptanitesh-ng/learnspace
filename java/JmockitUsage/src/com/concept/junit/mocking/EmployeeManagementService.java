package com.concept.junit.mocking;

public final class EmployeeManagementService {

	private static final EmployeeManagementService employeeService = new EmployeeManagementService();
	
	public static EmployeeManagementService getInstance() {
		return employeeService;
	}
	
	private EmployeeManagementService() {
		
	}
	
	public void addEmployee(Employee employee) {
		
	}
}
