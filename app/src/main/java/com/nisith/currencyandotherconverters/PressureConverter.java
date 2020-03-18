package com.nisith.currencyandotherconverters;

public class PressureConverter {

   private final int barId = 1,torrId = 2,pascalId = 3,atmosphereId = 4;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Bar")) {
            idValue = barId;

        } else if (unitName.equalsIgnoreCase("Torr")) {
            idValue = torrId;

        } else if (unitName.equalsIgnoreCase("Pascal")) {
            idValue = pascalId;

        } else if (unitName.equalsIgnoreCase("Atmosphere")) {
            idValue = atmosphereId;

        }
        return idValue;
    }


    public double getLengthConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("Bar")){
            result = barToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("Torr")) {
            result = torrToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Pascal")) {
            result = pascalToOthers(sourceUnit,destUnit,value);

        }  else if (sourceUnit.equalsIgnoreCase("Atmosphere")) {
            result = atmosphereToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }



    private double barToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case barId:
                result = value;
                break;

            case torrId:
                result = value*750.062;
                break;
            case pascalId:
                result = value*100000;
                break;
            case atmosphereId:
                result = value*0.986923;
                break;
        }

        return result;
    }

    private double torrToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case barId:
                result = value*0.00133322;
                break;

            case torrId:
                result = value;
                break;
            case pascalId:
                result = value*133.322;
                break;
            case atmosphereId:
                result = value/760;
                break;

        }

        return result;
    }

    private double pascalToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case barId:
                result = value*Math.pow(10,-5);
                break;

            case torrId:
                result = value*0.00750062;
                break;
            case pascalId:
                result = value;
                break;
            case atmosphereId:
                result = value/101325;
                break;

        }

        return result;
    }



    private double atmosphereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case barId:
                result = value*1.01325;
                break;

            case torrId:
                result = value*760;
                break;
            case pascalId:
                result = value*101325;
                break;
            case atmosphereId:
                result = value;
                break;

        }

        return result;
    }








}
