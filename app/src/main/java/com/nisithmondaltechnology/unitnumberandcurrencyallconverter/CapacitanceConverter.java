package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class CapacitanceConverter {
    private final int faradId = 1,nanoFaradId = 2,exaFaradId = 3,petaFaradId = 4,teraFaradId = 5,gigaFaradId = 6,
            megaFaradId = 7,kiloFaradId = 8,centiFaradId = 9,milliFaradId = 10,microFaradId = 11,picoFaradId = 12,
            femtoFaradId = 13,attoFaradId = 14,coulombPerVoltId = 15;



    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Farad (F)")) {
            idValue = faradId;

        } else if (unitName.equalsIgnoreCase("NanoFarad (nF)")) {
            idValue = nanoFaradId;

        } else if (unitName.equalsIgnoreCase("ExaFarad (EF)")) {
            idValue = exaFaradId;

        } else if (unitName.equalsIgnoreCase("PetaFarad (PF)")) {
            idValue = petaFaradId;

        } else if (unitName.equalsIgnoreCase("TeraFarad (TF)")) {
            idValue = teraFaradId;

        } else if (unitName.equalsIgnoreCase("GigaFarad (GF)")) {
            idValue = gigaFaradId;

        } else if (unitName.equalsIgnoreCase("MegaFarad (MF)")) {
            idValue = megaFaradId;

        } else if (unitName.equalsIgnoreCase("KiloFarad (KF)")) {
            idValue = kiloFaradId;

        } else if (unitName.equalsIgnoreCase("CentiFarad (cF)")) {
            idValue = centiFaradId;

        } else if (unitName.equalsIgnoreCase("MilliFarad (mF)")) {
            idValue = milliFaradId;
        } else if (unitName.equalsIgnoreCase("MicroFarad (µF)")) {
            idValue = microFaradId;

        } else if (unitName.equalsIgnoreCase("PicoFarad (pF)")) {
            idValue = picoFaradId;
        } else if (unitName.equalsIgnoreCase("FemtoFarad (fF)")) {
            idValue = femtoFaradId;
        } else if (unitName.equalsIgnoreCase("AttoFarad (aF)")) {
            idValue = attoFaradId;

        } else if (unitName.equalsIgnoreCase("coulomb/volt")) {
            idValue = coulombPerVoltId;
        }
        return idValue;
    }


    public double getCapacitanceConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("Farad (F)")){
            result = faradToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("NanoFarad (nF)")) {
            result = nanoFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("ExaFarad (EF)")) {
            result = exaFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("PetaFarad (PF)")) {
            result = petaFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("TeraFarad (TF)")) {
            result = teraFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("GigaFarad (GF)")) {
            result = gigaFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MegaFarad (MF)")) {
            result = megaFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("KiloFarad (KF)")) {
            result = kiloFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("CentiFarad (cF)")) {
            result = centiFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MilliFarad (mF)")) {

            result = milliFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MicroFarad (µF)")) {
            result = microFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("PicoFarad (pF)")) {

            result = picoFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("FemtoFarad (fF)")) {
            result = femtoFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("AttoFarad (aF)")) {

            result = attoFaradToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("coulomb/volt")) {

            result = coulombPerVoltToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }



    private double faradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value;
                break;

            case nanoFaradId:
                result = value*1000000000;
                break;
            case exaFaradId:
                result = value*1E-18;
                break;
            case petaFaradId:
                result = value*1E-15;
                break;
            case teraFaradId:
                result = value*1E-12;
                break;

            case gigaFaradId:
                result = value*1E-9;
                break;
            case megaFaradId:
                result = value*0.000001;
                break;

            case kiloFaradId:
                result = value*0.001;
                break;

            case centiFaradId:
                result = value*100;
                break;

            case milliFaradId:
                result = value*1000;
                break;

            case microFaradId:
                result = value*1000000;
                break;

            case picoFaradId:
                result = value*1E12;
                break;

            case femtoFaradId:
                result = value*1E15;
                break;

            case attoFaradId:
                result = value*1E18;
                break;

            case coulombPerVoltId:
                result = value;
                break;
        }

        return result;
    }




    private double nanoFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1E-9;
                break;

            case nanoFaradId:
                result = value;
                break;
            case exaFaradId:
                result = value*1E-27;
                break;
            case petaFaradId:
                result = value*1E-24;
                break;
            case teraFaradId:
                result = value*1E-21;
                break;

            case gigaFaradId:
                result = value*1E-18;
                break;
            case megaFaradId:
                result = value*1E-15;
                break;

            case kiloFaradId:
                result = value*1E-12;
                break;

            case centiFaradId:
                result = value*1E-7;
                break;

            case milliFaradId:
                result = value*0.000001;
                break;

            case microFaradId:
                result = value*0.001;
                break;

            case picoFaradId:
                result = value*1000;
                break;

            case femtoFaradId:
                result = value*1000000;
                break;

            case attoFaradId:
                result = value*1000000000;
                break;

            case coulombPerVoltId:
                result = value*1E-9;
                break;
        }

        return result;
    }




    private double exaFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1E18;
                break;

            case nanoFaradId:
                result = value*1E27;
                break;
            case exaFaradId:
                result = value;
                break;
            case petaFaradId:
                result = value*1000;
                break;
            case teraFaradId:
                result = value*1000000;
                break;

            case gigaFaradId:
                result = value*1000000000;
                break;
            case megaFaradId:
                result = value*1E12;
                break;

            case kiloFaradId:
                result = value*1E15;
                break;

            case centiFaradId:
                result = value*1E20;
                break;

            case milliFaradId:
                result = value*1E+21;
                break;

            case microFaradId:
                result = value*1E+24;
                break;

            case picoFaradId:
                result = value*1E+30;
                break;

            case femtoFaradId:
                result = value*1E+33;
                break;

            case attoFaradId:
                result = value*1E+36;
                break;

            case coulombPerVoltId:
                result = value*1E18;
                break;
        }

        return result;
    }




    private double petaFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1E15;
                break;

            case nanoFaradId:
                result = value*1E+24;
                break;
            case exaFaradId:
                result = value*0.001;
                break;
            case petaFaradId:
                result = value;
                break;
            case teraFaradId:
                result = value*1000;
                break;

            case gigaFaradId:
                result = value*1000000;
                break;
            case megaFaradId:
                result = value*1000000000;
                break;

            case kiloFaradId:
                result = value*1E12;
                break;

            case centiFaradId:
                result = value*1E17;
                break;

            case milliFaradId:
                result = value*1E18;
                break;

            case microFaradId:
                result = value*1E+21;
                break;

            case picoFaradId:
                result = value*1E+27;
                break;

            case femtoFaradId:
                result = value*9.999999999E29;
                break;

            case attoFaradId:
                result = value*1E+33;
                break;

            case coulombPerVoltId:
                result = value*1E15;
                break;
        }

        return result;
    }




    private double teraFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1E12;
                break;

            case nanoFaradId:
                result = value*1E21;
                break;
            case exaFaradId:
                result = value*0.000001;
                break;
            case petaFaradId:
                result = value*0.001;
                break;
            case teraFaradId:
                result = value;
                break;

            case gigaFaradId:
                result = value*1000;
                break;
            case megaFaradId:
                result = value*1000000;
                break;

            case kiloFaradId:
                result = value*1000000000;
                break;

            case centiFaradId:
                result = value*1E14;
                break;

            case milliFaradId:
                result = value*1E15;
                break;

            case microFaradId:
                result = value*1E18;
                break;

            case picoFaradId:
                result = value*1E24;
                break;

            case femtoFaradId:
                result = value*1E27;
                break;

            case attoFaradId:
                result = value*1E30;
                break;

            case coulombPerVoltId:
                result = value*1E12;
                break;
        }

        return result;
    }




    private double gigaFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1000000000;
                break;

            case nanoFaradId:
                result = value*1E18;
                break;
            case exaFaradId:
                result = value*1E-9;
                break;
            case petaFaradId:
                result = value*0.000001;
                break;
            case teraFaradId:
                result = value*0.001;
                break;

            case gigaFaradId:
                result = value;
                break;
            case megaFaradId:
                result = value*1000;
                break;

            case kiloFaradId:
                result = value*1000000;
                break;

            case centiFaradId:
                result = value*1E11;
                break;

            case milliFaradId:
                result = value*1E12;
                break;

            case microFaradId:
                result = value*1E15;
                break;

            case picoFaradId:
                result = value*1E21;
                break;

            case femtoFaradId:
                result = value*1E24;
                break;

            case attoFaradId:
                result = value*1E27;
                break;

            case coulombPerVoltId:
                result = value*1000000000;
                break;
        }

        return result;
    }



    private double megaFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1000000;
                break;

            case nanoFaradId:
                result = value*1E15;
                break;
            case exaFaradId:
                result = value*1E-12;
                break;
            case petaFaradId:
                result = value*1E-9;
                break;
            case teraFaradId:
                result = value*0.000001;
                break;

            case gigaFaradId:
                result = value*0.001;
                break;
            case megaFaradId:
                result = value;
                break;

            case kiloFaradId:
                result = value*1000;
                break;

            case centiFaradId:
                result = value*100000000;
                break;

            case milliFaradId:
                result = value*1000000000;
                break;

            case microFaradId:
                result = value*1E12;
                break;

            case picoFaradId:
                result = value*1E18;
                break;

            case femtoFaradId:
                result = value*1E21;
                break;

            case attoFaradId:
                result = value*1E24;
                break;

            case coulombPerVoltId:
                result = value*1000000;
                break;
        }

        return result;
    }




    private double kiloFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1000;
                break;

            case nanoFaradId:
                result = value*1E12;
                break;
            case exaFaradId:
                result = value*1E-15;
                break;
            case petaFaradId:
                result = value*1E-12;
                break;
            case teraFaradId:
                result = value*1E-9;
                break;

            case gigaFaradId:
                result = value*0.000001;
                break;
            case megaFaradId:
                result = value*0.001;
                break;

            case kiloFaradId:
                result = value;
                break;

            case centiFaradId:
                result = value*100000;
                break;

            case milliFaradId:
                result = value*1000000;
                break;

            case microFaradId:
                result = value*1000000000;
                break;

            case picoFaradId:
                result = value*1E15;
                break;

            case femtoFaradId:
                result = value*1E18;
                break;

            case attoFaradId:
                result = value*1E21;
                break;

            case coulombPerVoltId:
                result = value*1000;
                break;
        }

        return result;
    }



    private double centiFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*0.01;
                break;

            case nanoFaradId:
                result = value*10000000;
                break;
            case exaFaradId:
                result = value*1E-20;
                break;
            case petaFaradId:
                result = value*1E-17;
                break;
            case teraFaradId:
                result = value*1E-14;
                break;

            case gigaFaradId:
                result = value*1E-11;
                break;
            case megaFaradId:
                result = value*1E-8;
                break;

            case kiloFaradId:
                result = value*0.00001;
                break;

            case centiFaradId:
                result = value;
                break;

            case milliFaradId:
                result = value*10;
                break;

            case microFaradId:
                result = value*10000;
                break;

            case picoFaradId:
                result = value*1E10;
                break;

            case femtoFaradId:
                result = value*1E13;
                break;

            case attoFaradId:
                result = value*1E16;
                break;

            case coulombPerVoltId:
                result = value*0.01;
                break;
        }

        return result;
    }




    private double milliFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*0.001;
                break;

            case nanoFaradId:
                result = value*1000000;
                break;
            case exaFaradId:
                result = value*1E-21;
                break;
            case petaFaradId:
                result = value*1E-18;
                break;
            case teraFaradId:
                result = value*1E-15;
                break;

            case gigaFaradId:
                result = value*1E-12;
                break;
            case megaFaradId:
                result = value*1E-9;
                break;

            case kiloFaradId:
                result = value*0.000001;
                break;

            case centiFaradId:
                result = value*0.1;
                break;

            case milliFaradId:
                result = value;
                break;

            case microFaradId:
                result = value*1000;
                break;

            case picoFaradId:
                result = value*1000000000;
                break;

            case femtoFaradId:
                result = value*1E12;
                break;

            case attoFaradId:
                result = value*1E15;
                break;

            case coulombPerVoltId:
                result = value*0.001;
                break;
        }

        return result;
    }



    private double microFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*0.000001;
                break;

            case nanoFaradId:
                result = value*1000;
                break;
            case exaFaradId:
                result = value*1E-24;
                break;
            case petaFaradId:
                result = value*1E-21;
                break;
            case teraFaradId:
                result = value*1E-18;
                break;

            case gigaFaradId:
                result = value*1E-15;
                break;
            case megaFaradId:
                result = value*1E-12;
                break;

            case kiloFaradId:
                result = value*1E-9;
                break;

            case centiFaradId:
                result = value*0.0001;
                break;

            case milliFaradId:
                result = value*0.001;
                break;

            case microFaradId:
                result = value;
                break;

            case picoFaradId:
                result = value*1000000;
                break;

            case femtoFaradId:
                result = value*1000000000;
                break;

            case attoFaradId:
                result = value*1E12;
                break;

            case coulombPerVoltId:
                result = value*0.000001;
                break;
        }

        return result;
    }




    private double picoFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1E-12;
                break;

            case nanoFaradId:
                result = value*0.001;
                break;
            case exaFaradId:
                result = value*9.999999999E-31;
                break;
            case petaFaradId:
                result = value*1E-27;
                break;
            case teraFaradId:
                result = value*1E-24;
                break;

            case gigaFaradId:
                result = value*1E-21;
                break;
            case megaFaradId:
                result = value*1E-18;
                break;

            case kiloFaradId:
                result = value*1E-15;
                break;

            case centiFaradId:
                result = value*1E-10;
                break;

            case milliFaradId:
                result = value*1E-9;
                break;

            case microFaradId:
                result = value*0.000001;
                break;

            case picoFaradId:
                result = value;
                break;

            case femtoFaradId:
                result = value*1000;
                break;

            case attoFaradId:
                result = value*1000000;
                break;

            case coulombPerVoltId:
                result = value*1E-12;
                break;
        }

        return result;
    }




    private double femtoFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*1E-15;
                break;

            case nanoFaradId:
                result = value*0.000001;
                break;
            case exaFaradId:
                result = value*1E-33;
                break;
            case petaFaradId:
                result = value*1E-30;
                break;
            case teraFaradId:
                result = value*1E-27;
                break;

            case gigaFaradId:
                result = value*1E-24;
                break;
            case megaFaradId:
                result = value*1E-21;
                break;

            case kiloFaradId:
                result = value*1E-18;
                break;

            case centiFaradId:
                result = value*1E-13;
                break;

            case milliFaradId:
                result = value*1E-12;
                break;

            case microFaradId:
                result = value*1E-9;
                break;

            case picoFaradId:
                result = value*0.001;
                break;

            case femtoFaradId:
                result = value;
                break;

            case attoFaradId:
                result = value*1000;
                break;

            case coulombPerVoltId:
                result = value*1E-15;
                break;
        }

        return result;
    }




    private double attoFaradToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value*9.999999999E-19;
                break;

            case nanoFaradId:
                result = value*1E-9;
                break;
            case exaFaradId:
                result = value*1E-36;
                break;
            case petaFaradId:
                result = value*9.999999999E-34;
                break;
            case teraFaradId:
                result = value*9.999999999E-31;
                break;

            case gigaFaradId:
                result = value*1E-27;
                break;
            case megaFaradId:
                result = value*1E-24;
                break;

            case kiloFaradId:
                result = value*1E-21;
                break;

            case centiFaradId:
                result = value*1E-16;
                break;

            case milliFaradId:
                result = value*9.999999999E-16;
                break;

            case microFaradId:
                result = value*1E-12;
                break;

            case picoFaradId:
                result = value*0.000001;
                break;

            case femtoFaradId:
                result = value*0.001;
                break;

            case attoFaradId:
                result = value;
                break;

            case coulombPerVoltId:
                result = value*9.999999999E-19;
                break;
        }

        return result;
    }




    private double coulombPerVoltToOthers(String sourceUnit,String destUnit,double value){       //baki
        double result=0;
        switch (getUnitId(destUnit)){

            case faradId:
                result = value;
                break;

            case nanoFaradId:
                result = value*1000000000;
                break;
            case exaFaradId:
                result = value*1E-18;
                break;
            case petaFaradId:
                result = value*1E-15;
                break;
            case teraFaradId:
                result = value*1E-12;
                break;

            case gigaFaradId:
                result = value*1E-9;
                break;
            case megaFaradId:
                result = value*0.000001;
                break;

            case kiloFaradId:
                result = value*0.001;
                break;

            case centiFaradId:
                result = value*100;
                break;

            case milliFaradId:
                result = value*1000;
                break;

            case microFaradId:
                result = value*1000000;
                break;

            case picoFaradId:
                result = value*1E12;
                break;

            case femtoFaradId:
                result = value*1E15;
                break;

            case attoFaradId:
                result = value*1E18;
                break;

            case coulombPerVoltId:
                result = value;
                break;
        }

        return result;
    }



}
