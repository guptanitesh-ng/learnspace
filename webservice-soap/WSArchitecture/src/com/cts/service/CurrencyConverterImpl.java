package com.cts.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.cts.service.ICurrencyConverter")
public class CurrencyConverterImpl implements ICurrencyConverter {
  
  @Override
  public double getConvertedAmount(String toCurrencyCode, double amount,
      String fromCurrencyCode) {    
    return 50;
  }

}
