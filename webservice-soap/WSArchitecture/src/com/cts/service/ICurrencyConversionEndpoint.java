package com.cts.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
public interface ICurrencyConversionEndpoint {

  @WebMethod
  public CurrencyConversionResponse convert(@WebParam(name="ccr") CurrencyConversionRequest request);
}
