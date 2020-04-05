package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

import android.content.Context;
import android.content.SharedPreferences;

public class SoundStateSharedPreference {
    private SharedPreferences sharedPreferences;
    private final String keyName = "soundState";

    public SoundStateSharedPreference(Context context){
        sharedPreferences = context.getSharedPreferences("sound_state",Context.MODE_PRIVATE);
    }

    public void setSoundState(String state){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(keyName,state);
        editor.commit();
    }

    public String getSoundState(){
        return sharedPreferences.getString(keyName,"empty");
    }

}
