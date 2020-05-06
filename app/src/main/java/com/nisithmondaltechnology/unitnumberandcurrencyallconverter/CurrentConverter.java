package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class CurrentConverter {

    private final int ampereId = 1,biotId = 2,abAmpereId = 3,milliAmpereId = 4,microAmpereId = 5,nanoAmpereId = 6,
            picoAmpereId = 7,coulombPerSecondId = 8,kiloAmpereId = 9,megaAmpereId = 10;


    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Ampere (A)")) {
            idValue = ampereId;

        } else if (unitName.equalsIgnoreCase("Biot (Bi)")) {
            idValue = biotId;

        } else if (unitName.equalsIgnoreCase("AbAmpere (abA)")) {
            idValue = abAmpereId;

        } else if (unitName.equalsIgnoreCase("MilliAmpere (mA)")) {
            idValue = milliAmpereId;

        } else if (unitName.equalsIgnoreCase("MicroAmpere (µA)")) {
            idValue = microAmpereId;

        } else if (unitName.equalsIgnoreCase("NanoAmpere (nA)")) {
            idValue = nanoAmpereId;

        } else if (unitName.equalsIgnoreCase("PicoAmpere (pA)")) {
            idValue = picoAmpereId;

        } else if (unitName.equalsIgnoreCase("Coulomb/Second")) {
            idValue = coulombPerSecondId;

        } else if (unitName.equalsIgnoreCase("KiloAmpere (KA)")) {
            idValue = kiloAmpereId;

        } else if (unitName.equalsIgnoreCase("MegaAmpere (MA)")) {
            idValue = megaAmpereId;

        }
        return idValue;
    }

    public double getResistanceConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("Ampere (A)")){
            result = ampereToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("Biot (Bi)")) {
            result = biotToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("AbAmpere (abA)")) {
            result = abAmpereToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MilliAmpere (mA)")) {
            result = milliAmpereToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MicroAmpere (µA)")) {
            result = microAmpereToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("NanoAmpere (nA)")) {
            result = nanoAmpereToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("PicoAmpere (pA)")) {
            result = picoAmpereToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Coulomb/Second")) {
            result = columbPerSecondToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("KiloAmpere (KA)")) {
            result = kiloAmpereToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MegaAmpere (MA)")) {
            result = megaAmpereToOthers(sourceUnit,destUnit,value);

        }
        return result;
    }



    private double ampereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value;
                break;

            case biotId:
                result = value*0.1;
                break;
            case abAmpereId:
                result = value*0.1;
                break;
            case milliAmpereId:
                result = value*1000;
                break;
            case microAmpereId:
                result = value*1000000;
                break;

            case nanoAmpereId:
                result = value*1000000000;
                break;
            case picoAmpereId:
                result = value*1E12;
                break;

            case coulombPerSecondId:
                result = value;
                break;

            case kiloAmpereId:
                result = value*0.001;
                break;

            case megaAmpereId:
                result = value*0.000001;
                break;
        }

        return result;
    }



    private double biotToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value*10;
                break;

            case biotId:
                result = value;
                break;
            case abAmpereId:
                result = value;
                break;
            case milliAmpereId:
                result = value*10000;
                break;
            case microAmpereId:
                result = value*10000000;
                break;

            case nanoAmpereId:
                result = value*1E10;
                break;
            case picoAmpereId:
                result = value*1E13;
                break;

            case coulombPerSecondId:
                result = value*10;
                break;

            case kiloAmpereId:
                result = value*0.01;
                break;

            case megaAmpereId:
                result = value*0.00001;
                break;
        }

        return result;
    }



    private double abAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value*10;
                break;

            case biotId:
                result = value;
                break;
            case abAmpereId:
                result = value;
                break;
            case milliAmpereId:
                result = value*10000;
                break;
            case microAmpereId:
                result = value*10000000;
                break;

            case nanoAmpereId:
                result = value*1E10;
                break;
            case picoAmpereId:
                result = value*1E13;
                break;

            case coulombPerSecondId:
                result = value*10;
                break;

            case kiloAmpereId:
                result = value*0.01;
                break;

            case megaAmpereId:
                result = value*0.00001;
                break;
        }

        return result;
    }



    private double milliAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value*0.001;
                break;

            case biotId:
                result = value*0.0001;
                break;
            case abAmpereId:
                result = value*0.0001;
                break;
            case milliAmpereId:
                result = value;
                break;
            case microAmpereId:
                result = value*1000;
                break;

            case nanoAmpereId:
                result = value*1000000;
                break;
            case picoAmpereId:
                result = value*1000000000;
                break;

            case coulombPerSecondId:
                result = value*0.001;
                break;

            case kiloAmpereId:
                result = value*0.000001;
                break;

            case megaAmpereId:
                result = value*1E-9;
                break;
        }

        return result;
    }



    private double microAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value*0.000001;
                break;

            case biotId:
                result = value*1E-7;
                break;
            case abAmpereId:
                result = value*1E-7;
                break;
            case milliAmpereId:
                result = value*0.001;
                break;
            case microAmpereId:
                result = value;
                break;

            case nanoAmpereId:
                result = value*1000;
                break;
            case picoAmpereId:
                result = value*1000000;
                break;

            case coulombPerSecondId:
                result = value*0.000001;
                break;

            case kiloAmpereId:
                result = value*1E-9;
                break;

            case megaAmpereId:
                result = value*1E-12;
                break;
        }

        return result;
    }



    private double nanoAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;

        switch (getUnitId(destUnit)){

            case ampereId:
                result = value*1E-9;
                break;

            case biotId:
                result = value*1E-10;
                break;
            case abAmpereId:
                result = value*1E-10;
                break;
            case milliAmpereId:
                result = value*0.000001;
                break;
            case microAmpereId:
                result = value*0.001;
                break;

            case nanoAmpereId:
                result = value;
                break;
            case picoAmpereId:
                result = value*1000;
                break;

            case coulombPerSecondId:
                result = value*1E-9;
                break;

            case kiloAmpereId:
                result = value*1E-12;
                break;

            case megaAmpereId:
                result = value*1E-15;
                break;
        }

        return result;
    }



    private double picoAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value*1E-12;
                break;

            case biotId:
                result = value*1E-13;
                break;
            case abAmpereId:
                result = value*1E-13;
                break;
            case milliAmpereId:
                result = value*1E-9;
                break;
            case microAmpereId:
                result = value*0.000001;
                break;

            case nanoAmpereId:
                result = value*0.001;
                break;
            case picoAmpereId:
                result = value;
                break;

            case coulombPerSecondId:
                result = value*1E-12;
                break;

            case kiloAmpereId:
                result = value*1E-15;
                break;

            case megaAmpereId:
                result = value* 1E-18;
                break;
        }

        return result;
    }



    private double columbPerSecondToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value;
                break;

            case biotId:
                result = value*0.1;
                break;
            case abAmpereId:
                result = value*0.1;
                break;
            case milliAmpereId:
                result = value*1000;
                break;
            case microAmpereId:
                result = value*1000000;
                break;

            case nanoAmpereId:
                result = value*1000000000;
                break;
            case picoAmpereId:
                result = value*1E12;
                break;

            case coulombPerSecondId:
                result = value;
                break;

            case kiloAmpereId:
                result = value*0.001;
                break;

            case megaAmpereId:
                result = value*0.000001;
                break;
        }

        return result;
    }



    private double kiloAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value*1000;
                break;

            case biotId:
                result = value*100;
                break;
            case abAmpereId:
                result = value*100;
                break;
            case milliAmpereId:
                result = value*1000000;
                break;
            case microAmpereId:
                result = value*1000000000;
                break;

            case nanoAmpereId:
                result = value*1E12;
                break;
            case picoAmpereId:
                result = value*1E15;
                break;

            case coulombPerSecondId:
                result = value*1000;
                break;

            case kiloAmpereId:
                result = value;
                break;

            case megaAmpereId:
                result = value*0.001;
                break;
        }

        return result;
    }



        private double megaAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ampereId:
                result = value* 1000000;
                break;

            case biotId:
                result = value* 100000;
                break;
            case abAmpereId:
                result = value*100000;
                break;
            case milliAmpereId:
                result = value*1000000000;
                break;
            case microAmpereId:
                result = value*1E12;
                break;

            case nanoAmpereId:
                result = value*1E15;
                break;
            case picoAmpereId:
                result = value*1E18;
                break;

            case coulombPerSecondId:
                result = value*1000000;
                break;

            case kiloAmpereId:
                result = value*1000;
                break;

            case megaAmpereId:
                result = value;
                break;
        }

        return result;
    }







}
