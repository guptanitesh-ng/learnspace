package com.concepts.jee.support;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

	public static Object getRemoteObject(String jndiName) {
		Object remoteObject = null;
		try {
			remoteObject = getJNDIContext().lookup(jndiName+"/remote");
		} catch(NamingException e) {
			e.printStackTrace();
		}
		return remoteObject;
	}
	
	private static Context getJNDIContext() throws NamingException {
		Context jndiContext = null;		
			java.util.Properties properties = new java.util.Properties();		    
		properties.put(Context.SECURITY_PRINCIPAL, "guest");
		properties.put(Context.SECURITY_CREDENTIALS, "guest");
		properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,
	        "org.jboss.security.jndi.JndiLoginInitialContextFactory");
	    properties.put(Context.URL_PKG_PREFIXES, 
	    		"org.jboss.naming:org.jnp.interfaces");
	    properties.put(javax.naming.Context.PROVIDER_URL, 
				"localhost:1099");				
		jndiContext = new InitialContext(properties);		
		return jndiContext;
	}
}
