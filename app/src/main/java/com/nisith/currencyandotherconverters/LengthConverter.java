package com.nisith.currencyandotherconverters;

public class LengthConverter {
    private final int kmId = 1,mId = 2,cmId = 3,mmId = 4,inchId = 5,footId = 6,
                microMeterId = 7,nanoMeterId = 8,mileId = 9,yardId = 10; //this is all Length units id

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("km")) {
            idValue = kmId;

        } else if (unitName.equalsIgnoreCase("m")) {
            idValue = mId;

        } else if (unitName.equalsIgnoreCase("cm")) {
            idValue = cmId;

        } else if (unitName.equalsIgnoreCase("mm")) {
            idValue = mmId;

        } else if (unitName.equalsIgnoreCase("inch")) {
            idValue = inchId;

        } else if (unitName.equalsIgnoreCase("foot")) {
            idValue = footId;

        } else if (unitName.equalsIgnoreCase("micrometer")) {
            idValue = microMeterId;

        } else if (unitName.equalsIgnoreCase("nanometer")) {
            idValue = nanoMeterId;

        } else if (unitName.equalsIgnoreCase("mile")) {
            idValue = mileId;

        } else if (unitName.equalsIgnoreCase("yard")) {
            idValue = yardId;
        }
        return idValue;
    }

    public double getLengthConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("km")){
            result = kmToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("m")) {
            result = mToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("cm")) {
            result = cmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("mm")) {
            result = mmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("inch")) {
            result = inchToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("foot")) {
            result = footToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("micrometer")) {
            result = micrometerToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("nanometer")) {
            result = nanometerToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("mile")) {
            result = mileToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("yard")) {

            result = yardToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }


    private double kmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
             result = value;
            break;

            case mId:
                result = value*1000;// 1 km = 1000 m
                break;
            case cmId:
                result = value*100000;// 1 km = 100000 cm
                break;
            case mmId:
                result = value*1000000;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*39370.07874;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*3280.839895;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*Math.pow(10,9);// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*Math.pow(10,12);// 1 km = 10^12
                break;

            case mileId:
                result = value*0.6213711922;// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*1093.6132983;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }


    private double mToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*0.001;
                break;

            case mId:
                result = value;// 1 km = 1000 m
                break;
            case cmId:
                result = value*100;// 1 km = 100000 cm
                break;
            case mmId:
                result = value*1000;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*39.37007874;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*3.280839895;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*Math.pow(10,6);// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*Math.pow(10,9);// 1 km = 10^12
                break;

            case mileId:
                result = value*0.0006213712;// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*1.0936132983;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }


    private double cmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*Math.pow(10,-5);
                break;

            case mId:
                result = value*0.01;// 1 km = 1000 m
                break;
            case cmId:
                result = value;// 1 km = 100000 cm
                break;
            case mmId:
                result = value*10;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*0.3937007874;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*0.032808399;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*10000;// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*Math.pow(10,7);// 1 km = 10^12
                break;

            case mileId:
                result = value*6.2137*Math.pow(10,-6);// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*0.010936133;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }
    private double mmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*Math.pow(10,-6);
                break;

            case mId:
                result = value*0.001;// 1 km = 1000 m
                break;
            case cmId:
                result = value*0.1;// 1 km = 100000 cm
                break;
            case mmId:
                result = value;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*0.0393700787;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*0.0032808399;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*1000;// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*Math.pow(10,6);// 1 km = 10^12
                break;

            case mileId:
                result = value*6.213711922*Math.pow(10,-7);// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*0.0010936133;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }

    private double inchToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*2.54*Math.pow(10,-5);
                break;

            case mId:
                result = value*0.0254;// 1 km = 1000 m
                break;
            case cmId:
                result = value*2.54;// 1 km = 100000 cm
                break;
            case mmId:
                result = value*25.4;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*0.0833333333;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*25400;// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*2.54*Math.pow(10,7);// 1 km = 10^12
                break;

            case mileId:
                result = value*0.0000157828;// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*0.0277777778;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }

    private double footToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*0.0003048;
                break;

            case mId:
                result = value*0.3048;// 1 km = 1000 m
                break;
            case cmId:
                result = value*30.48;// 1 km = 100000 cm
                break;
            case mmId:
                result = value*304.8;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*12;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*304800;// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*3.048*Math.pow(10,8);// 1 km = 10^12
                break;

            case mileId:
                result = value*0.0001893939;// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*0.3333333333;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }

    private double micrometerToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*Math.pow(10,-9);
                break;

            case mId:
                result = value*Math.pow(10,-6);// 1 km = 1000 m
                break;
            case cmId:
                result = value*Math.pow(10,-4);// 1 km = 100000 cm
                break;
            case mmId:
                result = value*0.001;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*0.0000393701;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*3.2808*Math.pow(10,-6);// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value;// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*1000;// 1 km = 10^12
                break;

            case mileId:
                result = value*6.213711922*Math.pow(10,-10);// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*0.0000010936;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }

    private double nanometerToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*Math.pow(10,-12);
                break;

            case mId:
                result = value*Math.pow(10,-9);// 1 km = 1000 m
                break;
            case cmId:
                result = value*Math.pow(10,-7);// 1 km = 100000 cm
                break;
            case mmId:
                result = value*Math.pow(10,-6);// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*3.937007874*Math.pow(10,-8);// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*3.280839895*Math.pow(10,-9);// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*0.001;// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value;// 1 km = 10^12
                break;

            case mileId:
                result = value*6.213711922*Math.pow(10,-13);// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*1.093613298*Math.pow(10,-9);// 1 km = 1093.61 yard
                break;

        }

        return result;
    }

    private double mileToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*1.609344;
                break;

            case mId:
                result = value*1609.344;// 1 km = 1000 m
                break;
            case cmId:
                result = value*160934.4;// 1 km = 100000 cm
                break;
            case mmId:
                result = value*1609344;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*63360;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*5280;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*1.609344*Math.pow(10,9);// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*1.609344*Math.pow(10,12);// 1 km = 10^12
                break;

            case mileId:
                result = value;// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value*1760;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }



    private double yardToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case kmId:
                result = value*0.0009144;
                break;

            case mId:
                result = value*0.9144;// 1 km = 1000 m
                break;
            case cmId:
                result = value*91.44;// 1 km = 100000 cm
                break;
            case mmId:
                result = value*914.4;// 1 km = 1000000 mm
                break;
            case inchId:
                result = value*36;// 1 km = 39370.07 inch
                break;

            case footId:
                result = value*3;// 1 km = 3280.83 foot
                break;
            case microMeterId:
                result = value*914400;// 1 km = 10^9
                break;

            case nanoMeterId:
                result = value*9.144*Math.pow(10,8);// 1 km = 10^12
                break;

            case mileId:
                result = value*0.0005681818;// 1 km = 0.621371 mile
                break;

            case yardId:
                result = value;// 1 km = 1093.61 yard
                break;

        }

        return result;
    }






}

























