package com.nisith.currencyandotherconverters;

public class TimeConverter {

    private final int PicoSecondId = 1, NanoSecondId = 2,MicroSecondId = 3,MilliSecondId = 4,SecondId = 5,
            MinuteId = 6, HourId = 7,DayId = 8,WeekId = 9,MonthId =10,YearId =11,CenturyId =12;

    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("PicoSecond")) {
            idValue = PicoSecondId;

        } else if (unitName.equalsIgnoreCase("NanoSecond")) {
            idValue = NanoSecondId;

        } else if (unitName.equalsIgnoreCase("MicroSecond")) {
            idValue = MicroSecondId;

        } else if (unitName.equalsIgnoreCase("MilliSecond" )) {
            idValue = MilliSecondId;

        } else if (unitName.equalsIgnoreCase("Second")) {
            idValue = SecondId;

        } else if (unitName.equalsIgnoreCase("Minute")) {
            idValue = MinuteId;

        } else if (unitName.equalsIgnoreCase("Hour")) {
            idValue = HourId;

        } else if (unitName.equalsIgnoreCase("Day")) {
            idValue = DayId;

        } else if (unitName.equalsIgnoreCase("Week")) {
            idValue = WeekId;

        }else if (unitName.equalsIgnoreCase("Month")) {
            idValue = MonthId;

        }else if (unitName.equalsIgnoreCase("Year")) {
            idValue = YearId;

        }else if (unitName.equalsIgnoreCase("Century")) {
            idValue = CenturyId;

        }

        return idValue;
    }





    public double getWeightConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("PicoSecond")){
            result = picoSecondToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("NanoSecond")) {
            result = nanoSecondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MicroSecond")) {
            result = microSecondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MilliSecond")) {
            result = milliSecondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Second")) {
            result = secondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Minute")) {
            result = minuteToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Hour")) {
            result = hourToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Day")) {
            result = dayToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Week")) {
            result = weekToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("Month")) {
            result = monthToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("Year")) {
            result = yearToOthers(sourceUnit,destUnit,value);

        }else if (sourceUnit.equalsIgnoreCase("Century")) {
            result = centuryToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }






    private double picoSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value;
                break;

            case NanoSecondId:
                result = value*0.001;
                break;
            case MicroSecondId:
                result = value*Math.pow(10,-6);
                break;
            case MilliSecondId:
                result = value*Math.pow(10,-9);
                break;
            case SecondId:
                result = value*Math.pow(10,-12);
                break;

            case MinuteId:
                result = value*1.6666666666667*Math.pow(10,-14);
                break;
            case HourId:
                result = value*2.7777777777778*Math.pow(10,-16);
                break;

            case DayId:
                result = value*1.1574074074074*Math.pow(10,-17);
                break;

            case WeekId:
                result = value*1.6534391534392*Math.pow(10,-18);
                break;
            case MonthId:
                result = value*3.8051750380518*Math.pow(10,-19);
                break;

            case YearId:
                result = value*3.1709791983765*Math.pow(10,-20);
                break;

            case CenturyId:
                result = value*3.1709791983765*Math.pow(10,-22);
                break;
        }

        return result;
    }




    private double nanoSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*1000;
                break;

            case NanoSecondId:
                result = value;
                break;
            case MicroSecondId:
                result = value*0.001;
                break;
            case MilliSecondId:
                result = value*Math.pow(10,-6);
                break;
            case SecondId:
                result = value*Math.pow(10,-9);
                break;

            case MinuteId:
                result = value*1.6666666666667*Math.pow(10,-11);
                break;
            case HourId:
                result = value*2.7777777777778*Math.pow(10,-13);
                break;

            case DayId:
                result = value*1.1574074074074*Math.pow(10,-14);
                break;

            case WeekId:
                result = value*1.6534391534392*Math.pow(10,-15);
                break;
            case MonthId:
                result = value*3.8051750380518*Math.pow(10,-16);
                break;

            case YearId:
                result = value*3.1709791983765*Math.pow(10,-17);
                break;

            case CenturyId:
                result = value*3.1709791983765*Math.pow(10,-19);
                break;
        }

        return result;
    }



    private double microSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*Math.pow(10,6);
                break;

            case NanoSecondId:
                result = value*1000;
                break;
            case MicroSecondId:
                result = value;
                break;
            case MilliSecondId:
                result = value*0.001;
                break;
            case SecondId:
                result = value*Math.pow(10,-6);
                break;

            case MinuteId:
                result = value*1.6666666666667*Math.pow(10,-8);
                break;
            case HourId:
                result = value*2.7777777777778*Math.pow(10,-10);
                break;

            case DayId:
                result = value*1.1574074074074*Math.pow(10,-11);
                break;

            case WeekId:
                result = value*1.6534391534392*Math.pow(10,-12);
                break;
            case MonthId:
                result = value*3.8051750380518*Math.pow(10,-13);
                break;

            case YearId:
                result = value*3.1709791983765*Math.pow(10,-14);
                break;

            case CenturyId:
                result = value*3.1709791983765*Math.pow(10,-16);
                break;
        }

        return result;
    }





    private double milliSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*Math.pow(10,9);
                break;

            case NanoSecondId:
                result = value*Math.pow(10,6);
                break;
            case MicroSecondId:
                result = value*Math.pow(10,3);
                break;
            case MilliSecondId:
                result = value;
                break;
            case SecondId:
                result = value*Math.pow(10,-3);
                break;

            case MinuteId:
                result = value*1.6666666666667*Math.pow(10,-5);
                break;
            case HourId:
                result = value*2.7777777777778*Math.pow(10,-7);
                break;

            case DayId:
                result = value*1.1574074074074*Math.pow(10,-8);
                break;

            case WeekId:
                result = value*1.6534391534392*Math.pow(10,-9);
                break;
            case MonthId:
                result = value*3.8051750380518*Math.pow(10,-10);
                break;

            case YearId:
                result = value*3.1709791983765*Math.pow(10,-11);
                break;

            case CenturyId:
                result = value*3.1709791983765*Math.pow(10,-13);
                break;
        }

        return result;
    }





    private double secondToOthers(String sourceUnit,String destUnit,double value){  //Baki
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*Math.pow(10,12);
                break;

            case NanoSecondId:
                result = value*Math.pow(10,9);
                break;
            case MicroSecondId:
                result = value*Math.pow(10,6);
                break;
            case MilliSecondId:
                result = value*Math.pow(10,3);
                break;
            case SecondId:
                result = value;
                break;

            case MinuteId:
                result = value/60;
                break;
            case HourId:
                result = value/3600;
                break;

            case DayId:
                result = value/86400;
                break;

            case WeekId:
                result = value/604800;
                break;
            case MonthId:
                result = value*3.8051750380518*Math.pow(10,-7);
                break;

            case YearId:
                result = value*3.1709791983765*Math.pow(10,-8);
                break;

            case CenturyId:
                result = value*3.1709791983765*Math.pow(10,-10);
                break;
        }

        return result;
    }



    private double minuteToOthers(String sourceUnit,String destUnit,double value){  //Baki
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*6*Math.pow(10,13);
                break;

            case NanoSecondId:
                result = value*6*Math.pow(10,10);
                break;
            case MicroSecondId:
                result = value*6*Math.pow(10,7);
                break;
            case MilliSecondId:
                result = value*60000;
                break;
            case SecondId:
                result = value*60;
                break;

            case MinuteId:
                result = value;
                break;
            case HourId:
                result = value/60;
                break;

            case DayId:
                result = value/1440;
                break;

            case WeekId:
                result = value/10080;
                break;
            case MonthId:
                result = value/43800;
                break;

            case YearId:
                result = value/525600;
                break;

            case CenturyId:
                result = value*1.9025875190259*Math.pow(10,-8);
                break;
        }

        return result;
    }



    private double hourToOthers(String sourceUnit,String destUnit,double value){  //Baki
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*3.6*Math.pow(10,15);
                break;

            case NanoSecondId:
                result = value*3.6*Math.pow(10,12);
                break;
            case MicroSecondId:
                result = value*3.6*Math.pow(10,9);
                break;
            case MilliSecondId:
                result = value*3.6*Math.pow(10,6);
                break;
            case SecondId:
                result = value*3600;
                break;

            case MinuteId:
                result = value*60;
                break;
            case HourId:
                result = value;
                break;

            case DayId:
                result = value/ 24;
                break;

            case WeekId:
                result = value/168;
                break;
            case MonthId:
                result = value/730;
                break;

            case YearId:
                result = value/8760;
                break;

            case CenturyId:
                result = value/876000;
                break;
        }

        return result;
    }



    private double dayToOthers(String sourceUnit,String destUnit,double value){  //Baki
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*8.64*Math.pow(10,16);
                break;

            case NanoSecondId:
                result = value*8.64*Math.pow(10,13);
                break;
            case MicroSecondId:
                result = value*8.64*Math.pow(10,10);
                break;
            case MilliSecondId:
                result = value*8.64*Math.pow(10,7);
                break;
            case SecondId:
                result = value*86400;
                break;

            case MinuteId:
                result = value*1440;
                break;
            case HourId:
                result = value*24;
                break;

            case DayId:
                result = value;
                break;

            case WeekId:
                result = value/7;
                break;
            case MonthId:
                result = value/ 30.417;
                break;

            case YearId:
                result = value/365;
                break;

            case CenturyId:
                result = value/36500;
                break;
        }

        return result;
    }



    private double weekToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*6.048*Math.pow(10,17);
                break;

            case NanoSecondId:
                result = value*6.048*Math.pow(10,14);
                break;
            case MicroSecondId:
                result = value*6.048*Math.pow(10,11);
                break;
            case MilliSecondId:
                result = value*6.048*Math.pow(10,8);
                break;
            case SecondId:
                result = value*604800;
                break;

            case MinuteId:
                result = value*10080;
                break;
            case HourId:
                result = value*168;
                break;

            case DayId:
                result = value*7;
                break;

            case WeekId:
                result = value;
                break;
            case MonthId:
                result = value*0.23013698630137;
                break;

            case YearId:
                result = value*0.019178082191781;
                break;

            case CenturyId:
                result = value*0.00019178082191781;
                break;
        }

        return result;
    }



    private double monthToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*2.628*Math.pow(10,18);
                break;

            case NanoSecondId:
                result = value*2.628*Math.pow(10,15);
                break;
            case MicroSecondId:
                result = value*2.628*Math.pow(10,12);
                break;
            case MilliSecondId:
                result = value*2.628*Math.pow(10,9);
                break;
            case SecondId:
                result = value*2.628*Math.pow(10,6);
                break;

            case MinuteId:
                result = value*43800;
                break;
            case HourId:
                result = value*730;
                break;

            case DayId:
                result = value*30.416666666667;
                break;

            case WeekId:
                result = value*4.3452380952381;
                break;
            case MonthId:
                result = value;
                break;

            case YearId:
                result = value/12;
                break;

            case CenturyId:
                result = value/1200;
                break;
        }

        return result;
    }



    private double yearToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*3.1536*Math.pow(10,19);
                break;

            case NanoSecondId:
                result = value*3.1536*Math.pow(10,16);
                break;
            case MicroSecondId:
                result = value*3.1536*Math.pow(10,13);
                break;
            case MilliSecondId:
                result = value*3.1536*Math.pow(10,10);
                break;
            case SecondId:
                result = value*31536000;
                break;

            case MinuteId:
                result = value*525600;
                break;
            case HourId:
                result = value*8760;
                break;

            case DayId:
                result = value*365;
                break;

            case WeekId:
                result = value*52.142857142857;
                break;
            case MonthId:
                result = value*12;
                break;

            case YearId:
                result = value;
                break;

            case CenturyId:
                result = value*0.01;
                break;
        }

        return result;
    }



    private double centuryToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case PicoSecondId:
                result = value*3.1536*Math.pow(10,21);
                break;

            case NanoSecondId:
                result = value*3.1536*Math.pow(10,18);
                break;
            case MicroSecondId:
                result = value*3.1536*Math.pow(10,15);
                break;
            case MilliSecondId:
                result = value*3.1536*Math.pow(10,12);
                break;
            case SecondId:
                result = value*3.1536*Math.pow(10,9);
                break;

            case MinuteId:
                result = value*5.256*Math.pow(10,7);
                break;
            case HourId:
                result = value*876000;
                break;

            case DayId:
                result = value*36500;
                break;

            case WeekId:
                result = value*5214.2857142857;
                break;
            case MonthId:
                result = value*1200;
                break;

            case YearId:
                result = value*100;
                break;

            case CenturyId:
                result = value;
                break;
        }

        return result;
    }







}
