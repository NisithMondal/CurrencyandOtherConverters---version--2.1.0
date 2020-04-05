package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class FrequencyConverter {

    private final int  hertzId = 1, kiloHertzId = 2, megaHertzId = 3, gigaHertzId = 4, teraHertzId = 5;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Hertz (Hz)")) {
            idValue = hertzId;

        } else if (unitName.equalsIgnoreCase("KiloHertz (kHz)")) {
            idValue = kiloHertzId;

        } else if (unitName.equalsIgnoreCase("MegaHertz (MHz)")) {
            idValue = megaHertzId;

        } else if (unitName.equalsIgnoreCase("GigaHertz (GHz)")) {
            idValue = gigaHertzId;

        }else if (unitName.equalsIgnoreCase("TeraHertz (THz)")){
            idValue = teraHertzId;
        }
        return idValue;
    }


    public double getFrequencyConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("Hertz (Hz)")){
            result = hertzToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("KiloHertz (KHz)")) {
            result = kiloHertzToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MegaHertz (MHz)")) {
            result = megaHertzToOthers(sourceUnit,destUnit,value);

        }  else if (sourceUnit.equalsIgnoreCase("GigaHertz (GHz)")) {
            result = gigaHertzToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("TeraHertz (THz)")) {
            result = teraHertzToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }





    private double hertzToOthers(String sourceUnit,String destUnit,double value){
        //This method converts value in Hertz to other units
        double result=0;
        switch (getUnitId(destUnit)){

            case hertzId:
                result = value;
                break;

            case kiloHertzId:
                result = value*0.001;
                break;
            case megaHertzId:
                result = value*Math.pow(10,-6);
                break;
            case gigaHertzId:
                result = value*Math.pow(10,-9);
                break;

            case teraHertzId:
                result = value*Math.pow(10,-12);
                break;

        }

        return result;
    }



    private double kiloHertzToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case hertzId:
                result = value*1000;
                break;

            case kiloHertzId:
                result = value;
                break;
            case megaHertzId:
                result = value*0.001;
                break;
            case gigaHertzId:
                result = value*Math.pow(10,-6);
                break;

            case teraHertzId:
                result = value*Math.pow(10,-9);
                break;

        }

        return result;
    }


    private double megaHertzToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case hertzId:
                result = value*Math.pow(10,6);
                break;

            case kiloHertzId:
                result = value*1000;
                break;
            case megaHertzId:
                result = value;
                break;
            case gigaHertzId:
                result = value*0.001;
                break;

            case teraHertzId:
                result = value*Math.pow(10,-6);
                break;

        }

        return result;
    }


    private double gigaHertzToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case hertzId:
                result = value*Math.pow(10,9);
                break;

            case kiloHertzId:
                result = value*Math.pow(10,6);
                break;
            case megaHertzId:
                result = value*Math.pow(10,3);
                break;
            case gigaHertzId:
                result = value;
                break;

            case teraHertzId:
                result = value*0.001;
                break;

        }

        return result;
    }

    private double teraHertzToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case hertzId:
                result = value*Math.pow(10,12);
                break;

            case kiloHertzId:
                result = value*Math.pow(10,9);
                break;
            case megaHertzId:
                result = value*Math.pow(10,6);
                break;
            case gigaHertzId:
                result = value*Math.pow(10,3);
                break;

            case teraHertzId:
                result = value;
                break;

        }

        return result;
    }













}
