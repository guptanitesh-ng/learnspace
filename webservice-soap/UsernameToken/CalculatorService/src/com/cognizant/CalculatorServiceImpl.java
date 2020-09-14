/**
 * 
 */
package com.cognizant;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.jboss.ws.api.annotation.EndpointConfig;

/**
 * @author 150088
 *
 */
@WebService(endpointInterface="com.cognizant.CalculatorService",
			portName = "CalculatorPort",
			serviceName = "CalculatorService",
			wsdlLocation = "WEB-INF/wsdl/CalculatorService.wsdl")
@HandlerChain(file="/META-INF/handler-chain.xml")
@EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
public class CalculatorServiceImpl implements CalculatorService {

	/* (non-Javadoc)
	 * @see com.cognizant.CalculatorService#multiply(int, int)
	 */
	@Override
	@WebResult(name = "return", targetNamespace = "")
	@RequestWrapper(localName = "multiply", targetNamespace = "http://cognizant.com/", className = "com.cognizant.Multiply")
	@WebMethod
	@ResponseWrapper(localName = "multiplyResponse", targetNamespace = "http://cognizant.com/", className = "com.cognizant.MultiplyResponse")
	public int multiply(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1) {		
		System.out.println("Hits the multiply method");
		return arg0 * arg1;
	}

	/* (non-Javadoc)
	 * @see com.cognizant.CalculatorService#add(int, int)
	 */
	@Override
	@WebResult(name = "return", targetNamespace = "")
	@RequestWrapper(localName = "add", targetNamespace = "http://cognizant.com/", className = "com.cognizant.Add")
	@WebMethod
	@ResponseWrapper(localName = "addResponse", targetNamespace = "http://cognizant.com/", className = "com.cognizant.AddResponse")
	public int add(@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "arg1", targetNamespace = "") int arg1) {
		System.out.println("Hits the add method");
		return arg0 + arg1;
	}

}
