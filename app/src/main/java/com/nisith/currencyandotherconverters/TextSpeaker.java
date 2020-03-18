package com.nisith.currencyandotherconverters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class TextSpeaker {

    private TextToSpeech textToSpeech;
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


    public void closeTextSpeaker(){
        textToSpeech.stop();
        textToSpeech.shutdown();
    }

}
