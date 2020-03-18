package com.nisith.currencyandotherconverters;

public class VolumeConverter {

    private final int literId = 1, milliLiterId = 2,cubicMeterId = 3,cubicCentiMeterId = 4,cubickilometerId = 5,
            cubicMilliMeterId = 6, cubicFootId = 7,cubicInchId = 8,USLiquidGallonId = 9,USLiquidQuartId =10,USLiquidPintId =11,USLegalCupId =12,
            USFluidOunceId = 13, USTableSpoonId = 14, USTeaSpoonId = 15,imperialGallonId = 16,imperialQuartId = 17,imperialPintId = 18,
            imperialCupId = 19,imperialFluidOunceId = 20,imperialTableSpoonId = 21,imperialTeaSpoonId =22;



    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("liter")) {
            idValue = literId;

        } else if (unitName.equalsIgnoreCase("milliLiter")) {
            idValue = milliLiterId;

        } else if (unitName.equalsIgnoreCase("cubic Meter")) {
            idValue = cubicMeterId;

        } else if (unitName.equalsIgnoreCase("cubic CentiMeter" )) {
            idValue = cubicCentiMeterId;

        } else if (unitName.equalsIgnoreCase("cubic kilometer")) {
            idValue = cubickilometerId;

        } else if (unitName.equalsIgnoreCase("cubic MilliMeter")) {
            idValue = cubicMilliMeterId;

        } else if (unitName.equalsIgnoreCase("cubic Foot")) {
            idValue = cubicFootId;

        } else if (unitName.equalsIgnoreCase("cubic Inch")) {
            idValue = cubicInchId;

        } else if (unitName.equalsIgnoreCase("US liquid gallon")) {
            idValue = USLiquidGallonId;

        }else if (unitName.equalsIgnoreCase("US liquid quart")) {
            idValue = USLiquidQuartId;

        }else if (unitName.equalsIgnoreCase("US liquid pint")) {
            idValue = USLiquidPintId;

        }else if (unitName.equalsIgnoreCase("US legal cup")) {
            idValue = USLegalCupId;

        }else if (unitName.equalsIgnoreCase("US fluid ounce")) {
            idValue = USFluidOunceId;

        }else if (unitName.equalsIgnoreCase("US tableSpoon")) {
            idValue = USTableSpoonId;

        }else if (unitName.equalsIgnoreCase("US teaSpoon")) {
            idValue = USTeaSpoonId;

        }else if (unitName.equalsIgnoreCase("imperial gallon")) {
            idValue = imperialGallonId;

        }else if (unitName.equalsIgnoreCase("imperial quart")) {
            idValue = imperialQuartId;

        }else if (unitName.equalsIgnoreCase("imperial pint")) {
            idValue = imperialPintId;

        }else if (unitName.equalsIgnoreCase("imperial cup")) {
            idValue = imperialCupId;

        }else if (unitName.equalsIgnoreCase("imperial fluid ounce")) {
            idValue = imperialFluidOunceId;

        }else if (unitName.equalsIgnoreCase("imperial tableSpoon")) {
            idValue = imperialTableSpoonId;

        }else if (unitName.equalsIgnoreCase("imperial teaSpoon")){
            idValue = imperialTeaSpoonId;
        }

        return idValue;
    }








    public double getVolumeConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("liter")) {
            result = literToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("milliLiter")) {
            result = milliLiterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("cubic Meter")) {
            result = cubicMeterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("cubic CentiMeter" )) {
            result = cubicCentiMeterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("cubic kilometer")) {
            result = cubickilometerToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("cubic MilliMeter")) {
            result = cubicMilliMeterToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("cubic Foot")) {
            result = cubicFootToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("cubic Inch")) {
            result = cubicInchToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("US liquid gallon")) {
            result = USLiquidGallonToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("US liquid quart")) {
            result = USLiquidQuartToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("US liquid pint")) {
            result = USLiquidPintToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("US legal cup")) {
            result = USLegalCupToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("US fluid ounce")) {
            result = USFluidOunceToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("US tableSpoon")) {
            result = USTableSpoonToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("US teaSpoon")) {
            result = USTeaSpoonToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("imperial gallon")) {
            result = imperialGallonToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("imperial quart")) {
            result = imperialQuartToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("imperial pint")) {
            result = imperialPintToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("imperial cup")) {
            result = imperialCupToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("imperial fluid ounce")) {
            result = imperialFluidOunceToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("imperial tableSpoon")) {
            result = imperialTableSpoonToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("imperial teaSpoon")){
            result = imperialTeaSpoonToOthers(sourceUnit,destUnit,value);
        }


        return result;

    }






    private double literToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value;
                break;

            case milliLiterId:
                result = value*1000;
                break;
            case cubicMeterId:
                result = value*0.001;
                break;
            case cubicCentiMeterId:
                result = value*1000;
                break;
            case cubickilometerId:
                result = value*Math.pow(10,-12);
                break;

            case cubicMilliMeterId:
                result = value*1000000;
                break;
            case cubicFootId:
                result = value/28.317;
                break;

            case cubicInchId:
                result = value*61.0237;
                break;

            case USLiquidGallonId:
                result = value/3.785;
                break;
            case USLiquidQuartId:
                result = value*1.05669;
                break;

            case USLiquidPintId:
                result = value*2.11338;
                break;

            case USLegalCupId:
                result = value*4.16667;
                break;

            case USFluidOunceId:
                result = value*33.814;
                break;
            case USTableSpoonId:
                result = value*67.628;
                break;
            case USTeaSpoonId:
                result = value*202.884;
                break;

            case imperialGallonId:
                result = value/4.546;
                break;
            case imperialQuartId:
                result = value/1.137;
                break;

            case imperialPintId:
                result = value*1.75975;
                break;

            case imperialCupId:
                result = value*3.51951;
                break;
            case imperialFluidOunceId:
                result = value*35.1951;
                break;

            case imperialTableSpoonId:
                result = value*56.3121;
                break;

            case imperialTeaSpoonId:
                result = value*168.936;
                break;
        }

        return result;
    }





    private double milliLiterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*0.001;
                break;

            case milliLiterId:
                result = value;
                break;
            case cubicMeterId:
                result = value*Math.pow(10,-6);
                break;
            case cubicCentiMeterId:
                result = value;
                break;
            case cubickilometerId:
                result = value*Math.pow(10,-15);
                break;

            case cubicMilliMeterId:
                result = value*1000;
                break;
            case cubicFootId:
                result = value/28317;
                break;

            case cubicInchId:
                result = value/16.387;
                break;

            case USLiquidGallonId:
                result = value/3785;
                break;
            case USLiquidQuartId:
                result = value/946;
                break;

            case USLiquidPintId:
                result = value/473;
                break;

            case USLegalCupId:
                result = value/240;
                break;

            case USFluidOunceId:
                result = value/29.574;
                break;
            case USTableSpoonId:
                result = value/14.787;
                break;
            case USTeaSpoonId:
                result = value/4.929;
                break;

            case imperialGallonId:
                result = value/4546;
                break;
            case imperialQuartId:
                result = value/1137;
                break;

            case imperialPintId:
                result = value/568;
                break;

            case imperialCupId:
                result = value/284;
                break;
            case imperialFluidOunceId:
                result = value/28.413;
                break;

            case imperialTableSpoonId:
                result = value/17.758;
                break;

            case imperialTeaSpoonId:
                result = value/5.919;
                break;
        }

        return result;
    }




    private double cubicMeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*1000;
                break;

            case milliLiterId:
                result = value*Math.pow(10,6);
                break;
            case cubicMeterId:
                result = value;
                break;
            case cubicCentiMeterId:
                result = value*1000000;
                break;
            case cubickilometerId:
                result = value*Math.pow(10,-9);
                break;

            case cubicMilliMeterId:
                result = value*Math.pow(10,9);
                break;
            case cubicFootId:
                result = value*35.3147;
                break;

            case cubicInchId:
                result = value*61023.7;
                break;

            case USLiquidGallonId:
                result = value*264.172;
                break;
            case USLiquidQuartId:
                result = value*1056.69;
                break;

            case USLiquidPintId:
                result = value*2113.38;
                break;

            case USLegalCupId:
                result = value*4166.67;
                break;

            case USFluidOunceId:
                result = value*33814;
                break;
            case USTableSpoonId:
                result = value*67628;
                break;
            case USTeaSpoonId:
                result = value*202884;
                break;

            case imperialGallonId:
                result = value*219.969;
                break;
            case imperialQuartId:
                result = value*879.877;
                break;

            case imperialPintId:
                result = value*1759.75;
                break;

            case imperialCupId:
                result = value*3519.51;
                break;
            case imperialFluidOunceId:
                result = value*35195.1;
                break;

            case imperialTableSpoonId:
                result = value*56312.1;
                break;

            case imperialTeaSpoonId:
                result = value*168936;
                break;
        }

        return result;
    }





    private double cubicCentiMeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*0.001;
                break;

            case milliLiterId:
                result = value;
                break;
            case cubicMeterId:
                result = value*Math.pow(10,-6);
                break;
            case cubicCentiMeterId:
                result = value;
                break;
            case cubickilometerId:
                result = value*Math.pow(10,-15);
                break;

            case cubicMilliMeterId:
                result = value*1000;
                break;
            case cubicFootId:
                result = value/28317;
                break;

            case cubicInchId:
                result = value/16.387;
                break;

            case USLiquidGallonId:
                result = value/3785;
                break;
            case USLiquidQuartId:
                result = value/946;
                break;

            case USLiquidPintId:
                result = value/473;
                break;

            case USLegalCupId:
                result = value/240;
                break;

            case USFluidOunceId:
                result = value/29.574;
                break;
            case USTableSpoonId:
                result = value/14.787;
                break;
            case USTeaSpoonId:
                result = value/4.929;
                break;

            case imperialGallonId:
                result = value/4546;
                break;
            case imperialQuartId:
                result = value/1137;
                break;

            case imperialPintId:
                result = value/568;
                break;

            case imperialCupId:
                result = value/284;
                break;
            case imperialFluidOunceId:
                result = value/28.413;
                break;

            case imperialTableSpoonId:
                result = value/17.758;
                break;

            case imperialTeaSpoonId:
                result = value/5.919;
                break;
        }

        return result;
    }





    private double cubickilometerToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*Math.pow(10,12);
                break;

            case milliLiterId:
                result = value*Math.pow(10,15);
                break;
            case cubicMeterId:
                result = value*Math.pow(10,9);
                break;
            case cubicCentiMeterId:
                result = value*Math.pow(10,15);
                break;
            case cubickilometerId:
                result = value;
                break;

            case cubicMilliMeterId:
                result = value*Math.pow(10,18);
                break;
            case cubicFootId:
                result = value*3.531*Math.pow(10,10);
                break;

            case cubicInchId:
                result = value*6.102*Math.pow(10,13);
                break;

            case USLiquidGallonId:
                result = value*2.642*Math.pow(10,11);
                break;
            case USLiquidQuartId:
                result = value*1.057*Math.pow(10,12);
                break;

            case USLiquidPintId:
                result = value*2.113*Math.pow(10,12);
                break;

            case USLegalCupId:
                result = value*4.167*Math.pow(10,12);
                break;

            case USFluidOunceId:
                result = value*3.381*Math.pow(10,13);
                break;
            case USTableSpoonId:
                result = value*6.763*Math.pow(10,13);
                break;
            case USTeaSpoonId:
                result = value*2.029*Math.pow(10,14);
                break;

            case imperialGallonId:
                result = value*2.2*Math.pow(10,11);
                break;
            case imperialQuartId:
                result = value*8.799*Math.pow(10,11);
                break;

            case imperialPintId:
                result = value*1.76*Math.pow(10,12);
                break;

            case imperialCupId:
                result = value*3.52*Math.pow(10,12);
                break;
            case imperialFluidOunceId:
                result = value*3.52*Math.pow(10,13);
                break;

            case imperialTableSpoonId:
                result = value*5.631*Math.pow(10,13);
                break;

            case imperialTeaSpoonId:
                result = value*1.689*Math.pow(10,14);
                break;
        }

        return result;
    }




    private double cubicMilliMeterToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*Math.pow(10,-6);
                break;

            case milliLiterId:
                result = value*0.001;
                break;
            case cubicMeterId:
                result = value*Math.pow(10,-9);
                break;
            case cubicCentiMeterId:
                result = value*0.001;
                break;
            case cubickilometerId:
                result = value*Math.pow(10,-18);
                break;

            case cubicMilliMeterId:
                result = value;
                break;
            case cubicFootId:
                result = value*3.5315*Math.pow(10,-8);
                break;

            case cubicInchId:
                result = value*6.1024*Math.pow(10,-5);
                break;

            case USLiquidGallonId:
                result = value*2.6417*Math.pow(10,-7);
                break;
            case USLiquidQuartId:
                result = value*1.0567*Math.pow(10,-6);
                break;

            case USLiquidPintId:
                result = value*2.1134*Math.pow(10,-6);
                break;

            case USLegalCupId:
                result = value*4.1667*Math.pow(10,-6);
                break;

            case USFluidOunceId:
                result = value*3.3814*Math.pow(10,-5);
                break;
            case USTableSpoonId:
                result = value*6.7628*Math.pow(10,-5);
                break;
            case USTeaSpoonId:
                result = value/4929;
                break;

            case imperialGallonId:
                result = value*2.1997*Math.pow(10,-7);
                break;
            case imperialQuartId:
                result = value*8.7988*Math.pow(10,-7);
                break;

            case imperialPintId:
                result = value*1.7598*Math.pow(10,-6);
                break;

            case imperialCupId:
                result = value*3.5195*Math.pow(10,-6);
                break;
            case imperialFluidOunceId:
                result = value*3.5195*Math.pow(10,-5);
                break;

            case imperialTableSpoonId:
                result = value*5.6312*Math.pow(10,-5);
                break;

            case imperialTeaSpoonId:
                result = value/5919;
                break;
        }

        return result;
    }





    private double cubicFootToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*28.3168;
                break;

            case milliLiterId:
                result = value*28316.8;
                break;
            case cubicMeterId:
                result = value/35.315;
                break;
            case cubicCentiMeterId:
                result = value*28316.8;
                break;
            case cubickilometerId:
                result = value*2.8317*Math.pow(10,-11);
                break;

            case cubicMilliMeterId:
                result = value*2.832*Math.pow(10,7);
                break;
            case cubicFootId:
                result = value;
                break;

            case cubicInchId:
                result = value*1728;
                break;

            case USLiquidGallonId:
                result = value*7.48052;
                break;
            case USLiquidQuartId:
                result = value*29.9221;
                break;

            case USLiquidPintId:
                result = value*59.8442;
                break;

            case USLegalCupId:
                result = value*117.987;
                break;

            case USFluidOunceId:
                result = value*957.506;
                break;
            case USTableSpoonId:
                result = value*1915.01;
                break;
            case USTeaSpoonId:
                result = value*5745.04;
                break;

            case imperialGallonId:
                result = value*6.22884;
                break;
            case imperialQuartId:
                result = value*24.9153;
                break;

            case imperialPintId:
                result = value*49.8307;
                break;

            case imperialCupId:
                result = value*99.6614;
                break;
            case imperialFluidOunceId:
                result = value*996.614;
                break;

            case imperialTableSpoonId:
                result = value*1594.58;
                break;

            case imperialTeaSpoonId:
                result = value*4783.74;
                break;
        }

        return result;
    }





    private double cubicInchToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/61.024;
                break;

            case milliLiterId:
                result = value*16.3871;
                break;
            case cubicMeterId:
                result = value/61024;
                break;
            case cubicCentiMeterId:
                result = value*16.3871;
                break;
            case cubickilometerId:
                result = value*1.6387*Math.pow(10,-14);
                break;

            case cubicMilliMeterId:
                result = value*16387.1;
                break;
            case cubicFootId:
                result = value/1728;
                break;

            case cubicInchId:
                result = value;
                break;

            case USLiquidGallonId:
                result = value/231;
                break;
            case USLiquidQuartId:
                result = value/57.75;
                break;

            case USLiquidPintId:
                result = value/28.875;
                break;

            case USLegalCupId:
                result = value/14.646;
                break;

            case USFluidOunceId:
                result = value/1.805;
                break;
            case USTableSpoonId:
                result = value*1.10823;
                break;
            case USTeaSpoonId:
                result = value*3.32468;
                break;

            case imperialGallonId:
                result = value/277;
                break;
            case imperialQuartId:
                result = value/69.355;
                break;

            case imperialPintId:
                result = value/34.677;
                break;

            case imperialCupId:
                result = value/17.339;
                break;
            case imperialFluidOunceId:
                result = value/1.734;
                break;

            case imperialTableSpoonId:
                result = value/1.084;
                break;

            case imperialTeaSpoonId:
                result = value*2.76837;
                break;
        }

        return result;
    }




    private double USLiquidGallonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*3.78541;
                break;

            case milliLiterId:
                result = value*3785.41;
                break;
            case cubicMeterId:
                result = value/264;
                break;
            case cubicCentiMeterId:
                result = value*3785.41;
                break;
            case cubickilometerId:
                result = value*3.78541*Math.pow(10,-12);
                break;

            case cubicMilliMeterId:
                result = value*3785411.784;
                break;
            case cubicFootId:
                result = value/7.481;
                break;

            case cubicInchId:
                result = value*231;
                break;

            case USLiquidGallonId:
                result = value;
                break;
            case USLiquidQuartId:
                result = value*4;
                break;

            case USLiquidPintId:
                result = value*8;
                break;

            case USLegalCupId:
                result = value*15.7725;
                break;

            case USFluidOunceId:
                result = value*128;
                break;
            case USTableSpoonId:
                result = value*256;
                break;
            case USTeaSpoonId:
                result = value*768;
                break;

            case imperialGallonId:
                result = value/1.201;
                break;
            case imperialQuartId:
                result = value*3.3307;
                break;

            case imperialPintId:
                result = value*6.66139;
                break;

            case imperialCupId:
                result = value*13.3228;
                break;
            case imperialFluidOunceId:
                result = value*133.228;
                break;

            case imperialTableSpoonId:
                result = value*213.165;
                break;

            case imperialTeaSpoonId:
                result = value*639.494;
                break;
        }

        return result;
    }





    private double USLiquidQuartToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/1.057;
                break;

            case milliLiterId:
                result = value*946.353;
                break;
            case cubicMeterId:
                result = value/1057;
                break;
            case cubicCentiMeterId:
                result = value*946.353;
                break;
            case cubickilometerId:
                result = value*9.4635295*Math.pow(10,-13);
                break;

            case cubicMilliMeterId:
                result = value*946353;
                break;
            case cubicFootId:
                result = value/29.922;
                break;

            case cubicInchId:
                result = value*57.75;
                break;

            case USLiquidGallonId:
                result = value/4;
                break;
            case USLiquidQuartId:
                result = value;
                break;

            case USLiquidPintId:
                result = value*2;
                break;

            case USLegalCupId:
                result = value*3.94314;
                break;

            case USFluidOunceId:
                result = value*32;
                break;
            case USTableSpoonId:
                result = value*64;
                break;
            case USTeaSpoonId:
                result = value*192;
                break;

            case imperialGallonId:
                result = value/4.804;
                break;
            case imperialQuartId:
                result = value/1.201;
                break;

            case imperialPintId:
                result = value*1.66535;
                break;

            case imperialCupId:
                result = value*3.3307;
                break;
            case imperialFluidOunceId:
                result = value*33.307;
                break;

            case imperialTableSpoonId:
                result = value*53.2911;
                break;

            case imperialTeaSpoonId:
                result = value*159.873;
                break;
        }

        return result;
    }




    private double USLiquidPintToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/2.113;
                break;

            case milliLiterId:
                result = value*473.176;
                break;
            case cubicMeterId:
                result = value/2113;
                break;
            case cubicCentiMeterId:
                result = value*473.176;
                break;
            case cubickilometerId:
                result = value*4.73176*Math.pow(10,-13);
                break;

            case cubicMilliMeterId:
                result = value*473176;
                break;
            case cubicFootId:
                result = value/59.844;
                break;

            case cubicInchId:
                result = value/28.875;
                break;

            case USLiquidGallonId:
                result = value/8;
                break;
            case USLiquidQuartId:
                result = value/2;
                break;

            case USLiquidPintId:
                result = value;
                break;

            case USLegalCupId:
                result = value*1.97157;
                break;

            case USFluidOunceId:
                result = value*16;
                break;
            case USTableSpoonId:
                result = value*32;
                break;
            case USTeaSpoonId:
                result = value*96;
                break;

            case imperialGallonId:
                result = value/9.608;
                break;
            case imperialQuartId:
                result = value/2.402;
                break;

            case imperialPintId:
                result = value/1.201;
                break;

            case imperialCupId:
                result = value*1.66535;
                break;
            case imperialFluidOunceId:
                result = value*16.6535;
                break;

            case imperialTableSpoonId:
                result = value*26.6456;
                break;

            case imperialTeaSpoonId:
                result = value*79.9367;
                break;
        }

        return result;
    }





    private double USLegalCupToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/4.167;
                break;

            case milliLiterId:
                result = value*240;
                break;
            case cubicMeterId:
                result = value/4167;
                break;
            case cubicCentiMeterId:
                result = value*240;
                break;
            case cubickilometerId:
                result = value*2.4*Math.pow(10,-13);
                break;

            case cubicMilliMeterId:
                result = value*240000;
                break;
            case cubicFootId:
                result = value/118;
                break;

            case cubicInchId:
                result = value*14.6457;
                break;

            case USLiquidGallonId:
                result = value/15.773;
                break;
            case USLiquidQuartId:
                result = value/3.943;
                break;

            case USLiquidPintId:
                result = value/1.972;
                break;

            case USLegalCupId:
                result = value;
                break;

            case USFluidOunceId:
                result = value*8.11537;
                break;
            case USTableSpoonId:
                result = value*16.2307;
                break;
            case USTeaSpoonId:
                result = value*48.6922;
                break;

            case imperialGallonId:
                result = value/18.942;
                break;
            case imperialQuartId:
                result = value/4.736;
                break;

            case imperialPintId:
                result = value/2.368;
                break;

            case imperialCupId:
                result = value/1.184;
                break;
            case imperialFluidOunceId:
                result = value*8.44682;
                break;

            case imperialTableSpoonId:
                result = value*13.5149;
                break;

            case imperialTeaSpoonId:
                result = value*40.5447;
                break;
        }

        return result;
    }




    private double USFluidOunceToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/33.814;
                break;

            case milliLiterId:
                result = value*29.5735;
                break;
            case cubicMeterId:
                result = value*2.9574*Math.pow(10,-5);
                break;
            case cubicCentiMeterId:
                result = value*29.5735;
                break;
            case cubickilometerId:
                result = value*2.95735*Math.pow(10,-14);
                break;

            case cubicMilliMeterId:
                result = value*29573.5;
                break;
            case cubicFootId:
                result = value/958;
                break;

            case cubicInchId:
                result = value*1.80469;
                break;

            case USLiquidGallonId:
                result = value/128;
                break;
            case USLiquidQuartId:
                result = value/32;
                break;

            case USLiquidPintId:
                result = value/16;
                break;

            case USLegalCupId:
                result = value/8.115;
                break;

            case USFluidOunceId:
                result = value;
                break;
            case USTableSpoonId:
                result = value*2;
                break;
            case USTeaSpoonId:
                result = value*6;
                break;

            case imperialGallonId:
                result = value/154;
                break;
            case imperialQuartId:
                result = value/38.43;
                break;

            case imperialPintId:
                result = value/19.215;
                break;

            case imperialCupId:
                result = value/9.608;
                break;
            case imperialFluidOunceId:
                result = value*1.04084;
                break;

            case imperialTableSpoonId:
                result = value*1.66535;
                break;

            case imperialTeaSpoonId:
                result = value*4.99604;
                break;
        }

        return result;
    }




    private double USTableSpoonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/67.628;
                break;

            case milliLiterId:
                result = value*14.7868;
                break;
            case cubicMeterId:
                result = value*1.4787*Math.pow(10,-5);
                break;
            case cubicCentiMeterId:
                result = value*14.7868;
                break;
            case cubickilometerId:
                result = value*1.47868*Math.pow(10,-14);
                break;

            case cubicMilliMeterId:
                result = value*14786.8;
                break;
            case cubicFootId:
                result = value/1915;
                break;

            case cubicInchId:
                result = value/1.108;
                break;

            case USLiquidGallonId:
                result = value/256;
                break;
            case USLiquidQuartId:
                result = value/64;
                break;

            case USLiquidPintId:
                result = value/32;
                break;

            case USLegalCupId:
                result = value/16.231;
                break;

            case USFluidOunceId:
                result = value/2;
                break;
            case USTableSpoonId:
                result = value;
                break;
            case USTeaSpoonId:
                result = value*3;
                break;

            case imperialGallonId:
                result = value/307;
                break;
            case imperialQuartId:
                result = value/76.861;
                break;

            case imperialPintId:
                result = value/38.43;
                break;

            case imperialCupId:
                result = value/19.215;
                break;
            case imperialFluidOunceId:
                result = value/1.922;
                break;

            case imperialTableSpoonId:
                result = value/1.201;
                break;

            case imperialTeaSpoonId:
                result = value*2.49802;
                break;
        }

        return result;
    }



    private double USTeaSpoonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/203;
                break;

            case milliLiterId:
                result = value*4.92892;
                break;
            case cubicMeterId:
                result = value/202884;
                break;
            case cubicCentiMeterId:
                result = value*4.92892;
                break;
            case cubickilometerId:
                result = value*4.92892*Math.pow(10,-15);
                break;

            case cubicMilliMeterId:
                result = value*4928.92;
                break;
            case cubicFootId:
                result = value/5745;
                break;

            case cubicInchId:
                result = value/3.325;
                break;

            case USLiquidGallonId:
                result = value/768;
                break;
            case USLiquidQuartId:
                result = value/192;
                break;

            case USLiquidPintId:
                result = value/96;
                break;

            case USLegalCupId:
                result = value/48.692;
                break;

            case USFluidOunceId:
                result = value/6;
                break;
            case USTableSpoonId:
                result = value/3;
                break;
            case USTeaSpoonId:
                result = value;
                break;

            case imperialGallonId:
                result = value/922;
                break;
            case imperialQuartId:
                result = value/231;
                break;

            case imperialPintId:
                result = value/115;
                break;

            case imperialCupId:
                result = value/57.646;
                break;
            case imperialFluidOunceId:
                result = value/5.765;
                break;

            case imperialTableSpoonId:
                result = value/3.603;
                break;

            case imperialTeaSpoonId:
                result = value/1.201;
                break;
        }

        return result;
    }




    private double imperialGallonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*4.54609;
                break;

            case milliLiterId:
                result = value*4546.09;
                break;
            case cubicMeterId:
                result = value/220;
                break;
            case cubicCentiMeterId:
                result = value*4546.09;
                break;
            case cubickilometerId:
                result = value*4.54609*Math.pow(10,-12);
                break;

            case cubicMilliMeterId:
                result = value*4.546*Math.pow(10,6);
                break;
            case cubicFootId:
                result = value/6.229;
                break;

            case cubicInchId:
                result = value*277.419;
                break;

            case USLiquidGallonId:
                result = value*1.20095;
                break;
            case USLiquidQuartId:
                result = value*4.8038;
                break;

            case USLiquidPintId:
                result = value*9.6076;
                break;

            case USLegalCupId:
                result = value*18.942;
                break;

            case USFluidOunceId:
                result = value*153.722;
                break;
            case USTableSpoonId:
                result = value*307.443;
                break;
            case USTeaSpoonId:
                result = value*922.33;
                break;

            case imperialGallonId:
                result = value;
                break;
            case imperialQuartId:
                result = value*4;
                break;

            case imperialPintId:
                result = value*8;
                break;

            case imperialCupId:
                result = value*16;
                break;
            case imperialFluidOunceId:
                result = value*160;
                break;

            case imperialTableSpoonId:
                result = value*256;
                break;

            case imperialTeaSpoonId:
                result = value*768;
                break;
        }

        return result;
    }



    private double imperialQuartToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value*1.13652;
                break;

            case milliLiterId:
                result = value*1136.52;
                break;
            case cubicMeterId:
                result = value/880;
                break;
            case cubicCentiMeterId:
                result = value*1136.52;
                break;
            case cubickilometerId:
                result = value*1.13652*Math.pow(10,-12);
                break;

            case cubicMilliMeterId:
                result = value*1.137*Math.pow(10,6);
                break;
            case cubicFootId:
                result = value/24.915;
                break;

            case cubicInchId:
                result = value*69.3549;
                break;

            case USLiquidGallonId:
                result = value/3.331;
                break;
            case USLiquidQuartId:
                result = value*1.20095;
                break;

            case USLiquidPintId:
                result = value*2.4019;
                break;

            case USLegalCupId:
                result = value*4.73551;
                break;

            case USFluidOunceId:
                result = value*38.4304;
                break;
            case USTableSpoonId:
                result = value*76.8608;
                break;
            case USTeaSpoonId:
                result = value*230.582;
                break;

            case imperialGallonId:
                result = value/4;
                break;
            case imperialQuartId:
                result = value;
                break;

            case imperialPintId:
                result = value*2;
                break;

            case imperialCupId:
                result = value*4;
                break;
            case imperialFluidOunceId:
                result = value*40;
                break;

            case imperialTableSpoonId:
                result = value*64;
                break;

            case imperialTeaSpoonId:
                result = value*192;
                break;
        }

        return result;
    }




    private double imperialPintToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/1.76;
                break;

            case milliLiterId:
                result = value*568.261;
                break;
            case cubicMeterId:
                result = value/1760;
                break;
            case cubicCentiMeterId:
                result = value*568.261;
                break;
            case cubickilometerId:
                result = value*5.68261*Math.pow(10,-13);
                break;

            case cubicMilliMeterId:
                result = value*568261;
                break;
            case cubicFootId:
                result = value/49.831;
                break;

            case cubicInchId:
                result = value*34.6774;
                break;

            case USLiquidGallonId:
                result = value/6.661;
                break;
            case USLiquidQuartId:
                result = value/1.665;
                break;

            case USLiquidPintId:
                result = value*1.20095;
                break;

            case USLegalCupId:
                result = value*2.36776;
                break;

            case USFluidOunceId:
                result = value*19.2152;
                break;
            case USTableSpoonId:
                result = value*38.4304;
                break;
            case USTeaSpoonId:
                result = value*115.291;
                break;

            case imperialGallonId:
                result = value/8;
                break;
            case imperialQuartId:
                result = value/2;
                break;

            case imperialPintId:
                result = value;
                break;

            case imperialCupId:
                result = value*2;
                break;
            case imperialFluidOunceId:
                result = value*20;
                break;

            case imperialTableSpoonId:
                result = value*32;
                break;

            case imperialTeaSpoonId:
                result = value*96;
                break;
        }

        return result;
    }




    private double imperialCupToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/3.52;
                break;

            case milliLiterId:
                result = value*284.131;
                break;
            case cubicMeterId:
                result = value/3520;
                break;
            case cubicCentiMeterId:
                result = value*284.131;
                break;
            case cubickilometerId:
                result = value*2.84131*Math.pow(10,-13);
                break;

            case cubicMilliMeterId:
                result = value*284130.643;
                break;
            case cubicFootId:
                result = value/99.661;
                break;

            case cubicInchId:
                result = value*17.3387;
                break;

            case USLiquidGallonId:
                result = value/13.323;
                break;
            case USLiquidQuartId:
                result = value/3.331;
                break;

            case USLiquidPintId:
                result = value/1.665;
                break;

            case USLegalCupId:
                result = value*1.18388;
                break;

            case USFluidOunceId:
                result = value*9.6076;
                break;
            case USTableSpoonId:
                result = value*19.2152;
                break;
            case USTeaSpoonId:
                result = value*57.6456;
                break;

            case imperialGallonId:
                result = value/16;
                break;
            case imperialQuartId:
                result = value/4;
                break;

            case imperialPintId:
                result = value/2;
                break;

            case imperialCupId:
                result = value;
                break;
            case imperialFluidOunceId:
                result = value*10;
                break;

            case imperialTableSpoonId:
                result = value*16;
                break;

            case imperialTeaSpoonId:
                result = value*48;
                break;
        }

        return result;
    }



    private double imperialFluidOunceToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/35.195;
                break;

            case milliLiterId:
                result = value*28.4131;
                break;
            case cubicMeterId:
                result = value/35195;
                break;
            case cubicCentiMeterId:
                result = value*28.4131;
                break;
            case cubickilometerId:
                result = value*2.84131*Math.pow(10,-14);
                break;

            case cubicMilliMeterId:
                result = value*28413.1;
                break;
            case cubicFootId:
                result = value/997;
                break;

            case cubicInchId:
                result = value*1.73387;
                break;

            case USLiquidGallonId:
                result = value/133;
                break;
            case USLiquidQuartId:
                result = value/33.307;
                break;

            case USLiquidPintId:
                result = value/16.653;
                break;

            case USLegalCupId:
                result = value/8.447;
                break;

            case USFluidOunceId:
                result = value/1.041;
                break;
            case USTableSpoonId:
                result = value*1.92152;
                break;
            case USTeaSpoonId:
                result = value*5.76456;
                break;

            case imperialGallonId:
                result = value/160;
                break;
            case imperialQuartId:
                result = value/40;
                break;

            case imperialPintId:
                result = value/20;
                break;

            case imperialCupId:
                result = value/10;
                break;
            case imperialFluidOunceId:
                result = value;
                break;

            case imperialTableSpoonId:
                result = value*1.6;
                break;

            case imperialTeaSpoonId:
                result = value*4.8;
                break;
        }

        return result;
    }




    private double imperialTableSpoonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/56.312;
                break;

            case milliLiterId:
                result = value*17.7582;
                break;
            case cubicMeterId:
                result = value/56312;
                break;
            case cubicCentiMeterId:
                result = value*17.7582;
                break;
            case cubickilometerId:
                result = value*1.77582*Math.pow(10,-14);
                break;

            case cubicMilliMeterId:
                result = value*17758.2;
                break;
            case cubicFootId:
                result = value/1595;
                break;

            case cubicInchId:
                result = value*1.08367;
                break;

            case USLiquidGallonId:
                result = value/213;
                break;
            case USLiquidQuartId:
                result = value/53.291;
                break;

            case USLiquidPintId:
                result = value/26.646;
                break;

            case USLegalCupId:
                result = value/13.515;
                break;

            case USFluidOunceId:
                result = value/1.665;
                break;
            case USTableSpoonId:
                result = value*1.20095;
                break;
            case USTeaSpoonId:
                result = value*3.60285;
                break;

            case imperialGallonId:
                result = value/256;
                break;
            case imperialQuartId:
                result = value/64;
                break;

            case imperialPintId:
                result = value/32;
                break;

            case imperialCupId:
                result = value/16;
                break;
            case imperialFluidOunceId:
                result = value/1.6;
                break;

            case imperialTableSpoonId:
                result = value;
                break;

            case imperialTeaSpoonId:
                result = value*3;
                break;
        }

        return result;
    }




    private double imperialTeaSpoonToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case literId:
                result = value/169;
                break;

            case milliLiterId:
                result = value*5.91939;
                break;
            case cubicMeterId:
                result = value/168936;
                break;
            case cubicCentiMeterId:
                result = value*5.91939;
                break;
            case cubickilometerId:
                result = value*5.91939*Math.pow(10,-15);
                break;

            case cubicMilliMeterId:
                result = value*4928.92;
                break;
            case cubicFootId:
                result = value/4784;
                break;

            case cubicInchId:
                result = value/2.768;
                break;

            case USLiquidGallonId:
                result = value/639;
                break;
            case USLiquidQuartId:
                result = value/160;
                break;

            case USLiquidPintId:
                result = value/79.937;
                break;

            case USLegalCupId:
                result = value/40.545;
                break;

            case USFluidOunceId:
                result = value/4.996;
                break;
            case USTableSpoonId:
                result = value/2.498;
                break;
            case USTeaSpoonId:
                result = value*1.20095;
                break;

            case imperialGallonId:
                result = value/768;
                break;
            case imperialQuartId:
                result = value/192;
                break;

            case imperialPintId:
                result = value/96;
                break;

            case imperialCupId:
                result = value/48;
                break;
            case imperialFluidOunceId:
                result = value/4.8;
                break;

            case imperialTableSpoonId:
                result = value/3;
                break;

            case imperialTeaSpoonId:
                result = value;
                break;
        }

        return result;
    }



}
