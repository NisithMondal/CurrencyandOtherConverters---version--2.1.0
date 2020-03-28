package com.nisith.currencyandotherconverters;


public class AngleConverter {

    private final int  degreeId = 1, radianId = 2, gradianId = 3, arcMinuteId = 5, arcSecondId = 6;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("degree")) {
            idValue = degreeId;

        } else if (unitName.equalsIgnoreCase("radian")) {
            idValue = radianId;

        } else if (unitName.equalsIgnoreCase("gradian")) {
            idValue = gradianId;

        } else if (unitName.equalsIgnoreCase("arcMinute")) {
            idValue = arcMinuteId;

        }else if (unitName.equalsIgnoreCase("arcSecond")){
            idValue = arcSecondId;
        }
        return idValue;
    }

    public double getLengthConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("degree")){
            result = degreeToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("radian")) {
            result = radianToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("gradian")) {
            result = gradianToOthers(sourceUnit,destUnit,value);

        }  else if (sourceUnit.equalsIgnoreCase("arcMinute")) {
            result = arcMinuteToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("arcSecond")) {
            result = arcSecondToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }




    private double degreeToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case degreeId:
                result = value;
                break;

            case radianId:
                result = value*0.017453292519943;
                break;
            case gradianId:
                result = value*1.1111111111111;
                break;
            case arcMinuteId:
                result = value*60;
                break;

            case arcSecondId:
                result = value*3600;
                break;

        }

        return result;
    }


    private double radianToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case degreeId:
                result = value*57.295779513082;
                break;

            case radianId:
                result = value;
                break;
            case gradianId:
                result = value*63.661977236758;
                break;
            case arcMinuteId:
                result = value*3437.7467707849;
                break;

            case arcSecondId:
                result = value*206264.8062471;
                break;

        }

        return result;
    }



    private double gradianToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case degreeId:
                result = value*0.9;
                break;

            case radianId:
                result = value*0.015707963267949;
                break;
            case gradianId:
                result = value;
                break;
            case arcMinuteId:
                result = value*54;
                break;

            case arcSecondId:
                result = value*3240;
                break;

        }

        return result;
    }





    private double arcMinuteToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case degreeId:
                result = value*0.016666666666667;
                break;

            case radianId:
                result = value*0.00029088820866572;
                break;
            case gradianId:
                result = value*0.018518518518519;
                break;

            case arcMinuteId:
                result = value;
                break;

            case arcSecondId:
                result = value*60;
                break;

        }

        return result;
    }



    private double arcSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case degreeId:
                result = value*0.00027777777777778;
                break;

            case radianId:
                result = value*4.8481368110954*Math.pow(10,-6);
                break;
            case gradianId:
                result = value*0.00030864197530864;
                break;
            case arcMinuteId:
                result = value*0.016666666666667;
                break;

            case arcSecondId:
                result = value;
                break;

        }

        return result;
    }






}
