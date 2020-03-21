package com.nisith.currencyandotherconverters;

public class CurrencyInfoHolder {
    private String currencyName;
    private String currencyRate;

    public CurrencyInfoHolder(String currencyName, String currencyRate) {
        this.currencyName = currencyName;
        this.currencyRate = currencyRate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }
}
