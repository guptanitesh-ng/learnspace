/**
 * 
 */
package com.cts.service.client;

import com.cts.service.AreaServiceCallbackHandler;

/**
 * @author 150088
 *
 */
public class AreaServiceCallbackClient extends AreaServiceCallbackHandler {

  public void receiveResultcalculateRectArea(org.tempuri.areaservice.Area result) {
    System.out.println("Received result inside callback " + result.getArea());
  }
  
  public void receiveErrorcalculateRectArea(java.lang.Exception e) {
    System.out.println("Inside Callback");
    e.printStackTrace();
  }
}
