package com.cts.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.cts.service.BankDetails;
import com.cts.service.CurrencyConversionRequest;
import com.cts.service.CurrencyConversionResponse;
import com.cts.service.ICurrencyConversionEndpoint;

public class CurrencyConverterClient {

  public static void main(String[] args) throws Exception {
    URL url = new URL("http://127.0.0.1:80/currencyconverter?wsdl");
    QName qualifiedName = new QName("http://service.cts.com/", "CurrencyConversionEndpointService");
    Service service = Service.create(url, qualifiedName);
    ICurrencyConversionEndpoint currencyConverter = service.getPort(ICurrencyConversionEndpoint.class);
    CurrencyConversionRequest request = new CurrencyConversionRequest();
    request.setAmount(50);
    request.setAmountCurrency("INR");
    request.setRequestedCurrency("USD");
    CurrencyConversionResponse result = currencyConverter.convert(request);
    System.out.println(result);
  }
}
