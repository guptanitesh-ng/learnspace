package com.cts.service;


public class CurrencyConversionRequest {

  private String convertToCurrency;
  
  private double amountToConvert;
  
  private String convertFromCurrency;

  public String getRequestedCurrency() {
    return convertToCurrency;
  }

  public void setRequestedCurrency(String requestedCurrency) {
    this.convertToCurrency = requestedCurrency;
  }

  public double getAmount() {
    return amountToConvert;
  }

  public void setAmount(double amount) {
    this.amountToConvert = amount;
  }

  public String getAmountCurrency() {
    return convertFromCurrency;
  }

  public void setAmountCurrency(String amountCurrency) {
    this.convertFromCurrency = amountCurrency;
  }
  
}
