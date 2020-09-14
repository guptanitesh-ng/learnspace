package com.cts.service.client;

import java.rmi.RemoteException;

import org.tempuri.areaservice.Dimensions;
import org.tempuri.areaservice.Parameters;

import com.cts.service.AreaServiceStub;

public class AreaServiceClient {

  /**
   * @param args
   * @throws RemoteException 
   */
  public static void main(String[] args) throws RemoteException {
    AreaServiceStub stub = new AreaServiceStub();
    Parameters params = new Parameters();
    Dimensions dimensions = new Dimensions();
    dimensions.setHeight(3);
    dimensions.setWidth(3);
    params.setParameters(dimensions);
    System.out.println(stub.calculateRectArea(params).getArea());
    
    stub.startcalculateRectArea(params, new AreaServiceCallbackClient());
  }

}
