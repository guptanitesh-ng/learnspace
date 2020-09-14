package com.concept.ejb.webservice;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class WebServiceClient {

  /**
   * @param args
 * @throws Exception 
   */
  public static void main(String[] args) throws Exception {
    InterestCalculatorService service = new InterestCalculatorService();
    System.out.println(service.getInterestCalculatorPort().calculateSimpleInterest(1000, 8.25f, 365));
    service.getInterestCalculatorPort().calculateSimpleInterestAsync(1000, 8.5f, 365, new AsyncHandler<CalculateSimpleInterestResponse>() {
		
		@Override
		public void handleResponse(Response<CalculateSimpleInterestResponse> response) {
			System.out.println("Inside async. handler");
			try {
				System.out.println(response.get().getReturn());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
    Thread.sleep(1000);
    Response<CalculateSimpleInterestResponse> response = service.getInterestCalculatorPort().calculateSimpleInterestAsync(10000, 9.25f, 365);
    while (!response.isDone()) {
    	System.out.println("I am waiting");
    }
    System.out.println(response.get().getReturn());
  }
  
}
