package com.cts.service;


public class CurrencyConversionResponse {

  private double convertedAmount;
  
  private String convertedToCurrency;
  
  private double amountConverted;
  
  private String convertedFromCurrency;

  public double getConvertedAmount() {
    return convertedAmount;
  }

  public void setConvertedAmount(double convertedAmount) {
    this.convertedAmount = convertedAmount;
  }

  public String getConvertedToCurrency() {
    return convertedToCurrency;
  }

  public void setConvertedToCurrency(String convertedToCurrency) {
    this.convertedToCurrency = convertedToCurrency;
  }

  public double getAmountConverted() {
    return amountConverted;
  }

  public void setAmountConverted(double amountConverted) {
    this.amountConverted = amountConverted;
  }

  public String getConvertedFromCurrency() {
    return convertedFromCurrency;
  }

  public void setConvertedFromCurrency(String convertedFromCurrency) {
    this.convertedFromCurrency = convertedFromCurrency;
  }
  
}
