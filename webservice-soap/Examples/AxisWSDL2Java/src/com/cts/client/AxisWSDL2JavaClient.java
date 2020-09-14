package com.cts.client;

import com.cts.math.ws.Add;
import com.cts.math.ws.AddE;
import com.cts.math.ws.AddResponseE;
import com.cts.service.MathServiceStub;

public class AxisWSDL2JavaClient {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		MathServiceStub mathServiceStub = new MathServiceStub();
		AddE addRequest = new AddE();
		Add param = new Add();
		param.setNum1(2);
		param.setNum2(3);
		addRequest.setAdd(param);
		AddResponseE response = mathServiceStub.add(addRequest);
		System.out.println(response.getAddResponse().getSum());
	}

}
