package com.cts.service;

import com.cts.service.MathStub.Add;
import com.cts.service.MathStub.AddResponse;


public class MathClient {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		MathStub math = new MathStub();
		Add addRequest = new Add();
		addRequest.setA(23);
		addRequest.setB(5);
		AddResponse response = math.add(addRequest);
		System.out.println(response.get_return());
		MathCallbackHandler callback = new MathCallbackHandlerImpl();
		math.startadd(addRequest, callback );
		
	}

}
