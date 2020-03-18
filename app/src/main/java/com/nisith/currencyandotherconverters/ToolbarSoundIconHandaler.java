package com.nisith.currencyandotherconverters;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ToolbarSoundIconHandaler implements View.OnClickListener {

    private SoundStateSharedPreference soundStateSharedPreference;
    private Context context;

    public ToolbarSoundIconHandaler(Context context){
        soundStateSharedPreference = new SoundStateSharedPreference(context);
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String soundState = soundStateSharedPreference.getSoundState();
        if (soundState.equalsIgnoreCase(context.getString(R.string.enable))){
            v.setBackground(context.getDrawable(R.drawable.ic_volume_off));
            soundStateSharedPreference.setSoundState(context.getString(R.string.dissable));
            Toast.makeText(context, "Sound Dissable", Toast.LENGTH_SHORT).show();

        }else if (soundState.equalsIgnoreCase(context.getString(R.string.dissable))){
            v.setBackground(context.getDrawable(R.drawable.ic_volume_on));
            soundStateSharedPreference.setSoundState(context.getString(R.string.enable));
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
