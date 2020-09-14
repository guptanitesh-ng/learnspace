/**
 * 
 */
package com.training.soapbased.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

/**
 * @author 150088
 * 
 */
public class StockServiceDispatchClient {

	/*
	 * @WebServiceRef(wsdlLocation=
	 * "http://localhost:8080/ServiceProvider/stockquote?wsdl") private static
	 * Service service;
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Service service = Service
				.create(new QName("http://soapapproach.service.training.com",
						"StockQuoteService"));
		service.addPort(new QName("http://soapapproach.service.training.com",
				"StockQuoteServiceSOAP11port"), SOAPBinding.SOAP11HTTP_BINDING,
				"http://localhost:8080/ServiceProviderPayload/stockquote");
		Dispatch<Source> dispatch = service.createDispatch(new QName(
				"http://soapapproach.service.training.com",
				"StockQuoteServiceSOAP11port"), Source.class,
				Service.Mode.PAYLOAD);
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
		//printSOAPMessage(message);
		Source source = dispatch.invoke(new StreamSource(new StringReader("<sq:getStockPrice xmlns:sq=\"http://soapapproach.service.training.com/StockQuoteService\"><stockCode>INA</stockCode></sq:getStockPrice>")));
		System.out.println(sourceToXMLString(source));
		//printSOAPMessage(message);
	}
	
	private static String sourceToXMLString(Source result) {
	      String xmlResult = null;
	      try {
	         TransformerFactory factory = TransformerFactory.newInstance();
	         Transformer transformer = factory.newTransformer();
	         transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	         transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	         OutputStream out = new ByteArrayOutputStream();
	         StreamResult streamResult = new StreamResult();
	         streamResult.setOutputStream(out);
	         transformer.transform(result, streamResult);
	         xmlResult = streamResult.getOutputStream().toString();
	      } catch (TransformerException e) {
	         e.printStackTrace();
	      }
	      return xmlResult;
	   }

	private static void printSOAPMessage(SOAPMessage message)
			throws SOAPException, IOException {
		ByteArrayOutputStream baos = null;
		String s = null;

		baos = new ByteArrayOutputStream();
		message.writeTo(baos);
		s = baos.toString();
		System.out.println(s);
	}
}
