package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

public class BitsBytesConverter {

    private final int BitsId = 1,BytesId = 2,KiloBitsId = 3,KiloBytesId = 4,MegaBitsId = 5,MegaBytesId = 6,
            GigaBitsId = 7,GigaBytesId = 8,TeraBitsId = 9,TeraBytesId = 10,PetaBitsId = 11,PetaBytesId = 12,
            ExaBitsId = 13,ExaBytesId = 14;


    private int getUnitId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Bits (b)")) {
            idValue = BitsId;

        } else if (unitName.equalsIgnoreCase("Bytes (B)")) {
            idValue = BytesId;

        } else if (unitName.equalsIgnoreCase("KiloBits (Kb)")) {
            idValue = KiloBitsId;

        } else if (unitName.equalsIgnoreCase("KiloBytes (KB)")) {
            idValue = KiloBytesId;

        } else if (unitName.equalsIgnoreCase("MegaBits (Mb)")) {
            idValue = MegaBitsId;

        } else if (unitName.equalsIgnoreCase("MegaBytes (MB)")) {
            idValue = MegaBytesId;

        } else if (unitName.equalsIgnoreCase("GigaBits (Gb)")) {
            idValue = GigaBitsId;

        } else if (unitName.equalsIgnoreCase("GigaBytes (GB)")) {
            idValue = GigaBytesId;

        } else if (unitName.equalsIgnoreCase("TeraBits (Tb)")) {
            idValue = TeraBitsId;

        } else if (unitName.equalsIgnoreCase("TeraBytes (TB)")) {
            idValue = TeraBytesId;
        } else if (unitName.equalsIgnoreCase("PetaBits (Pb)")) {
            idValue = PetaBitsId;

        } else if (unitName.equalsIgnoreCase("PetaBytes (PB)")) {
            idValue = PetaBytesId;
        } else if (unitName.equalsIgnoreCase("ExaBits (Eb)")) {
            idValue = ExaBitsId;

        } else if (unitName.equalsIgnoreCase("ExaBytes (EB)")) {
            idValue = ExaBytesId;
        }
        return idValue;
    }


    public double getBitsBytesConvertResult(String sourceUnit,String destUnit,double value ){

        double result=0;

        if (sourceUnit.equalsIgnoreCase("Bits (b)")){
            result = BitsToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("Bytes (B)")) {
            result = BytesToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("KiloBits (Kb)")) {
            result = KiloBitsToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("KiloBytes (KB)")) {
            result = KiloBytesToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MegaBits (Mb)")) {
            result = MegaBitsToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("MegaBytes (MB)")) {
            result = MegaBytesToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("GigaBits (Gb)")) {
            result = GigaBitsToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("GigaBytes (GB)")) {
            result = GigaBytesToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("TeraBits (Tb)")) {
            result = TeraBitsToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("TeraBytes (TB)")) {

            result = TeraBytesToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("PetaBits (Pb)")) {
            result = PetaBitsToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("PetaBytes (PB)")) {

            result = PetaBytesToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("ExaBits (Eb)")) {
            result = ExaBitsToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("ExaBytes (EB)")) {

            result = ExaBytesToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }




    private double BitsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value;
                break;

            case BytesId:
                result = value*0.125;
                break;
            case KiloBitsId:
                result = value*0.0009765625;
                break;
            case KiloBytesId:
                result = value*0.0001220703;
                break;
            case MegaBitsId:
                result = value*9.536743164E-7;
                break;

            case MegaBytesId:
                result = value*1.192092895E-7;
                break;
            case GigaBitsId:
                result = value*9.313225746E-10;
                break;

            case GigaBytesId:
                result = value*1.164153218E-10;
                break;

            case TeraBitsId:
                result = value*9.094947017E-13;
                break;

            case TeraBytesId:
                result = value*1.136868377E-13;
                break;

            case PetaBitsId:
                result = value*8.881784197E-16;
                break;

            case PetaBytesId:
                result = value*1.110223024E-16;
                break;

            case ExaBitsId:
                result = value*8.673617379E-19;
                break;

            case ExaBytesId:
                result = value*1.084202172E-19;
                break;

        }

        return result;
    }



    private double BytesToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*8;
                break;

            case BytesId:
                result = value;
                break;
            case KiloBitsId:
                result = value*0.0078125;
                break;
            case KiloBytesId:
                result = value*0.0009765625;
                break;
            case MegaBitsId:
                result = value*0.0000076294;
                break;

            case MegaBytesId:
                result = value*9.536743164E-7;
                break;
            case GigaBitsId:
                result = value*7.450580596E-9;
                break;

            case GigaBytesId:
                result = value*9.313225746E-10;
                break;

            case TeraBitsId:
                result = value*7.275957614E-12;
                break;

            case TeraBytesId:
                result = value*9.094947017E-13;
                break;

            case PetaBitsId:
                result = value*7.105427357E-15;
                break;

            case PetaBytesId:
                result = value*8.881784197E-16;
                break;

            case ExaBitsId:
                result = value*6.938893903E-18;
                break;

            case ExaBytesId:
                result = value*8.673617379E-19;
                break;

        }

        return result;
    }




    private double KiloBitsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*1024;
                break;

            case BytesId:
                result = value*128;
                break;
            case KiloBitsId:
                result = value;
                break;
            case KiloBytesId:
                result = value*0.125;
                break;
            case MegaBitsId:
                result = value*0.0009765625;
                break;

            case MegaBytesId:
                result = value*0.0001220703;
                break;
            case GigaBitsId:
                result = value*9.536743164E-7;
                break;

            case GigaBytesId:
                result = value*1.192092895E-7;
                break;

            case TeraBitsId:
                result = value*9.313225746E-10;
                break;

            case TeraBytesId:
                result = value*1.164153218E-10;
                break;

            case PetaBitsId:
                result = value*9.094947017E-13;
                break;

            case PetaBytesId:
                result = value*1.136868377E-13;
                break;

            case ExaBitsId:
                result = value*8.881784197E-16;
                break;

            case ExaBytesId:
                result = value*1.110223024E-16;
                break;

        }

        return result;
    }



    private double KiloBytesToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*8192;
                break;

            case BytesId:
                result = value*1024;
                break;
            case KiloBitsId:
                result = value*8;
                break;
            case KiloBytesId:
                result = value;
                break;
            case MegaBitsId:
                result = value*0.0078125;
                break;

            case MegaBytesId:
                result = value*0.0009765625;
                break;
            case GigaBitsId:
                result = value*0.0000076294;
                break;

            case GigaBytesId:
                result = value*9.536743164E-7;
                break;

            case TeraBitsId:
                result = value*7.450580596E-9;
                break;

            case TeraBytesId:
                result = value*9.313225746E-10;
                break;

            case PetaBitsId:
                result = value*7.275957614E-12;
                break;

            case PetaBytesId:
                result = value*9.094947017E-13;
                break;

            case ExaBitsId:
                result = value*7.105427357E-15;
                break;

            case ExaBytesId:
                result = value*8.881784197E-16;
                break;

        }

        return result;
    }




    private double MegaBitsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*1048576;
                break;

            case BytesId:
                result = value*131072;
                break;
            case KiloBitsId:
                result = value*1024;
                break;
            case KiloBytesId:
                result = value*128;
                break;
            case MegaBitsId:
                result = value;
                break;

            case MegaBytesId:
                result = value*0.125;
                break;
            case GigaBitsId:
                result = value*0.0009765625;
                break;

            case GigaBytesId:
                result = value*0.0001220703;
                break;

            case TeraBitsId:
                result = value*9.536743164E-7;
                break;

            case TeraBytesId:
                result = value*1.192092895E-7;
                break;

            case PetaBitsId:
                result = value*9.313225746E-10;
                break;

            case PetaBytesId:
                result = value*1.164153218E-10;
                break;

            case ExaBitsId:
                result = value*9.094947017E-13;
                break;

            case ExaBytesId:
                result = value*1.136868377E-13;
                break;

        }

        return result;
    }



    private double MegaBytesToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*8388608;
                break;

            case BytesId:
                result = value*1048576;
                break;
            case KiloBitsId:
                result = value*8192;
                break;
            case KiloBytesId:
                result = value*1024;
                break;
            case MegaBitsId:
                result = value*8;
                break;

            case MegaBytesId:
                result = value;
                break;
            case GigaBitsId:
                result = value*0.0078125;
                break;

            case GigaBytesId:
                result = value*0.0009765625;
                break;

            case TeraBitsId:
                result = value*0.0000076294;
                break;

            case TeraBytesId:
                result = value*9.536743164E-7;
                break;

            case PetaBitsId:
                result = value*7.450580596E-9;
                break;

            case PetaBytesId:
                result = value*9.313225746E-10;
                break;

            case ExaBitsId:
                result = value*7.275957614E-12;
                break;

            case ExaBytesId:
                result = value*9.094947017E-13;
                break;

        }

        return result;
    }



    private double GigaBitsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*1073741824;
                break;

            case BytesId:
                result = value*134217728;
                break;
            case KiloBitsId:
                result = value*1048576;
                break;
            case KiloBytesId:
                result = value*131072;
                break;
            case MegaBitsId:
                result = value*1024;
                break;

            case MegaBytesId:
                result = value*128;
                break;
            case GigaBitsId:
                result = value;
                break;

            case GigaBytesId:
                result = value*0.125;
                break;

            case TeraBitsId:
                result = value*0.0009765625;
                break;

            case TeraBytesId:
                result = value*0.0001220703;
                break;

            case PetaBitsId:
                result = value*9.536743164E-7;
                break;

            case PetaBytesId:
                result = value*1.192092895E-7;
                break;

            case ExaBitsId:
                result = value*9.313225746E-10;
                break;

            case ExaBytesId:
                result = value*1.164153218E-10;
                break;

        }

        return result;
    }



    private double GigaBytesToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*8.589934592E9;
                break;

            case BytesId:
                result = value*1.073741824E9;
                break;
            case KiloBitsId:
                result = value*8388608;
                break;
            case KiloBytesId:
                result = value*1048576;
                break;
            case MegaBitsId:
                result = value*8192;
                break;

            case MegaBytesId:
                result = value*1024;
                break;
            case GigaBitsId:
                result = value*8;
                break;

            case GigaBytesId:
                result = value;
                break;

            case TeraBitsId:
                result = value*0.0078125;
                break;

            case TeraBytesId:
                result = value*0.0009765625;
                break;

            case PetaBitsId:
                result = value*0.0000076294;
                break;

            case PetaBytesId:
                result = value*9.536743164E-7;
                break;

            case ExaBitsId:
                result = value*7.450580596E-9;
                break;

            case ExaBytesId:
                result = value*9.313225746E-10;
                break;

        }

        return result;
    }



    private double TeraBitsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*1.099511627776E12;
                break;

            case BytesId:
                result = value*1.37438953472E11;
                break;
            case KiloBitsId:
                result = value*1.073741824E9;
                break;
            case KiloBytesId:
                result = value*134217728;
                break;
            case MegaBitsId:
                result = value*1048576;
                break;

            case MegaBytesId:
                result = value*131072;
                break;
            case GigaBitsId:
                result = value*1024;
                break;

            case GigaBytesId:
                result = value*128;
                break;

            case TeraBitsId:
                result = value;
                break;

            case TeraBytesId:
                result = value*0.125;
                break;

            case PetaBitsId:
                result = value*0.0009765625;
                break;

            case PetaBytesId:
                result = value*0.0001220703;
                break;

            case ExaBitsId:
                result = value*9.536743164E-7;
                break;

            case ExaBytesId:
                result = value*1.192092895E-7;
                break;

        }

        return result;
    }



    private double TeraBytesToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*8.796093022208E12;
                break;

            case BytesId:
                result = value*1.099511627776E12;
                break;
            case KiloBitsId:
                result = value*8.589934592E9;
                break;
            case KiloBytesId:
                result = value*1073741824;
                break;
            case MegaBitsId:
                result = value*8388608;
                break;

            case MegaBytesId:
                result = value*1048576;
                break;
            case GigaBitsId:
                result = value*8192;
                break;

            case GigaBytesId:
                result = value*1024;
                break;

            case TeraBitsId:
                result = value*8;
                break;

            case TeraBytesId:
                result = value;
                break;

            case PetaBitsId:
                result = value*0.0078125;
                break;

            case PetaBytesId:
                result = value*0.0009765625;
                break;

            case ExaBitsId:
                result = value*0.0000076294;
                break;

            case ExaBytesId:
                result = value*9.536743164E-7;
                break;

        }

        return result;
    }



    private double PetaBitsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*1.125899906842631E15;
                break;

            case BytesId:
                result = value*1.40737488355329E14;
                break;
            case KiloBitsId:
                result = value*1.099511627776E12;
                break;
            case KiloBytesId:
                result = value*1.37438953472E11;
                break;
            case MegaBitsId:
                result = value*1073741824;
                break;

            case MegaBytesId:
                result = value*134217728;
                break;
            case GigaBitsId:
                result = value*1048576;
                break;

            case GigaBytesId:
                result = value*131072;
                break;

            case TeraBitsId:
                result = value*1024;
                break;

            case TeraBytesId:
                result = value*128;
                break;

            case PetaBitsId:
                result = value;
                break;

            case PetaBytesId:
                result = value*0.125;
                break;

            case ExaBitsId:
                result = value*0.0009765625;
                break;

            case ExaBytesId:
                result = value*0.0001220703;
                break;

        }

        return result;
    }


    private double PetaBytesToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*9.007199254740640E15;
                break;

            case BytesId:
                result = value*1.125899906842580E15;
                break;
            case KiloBitsId:
                result = value*8.796093022208E12;
                break;
            case KiloBytesId:
                result = value*1.099511627776E12;
                break;
            case MegaBitsId:
                result = value*8.589934592E9;
                break;

            case MegaBytesId:
                result = value*1073741824;
                break;
            case GigaBitsId:
                result = value*8388608;
                break;

            case GigaBytesId:
                result = value*1048576;
                break;

            case TeraBitsId:
                result = value*8192;
                break;

            case TeraBytesId:
                result = value*1024;
                break;

            case PetaBitsId:
                result = value*8;
                break;

            case PetaBytesId:
                result = value;
                break;

            case ExaBitsId:
                result = value*0.0078125;
                break;

            case ExaBytesId:
                result = value*0.0009765625;
                break;

        }

        return result;
    }


    private double ExaBitsToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*11.52921504606851600E17;
                break;

            case BytesId:
                result = value*14.4115188075856450E16;
                break;
            case KiloBitsId:
                result = value*11.25899906842629E14;
                break;
            case KiloBytesId:
                result = value*14.0737488355329E13;
                break;
            case MegaBitsId:
                result = value*10.99511627776E11;
                break;

            case MegaBytesId:
                result = value*13.7438953472E10;
                break;
            case GigaBitsId:
                result = value*1073741824;
                break;

            case GigaBytesId:
                result = value*134217728;
                break;

            case TeraBitsId:
                result = value*1048576;
                break;

            case TeraBytesId:
                result = value*131072;
                break;

            case PetaBitsId:
                result = value*1024;
                break;

            case PetaBytesId:
                result = value*128;
                break;

            case ExaBitsId:
                result = value;
                break;

            case ExaBytesId:
                result = value*0.125;
                break;

        }

        return result;
    }



    private double ExaBytesToOthers(String sourceUnit,String destUnit,double value){
        double result=0;
        switch (getUnitId(destUnit)){

            case BitsId:
                result = value*9.223372036854813E18;
                break;

            case BytesId:
                result = value*11.529215046068516E17;
                break;
            case KiloBitsId:
                result = value*9.007199254741028E15;
                break;
            case KiloBytesId:
                result = value*11.25899906842629E14;
                break;
            case MegaBitsId:
                result = value*8.796093022208E12;
                break;

            case MegaBytesId:
                result = value*10.99511627776E11;
                break;
            case GigaBitsId:
                result = value*8.589934592E9;
                break;

            case GigaBytesId:
                result = value*1073741824;
                break;

            case TeraBitsId:
                result = value*8388608;
                break;

            case TeraBytesId:
                result = value*1048576;
                break;

            case PetaBitsId:
                result = value*8192;
                break;

            case PetaBytesId:
                result = value*1024;
                break;

            case ExaBitsId:
                result = value*8;
                break;

            case ExaBytesId:
                result = value;
                break;

        }

        return result;
    }



}
