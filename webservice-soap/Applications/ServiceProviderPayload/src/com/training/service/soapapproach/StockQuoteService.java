/**
 * 
 */
package com.training.service.soapapproach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

import org.w3c.dom.Node;

/**
 * @author 150088
 * 
 */
@WebServiceProvider(portName = "StockQuoteServiceSOAP11port", serviceName = "StockQuoteService", wsdlLocation = "WEB-INF/StockQuote.wsdl")
@ServiceMode(value = Mode.PAYLOAD)
@BindingType(value = "http://schemas.xmlsoap.org/wsdl/soap/http")
public class StockQuoteService implements Provider<Source> {

	@Override
	public Source invoke(Source request) {
		try {
			DOMResult dom = new DOMResult();
		      Transformer trans = TransformerFactory.newInstance().newTransformer();
		      trans.transform(request, dom);
		      Node node = dom.getNode();
		      // Get the operation name node.
		      Node root = node.getFirstChild();
		      // Get the parameter node.
		      Node first = root.getFirstChild();
		      String input = first.getFirstChild().getNodeValue();
		      // Get the operation name.
		      String op = root.getLocalName();
		      System.out.println(op + "\t" + input);
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
			Source source = new StreamSource(new ByteArrayInputStream(printSOAPMessage(message).getBytes()));
			return source;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private String printSOAPMessage(SOAPMessage request) throws SOAPException,
			IOException {
		ByteArrayOutputStream baos = null;
		String s = null;
		baos = new ByteArrayOutputStream();
		request.writeTo(baos);
		s = baos.toString();
		System.out.println(s);
		return s;
	}
}
