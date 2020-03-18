package com.nisith.currencyandotherconverters;

import java.text.DecimalFormat;

public class WeightConvert {
    private final int gramId = 1, kilogramId = 2,milliGramId = 3,microGramId = 4,tonneId = 5,
            stoneId = 6, poundId = 7,ounceId = 8,usTonId = 9, imperialTonId = 10;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("gram (gm)")) {
            idValue = gramId;

        } else if (unitName.equalsIgnoreCase("kilogram (kg)")) {
            idValue = kilogramId;

        } else if (unitName.equalsIgnoreCase("milligram (mg)")) {
            idValue = milliGramId;

        } else if (unitName.equalsIgnoreCase("microgram")) {
            idValue = microGramId;

        } else if (unitName.equalsIgnoreCase("tonne")) {
            idValue = tonneId;

        } else if (unitName.equalsIgnoreCase("stone")) {
            idValue = stoneId;

        } else if (unitName.equalsIgnoreCase("pound")) {
            idValue = poundId;

        } else if (unitName.equalsIgnoreCase("ounce")) {
            idValue = ounceId;

        } else if (unitName.equalsIgnoreCase("usTon")) {
            idValue = usTonId;

        } else if (unitName.equalsIgnoreCase("imperialTon")) {
            idValue = imperialTonId;
        }
        return idValue;
    }




    public double getWeightConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("gram (gm)")){
            result = gramToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("kilogram (kg)")) {
            result = kilogramToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("milligram (mg)")) {
            result = milligramToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("microgram")) {
            result = microgramToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("tonne")) {
            result = tonneToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("stone")) {
            result = stoneToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("pound")) {
            result = poundToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("ounce")) {
            result = ounceToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("usTon")) {
            result = usTonToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("imperialTon")) {

            result = imperialTonToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }


    private double gramToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value;
                break;

            case kilogramId:
                result = value*0.001;
                break;
            case milliGramId:
                result = value*1000;
                break;
            case microGramId:
                result = value*Math.pow(10,6);
                break;
            case tonneId:
                result = value*Math.pow(10,-6);
                break;

            case stoneId:
                result = value*0.000157473;
                break;
            case poundId:
                result = value/454;
                break;

            case ounceId:
                result = value/28.35;
                break;

            case usTonId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case imperialTonId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double kilogramToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*1000;
                break;

            case kilogramId:
                result = value;
                break;
            case milliGramId:
                result = value*Math.pow(10,6);
                break;
            case microGramId:
                result = value*Math.pow(10,9);
                break;
            case tonneId:
                result = value*0.001;
                break;

            case stoneId:
                result = value/6.35;
                break;
            case poundId:
                result = value*2.20462;
                break;

            case ounceId:
                result = value*35.274;
                break;

            case usTonId:
                result = value/907;
                break;

            case imperialTonId:
                result = value/1016;
                break;

        }

        return result;
    }



    private double milligramToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value/1000;
                break;

            case kilogramId:
                result = value*Math.pow(10,-6);
                break;
            case milliGramId:
                result = value;
                break;
            case microGramId:
                result = value*1000;
                break;
            case tonneId:
                result = value*Math.pow(10,-9);
                break;

            case stoneId:
                result = value*1.5747*Math.pow(10,-7);
                break;
            case poundId:
                result = value*2.2046*Math.pow(10,-6);
                break;

            case ounceId:
                result = value*3.5274*Math.pow(10,-5);
                break;

            case usTonId:
                result = value*1.1023*Math.pow(10,-9);
                break;

            case imperialTonId:
                result = value*9.8421*Math.pow(10,-10);
                break;

        }

        return result;
    }



    private double microgramToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*Math.pow(10,-6);
                break;

            case kilogramId:
                result = value*Math.pow(10,-9);
                break;
            case milliGramId:
                result = value*0.001;
                break;
            case microGramId:
                result = value;
                break;
            case tonneId:
                result = value*Math.pow(10,-12);
                break;

            case stoneId:
                result = value*1.5747*Math.pow(10,-10);
                break;
            case poundId:
                result = value*2.2046*Math.pow(10,-9);
                break;

            case ounceId:
                result = value*3.5274*Math.pow(10,-8);
                break;

            case usTonId:
                result = value*1.1023*Math.pow(10,-12);
                break;

            case imperialTonId:
                result = value*9.8421*Math.pow(10,-13);
                break;

        }

        return result;
    }



    private double tonneToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*Math.pow(10,6);
                break;

            case kilogramId:
                result = value*1000;
                break;
            case milliGramId:
                result = value*Math.pow(10,9);
                break;
            case microGramId:
                result = value*Math.pow(10,12);
                break;
            case tonneId:
                result = value;
                break;

            case stoneId:
                result = value*157.473;
                break;
            case poundId:
                result = value*2204.62;
                break;

            case ounceId:
                result = value*35274;
                break;

            case usTonId:
                result = value*1.10231;
                break;

            case imperialTonId:
                result = value*0.984207;
                break;

        }

        return result;
    }



    private double stoneToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*6350.29;
                break;

            case kilogramId:
                result = value*6.35029;
                break;
            case milliGramId:
                result = value*6.35*Math.pow(10,6);
                break;
            case microGramId:
                result = value*6.35*Math.pow(10,9);
                break;
            case tonneId:
                result = value*0.00635029;
                break;

            case stoneId:
                result = value;
                break;
            case poundId:
                result = value*14;
                break;

            case ounceId:
                result = value*224;
                break;

            case usTonId:
                result = value*0.007;
                break;

            case imperialTonId:
                result = value*0.00625;
                break;

        }

        return result;
    }



    private double poundToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*453.592;
                break;

            case kilogramId:
                result = value*0.453592;
                break;
            case milliGramId:
                result = value*453592;
                break;
            case microGramId:
                result = value*4.536*Math.pow(10,8);
                break;
            case tonneId:
                result = value*0.000453592;
                break;

            case stoneId:
                result = value*0.0714286;
                break;
            case poundId:
                result = value;
                break;

            case ounceId:
                result = value*16;
                break;

            case usTonId:
                result = value*0.0005;
                break;

            case imperialTonId:
                result = value*0.000446429;
                break;

        }

        return result;
    }



    private double ounceToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*28.3495;
                break;

            case kilogramId:
                result = value*0.0283495;
                break;
            case milliGramId:
                result = value*28349.5;
                break;
            case microGramId:
                result = value*2.835*Math.pow(10,7);
                break;
            case tonneId:
                result = value*2.835*Math.pow(10,-5);
                break;

            case stoneId:
                result = value*0.00446429;
                break;
            case poundId:
                result = value*0.0625;
                break;

            case ounceId:
                result = value;
                break;

            case usTonId:
                result = value*3.125*Math.pow(10,-5);
                break;

            case imperialTonId:
                result = value*2.7902*Math.pow(10,-5);
                break;

        }

        return result;
    }



    private double usTonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*907185;
                break;

            case kilogramId:
                result = value*907.185;
                break;
            case milliGramId:
                result = value*9.072*Math.pow(10,8);
                break;
            case microGramId:
                result = value*9.072*Math.pow(10,11);
                break;
            case tonneId:
                result = value*0.907185;
                break;

            case stoneId:
                result = value*142.857;
                break;
            case poundId:
                result = value*2000;
                break;

            case ounceId:
                result = value*32000;
                break;

            case usTonId:
                result = value;
                break;

            case imperialTonId:
                result = value*0.892857;
                break;

        }

        return result;
    }



    private double imperialTonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*1.016*Math.pow(10,6);
                break;

            case kilogramId:
                result = value*1016.05;
                break;
            case milliGramId:
                result = value*1.016*Math.pow(10,9);
                break;
            case microGramId:
                result = value*1.016*Math.pow(10,12);
                break;
            case tonneId:
                result = value*1.01605;
                break;

            case stoneId:
                result = value*160;
                break;
            case poundId:
                result = value*2240;
                break;

            case ounceId:
                result = value*35840;
                break;

            case usTonId:
                result = value*1.12;
                break;

            case imperialTonId:
                result = value;
                break;

        }

        return result;
    }







}
