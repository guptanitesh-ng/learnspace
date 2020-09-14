package com.cts.service;

public class MathCallbackHandlerImpl extends MathCallbackHandler {

	public void receiveResultadd(com.cts.service.MathStub.AddResponse result) {
		System.out.println(result.get_return());
	}
	
	public void receiveErroradd(java.lang.Exception e) {
		e.printStackTrace();
	}
}
