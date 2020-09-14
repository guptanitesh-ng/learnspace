/**
 * 
 */
package com.training.publisher;

import javax.xml.ws.Endpoint;

import com.training.service.WeatherUpdateImpl;

/**
 * @author 150088
 *
 */
public class ServicePublisher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:7777/WeatherUpdateImpl", new WeatherUpdateImpl());

	}

}
