package com.concepts.jee.bean.session.stateful;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful(mappedName="CallbackMethods")
@Remote(CallbackMethods.class)
public class CallbackMethodsImpl implements CallbackMethods {

	public void invokeBean() {
		System.out.println("** Inside invoke bean");
		//return "bean invoked";
	}

}
