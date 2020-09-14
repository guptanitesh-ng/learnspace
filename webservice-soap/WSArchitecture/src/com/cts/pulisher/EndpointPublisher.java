package com.cts.pulisher;

import javax.xml.ws.Endpoint;

import com.cts.service.CurrencyConversionEndpoint;
import com.cts.service.CurrencyConverterImpl;

public class EndpointPublisher {

  public static void main(String[] args) {
    /*Endpoint.publish("http://127.0.0.1:8888/currencyconverter",
        new CurrencyConverterImpl());*/
    
    Endpoint.publish("http://127.0.0.1:8888/currencyconverter",
        new CurrencyConversionEndpoint());
  }
}
