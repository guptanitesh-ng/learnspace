/**
 * 
 */
package com.manifest.concept;

/**
 * @author 150088
 *
 */
public class Employee {

	private int employeeId;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	public Employee() {
		
	}
	
	public Employee(int employeeId, String name, String surname, String email) {
		this.employeeId = employeeId;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
