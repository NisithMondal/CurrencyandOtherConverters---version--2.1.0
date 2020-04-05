package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class GeneralHistoryActivity extends AppCompatActivity implements GeneralHistoryRecyclerViewAdapter.OnDeleteIconClickListener, GeneralHistoryRecyclerViewAdapter.OnSpeakerIconClickListener {
    private GeneralHistoryRecyclerViewAdapter adapter;
    private MyDatabaseHelper myDatabaseHelper;
    private TextSpeaker textSpeaker;
    private SoundStateSharedPreference soundStateSharedPreference;
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private ImageView toolbarSoundIconImageView;
    private String convertionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_history);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        TextView toolbarTitle = findViewById(R.id.app_toolbar_title);
        toolbarSoundIconImageView = appToolbar.findViewById(R.id.audio_enable_image_view);
        RecyclerView recyclerView = findViewById(R.id.history_recycler_view);
        TextView noItemTextView = findViewById(R.id.no_item_text_view);
        setSupportActionBar(appToolbar);
        Intent intent = getIntent();
        //get Intent data
        String activityTitle = intent.getStringExtra("activity_name");
        //convertionType value may be frequency,length,volume,currency,speed,area etc...
        convertionType = intent.getStringExtra("convertion_type");
        setTitle("");
        toolbarTitle.setText(activityTitle);
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This method is Called when toolBar Back Arrow is Clicked
                //If the KeyBoard is Open then it will close and then the activity will finish i.e. Destroyed
                closeKeyBoard();
                finish();
            }
        });
        textSpeaker = new TextSpeaker(getApplicationContext());
        soundStateSharedPreference = new SoundStateSharedPreference(this);
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this,textSpeaker);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        myDatabaseHelper = new MyDatabaseHelper(this);
        Cursor dbCursor = myDatabaseHelper.getCursorObject(convertionType);
        if (dbCursor != null) {
            adapter = new GeneralHistoryRecyclerViewAdapter(this,this,noItemTextView,toolbarSoundIconImageView,dbCursor);
            recyclerView.setAdapter(adapter);
        }
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);

        //To show Banner Ad
        showSmallBannerAd();

    }


    private void showSmallBannerAd(){
        //For showing Small Banner Ads
        //For AdMob Ads
        //For Banner Ads
        AdView smallBannedAdView = findViewById(R.id.small_banner_ad);
        smallBannedAdView.loadAd(new AdRequest.Builder().build());
    }


    private void closeKeyBoard(){
        //this method hide the key board on android device if the keyBoard was visible
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }


    @Override
    public void onDeleteIconClick(int position,int dataBaseRowId) {
        //This method is called when history recycler view's each row's delete icon is Clicked
        deleteDataFromDataBase(position,dataBaseRowId);

    }



    @Override
    public void onSpeakerIconClick(int position, String audioText) {//baki
        //This method is called when histry recycler view's each row's speaker icon is Clicked
        //when speaker icon is clicked then do something
        String soundState = soundStateSharedPreference.getSoundState();
        //The soundState saved in sharedPreference  if enabled then only text to speech converTion is performed
        if(soundState.equalsIgnoreCase(getString(R.string.enable))) {
            textSpeaker.speak(audioText);
        }else {
            Toast.makeText(this, "Enable the Sound Icon", Toast.LENGTH_SHORT).show();
        }

    }


    private void deleteDataFromDataBase(int position,int dataBaseRowId){
        //This method delete Specified row from DataBase
        /*myDatabaseHelper.deleteDataFromDatabase() of MyDatabaseHelper class method is actually responsible to delete specified row from database
           that's why I call that method here */
        boolean isSuccessfull = myDatabaseHelper.deleteDataFromDatabase(dataBaseRowId);
        //If specified row is deleted from dataBase then only isSuccessfull will true
        if (isSuccessfull) {
            //If specified row is deleted from dataBase then remove that ROW from recycler view With Animation
            adapter.notifyItemRemoved(position);
            //After delating specified ROW from recycler view ,set New Cursor in recyclerView Adapter.. This is Very Very Very Important
            //If we not set the new cursor in adapter then it will not properly work
            adapter.setCursor(myDatabaseHelper.getCursorObject(convertionType));
        }else {
            Toast.makeText(this, "Not Delete", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    protected void onDestroy() {
        if(textSpeaker != null) {
            textSpeaker.closeTextSpeaker();
        }
        if (myDatabaseHelper != null){
            myDatabaseHelper.close();
        }
        super.onDestroy();

    }





}
