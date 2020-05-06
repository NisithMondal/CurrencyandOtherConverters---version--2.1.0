package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class ResistanceConverter {

    private final int ohmId = 1,abOhmId = 2,kiloOhmId = 3,megaOhmId = 4,gigaOhmId = 5,milliOhmId = 6,
            microOhmId = 7,nanoOhmId = 8,voltPerAmpereId = 9;


    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Ohm (Ω)")) {
            idValue = ohmId;

        } else if (unitName.equalsIgnoreCase("AbOhm (abΩ)")) {
            idValue = abOhmId;

        } else if (unitName.equalsIgnoreCase("KiloOhm (kΩ)")) {
            idValue = kiloOhmId;

        } else if (unitName.equalsIgnoreCase("MegaOhm (MΩ)")) {
            idValue = megaOhmId;

        } else if (unitName.equalsIgnoreCase("GigaOhm (GΩ)")) {
            idValue = gigaOhmId;

        } else if (unitName.equalsIgnoreCase("MilliOhm (mΩ)")) {
            idValue = milliOhmId;

        } else if (unitName.equalsIgnoreCase("MicroOhm (µΩ)")) {
            idValue = microOhmId;

        } else if (unitName.equalsIgnoreCase("NanoOhm (nΩ)")) {
            idValue = nanoOhmId;

        } else if (unitName.equalsIgnoreCase("Volt/Ampere")) {
            idValue = voltPerAmpereId;

        }
        return idValue;
    }

    public double getResistanceConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("Ohm (Ω)")){
            result = ohmToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("AbOhm (abΩ)")) {
            result = abOhmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("KiloOhm (kΩ)")) {
            result = kiloOhmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MegaOhm (MΩ)")) {
            result = megaOhmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("GigaOhm (GΩ)")) {
            result = gigaOhmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MilliOhm (mΩ)")) {
            result = milliOhmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MicroOhm (µΩ)")) {
            result = microOhmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("NanoOhm (nΩ)")) {
            result = nanoOhmToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Volt/Ampere")) {
            result = voltPerAmpereToOthers(sourceUnit,destUnit,value);

        }
        return result;
    }



    private double ohmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value;
                break;

            case abOhmId:
                result = value*1000000000;
                break;
            case kiloOhmId:
                result = value*0.001;
                break;
            case megaOhmId:
                result = value*0.000001;
                break;
            case gigaOhmId:
                result = value*1E-9;
                break;

            case milliOhmId:
                result = value*1000;
                break;
            case microOhmId:
                result = value*1000000;
                break;

            case nanoOhmId:
                result = value*1000000000;
                break;

            case voltPerAmpereId:
                result = value;
                break;

        }

        return result;
    }




    private double abOhmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value*1E-9;
                break;

            case abOhmId:
                result = value;
                break;
            case kiloOhmId:
                result = value*1E-12;
                break;
            case megaOhmId:
                result = value*1E-15;
                break;
            case gigaOhmId:
                result = value*1E-18;
                break;

            case milliOhmId:
                result = value*0.000001;
                break;
            case microOhmId:
                result = value*0.001;
                break;

            case nanoOhmId:
                result = value;
                break;

            case voltPerAmpereId:
                result = value*1E-9;
                break;

        }

        return result;
    }



    private double kiloOhmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value*1000;
                break;

            case abOhmId:
                result = value*1E12;
                break;
            case kiloOhmId:
                result = value;
                break;
            case megaOhmId:
                result = value*0.001;
                break;
            case gigaOhmId:
                result = value*0.000001;
                break;

            case milliOhmId:
                result = value*1000000;
                break;
            case microOhmId:
                result = value*1000000000;
                break;

            case nanoOhmId:
                result = value*1E12;
                break;

            case voltPerAmpereId:
                result = value*1000;
                break;

        }

        return result;
    }



    private double megaOhmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value*1000000;
                break;

            case abOhmId:
                result = value*1E15;
                break;
            case kiloOhmId:
                result = value*1000;
                break;
            case megaOhmId:
                result = value;
                break;
            case gigaOhmId:
                result = value*0.001;
                break;

            case milliOhmId:
                result = value*1000000000;
                break;
            case microOhmId:
                result = value*1E12;
                break;

            case nanoOhmId:
                result = value*1E15;
                break;

            case voltPerAmpereId:
                result = value*1000000;
                break;

        }

        return result;
    }



    private double gigaOhmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value*1000000000;
                break;

            case abOhmId:
                result = value*1E18;
                break;
            case kiloOhmId:
                result = value*1000000;
                break;
            case megaOhmId:
                result = value*1000;
                break;
            case gigaOhmId:
                result = value;
                break;

            case milliOhmId:
                result = value*1E12;
                break;
            case microOhmId:
                result = value*1E15;
                break;

            case nanoOhmId:
                result = value*1E18;
                break;

            case voltPerAmpereId:
                result = value*1000000000;
                break;

        }

        return result;
    }



    private double milliOhmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value*0.001;
                break;

            case abOhmId:
                result = value*1000000;
                break;
            case kiloOhmId:
                result = value*0.000001;
                break;
            case megaOhmId:
                result = value*1E-9;
                break;
            case gigaOhmId:
                result = value*1E-12;
                break;

            case milliOhmId:
                result = value;
                break;
            case microOhmId:
                result = value*1000;
                break;

            case nanoOhmId:
                result = value*1000000;
                break;

            case voltPerAmpereId:
                result = value*0.001;
                break;

        }

        return result;
    }



    private double microOhmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value*0.000001;
                break;

            case abOhmId:
                result = value*1000;
                break;
            case kiloOhmId:
                result = value*1E-9;
                break;
            case megaOhmId:
                result = value*1E-12;
                break;
            case gigaOhmId:
                result = value*1E-15;
                break;

            case milliOhmId:
                result = value*0.001;
                break;
            case microOhmId:
                result = value;
                break;

            case nanoOhmId:
                result = value*1000;
                break;

            case voltPerAmpereId:
                result = value*0.000001;
                break;

        }

        return result;
    }



    private double nanoOhmToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value*1E-9;
                break;

            case abOhmId:
                result = value;
                break;
            case kiloOhmId:
                result = value*1E-12;
                break;
            case megaOhmId:
                result = value*1E-15;
                break;
            case gigaOhmId:
                result = value*1E-18;
                break;

            case milliOhmId:
                result = value*0.000001;
                break;
            case microOhmId:
                result = value*0.001;
                break;

            case nanoOhmId:
                result = value;
                break;

            case voltPerAmpereId:
                result = value*1E-9;
                break;

        }

        return result;
    }



    private double voltPerAmpereToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case ohmId:
                result = value;
                break;

            case abOhmId:
                result = value*1000000000;
                break;
            case kiloOhmId:
                result = value*0.001;
                break;
            case megaOhmId:
                result = value*0.000001;
                break;
            case gigaOhmId:
                result = value*1E-9;
                break;

            case milliOhmId:
                result = value*1000;
                break;
            case microOhmId:
                result = value*1000000;
                break;

            case nanoOhmId:
                result = value*1000000000;
                break;

            case voltPerAmpereId:
                result = value;
                break;

        }

        return result;
    }



}
