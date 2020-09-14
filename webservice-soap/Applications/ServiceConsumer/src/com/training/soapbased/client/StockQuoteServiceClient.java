/**
 * 
 */
package com.training.soapbased.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 * @author 150088
 * 
 */
public class StockQuoteServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage message = messageFactory.createMessage();

		// Create objects for the message parts
		SOAPPart SOAPPart = message.getSOAPPart();
		SOAPEnvelope envelope = SOAPPart.getEnvelope();
		SOAPBody body = envelope.getBody();

		SOAPElement bodyElement = body.addChildElement(envelope.createName(
				"getStockPrice", "sq",
				"http://soapapproach.service.training.com/StockQuoteService"));
		bodyElement.addChildElement("stockCode").addTextNode("INA");
		message.saveChanges();

		printSOAPMessage(message);

		// Now create the connection
		SOAPConnectionFactory SOAPConnFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection connection = SOAPConnFactory.createConnection();

		SOAPMessage reply = connection.call(message,
				"http://localhost:8080/ServiceProvider/stockquote");
			
		printSOAPMessage(reply);
		connection.close();

	}

	private static void printSOAPMessage(SOAPMessage message) throws SOAPException,
			IOException {
		ByteArrayOutputStream baos = null;
		String s = null;

		baos = new ByteArrayOutputStream();
		message.writeTo(baos);
		s = baos.toString();
		System.out.println(s);
	}

}
