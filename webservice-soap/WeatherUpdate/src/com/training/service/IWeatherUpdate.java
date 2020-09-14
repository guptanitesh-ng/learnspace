/**
 * 
 */
package com.training.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @author 150088
 * 
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface IWeatherUpdate {

	@WebMethod
	public @WebResult(name = "metrics", partName = "result")
	WeatherMetrics getWeatherDetails(
			@WebParam(name = "location", partName = "input") Locality locality);
}
