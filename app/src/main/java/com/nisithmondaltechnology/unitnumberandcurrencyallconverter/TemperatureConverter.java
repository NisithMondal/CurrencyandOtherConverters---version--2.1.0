package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class TemperatureConverter {
    private final int celsiusId = 1, kelvinId = 2, fahrenheitId = 3;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Celsius (*C)")) {
            idValue = celsiusId;

        } else if (unitName.equalsIgnoreCase("Kelvin (K)")) {
            idValue = kelvinId;

        } else if (unitName.equalsIgnoreCase("Fahrenheit (*F)")) {
            idValue = fahrenheitId;

        }
        return idValue;
    }


    public double getTemperatureConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("Celsius (*C)")){
            result = celsiusToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("Kelvin (K)")) {
            result = kelvinToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Fahrenheit (*F)")) {
            result = fahrenheitToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }




    private double celsiusToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case celsiusId:
                result = value;
                break;

            case kelvinId:
                result = value+273.15;
                break;
            case fahrenheitId:
                result = value*9/5+32;
                break;
        }

        return result;
    }


    private double kelvinToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case celsiusId:
                result = value-273.15;
                break;

            case kelvinId:
                result = value;
                break;
            case fahrenheitId:
                result = (value-273.15)*9/5+32;
                break;
        }

        return result;
    }


    private double fahrenheitToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case celsiusId:
                result = (value-32)*5/9;
                break;

            case kelvinId:
                result = (value-32)*5/9+273.15;
                break;
            case fahrenheitId:
                result = value;
                break;
        }

        return result;
    }

}
