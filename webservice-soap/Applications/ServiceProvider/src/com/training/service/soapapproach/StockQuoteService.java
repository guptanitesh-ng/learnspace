/**
 * 
 */
package com.training.service.soapapproach;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

/**
 * @author 150088
 * 
 */
@WebServiceProvider(portName = "StockQuoteServiceSOAP11port", serviceName = "StockQuoteService", wsdlLocation = "WEB-INF/StockQuote.wsdl")
@ServiceMode(value = Mode.MESSAGE)
@BindingType(value = "http://schemas.xmlsoap.org/wsdl/soap/http")
public class StockQuoteService implements Provider<SOAPMessage> {

	@Override
	public SOAPMessage invoke(SOAPMessage request) {
		try {
			SOAPBody body = request.getSOAPPart().getEnvelope().getBody();
			System.out.println(body.getFirstChild().getTextContent());
			printSOAPMessage(request);
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
			SOAPBody responseBody = envelope.getBody();
			SOAPElement responseElement = responseBody
					.addChildElement(envelope
							.createName("getStockPrice", "sq",
									"http://soapapproach.service.training.com/StockQuoteService"));
			responseElement.addChildElement("currentPrice").addTextNode(
					"122.56");
			message.saveChanges();
			return message;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private void printSOAPMessage(SOAPMessage request) throws SOAPException,
			IOException {
		ByteArrayOutputStream baos = null;
		String s = null;
		baos = new ByteArrayOutputStream();
		request.writeTo(baos);
		s = baos.toString();
		System.out.println(s);
	}
}
