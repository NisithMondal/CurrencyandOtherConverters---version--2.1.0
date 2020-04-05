package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ToolbarSoundIconHandaler implements View.OnClickListener {

    private SoundStateSharedPreference soundStateSharedPreference;
    private Context context;
    private TextSpeaker textSpeaker;

    public ToolbarSoundIconHandaler(Context context,TextSpeaker textSpeaker){
        soundStateSharedPreference = new SoundStateSharedPreference(context);
        this.context = context;
        this.textSpeaker = textSpeaker;
    }

    @Override
    public void onClick(View v) {
        String soundState = soundStateSharedPreference.getSoundState();
        if (soundState.equalsIgnoreCase(context.getString(R.string.enable))){
            v.setBackground(context.getDrawable(R.drawable.ic_volume_off));
            soundStateSharedPreference.setSoundState(context.getString(R.string.dissable));
            if (textSpeaker != null) {
                textSpeaker.speak("sound disable");
                Log.d("ABVD"," textSpeaker is not NULL");
            }else {
                Log.d("ABVD"," textSpeaker is NULL");
            }
            Toast.makeText(context, "Sound Disable", Toast.LENGTH_SHORT).show();

        }else if (soundState.equalsIgnoreCase(context.getString(R.string.dissable))){
            v.setBackground(context.getDrawable(R.drawable.ic_volume_on));
            soundStateSharedPreference.setSoundState(context.getString(R.string.enable));
            if (textSpeaker != null) {
                textSpeaker.speak("sound enable");
            }
            Toast.makeText(context, "Sound Enable", Toast.LENGTH_SHORT).show();
        }
    }

    public void setToolbarSoundIconState(View view){
        //this function set toolbar sound icon state i.e. if it will remain enable or dissable

        String soundState = soundStateSharedPreference.getSoundState();
        if (soundState.equalsIgnoreCase(context.getString(R.string.enable))){
            view.setBackground(context.getDrawable(R.drawable.ic_volume_on));

        }else {
            view.setBackground(context.getDrawable(R.drawable.ic_volume_off));

        }
    }


}
