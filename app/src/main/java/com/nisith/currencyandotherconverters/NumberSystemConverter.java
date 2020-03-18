package com.nisith.currencyandotherconverters;

import java.util.ArrayList;

public class NumberSystemConverter {

    private final int decimalId = 1,binaryId = 2,octalId = 3,hexaDecimalId = 4;

    private int getId(String unitName) {
        int idValue = 0;
        if (unitName.equalsIgnoreCase("Binary")) {
            idValue = binaryId;

        } else if (unitName.equalsIgnoreCase("Decimal")) {
            idValue = decimalId;

        } else if (unitName.equalsIgnoreCase("Octal")) {
            idValue = octalId;

        } else if (unitName.equalsIgnoreCase("HexaDecimal")) {
            idValue = hexaDecimalId;

        }
        return idValue;


    }

    public String getNumberSystemConvertResult(String sourceUnit,String destUnit,String value ){

        String result="";

        if (sourceUnit.equalsIgnoreCase("Binary")){
            result = binaryToOthers(sourceUnit,destUnit,value);
        } else if (sourceUnit.equalsIgnoreCase("Decimal")) {
            result = decimalToOthers(sourceUnit,destUnit,value);

        } else if (sourceUnit.equalsIgnoreCase("Octal")) {
            result = octalToOthers(sourceUnit,destUnit,value);

        }  else if (sourceUnit.equalsIgnoreCase("HexaDecimal")) {
            result = hexaDecimalToOthers(sourceUnit,destUnit,value);

        }

        return result;

    }



    private String binaryToOthers(String sourceUnit,String destUnit,String value){
        String result="";
        switch (getId(destUnit)){

            case binaryId:
                result = value;
                break;

            case decimalId:
                //Maximum digits before point no Limit
                //Maximum digits after point no Limit
                result = binaryToDecimal( value);
                break;
            case octalId:
                //Maximum digits no Limit
                result = binaryToOctal(value);
                break;
            case hexaDecimalId:
                //Maximum digits no Limits
                result = binaryToHexaDecimal(value);
                break;
        }

        return result;
    }


    private String decimalToOthers(String sourceUnit,String destUnit,String value){
        String result="";
        switch (getId(destUnit)){

            case binaryId:
                //Maximum 18 digits possible before point
                //Maximum digits after point has no Limit
                result = decimalToBinary(value);
                break;

            case decimalId:
                result = value;
                break;
            case octalId:
                //Maximum 18 digits possible before point
                //Maximum digits after point has no Limit
                result = decimalToOctal(value);
                break;
            case hexaDecimalId:
                //Maximum 18 digits possible before point
                //Maximum digits after point has no Limit
                result = decimalToHexaDecimal(value);
                break;
        }

        return result;
    }



    private String octalToOthers(String sourceUnit,String destUnit,String value){
        String result="";
        switch (getId(destUnit)){

            case binaryId:
                //no digits limit before point
                //no digits limit after point
                result = octalToBinary(value);
                break;

            case decimalId:
                //Maximum digits is no Limit before point
                //Maximum digits is no Limit after point
                result = octalToDecimal(value);
                break;
            case octalId:
                result = value;
                break;
            case hexaDecimalId:
                //Maximum digits is no Limit before point
                //Maximum digits is no Limit after point
                result = octalToHexaDecimal(value);
                break;
        }

        return result;
    }


    private String hexaDecimalToOthers(String sourceUnit,String destUnit,String value){
        String result="";
        switch (getId(destUnit)){

            case binaryId:
                //Maximum Digits no Limit
                result = hexaDecimalToBinary(value);
                break;

            case decimalId:
                //Maximum Digits no Limit
                result = hexaDecimalToDecimal(value);
                break;
            case octalId:
                //Maximum digits no Limit
                result = hexaDecimalToOctal(value);
                break;
            case hexaDecimalId:
                result = value;
                break;
        }

        return result;
    }




////////////////////////////////////////////////////////
    private String hexaDecimalToDecimal(String hexaDecimalNumber){
        //Maximum digits no Limit
        return binaryToDecimal(hexaDecimalToBinary(hexaDecimalNumber));
    }


///////////////////////////////////////////////////////////


    private String hexaDecimalToOctal(String hexaDecimalNumber){
        //Maximum digits no Limit
        return binaryToOctal(hexaDecimalToBinary(hexaDecimalNumber));
    }



   /////////////////////////////////////////////////////

    private String hexaDecimalToBinary(String hexaDecimalNumber){

        //Maximum digits is possible before Point no Limit
        //Maximum digits is possible after point no Limit
        //This method convert Octal number to Decimal number

        String digitsBeforePoint,digitsAfterPoint;
        String resultBeforePointDigits="",resultAfterPointDigits = "";
        String result;
        if (hexaDecimalNumber.contains(".")){
            if(hexaDecimalNumber.indexOf(".") == hexaDecimalNumber.length()-1){
                // This is because if user enter numbers like 1111. then this will add 0 at after point i.e. 1111.0  . Otherwise it will create an Exception in the following code
                hexaDecimalNumber = hexaDecimalNumber + "0";
            }else if (hexaDecimalNumber.indexOf(".") == 0){
                // This is because if user enter numbers like .1111 , then this will add 0 at before point i.e. 0.1111  . Otherwise it will create an Exception in the following code
                hexaDecimalNumber = "0" + hexaDecimalNumber;
            }
            digitsBeforePoint = hexaDecimalNumber.substring(0,hexaDecimalNumber.indexOf("."));
            digitsAfterPoint = hexaDecimalNumber.substring(hexaDecimalNumber.indexOf(".")+1);

        }else {
            digitsBeforePoint = hexaDecimalNumber;
            digitsAfterPoint = "0";
        }

        resultBeforePointDigits = hexaDecimalToBinaryBeforePoint(digitsBeforePoint);
        if (!digitsAfterPoint.equals("0")){
            resultAfterPointDigits = hexaDecimalToBinaryAfterPoint(digitsAfterPoint);
        }

        result = resultBeforePointDigits + resultAfterPointDigits;
        return result;


    }





   ///////////////////////////////////////

    private String hexaDecimalToBinaryBeforePoint(String hexaDecimalNumber){

        //Digits before point has no Limit

        String result = "";
        int index ,digit;
        for ( index = 0; index <hexaDecimalNumber.length() ; index++) {
            digit = hexaDecimalDigitToNormalNumber(String.valueOf(hexaDecimalNumber.charAt(index)));
            if (digit == 0){
                result = result +"0000";//For Hex number base is 4. That's why four 0 .
            }else if (digit == 1){
                result = result+ "000"+Integer.toBinaryString(digit);
            }else if(digit == 2){
                result = result+ "00"+Integer.toBinaryString(digit);
            }else if (digit == 3){
                result = result+ "00"+Integer.toBinaryString(digit);
            }else if (digit == 4){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else if (digit == 5){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else if (digit == 6){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else if (digit == 7){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else {
                result = result + Integer.toBinaryString(digit);
            }

        }
        return result;

    }



   //////////////////////////////////////
    private String hexaDecimalToBinaryAfterPoint(String hexaDecimalNumber){
        //This method convert hexaDecimal Number to binary Number
        //Digits after Point is no Limit

        String result = ".";
        int index ,digit;
        for ( index = 0; index <hexaDecimalNumber.length() ; index++) {
            digit = hexaDecimalDigitToNormalNumber(String.valueOf(hexaDecimalNumber.charAt(index)));
            if (digit == 0){
                result = result +"0000";//For Hex number base is 4. That's why four 0 .
            }else if (digit == 1){
                result = result+ "000"+Integer.toBinaryString(digit);
            }else if(digit == 2){
                result = result+ "00"+Integer.toBinaryString(digit);
            }else if (digit == 3){
                result = result+ "00"+Integer.toBinaryString(digit);
            }else if (digit == 4){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else if (digit == 5){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else if (digit == 6){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else if (digit == 7){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else {
                result = result + Integer.toBinaryString(digit);
            }
        }
        return result;
    }





    /////////////////////////////////////////////

    private int hexaDecimalDigitToNormalNumber(String character){
        int digit;

        character = character.toUpperCase();
        switch (character){
            case "A":
                digit = 10;
                break;
            case "B":
                digit = 11;
                break;
            case "C":
                digit = 12;
                break;
            case "D":
                digit = 13;
                break;
            case "E":
                digit = 14;
                break;
            case "F":
                digit = 15;
                break;
            default:
                digit = Integer.parseInt( character);
        }
        return digit;

    }

    /////////////////////////////////
    private String octalToHexaDecimal(String octalNumber){
        //This method convert Octal number to HexaDecimal number
        //Maximum digits before point is no limit
        //Maximum digits after point is no limit
        return binaryToHexaDecimal(octalToBinary(octalNumber));
    }







//////////////////////////////////////////////////////

    private String octalToBinary(String octalNumber){

        //This method convert Octal number to Binary number

        String digitsBeforePoint,digitsAfterPoint;
        String resultBeforePointDigits="",resultAfterPointDigits = "";
        String result = "";
        if (octalNumber.contains(".")){
            if(octalNumber.indexOf(".") == octalNumber.length()-1){
                // This is because if user enter numbers like 1111. then this will add 0 at after point i.e. 1111.0  . Otherwise it will create an Exception in the following code
                octalNumber = octalNumber + "0";
            }else if (octalNumber.indexOf(".") == 0){
                // This is because if user enter numbers like .1111 , then this will add 0 at before point i.e. 0.1111  . Otherwise it will create an Exception in the following code
                octalNumber = "0" + octalNumber;
            }
            digitsBeforePoint = octalNumber.substring(0,octalNumber.indexOf("."));
            digitsAfterPoint = octalNumber.substring(octalNumber.indexOf(".")+1);

        }else {
            digitsBeforePoint = octalNumber;
            digitsAfterPoint = "0";
        }

        resultBeforePointDigits = octalToBinaryBeforePoint(digitsBeforePoint);
        if (!digitsAfterPoint.equals("0")){
            resultAfterPointDigits = octalToBinaryAfterPoint(digitsAfterPoint);
        }

        result = resultBeforePointDigits + resultAfterPointDigits;
        return result;


    }




    /////////////////////////////////////////

    private static String octalToBinaryBeforePoint(String octalNumber){
        //Maximum digits no Limit

        String result = "";
        int index ,digit;
        for ( index = 0; index <octalNumber.length() ; index++) {
            digit = Integer.parseInt(String.valueOf(octalNumber.charAt(index)));
            if (digit == 0){
                result = result +"000";//for octal number base is 3. That's why three 0 .
            }else if (digit == 1){
                result = result+ "00"+Integer.toBinaryString(digit);
            }else if(digit == 2){
                result = result+ "0"+Integer.toBinaryString(digit);

            }else if (digit == 3){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else {
                result = result + Integer.toBinaryString(digit);
            }

        }
        return result;
    }


    ///////////////////////////////////

    private String octalToBinaryAfterPoint(String octalNumber){
        //Maximum digits no Limit

        String result = ".";
        int index ,digit;
        for ( index = 0; index <octalNumber.length() ; index++) {
            digit = Integer.parseInt(String.valueOf(octalNumber.charAt(index)));
            if (digit == 0){
                result = result +"000";//for octal number base is 3. That's why three 0 .
            }else if (digit == 1){
                result = result+ "00"+Integer.toBinaryString(digit);
            }else if(digit == 2){
                result = result+ "0"+Integer.toBinaryString(digit);

            }else if (digit == 3){
                result = result+ "0"+Integer.toBinaryString(digit);
            }else {
                result = result + Integer.toBinaryString(digit);
            }

        }
        return result;
    }

//////////////////////////////////////////////

    private String octalToDecimal(String octalNumber){
        //Maximum digits is no Limit before point
        //Maximum digits is no Limit after point
        //This method convert Octal number to Decimal number

        String digitsBeforePoint,digitsAfterPoint;
        String resultBeforePointDigits="",resultAfterPointDigits = "";
        String result = "";
        if (octalNumber.contains(".")){
            if(octalNumber.indexOf(".") == octalNumber.length()-1){
                // This is because if user enter numbers like 1111. then this will add 0 at after point i.e. 1111.0  . Otherwise it will create an Exception in the following code
                octalNumber = octalNumber + "0";
            }else if (octalNumber.indexOf(".") == 0){
                // This is because if user enter numbers like .1111 , then this will add 0 at before point i.e. 0.1111  . Otherwise it will create an Exception in the following code
                octalNumber = "0" + octalNumber;
            }
            digitsBeforePoint = octalNumber.substring(0,octalNumber.indexOf("."));
            digitsAfterPoint = octalNumber.substring(octalNumber.indexOf(".")+1);

        }else {
            digitsBeforePoint = octalNumber;
            digitsAfterPoint = "0";
        }

        resultBeforePointDigits = octalToDecimalBeforePoint(digitsBeforePoint);
        if (!digitsAfterPoint.equals("0")){
            resultAfterPointDigits = octalToDecimalAfterPoint(digitsAfterPoint);
        }

        result = resultBeforePointDigits + resultAfterPointDigits;
        return result;

    }



    ////////////////////////////////





    private String octalToDecimalBeforePoint(String octalNumber){
        //Maximum digits is no Limit
        String result;
        int power ,digit,index;
        double sum = 0;
        power = octalNumber.length()-1;
        for(index = 0; index<octalNumber.length(); index++){
            digit = Integer.parseInt(String.valueOf(octalNumber.charAt(index)));
            sum = sum + digit*Math.pow(8,power);
            System.out.println("Sum "+index+" = "+sum);
            power --;
        }
        result = String.valueOf(sum);
        return result;
    }


    ////////////////////////////////////
    private String octalToDecimalAfterPoint(String octalNumber){
        //Maximum digits is no Limit
        String result;
        int power = 1 ,digit,index;
        double sum = 0;
        for(index = 0; index<octalNumber.length(); index++){
            digit = Integer.parseInt(String.valueOf(octalNumber.charAt(index)));
            sum = sum + digit*Math.pow(8,-power);
            power ++;
        }
        result = String.valueOf(sum);
        result = result.substring(1);//to remove 0 from like 0.123 .this gives only .123 not 0.123
        return result;

    }





    //////////////////////////
    private String decimalToHexaDecimal(String decimalNumber){
        //This method convert decimal number to HexaDecimal number

        String result;
        String binaryResult = decimalToBinary(decimalNumber);
        result = binaryToHexaDecimal(binaryResult);
        return result;
    }

    /////////////////

    private String decimalToOctal(String decimalNumber){

        //This method converts Decimal number to Octal Number
        String result;
        String binaryResult = decimalToBinary(decimalNumber);
        result = binaryToOctal(binaryResult);
        return result;

    }




    /////////////////////////

    private String binaryToOctal(String binaryNumber){

        //Maximum digits no Limit
        //This method convert binary number to Octal number

        String digitsBeforePoint,digitsAfterPoint;
        String resultBeforePointDigits = "", resultAfterPointDigits = "";
        String result = "";
        if (binaryNumber.contains(".")){
            if(binaryNumber.indexOf(".") == binaryNumber.length()-1){
                // This is because if user enter numbers like 1111. then this will add 0 at after point i.e. 1111.0  . Otherwise it will create an Exception in the following code
                binaryNumber = binaryNumber + "0";
            }else if (binaryNumber.indexOf(".") == 0){
                // This is because if user enter numbers like .1111 , then this will add 0 at before point i.e. 0.1111  . Otherwise it will create an Exception in the following code
                binaryNumber = "0" + binaryNumber;
            }
            digitsBeforePoint = binaryNumber.substring(0,binaryNumber.indexOf("."));
            digitsAfterPoint = binaryNumber.substring(binaryNumber.indexOf(".")+1);

        }else {
            digitsBeforePoint = binaryNumber;
            digitsAfterPoint = "0";
        }
        //To add 0 before digitBeforePoint number
        if (digitsBeforePoint.length()%3==1){
            //For octal number the base is 3.
            digitsBeforePoint ="00" + digitsBeforePoint;
        }else if (digitsBeforePoint.length()%3 == 2){
            digitsBeforePoint ="0" +  digitsBeforePoint;
        }
        resultBeforePointDigits = binaryToOctalBeforePoint(digitsBeforePoint);

        if (!digitsAfterPoint.equals("0")) {
            //Check if there is any point present in the user input
            if (digitsAfterPoint.length()%3==1){
                //For octal number the base is 3.
                digitsAfterPoint = digitsAfterPoint+"00";
            }else if (digitsAfterPoint.length()%3 == 2){
                digitsAfterPoint = digitsAfterPoint+"0";
            }
            resultAfterPointDigits = binaryToOctalAfterPoint(digitsAfterPoint);
        }
        result = resultBeforePointDigits + resultAfterPointDigits;

        return result;
    }
    ////////////////





    private String binaryToHexaDecimal(String binaryNumber){

        //Maximum digits no Limits
        //This method convert binary number to hex number
        String digitsBeforePoint,digitsAfterPoint;
        String result, resultBeforePointDigits = "", resultAfterPointDigits = "";
        if (binaryNumber.contains(".")){
            if(binaryNumber.indexOf(".") == binaryNumber.length()-1){
                // This is because if user enter numbers like 1111. then this will add 0 at after point i.e. 1111.0  . Otherwise it will create an Exception in the following code
                binaryNumber = binaryNumber + "0";
            }else if (binaryNumber.indexOf(".") == 0){
                // This is because if user enter numbers like .1111 , then this will add 0 at before point i.e. 0.1111  . Otherwise it will create an Exception in the following code
                binaryNumber = "0" + binaryNumber;
            }
            digitsBeforePoint = binaryNumber.substring(0,binaryNumber.indexOf("."));
            digitsAfterPoint = binaryNumber.substring(binaryNumber.indexOf(".")+1);

        }else {
            digitsBeforePoint = binaryNumber;
            digitsAfterPoint = "0";
        }

        if (digitsBeforePoint.length()%4==1){
            //For octal number the base is 4.
            digitsBeforePoint ="000" + digitsBeforePoint;
        }else if (digitsBeforePoint.length()%4 == 2){
            digitsBeforePoint ="00" + digitsBeforePoint;
        }else if (digitsBeforePoint.length()%4 == 3){
            digitsBeforePoint ="0" + digitsBeforePoint;
        }
        resultBeforePointDigits =  binaryToHexaDecimalBeforePoint(digitsBeforePoint);

        if (!digitsAfterPoint.equals("0")) {
            //Check if there is any point present in the user input
            if (digitsAfterPoint.length()%4==1){
                //For octal number the base is 4.
                digitsAfterPoint = digitsAfterPoint+"000";
            }else if (digitsAfterPoint.length()%4 == 2){
                digitsAfterPoint = digitsAfterPoint+"00";
            }else if (digitsAfterPoint.length()%4 == 3){
                digitsAfterPoint = digitsAfterPoint + "0";
            }
            resultAfterPointDigits = binaryToHexaDecimalAfterPoint(digitsAfterPoint);

        }
        result = resultBeforePointDigits + resultAfterPointDigits;

        return result.toUpperCase();
    }







    //////////////////////////////////////////
    private  String binaryToDecimal(String binaryNumber){
        //This method convert binary number to decimal number
        //Maximum digits is no Limit
        String digitsBeforePoint,digitsAfterPoint;
        String result , beforePointResult="0",afterPointResult="0";
        if (binaryNumber.contains(".")){
            if(binaryNumber.indexOf(".") == binaryNumber.length()-1){
                // This is because if user enter numbers like 1111. then this will add 0 at after point i.e. 1111.0  . Otherwise it will create an Exception in the following code
                binaryNumber = binaryNumber + "0";
            }else if (binaryNumber.indexOf(".") == 0){
                // This is because if user enter numbers like .1111 , then this will add 0 at before point i.e. 0.1111  . Otherwise it will create an Exception in the following code
                binaryNumber = "0" + binaryNumber;
            }
            digitsBeforePoint = binaryNumber.substring(0,binaryNumber.indexOf("."));
            digitsAfterPoint = binaryNumber.substring(binaryNumber.indexOf(".")+1);

        }else {
            digitsBeforePoint = binaryNumber;
            digitsAfterPoint = "0";
        }

        beforePointResult = binaryToDecimalBeforePoint(digitsBeforePoint);
        if (!digitsAfterPoint.equals("0")) {
            afterPointResult = binaryToDecimalAfterPoint(digitsAfterPoint);
        }
        result =String.valueOf( Double.parseDouble(beforePointResult) + Double.parseDouble(afterPointResult));
        return result;


    }







    //////////////////////////////////////

    private String binaryToDecimalBeforePoint(String binaryNumber){
        //This method convert Octal number to Decimal Number
        //Maximum digits is no Limit
        String result;
        int power ,digit,index;
        double sum = 0;
        power = binaryNumber.length()-1;
        for(index = 0; index<binaryNumber.length(); index++){
            digit = Integer.parseInt(String.valueOf(binaryNumber.charAt(index)));
            sum = sum + digit*Math.pow(2,power);
            power --;
        }
        result = String.valueOf(sum);
        return result;

    }

    //////////////////////////////////////////////
    private String binaryToDecimalAfterPoint(String binaryNumber){
        //Maximum digits is no Limit
        String result;
        int power = 1 ,digit,index;
        double sum = 0;
        for(index = 0; index<binaryNumber.length(); index++){
            digit = Integer.parseInt(String.valueOf(binaryNumber.charAt(index)));
            sum = sum + digit*Math.pow(2,-power);
            power ++;
        }
        result = String.valueOf(sum);
        result = result.substring(1);//to remove 0 from like 0.123 .this gives only .123 not 0.123
        return result;

    }


///////////////////////////////////////////////////////////////

    private String decimalToBinary(String decimalNumber){
        //Maximum 18 digits possible before point
        //Maximum digits after point has no Limit
        //This method convert decimal number to binary number
        String digitsBeforePoint,digitsAfterPoint;
        String resultBeforePointDigits="",resultAfterPointDigits = "";
        String result = "";
        if (decimalNumber.contains(".")){
            if(decimalNumber.indexOf(".") == decimalNumber.length()-1){
                // This is because if user enter numbers like 1111. then this will add 0 at after point i.e. 1111.0  . Otherwise it will create an Exception in the following code
                decimalNumber = decimalNumber + "0";
            }else if (decimalNumber.indexOf(".") == 0){
                // This is because if user enter numbers like .1111 , then this will add 0 at before point i.e. 0.1111  . Otherwise it will create an Exception in the following code
                decimalNumber = "0" + decimalNumber;
            }
            digitsBeforePoint = decimalNumber.substring(0,decimalNumber.indexOf("."));
            digitsAfterPoint = decimalNumber.substring(decimalNumber.indexOf("."));

        }else {
            digitsBeforePoint = decimalNumber;
            digitsAfterPoint = "0";
        }

        resultBeforePointDigits = decimalToBinaryBeforePoint(digitsBeforePoint);
        if (!digitsAfterPoint.equals("0")){
            resultAfterPointDigits = decimalToBinaryAfterPoint(digitsAfterPoint);
        }

        result = resultBeforePointDigits + resultAfterPointDigits;
        return result;

    }




    /////////////////////////////////////////////


    private String decimalToBinaryBeforePoint(String decimalNumber){
        //Maximum 18 digits possible before point
        String result = "";
        long number = Long.parseLong(decimalNumber),reminder;

        while (number != 0){

            reminder = number % 2;
            result = reminder + result;
            number = number/2;
        }
        return result;
    }









/////////////////////////////////////////////////////


    private String decimalToBinaryAfterPoint(String decimalNumber){
        String result = ".";
        int round = 0,carry;
        final int max_round = 25;
        double number = Double.parseDouble(decimalNumber);
        boolean flag = true;
        ArrayList<String> arrayList = new ArrayList<>();
        while (flag){
            arrayList.add(String.valueOf(number));
            if (number == 0.0){
                break;
            }
            number = number*2;
            if (number >= 1){
                number = number-1;
                carry = 1;
            }else {
                carry = 0;
            }
            if (arrayList.contains(String.valueOf(number))){
                break;
            }
            result = result+carry;
            if (round == max_round){
                break;
            }else {
                round++;
            }
        }

        return result;

    }




  /////////////////////////////////


    private String binaryToOctalBeforePoint(String binaryNumber){
        //Maximum digits no Limit
        String result = "",threeDigits;
        int statr_index , end_index;
        final int base = 3;
        statr_index = binaryNumber.length() - base;
        end_index = binaryNumber.length();

        int round = 0;
        final int max_round = binaryNumber.length()/3;
        while (round < max_round) {
            threeDigits = binaryNumber.substring(statr_index, end_index);
            result = Integer.toOctalString(Integer.parseInt(threeDigits,2)) + result;
            statr_index =statr_index - base;
            end_index = end_index - base;
            round++;
        }
        return result;

    }


    //////////////////////////////////////

    private  String binaryToOctalAfterPoint(String binaryNumber){
        String result = ".",threeDigits;
        int statr_index = 0, end_index = 3, base = 3;
        int round = 0;
        final int max_round = binaryNumber.length()/3;
        while (round < max_round) {
            threeDigits = binaryNumber.substring(statr_index, end_index);
            result = result + Integer.toOctalString(Integer.parseInt(threeDigits,2));
            statr_index =statr_index + base;
            end_index = end_index + base;
            round++;
        }
        return result;
    }





    /////////////////////////////////////////////




    ////////////////////////////


    private String binaryToHexaDecimalBeforePoint(String binaryNumber){
        //Maximum digits no Limit
        String result = "",fourDigits;
        int statr_index , end_index;
        final int base = 4;
        statr_index = binaryNumber.length() - base;
        end_index = binaryNumber.length();
        int round = 0;
        final int max_round = binaryNumber.length()/4;
        while (round < max_round) {
            fourDigits = binaryNumber.substring(statr_index, end_index);
            result = Integer.toHexString(Integer.parseInt(fourDigits,2)) + result;
            statr_index =statr_index - base;
            end_index = end_index - base;
            round++;
        }
        return result.toUpperCase();
    }



  /////////////////////////


    private String binaryToHexaDecimalAfterPoint(String binaryNumber){


        String result = ".",fourDigits;
        int statr_index = 0, end_index = 4, base = 4;
        int round = 0;
        final int max_round = binaryNumber.length()/4;
        while (round < max_round) {
            fourDigits = binaryNumber.substring(statr_index, end_index);
            result = result + Integer.toHexString(Integer.parseInt(fourDigits,2));
            statr_index =statr_index + base;
            end_index = end_index + base;
            round++;
        }
        return result.toUpperCase();
    }

}
