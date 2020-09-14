package com.concepts.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageProducerClient {

	public static void main(String[] args) throws Exception {
		Context initialContext = getJNDIContext();		
		ConnectionFactory factory = (ConnectionFactory)initialContext.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);		
		Queue conceptQueue =(Queue)initialContext.lookup("queue/conceptQueue");
		MessageProducer sender = session.createProducer(conceptQueue);
		for(int msgCount=0; msgCount<10; msgCount++) {
			sender.send(createMessages(session, "ConceptMessage"+msgCount));
		}
	}
	
	public static Message createMessages(Session session, String msgValue) throws JMSException {		
		Message textMessage = session.createTextMessage();
		textMessage.setStringProperty("Token1", msgValue);
		return textMessage;
	}
	
	public static Context getJNDIContext() throws NamingException {
		java.util.Properties properties = new java.util.Properties();		    
		properties.put(Context.SECURITY_PRINCIPAL, "guest");
		properties.put(Context.SECURITY_CREDENTIALS, "guest");
		properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,
	        "org.jboss.security.jndi.JndiLoginInitialContextFactory");
	    properties.put(Context.URL_PKG_PREFIXES, 
	    		"org.jboss.naming:org.jnp.interfaces");
	    properties.put(javax.naming.Context.PROVIDER_URL, 
				"localhost:1099");		
		return new InitialContext(properties);
	}
}
