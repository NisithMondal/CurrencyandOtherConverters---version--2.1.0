public class AreaConverter {

    private final int squareMeterId =1,acreId =2,hectareId =3,squareMileId = 4,squareInchId = 5,
                      squareFootId = 6,squareYardId = 7,squareMicronsId = 8,squareCentimeterId = 9,
                      squareMillimeterId = 10,squareKilometerId = 11;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("square meter (m^2)")) {
            idValue = squareMeterId;

        } else if (unitName.equalsIgnoreCase("acre")) {
            idValue = acreId;

        } else if (unitName.equalsIgnoreCase("hectare")) {
            idValue = hectareId;

        } else if (unitName.equalsIgnoreCase("square mile")) {
            idValue = squareMileId;

        } else if (unitName.equalsIgnoreCase("square inch")) {
            idValue = squareInchId;

        } else if (unitName.equalsIgnoreCase("square foot")) {
            idValue = squareFootId;

        } else if (unitName.equalsIgnoreCase("square yard")) {
            idValue = squareYardId;

        } else if (unitName.equalsIgnoreCase("square microns")) {
            idValue = squareMicronsId;

        } else if (unitName.equalsIgnoreCase("square centimeter (cm^2)")) {
            idValue = squareCentimeterId;

        } else if (unitName.equalsIgnoreCase("square millimeter")) {
            idValue = squareMillimeterId;
        }else if (unitName.equalsIgnoreCase("square kilometer (km^2)")){

            idValue = squareKilometerId;

        }

        return idValue;
    }





    public double getWeightConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("square meter (m^2)")) {
            result = squareMeterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("acre")) {
            result = acreToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("hectare")) {
            result = hectareToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square mile")) {
            result = squareMileeMeterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square inch")) {
            result = squareInchToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square foot")) {
            result = squareFootToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square yard")) {
            result = squareYardToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square microns")) {
            result = squareMicronsToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square centimeter (cm^2)")) {
            result = squareCentimeterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("square millimeter")) {
            result = squareMillimeterToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("square kilometer (km^2)")){

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
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }




    private double acreToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }

    private double hectareToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double squareMileeMeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double squareInchToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }


    private double squareFootToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double squareYardToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double squareMicronsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }


    private double squareCentimeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double squareMillimeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }



    private double squareKilometerToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case squareMeterId:
                result = value;
                break;

            case acreId:
                result = value*0.001;
                break;
            case hectareId:
                result = value*1000;
                break;
            case squareMileId:
                result = value*Math.pow(10,6);
                break;
            case squareInchId:
                result = value*Math.pow(10,-6);
                break;

            case squareFootId:
                result = value*0.000157473;
                break;
            case squareYardId:
                result = value/454;
                break;

            case squareMicronsId:
                result = value/28.35;
                break;

            case squareCentimeterId:
                result = value*1.1023*Math.pow(10,-6);
                break;

            case squareMillimeterId:
                result = value*9.8421*Math.pow(10,-7);
                break;

            case squareKilometerId:
                result = value*9.8421*Math.pow(10,-7);
                break;

        }

        return result;
    }














}
