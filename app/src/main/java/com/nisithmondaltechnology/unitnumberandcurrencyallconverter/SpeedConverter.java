package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

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

        } else if (unitName.equalsIgnoreCase("yard/second (y/s)")) {
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

        } else if (sourceUnit.equalsIgnoreCase("yard/second (y/s)")) {
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
                result = value*2.236936292054;
                break;

            case footPerSecondId:
                result = value*3.280839895013;
                break;

            case yardPerSecondId:
                result = value*1.093613298338;
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
                result = value*1.666666666667;
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
                result = value*0.03728227153424;
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
                result = value*0.02236936292054;
                break;

            case footPerSecondId:
                result = value*0.03280839895013;
                break;

            case yardPerSecondId:
                result = value*0.01093613298338;
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
                result = value*2236.936292054 ;
                break;

            case footPerSecondId:
                result = value*3280.839895013 ;
                break;

            case yardPerSecondId:
                result = value*1093.613298338 ;
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
                result = value*1666.666666667;
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
                result = value*37.28227153424;
                break;

            case footPerSecondId:
                result = value*54.68066491689;
                break;

            case yardPerSecondId:
                result = value*18.22688830563;
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
                result = value*16.66666666667;
                break;
            case centimeterPerSecondId:
                result = value*27.77777777778;
                break;
            case kilometerPerSecondId:
                result = value/3600;
                break;
            case kilometerPerMinuteId:
                result = value*0.01666666666667;
                break;

            case kilometerPerHourId:
                result = value;
                break;
            case milePerHourId:
                result = value*0.6213711922373;
                break;

            case footPerSecondId:
                result = value*0.9113444152814;
                break;

            case yardPerSecondId:
                result = value*0.3037814717605;
                break;

        }

        return result;
    }








    private double milePerHourToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case meterPerSecondId:
                result = value*0.44704;
                break;

            case meterPerMuniteId:
                result = value*26.8224;
                break;
            case centimeterPerSecondId:
                result = value*44.704;
                break;
            case kilometerPerSecondId:
                result = value*0.00044704;
                break;
            case kilometerPerMinuteId:
                result = value*0.0268224;
                break;

            case kilometerPerHourId:
                result = value*1.609344;
                break;
            case milePerHourId:
                result = value;
                break;

            case footPerSecondId:
                result = value*1.466666666667;
                break;

            case yardPerSecondId:
                result = value*0.4888888888889;
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
                result = value*0.6818181818182;
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
                result = value*0.9144;
                break;

            case meterPerMuniteId:
                result = value*54.864;
                break;
            case centimeterPerSecondId:
                result = value*91.44;
                break;
            case kilometerPerSecondId:
                result = value*0.0009144;
                break;
            case kilometerPerMinuteId:
                result = value/18.227;
                break;

            case kilometerPerHourId:
                result = value*3.29184;
                break;
            case milePerHourId:
                result = value*2.045454545455;
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
