package com.concepts.jee.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Customer {

	private String firstName;
	
	private String lastName;
	
	private CustomerPK customerPK;

	@EmbeddedId
	public CustomerPK getCustomerPK() {
		return customerPK;
	}

	public void setCustomerPK(CustomerPK customerPK) {
		this.customerPK = customerPK;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
