package com.nisith.currencyandotherconverters;

public class SpeedConverter {

    private final int meterPerSecondId = 1, meterPerMuniteId = 2,centimeterPerSecondId = 3,kilometerPerSecondId = 4,kilometerPerMinuteId = 5,
            kilometerPerHourId = 6, milePerHourId = 7,footPerSecondId = 8,yardPerSecondId = 9;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("meter/second (m/s)")) {
            idValue = meterPerSecondId;

        } else if (unitName.equalsIgnoreCase("meter/minute (m/min)")) {
            idValue = meterPerMuniteId;

        } else if (unitName.equalsIgnoreCase("centimeter/second (cm/s)")) {
            idValue = centimeterPerSecondId;

        } else if (unitName.equalsIgnoreCase("kilometer/second (km/s)" )) {
            idValue = kilometerPerSecondId;

        } else if (unitName.equalsIgnoreCase("kilometer/minute (km/min)")) {
            idValue = kilometerPerMinuteId;

        } else if (unitName.equalsIgnoreCase("kilometer/hour (km/h)")) {
            idValue = kilometerPerHourId;

        } else if (unitName.equalsIgnoreCase("mile/hour (mph)")) {
            idValue = milePerHourId;

        } else if (unitName.equalsIgnoreCase("foot/second (ft/s)")) {
            idValue = footPerSecondId;

        } else if (unitName.equalsIgnoreCase("yard/second")) {
            idValue = yardPerSecondId;

        }


        return idValue;
    }



    public double getWeightConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("meter/second (m/s)")){
            result = meterPerSecondToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("meter/minute (m/min)")) {
            result = meterPerMuniteToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("centimeter/second (cm/s)")) {
            result = centimeterPerSecondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("kilometer/second (km/s)")) {
            result = kilometerPerSecondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("kilometer/minute (km/min)")) {
            result = kilometerPerMinuteToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("kilometer/hour (km/h)")) {
            result = kilometerPerHourToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("mile/hour (mph)")) {
            result = milePerHourToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("foot/second (ft/s)")) {
            result = footPerSecondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("yard/second")) {
            result = yardPerSecondToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }




    private double meterPerSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value;
                break;

            case meterPerMuniteId:
                result = value*60;
                break;
            case centimeterPerSecondId:
                result = value*100;
                break;
            case kilometerPerSecondId:
                result = value*Math.pow(10,-3);
                break;
            case kilometerPerMinuteId:
                result = value*0.06;
                break;

            case kilometerPerHourId:
                result = value*3.6;
                break;
            case milePerHourId:
                result = value*2.23694;
                break;

            case footPerSecondId:
                result = value*3.28084;
                break;

            case yardPerSecondId:
                result = value*1.09361;
                break;

        }

        return result;
    }






    private double meterPerMuniteToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value/60;
                break;

            case meterPerMuniteId:
                result = value;
                break;
            case centimeterPerSecondId:
                result = value*1.66667;
                break;
            case kilometerPerSecondId:
                result = value/60000;
                break;
            case kilometerPerMinuteId:
                result = value/1000;
                break;

            case kilometerPerHourId:
                result = value*0.06;
                break;
            case milePerHourId:
                result = value/26.822;
                break;

            case footPerSecondId:
                result = value/18.288;
                break;

            case yardPerSecondId:
                result = value/54.864;
                break;

        }

        return result;
    }




    private double centimeterPerSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value*0.01;
                break;

            case meterPerMuniteId:
                result = value*0.6;
                break;
            case centimeterPerSecondId:
                result = value;
                break;
            case kilometerPerSecondId:
                result = value*Math.pow(10,-5);
                break;
            case kilometerPerMinuteId:
                result = value*0.0006;
                break;

            case kilometerPerHourId:
                result = value*0.036;
                break;
            case milePerHourId:
                result = value*0.0223694;
                break;

            case footPerSecondId:
                result = value*0.0328084;
                break;

            case yardPerSecondId:
                result = value/91.44;
                break;

        }

        return result;
    }






    private double kilometerPerSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value*1000;
                break;

            case meterPerMuniteId:
                result = value*60000;
                break;
            case centimeterPerSecondId:
                result = value*100000;
                break;
            case kilometerPerSecondId:
                result = value;
                break;
            case kilometerPerMinuteId:
                result = value*60;
                break;

            case kilometerPerHourId:
                result = value*3600;
                break;
            case milePerHourId:
                result = value*2237;
                break;

            case footPerSecondId:
                result = value*3280.84;
                break;

            case yardPerSecondId:
                result = value*1093.61;
                break;

        }

        return result;
    }






    private double kilometerPerMinuteToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value*1000/60;
                break;

            case meterPerMuniteId:
                result = value*1000;
                break;
            case centimeterPerSecondId:
                result = value*1666.67;
                break;
            case kilometerPerSecondId:
                result = value/60;
                break;
            case kilometerPerMinuteId:
                result = value;
                break;

            case kilometerPerHourId:
                result = value*60;
                break;
            case milePerHourId:
                result = value*37.2823;
                break;

            case footPerSecondId:
                result = value*54.6807;
                break;

            case yardPerSecondId:
                result = value*18.2269;
                break;

        }

        return result;
    }








    private double kilometerPerHourToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value/3.6;
                break;

            case meterPerMuniteId:
                result = value*16.6667;
                break;
            case centimeterPerSecondId:
                result = value*27.7778;
                break;
            case kilometerPerSecondId:
                result = value/3600;
                break;
            case kilometerPerMinuteId:
                result = value*60;
                break;

            case kilometerPerHourId:
                result = value;
                break;
            case milePerHourId:
                result = value/1.609;
                break;

            case footPerSecondId:
                result = value/1.097;
                break;

            case yardPerSecondId:
                result = value/3.292;
                break;

        }

        return result;
    }








    private double milePerHourToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value/2.237;
                break;

            case meterPerMuniteId:
                result = value*26.8224;
                break;
            case centimeterPerSecondId:
                result = value*44.704;
                break;
            case kilometerPerSecondId:
                result = value/2237;
                break;
            case kilometerPerMinuteId:
                result = value*37.2823;
                break;

            case kilometerPerHourId:
                result = value*1.60934;
                break;
            case milePerHourId:
                result = value;
                break;

            case footPerSecondId:
                result = value*1.46667;
                break;

            case yardPerSecondId:
                result = value/2.045;
                break;

        }

        return result;
    }






    private double footPerSecondToOthers(String sourceUnit,String destUnit,double value){  //Baki
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value/3.281;
                break;

            case meterPerMuniteId:
                result = value*18.288;
                break;
            case centimeterPerSecondId:
                result = value*30.48;
                break;
            case kilometerPerSecondId:
                result = value/3281;
                break;
            case kilometerPerMinuteId:
                result = value/54.681;
                break;

            case kilometerPerHourId:
                result = value*1.09728;
                break;
            case milePerHourId:
                result = value/1.467;
                break;

            case footPerSecondId:
                result = value;
                break;

            case yardPerSecondId:
                result = value/3;
                break;

        }

        return result;
    }






    private double yardPerSecondToOthers(String sourceUnit,String destUnit,double value){  //Baki
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value/1.094;
                break;

            case meterPerMuniteId:
                result = value*54.864;
                break;
            case centimeterPerSecondId:
                result = value*91.44;
                break;
            case kilometerPerSecondId:
                result = value/1094;
                break;
            case kilometerPerMinuteId:
                result = value/18.227;
                break;

            case kilometerPerHourId:
                result = value*3.29184;
                break;
            case milePerHourId:
                result = value*2.04545;
                break;

            case footPerSecondId:
                result = value*3;
                break;

            case yardPerSecondId:
                result = value;
                break;

        }

        return result;
    }



}
