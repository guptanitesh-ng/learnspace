/**
 * 
 */
package com.training.service.client;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.training.service.IWeatherUpdate;
import com.training.service.Locality;

/**
 * @author 150088
 *
 */
public class WeatherUpdateClient {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		URL serviceURL = new URL("http://127.0.0.1:7777/WeatherUpdateImpl?wsdl");
		QName qualifiedServiceName = new QName("http://service.training.com/", "WeatherUpdateImplService");
		Service weatherUpdateService = Service.create(serviceURL, qualifiedServiceName);
		IWeatherUpdate weatherUpdate = weatherUpdateService.getPort(IWeatherUpdate.class);
		Map<String, Object> requestContext = ((BindingProvider)weatherUpdate).getRequestContext();
		Map<String, List<String>> requestMap = new HashMap<String, List<String>>();
		requestMap.put("Username", Collections.singletonList("150088"));
		requestMap.put("Password", Collections.singletonList("78e32ef834"));
		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestMap);
		Locality locality = new Locality("700091", "India");
		weatherUpdate.getWeatherDetails(locality);
	}

}
