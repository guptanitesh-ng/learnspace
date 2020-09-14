/**
 * 
 */
package com.training.service;

/**
 * @author 150088
 *
 */
public class Locality {

	private String zipCode;
	
	private String country;

	public Locality() {		
	}

	public Locality (String zipCode, String country) {
		this.zipCode = zipCode;
		this.country = country;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
