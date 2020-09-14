package com.concepts.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CallbackClient {
	
	public static void main(String[] args) throws JMSException {		
		try {
			java.util.Properties properties = new java.util.Properties();		    
			properties.put(Context.SECURITY_PRINCIPAL, "guest");
			properties.put(Context.SECURITY_CREDENTIALS, "guest");
			properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,
		        "org.jboss.security.jndi.JndiLoginInitialContextFactory");
		    properties.put(Context.URL_PKG_PREFIXES, 
		    		"org.jboss.naming:org.jnp.interfaces");
		    properties.put(javax.naming.Context.PROVIDER_URL, 
    				"localhost:1099");
			Context initialContext = new InitialContext(properties);			
			ConnectionFactory factory = (ConnectionFactory)initialContext.lookup("ConnectionFactory");
			Connection connection = factory.createConnection();
			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			
			Queue ticketQueue =(Queue)initialContext.lookup("queue/conceptQueue");
			
			
			/*Object object = initialContext.lookup("CallbackMethods/remote");
			CallbackMethods callbackMethods = (CallbackMethods)object;
			callbackMethods.invokeBean();*/			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

}
