/**
 * 
 */
package com.cognizant.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * @author 150088
 * 
 */
public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			SOAPMessage message = context.getMessage();
			printSOAPMessage(message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
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

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
