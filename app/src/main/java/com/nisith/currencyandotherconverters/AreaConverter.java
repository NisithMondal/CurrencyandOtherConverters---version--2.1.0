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

        }else if (unitName.equalsIgnoreCase("square millimeter (mm^2)")) {
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

        }else if (sourceUnit.equalsIgnoreCase("square millimeter (mm^2)")) {
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
                result = value*3.861021585*Math.pow(10,-7);
                break;
            case squareInchId:
                result = value*1550.0031;
                break;

            case squareFootId:
                result = value*10.763910417;
                break;
            case squareYardId:
                result = value*1.1959900463;
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
                result = value*4046.8564224;
                break;

            case acreId:
                result = value;
                break;
            case hectareId:
                result = value*0.4046856422;
                break;
            case squareMileId:
                result = value/640;
                break;
            case squareInchId:
                result = value*6272640;
                break;

            case squareFootId:
                result = value*43560;
                break;
            case squareYardId:
                result = value*4840;
                break;

            case squareMicroMeterId:
                result = value*4.046856422399924*Math.pow(10,15);
                break;

            case squareCentimeterId:
                result = value*40468564.224;
                break;
            case squareMillimeterId:
                result = value*4046856422.4;
                break;

            case squareKilometerId:
                result = value*0.0040468564;
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
                result = value*2.4710538147;
                break;
            case hectareId:
                result = value;
                break;
            case squareMileId:
                result = value*0.0038610216;
                break;
            case squareInchId:
                result = value*1.5500031*Math.pow(10,7);
                break;

            case squareFootId:
                result = value*107639.10417;
                break;
            case squareYardId:
                result = value*11959.900463;
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
                result = value*2589988.1103;
                break;

            case acreId:
                result = value*640;
                break;
            case hectareId:
                result = value*258.99881103;
                break;
            case squareMileId:
                result = value;
                break;
            case squareInchId:
                result = value*4.014489600*Math.pow(10,9);
                break;

            case squareFootId:
                result = value*2.7878400*Math.pow(10,7);
                break;
            case squareYardId:
                result = value*3.097600*Math.pow(10,6);
                break;

            case squareMicroMeterId:
                result = value*2.589988110335972400*Math.pow(10,18);
                break;

            case squareCentimeterId:
                result = value*2.589988110336*Math.pow(10,10);
                break;
            case squareMillimeterId:
                result = value*2.589988110336*Math.pow(10,12);
                break;

            case squareKilometerId:
                result = value*2.5899881103;
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
                result = value*1.594225079*Math.pow(10,-7);
                break;
            case hectareId:
                result = value*6.4516*Math.pow(10,-8);
                break;
            case squareMileId:
                result = value*2.490976686*Math.pow(10,-10);
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
                result = value*6.45160000*Math.pow(10,8);
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
                result = value*0.09290304;
                break;

            case acreId:
                result = value/43560;
                break;
            case hectareId:
                result = value/107639;
                break;
            case squareMileId:
                result = value*3.587006427*Math.pow(10,-8);
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
                result = value*9.2903040000*Math.pow(10,10);
                break;

            case squareCentimeterId:
                result = value*929.0304;
                break;
            case squareMillimeterId:
                result = value*92903.04;
                break;

            case squareKilometerId:
                result = value*9.290303999*Math.pow(10,-8);
                break;

        }

        return result;
    }



    private double squareYardToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value*0.83612736;
                break;

            case acreId:
                result = value/4840;
                break;
            case hectareId:
                result = value/11960;
                break;
            case squareMileId:
                result = value*3.228305785*Math.pow(10,-7);
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
                result = value*8.36127360000*Math.pow(10,11);
                break;

            case squareCentimeterId:
                result = value*8361.2736;
                break;
            case squareMillimeterId:
                result = value*836127.36;
                break;

            case squareKilometerId:
                result = value*8.361273599*Math.pow(10,-7);
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
                result = value*2.471053814*Math.pow(10,-16);
                break;
            case hectareId:
                result = value*Math.pow(10,-16);
                break;
            case squareMileId:
                result = value*3.861021585*Math.pow(10,-19);
                break;
            case squareInchId:
                result = value*1.5500031*Math.pow(10,-9);
                break;

            case squareFootId:
                result = value*1.076391041*Math.pow(10,-11);
                break;
            case squareYardId:
                result = value*1.195990046*Math.pow(10,-12);
                break;

            case squareMicroMeterId:
                result = value;
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
                result = value*2.471053814*Math.pow(10,-8);
                break;
            case hectareId:
                result = value*Math.pow(10,-8);
                break;
            case squareMileId:
                result = value*3.861021585*Math.pow(10,-11);
                break;
            case squareInchId:
                result = value*0.15500031;
                break;

            case squareFootId:
                result = value*0.001076391;
                break;
            case squareYardId:
                result = value*0.000119599;
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
                result = value*2.471053814*Math.pow(10,-10);
                break;
            case hectareId:
                result = value*Math.pow(10,-10);
                break;
            case squareMileId:
                result = value*3.861021585*Math.pow(10,-13);
                break;
            case squareInchId:
                result = value*0.0015500031;
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
                result = value*247.10538147;
                break;
            case hectareId:
                result = value*100;
                break;
            case squareMileId:
                result = value*0.3861021585;
                break;
            case squareInchId:
                result = value*1.550003100*Math.pow(10,9);
                break;

            case squareFootId:
                result = value*1.0763910417*Math.pow(10,7);
                break;
            case squareYardId:
                result = value*1.1959900463*Math.pow(10,6);
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
