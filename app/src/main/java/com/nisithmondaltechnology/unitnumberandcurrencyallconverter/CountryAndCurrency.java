package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class CountryAndCurrency {
    private String countryName;
    private String currencyName;
    public CountryAndCurrency(String countryName,String currencyName){
        this.countryName = countryName;
        this.currencyName = currencyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }
}
