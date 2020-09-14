/**
 * 
 */
package com.training.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 * @author 150088
 * 
 */
@WebService(endpointInterface = "com.training.service.IWeatherUpdate")
public class WeatherUpdateImpl implements IWeatherUpdate {

	@Resource
	WebServiceContext context;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.training.webservice.IWeatherUpdate#getWeatherDetails(com.training
	 * .webservice.Locality)
	 */
	@Override
	public WeatherMetrics getWeatherDetails(Locality locality) {
		Map<String, List<String>> requestMap = (Map<String, List<String>>)context.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
		System.out.println(requestMap.get("Username"));
		System.out.println(requestMap.get("Password"));
		return new WeatherMetrics(locality.getZipCode(), 20.5, 72);
	}

}
