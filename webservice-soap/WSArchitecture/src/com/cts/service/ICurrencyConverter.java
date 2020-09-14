package com.cts.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, parameterStyle=SOAPBinding.ParameterStyle.BARE)
public interface ICurrencyConverter {

  @WebMethod
  public double getConvertedAmount(String toCurrencyCode, double amount, String fromCurrencyCode);
}
