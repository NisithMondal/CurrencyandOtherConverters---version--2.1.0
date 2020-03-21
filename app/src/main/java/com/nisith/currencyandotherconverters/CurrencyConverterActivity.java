package com.nisith.currencyandotherconverters;

import java.util.ArrayList;

public class CurrencyConverterActivity {


    public String getCurrencyConvertionResult(String sourceCurrency, String destinationCurrency, double value, ArrayList<CurrencyInfoHolder> allCurrencyInfoArrayList){
        String result;
        boolean isSourceCurrencyPresentInArrayList = false,isDestinationCurrencyPresentInArrayList = false;
        //This both Currency rate value is with respect to USD .Like 1 USD = 75.34 INR or 1 USD = 0.9305 EUR
        double sourceCurrencyRate=0,destinationCurrencyRate=0;
        for (CurrencyInfoHolder currencyInfoHolder : allCurrencyInfoArrayList){
            //Get a Currency Name
            String currencyName = currencyInfoHolder.getCurrencyName();
            if (currencyName.equalsIgnoreCase(sourceCurrency)){
                //If the above currency Name is equal to the source CurrencyName of Currency Activity
                sourceCurrencyRate = Double.parseDouble(currencyInfoHolder.getCurrencyRate());
                //If both currencies are equal then assign true
                isSourceCurrencyPresentInArrayList = true;
            }
            if (currencyName.equalsIgnoreCase(destinationCurrency)){
                //If the above currency Name is equal to the destination CurrencyName of Currency Activity
                destinationCurrencyRate = Double.parseDouble(currencyInfoHolder.getCurrencyRate());
                //If both currencies are equal then assign true
                isDestinationCurrencyPresentInArrayList = true;
            }
            if (isSourceCurrencyPresentInArrayList && isDestinationCurrencyPresentInArrayList){
                //If both Currency rate is Available ,then break the loop
                break;
            }
        }

        if (isSourceCurrencyPresentInArrayList && isDestinationCurrencyPresentInArrayList){
            //If both Currency rate is Available ,then perform currency Convertion
            result = String.valueOf((destinationCurrencyRate*value)/sourceCurrencyRate);
        }else {
            //Else return failed message means convertion not perform
            result = "FAILED";
        }
        return result;
    }


}
