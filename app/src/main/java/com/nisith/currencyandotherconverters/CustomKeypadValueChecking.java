package com.nisith.currencyandotherconverters;
//This Class checked each entering character by user in EdieText for a Custom KeyPad i.e. for Binary,Octal or HexaDecimal Number KeyPad.
public class CustomKeypadValueChecking {
    public boolean isBinaryKeypadEnteringValueOK(String enteredCharacter){
        boolean isOk = true;
        //If Entered Character is a Binary Number(1,0) also for point(.) ,then only this method return true elde return false....
        if (!(enteredCharacter.contains("1") || enteredCharacter.contains("0") || enteredCharacter.contains("."))){
            //If not contains binary value or point then isOk = false else isOk = true.
            isOk = false;
        }

        return isOk;
    }

    public boolean isOctalKeypadEnteringValueOK(String enteredCharacter){
        boolean isOk = true;
        if (!(enteredCharacter.contains("1") || enteredCharacter.contains("2") || enteredCharacter.contains("3") || enteredCharacter.contains("4")
                || enteredCharacter.contains("5") || enteredCharacter.contains("6") || enteredCharacter.contains("7") || enteredCharacter.contains("0")
                || enteredCharacter.contains("."))){
            isOk = false;
        }
        return isOk;
    }


    public boolean isHexaDecimalKeypadEnteringValueOK(String enteredCharacter){
        boolean isOk = true;
        if (!(enteredCharacter.contains("1") || enteredCharacter.contains("2") || enteredCharacter.contains("3") || enteredCharacter.contains("4")
                || enteredCharacter.contains("5") || enteredCharacter.contains("6") || enteredCharacter.contains("7") || enteredCharacter.contains("8")
                || enteredCharacter.contains("9") || enteredCharacter.contains("0") || enteredCharacter.contains(".") || enteredCharacter.contains("A")
                || enteredCharacter.contains("B") || enteredCharacter.contains("C") || enteredCharacter.contains("D") || enteredCharacter.contains("E")
                || enteredCharacter.contains("F") )){
            isOk = false;
        }
        return isOk;
    }


}
