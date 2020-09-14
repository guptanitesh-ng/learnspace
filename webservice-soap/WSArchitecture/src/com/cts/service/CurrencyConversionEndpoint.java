package com.cts.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.cts.service.ICurrencyConversionEndpoint")
public class CurrencyConversionEndpoint implements ICurrencyConversionEndpoint {

  public CurrencyConversionResponse convert(CurrencyConversionRequest request) {
    CurrencyConversionResponse response = new CurrencyConversionResponse();
    response.setAmountConverted(request.getAmount());
    response.setConvertedAmount(1);
    response.setConvertedFromCurrency(request.getAmountCurrency());
    response.setConvertedToCurrency(request.getRequestedCurrency());
    return new CurrencyConversionResponse();
  }
}
