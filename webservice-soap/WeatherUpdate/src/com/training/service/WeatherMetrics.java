/**
 * 
 */
package com.training.service;

/**
 * @author 150088
 *
 */
public class WeatherMetrics {

	private String zipCode;
	
	private double currentTemp;
	
	private double humidity;

	public WeatherMetrics() {		
	}

	public WeatherMetrics(String zipCode, double currentTemp, double humidity) {
		this.zipCode = zipCode;
		this.currentTemp = currentTemp;
		this.humidity = humidity;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	 
}
