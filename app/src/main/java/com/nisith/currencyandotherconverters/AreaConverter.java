package com.nisith.currencyandotherconverters;

public class AreaConverter {

    private final int squareMeterId = 1, acreId = 2,hectareId = 3,squareMileId = 4,squareInchId = 5,
           squareFootId = 6, squareYardId = 7,squareMicroMeterId = 8,squareCentimeterId = 9,squareMillimeterId =10,
            squareKilometerId =11;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("square meter (m^2)")) {
            idValue = squareMeterId;

        } else if (unitName.equalsIgnoreCase("acre")) {
            idValue = acreId;

        } else if (unitName.equalsIgnoreCase("hectare")) {
            idValue = hectareId;

        } else if (unitName.equalsIgnoreCase("square mile" )) {
            idValue = squareMileId;

        } else if (unitName.equalsIgnoreCase("square inch")) {
            idValue = squareInchId;

        } else if (unitName.equalsIgnoreCase("square foot")) {
            idValue = squareFootId;

        } else if (unitName.equalsIgnoreCase("square yard")) {
            idValue = squareYardId;

        } else if (unitName.equalsIgnoreCase("square micrometer")) {
            idValue = squareMicroMeterId;

        } else if (unitName.equalsIgnoreCase("square centimeter (cm^2)")) {
            idValue = squareCentimeterId;

        }else if (unitName.equalsIgnoreCase("square millimeter")) {
            idValue = squareMillimeterId;

        }else if (unitName.equalsIgnoreCase("square kilometer (km^2)")) {
            idValue = squareKilometerId;

        }

        return idValue;
    }





    public double getAreaConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("square meter (m^2)")){
            result = squareMeterToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("acre")) {
            result = acreToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("hectare")) {
            result = hectareToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square mile")) {
            result = squareMileToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square inch")) {
            result = squareInchToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square foot")) {
            result = squareFootToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square yard")) {
            result = squareYardToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square micrometer")) {
            result = squareMicroMeterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square centimeter (cm^2)")) {
            result = squareCentimeterToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("square millimeter")) {
            result = squareMillimeterToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("square kilometer (km^2)")) {
            result = squareKilometerToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }






    private double squareMeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.000247105;
                break;
            case hectareId:
                result = value/10000;
                break;
            case squareMileId:
                result = value/(2.59*Math.pow(10,6));
                break;
            case squareInchId:
                result = value*1550;
                break;

            case squareFootId:
                result = value*10.7639;
                break;
            case squareYardId:
                result = value*1.19599;
                break;

            case squareMicroMeterId:
                result = value*Math.pow(10,12);
                break;

            case squareCentimeterId:
                result = value*10000;
                break;
            case squareMillimeterId:
                result = value*1000000;
                break;

            case squareKilometerId:
                result = value*Math.pow(10,-6);
                break;

        }

        return result;
    }



    private double acreToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*4046.86;
                break;

            case acreId:
                result = value;
                break;
            case hectareId:
                result = value*0.404686;
                break;
            case squareMileId:
                result = value/640;
                break;
            case squareInchId:
                result = value*6.273*Math.pow(10,6);
                break;

            case squareFootId:
                result = value*43560;
                break;
            case squareYardId:
                result = value*4840;
                break;

            case squareMicroMeterId:
                result = value*4.047*Math.pow(10,15);
                break;

            case squareCentimeterId:
                result = value*4.047*Math.pow(10,7);
                break;
            case squareMillimeterId:
                result = value*4.047*Math.pow(10,9);
                break;

            case squareKilometerId:
                result = value*0.00404686;
                break;

        }

        return result;
    }



    private double hectareToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*10000;
                break;

            case acreId:
                result = value*2.47105;
                break;
            case hectareId:
                result = value;
                break;
            case squareMileId:
                result = value*0.00386102;
                break;
            case squareInchId:
                result = value*1.55*Math.pow(10,7);
                break;

            case squareFootId:
                result = value*107639;
                break;
            case squareYardId:
                result = value*11959.9;
                break;

            case squareMicroMeterId:
                result = value*Math.pow(10,16);
                break;

            case squareCentimeterId:
                result = value*Math.pow(10,8);
                break;
            case squareMillimeterId:
                result = value*Math.pow(10,10);
                break;

            case squareKilometerId:
                result = value*0.01;
                break;

        }

        return result;
    }




    private double squareMileToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*2.59*Math.pow(10,6);
                break;

            case acreId:
                result = value*640;
                break;
            case hectareId:
                result = value*258.999;
                break;
            case squareMileId:
                result = value;
                break;
            case squareInchId:
                result = value*4.014*Math.pow(10,9);
                break;

            case squareFootId:
                result = value*2.788*Math.pow(10,7);
                break;
            case squareYardId:
                result = value*3.098*Math.pow(10,6);
                break;

            case squareMicroMeterId:
                result = value*2.59*Math.pow(10,18);
                break;

            case squareCentimeterId:
                result = value*2.59*Math.pow(10,10);
                break;
            case squareMillimeterId:
                result = value*2.59*Math.pow(10,12);
                break;

            case squareKilometerId:
                result = value*2.58999;
                break;

        }

        return result;
    }



    private double squareInchToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*0.00064516;
                break;

            case acreId:
                result = value*1.5942*Math.pow(10,-7);
                break;
            case hectareId:
                result = value*6.4516*Math.pow(10,-8);
                break;
            case squareMileId:
                result = value*2.491*Math.pow(10,-10);
                break;
            case squareInchId:
                result = value;
                break;

            case squareFootId:
                result = value/144;
                break;
            case squareYardId:
                result = value/1296;
                break;

            case squareMicroMeterId:
                result = value*6.452*Math.pow(10,8);
                break;

            case squareCentimeterId:
                result = value*6.4516;
                break;
            case squareMillimeterId:
                result = value*645.16;
                break;

            case squareKilometerId:
                result = value*6.4516*Math.pow(10,-10);
                break;

        }

        return result;
    }



    private double squareFootToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value/10.764;
                break;

            case acreId:
                result = value/43560;
                break;
            case hectareId:
                result = value/107639;
                break;
            case squareMileId:
                result = value*3.587*Math.pow(10,-8);
                break;
            case squareInchId:
                result = value*144;
                break;

            case squareFootId:
                result = value;
                break;
            case squareYardId:
                result = value/9;
                break;

            case squareMicroMeterId:
                result = value*9.29*1.1574*Math.pow(10,10);
                break;

            case squareCentimeterId:
                result = value*929.03;
                break;
            case squareMillimeterId:
                result = value*92903;
                break;

            case squareKilometerId:
                result = value*9.2903*Math.pow(10,-8);
                break;

        }

        return result;
    }



    private double squareYardToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*0.836127;
                break;

            case acreId:
                result = value/4840;
                break;
            case hectareId:
                result = value/11960;
                break;
            case squareMileId:
                result = value*3.2283*Math.pow(10,-7);
                break;
            case squareInchId:
                result = value*1296;
                break;

            case squareFootId:
                result = value*9;
                break;
            case squareYardId:
                result = value;
                break;

            case squareMicroMeterId:
                result = value*8.361*Math.pow(10,11);
                break;

            case squareCentimeterId:
                result = value*8361.27*Math.pow(10,-18);
                break;
            case squareMillimeterId:
                result = value*836127;
                break;

            case squareKilometerId:
                result = value*8.3613*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double squareMicroMeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*Math.pow(10,-12);
                break;

            case acreId:
                result = value*2.4711*Math.pow(10,-16);
                break;
            case hectareId:
                result = value*Math.pow(10,-16);
                break;
            case squareMileId:
                result = value*3.861*Math.pow(10,-19);
                break;
            case squareInchId:
                result = value*1.55*Math.pow(10,-9);
                break;

            case squareFootId:
                result = value*1.0764*Math.pow(10,-11);
                break;
            case squareYardId:
                result = value*1.196*Math.pow(10,-12);
                break;

            case squareMicroMeterId:
                result = value*1.1574*Math.pow(10,-17);
                break;

            case squareCentimeterId:
                result = value*Math.pow(10,-8);
                break;
            case squareMillimeterId:
                result = value*Math.pow(10,-6);
                break;

            case squareKilometerId:
                result = value*Math.pow(10,-18);
                break;

        }

        return result;
    }



    private double squareCentimeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value/10000;
                break;

            case acreId:
                result = value*2.4711*Math.pow(10,-8);
                break;
            case hectareId:
                result = value*Math.pow(10,-8);
                break;
            case squareMileId:
                result = value*3.861*Math.pow(10,-11);
                break;
            case squareInchId:
                result = value/6.452;
                break;

            case squareFootId:
                result = value/929;
                break;
            case squareYardId:
                result = value/8361;
                break;

            case squareMicroMeterId:
                result = value*Math.pow(10,8);
                break;

            case squareCentimeterId:
                result = value;
                break;
            case squareMillimeterId:
                result = value*100;
                break;

            case squareKilometerId:
                result = value*Math.pow(10,-10);
                break;

        }

        return result;
    }




    private double squareMillimeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*Math.pow(10,-6);
                break;

            case acreId:
                result = value*2.4711*Math.pow(10,-10);
                break;
            case hectareId:
                result = value*Math.pow(10,-10);
                break;
            case squareMileId:
                result = value*3.861*Math.pow(10,-13);
                break;
            case squareInchId:
                result = value/645;
                break;

            case squareFootId:
                result = value/92903;
                break;
            case squareYardId:
                result = value/836127;
                break;

            case squareMicroMeterId:
                result = value*1000000;
                break;

            case squareCentimeterId:
                result = value/100;
                break;
            case squareMillimeterId:
                result = value;
                break;

            case squareKilometerId:
                result = value*Math.pow(10,-12);
                break;

        }

        return result;
    }




    private double squareKilometerToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*Math.pow(10,6);
                break;

            case acreId:
                result = value*247.105;
                break;
            case hectareId:
                result = value*100;
                break;
            case squareMileId:
                result = value*0.386102;
                break;
            case squareInchId:
                result = value*1.55*Math.pow(10,9);
                break;

            case squareFootId:
                result = value*1.076*Math.pow(10,7);
                break;
            case squareYardId:
                result = value*1.196*Math.pow(10,6);
                break;

            case squareMicroMeterId:
                result = value*Math.pow(10,18);
                break;

            case squareCentimeterId:
                result = value*Math.pow(10,10);
                break;
            case squareMillimeterId:
                result = value*Math.pow(10,12);
                break;

            case squareKilometerId:
                result = value;
                break;

        }

        return result;
    }







}
