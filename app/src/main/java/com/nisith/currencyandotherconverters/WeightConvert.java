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

        } else if (unitName.equalsIgnoreCase("stone (UK)")) {
            idValue = stoneId;

        } else if (unitName.equalsIgnoreCase("pound")) {
            idValue = poundId;

        } else if (unitName.equalsIgnoreCase("ounce")) {
            idValue = ounceId;

        } else if (unitName.equalsIgnoreCase("usTon")) {
            idValue = usTonId;

        } else if (unitName.equalsIgnoreCase("imperialTon (UK)")) {
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

        } else if (sourceUnit.equalsIgnoreCase("stone (UK)")) {
            result = stoneToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("pound")) {
            result = poundToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("ounce")) {
            result = ounceToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("usTon")) {
            result = usTonToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("imperialTon (UK)")) {

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
                result = value*0.0022046226;
                break;

            case ounceId:
                result = value*0.0352739619;
                break;

            case usTonId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case imperialTonId:
                result = value*9.842065276*Math.pow(10,-7);
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
                result = value*0.1574730444;
                break;
            case poundId:
                result = value*2.2046226218;
                break;

            case ounceId:
                result = value*35.27396195;
                break;

            case usTonId:
                result = value*0.0011023113;
                break;

            case imperialTonId:
                result = value*0.0009842065;
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
                result = value*1.574730444*Math.pow(10,-7);
                break;
            case poundId:
                result = value*2.2046*Math.pow(10,-6);
                break;

            case ounceId:
                result = value*3.5274*Math.pow(10,-5);
                break;

            case usTonId:
                result = value*1.10231131*Math.pow(10,-9);
                break;

            case imperialTonId:
                result = value*9.842065276*Math.pow(10,-10);
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
                result = value*1.574730444*Math.pow(10,-10);
                break;
            case poundId:
                result = value*2.204622621*Math.pow(10,-9);
                break;

            case ounceId:
                result = value*3.527396194*Math.pow(10,-8);
                break;

            case usTonId:
                result = value*1.10231131*Math.pow(10,-12);
                break;

            case imperialTonId:
                result = value*9.842065276*Math.pow(10,-13);
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
                result = value*157.47304442;
                break;
            case poundId:
                result = value*2204.6226218;
                break;

            case ounceId:
                result = value*35273.96195;
                break;

            case usTonId:
                result = value*1.1023113109;
                break;

            case imperialTonId:
                result = value*0.9842065276;
                break;

        }

        return result;
    }



    private double stoneToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*6350.29318;
                break;

            case kilogramId:
                result = value*6.35029318;
                break;
            case milliGramId:
                result = value*6.35029318*Math.pow(10,6);
                break;
            case microGramId:
                result = value*6.350293180*Math.pow(10,9);
                break;
            case tonneId:
                result = value*0.0063502932;
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
                result = value*453.59237;
                break;

            case kilogramId:
                result = value*0.45359237;
                break;
            case milliGramId:
                result = value*453592.37;
                break;
            case microGramId:
                result = value*4.53592370*Math.pow(10,8);
                break;
            case tonneId:
                result = value*0.0004535924;
                break;

            case stoneId:
                result = value*0.0714285714;
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
                result = value*0.0004464286;
                break;

        }

        return result;
    }



    private double ounceToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*28.349523125;
                break;

            case kilogramId:
                result = value*0.0283495231;
                break;
            case milliGramId:
                result = value*28349.523125;
                break;
            case microGramId:
                result = value*2.8349523125*Math.pow(10,7);
                break;
            case tonneId:
                result = value*0.0000283495;
                break;

            case stoneId:
                result = value*0.0044642857;
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
                result = value*0.0000279018;
                break;

        }

        return result;
    }



    private double usTonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*907184.74;
                break;

            case kilogramId:
                result = value*907.18474;
                break;
            case milliGramId:
                result = value*9.07184740*Math.pow(10,8);
                break;
            case microGramId:
                result = value*9.07184740000*Math.pow(10,11);
                break;
            case tonneId:
                result = value*0.90718474;
                break;

            case stoneId:
                result = value*142.85714286;
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
                result = value*0.8928571429;
                break;

        }

        return result;
    }



    private double imperialTonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case gramId:
                result = value*1.0160469088*Math.pow(10,6);
                break;

            case kilogramId:
                result = value*1016.0469088;
                break;
            case milliGramId:
                result = value*1.0160469088*Math.pow(10,9);
                break;
            case microGramId:
                result = value*1.016046908800*Math.pow(10,12);
                break;
            case tonneId:
                result = value*1.0160469088;
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
