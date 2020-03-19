package com.nisith.currencyandotherconverters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class TextSpeaker {

    private TextToSpeech textToSpeech;
    private String previousString="";
    public TextSpeaker(Context context){
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    //Set language in text to Speech object
                    textToSpeech.setLanguage(Locale.US );

                }
            }
        });
    }



    public void speak(String text){
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
    }


    public void speakLastCharacterOfEditText(String enterString){
        if (enterString == null){
            return;
        }
          /*This Method will tells the last enter Character in search View or Edit text. But it will not speak anything when character is removed from
                  edit text Field */
        if (enterString.trim().length()>0) {
            /*when we remove character from edit text ,then the length of the entered String will be less then the previousString.length()
            value. Then this condition will false and nothing speak by TextSpeaker.In this way when we from character from edit text then nothing
            tells by textSpeaker */
            if (enterString.length()>previousString.length()) {
                speak(String.valueOf(enterString.charAt(enterString.length() - 1)));
            }
        }
        previousString=enterString;
    }
    public void closeTextSpeaker(){
        textToSpeech.stop();
        textToSpeech.shutdown();
    }

}
