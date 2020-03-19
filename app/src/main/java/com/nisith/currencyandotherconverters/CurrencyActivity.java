package com.nisith.currencyandotherconverters;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class CurrencyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationDrawerView;
    private ImageView arrowImageView;
    private LinearLayout leftCurrencyLayout,rightCurrencyLayout;
    private TextView leftCurrencyTextView,rightCurrencyTextView;
    private EditText enterAmountEditText;
    private Toolbar appToolbar;
    private int mRequestCode = 123;
    private TextView marqueTextView;
    private SoundStateSharedPreference soundStateSharedPreference;//this is use to store the state(Enable or dissable) of the audio sound of text to speech
    private TextSpeaker textSpeaker;
    // I used sharedPreference to store sound icon state (enable or dissable) instead of using database
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private ImageView toolbarSoundIconImageView;


    //For InterstitialAd
    private MyInterstitialAd myInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        appToolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);
        setTitle("");
        TextView appToolbarTitle = appToolbar.findViewById(R.id.app_toolbar_title);
        toolbarSoundIconImageView = appToolbar.findViewById(R.id.audio_enable_image_view);
        appToolbarTitle.setText("Currency Converter");
        drawerLayout = findViewById(R.id.drawer_layout);
        enterAmountEditText = findViewById(R.id.amount_edit_text);
        navigationDrawerView = findViewById(R.id.navigation_drawer_view);
        leftCurrencyLayout = findViewById(R.id.left_currency_layout);
        rightCurrencyLayout = findViewById(R.id.right_currency_layout);
        leftCurrencyTextView = findViewById(R.id.left_currency_text_view);
        rightCurrencyTextView = findViewById(R.id.right_currency_text_view);
        Button currencyConvertButton = findViewById(R.id.currency_convert_button);
        Button currencyHistoryButton = findViewById(R.id.currency_history_button);
        arrowImageView = findViewById(R.id.arrow_image_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        marqueTextView.setSelected(true);
        soundStateSharedPreference = new SoundStateSharedPreference(this);
        if (soundStateSharedPreference.getSoundState().equalsIgnoreCase("empty")){
            //at the first time when this app in installed then this condition will true only for once
            soundStateSharedPreference.setSoundState("enable");
        }
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);//set toolbar sound icon state(voume off or volume on) at the begining of this activity

        addNavigationDrawer();
        attachAnimationToViews();
        leftCurrencyLayout.setOnClickListener(new MyCurrencyLayoutClickListener());
        rightCurrencyLayout.setOnClickListener(new MyCurrencyLayoutClickListener());
        currencyConvertButton.setOnClickListener(new MyCurrencyButtonClickListener());
        currencyHistoryButton.setOnClickListener(new MyCurrencyButtonClickListener());
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);

        textSpeaker = new TextSpeaker(getApplicationContext());// initalization of textSpeaker



        //To show Ads
        showSmallBannerAd();
        showLargeBannerAd();
//        showInterstitialAd(30000);



    }


    private void showSmallBannerAd(){
        //For showing Small Banner Ads
        //For AdMob Ads
        //For Banner Ads
        AdView smallBannedAdView = findViewById(R.id.small_banner_ad);
        smallBannedAdView.loadAd(new AdRequest.Builder().build());
    }


    private void showLargeBannerAd(){
        //For showing Large Banner Ads
        AdView largeBannerAdView = findViewById(R.id.large_banner_ad);
        largeBannerAdView.loadAd(new AdRequest.Builder().build());
    }
    private void showInterstitialAd(long adIntervalTime){
        //For showing Large Banner Ads
        myInterstitialAd = new MyInterstitialAd(this);
        myInterstitialAd.showInterstitialAd(adIntervalTime);//ad interval time in millisecond
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //To stop the Thread of InterstitialAd when this Activity is Destroyed
        if (myInterstitialAd != null) {
            myInterstitialAd.stopThread();
        }
        if (textSpeaker != null) {
            //this will release memory of textSpeaker object from Ram. This is Important
            textSpeaker.closeTextSpeaker();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){



            case R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.length:
                Intent lengthIntent = new Intent(CurrencyActivity.this,LengthConverterActivity.class);
                startActivity(lengthIntent);
                break;

            case R.id.area:
                Intent areaIntent = new Intent(CurrencyActivity.this,AreaConverterActivity.class);
                startActivity(areaIntent);
                break;

            case R.id.volume:
                Intent volumeIntent = new Intent(CurrencyActivity.this,VolumeConverterActivity.class);
                startActivity(volumeIntent);
                break;
            case R.id.pressure:
                Intent pressureIntent = new Intent(CurrencyActivity.this,PressureConverterActivity.class);
                startActivity(pressureIntent);
                break;

            case R.id.weight:
                Intent weightIntent = new Intent(CurrencyActivity.this,WeightConverterActivity.class);
                startActivity(weightIntent);
                break;
            case R.id.angle:
                Intent angleIntent = new Intent(CurrencyActivity.this,AngleConverterActivity.class);
                startActivity(angleIntent);
                break;
            case R.id.temperature:
                Intent temperatureIntent = new Intent(CurrencyActivity.this,TemperatureConverterActivity.class);
                startActivity(temperatureIntent);
                break;
            case R.id.number_system:
                Intent numberSystemIntent = new Intent(CurrencyActivity.this,NumberSystemConverterActivity.class);
                startActivity(numberSystemIntent);
                break;
            case R.id.speed:
                Intent speedIntent = new Intent(CurrencyActivity.this,SpeedConverterActivity.class);
                startActivity(speedIntent);
                break;
            case R.id.time:
                Intent timeIntent = new Intent(CurrencyActivity.this,TimeConverterActivity.class);
                startActivity(timeIntent);
                break;
            case R.id.frequency:
                Intent frequencyIntent = new Intent(CurrencyActivity.this,FrequencyConverterActivity.class);
                startActivity(frequencyIntent);
                break;
            case R.id.about_app:
                Intent aboutAppIntent = new Intent(CurrencyActivity.this,AboutAppActivity.class);
                startActivity(aboutAppIntent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addNavigationDrawer(){
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,appToolbar,R.string.open_drawer,R.string.close_drawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //when nevagitation drawer is opened

            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //when nevagitation drawer is Closed
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationDrawerView.setNavigationItemSelectedListener(this);
        navigationDrawerView.setCheckedItem(R.id.home);
    }

    private void attachAnimationToViews(){

        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String leftCurrencyTextViewValue = leftCurrencyTextView.getText().toString();
                 String rightCurrencyTextViewValue = rightCurrencyTextView.getText().toString();
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);

                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftCurrencyLayout);
                leftCurrencyTextView.setText(rightCurrencyTextViewValue);
                enterAmountEditText.setHint("Enter Amount ("+leftCurrencyTextView.getText().toString()+")");


                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightCurrencyLayout);

                rightCurrencyTextView.setText(leftCurrencyTextViewValue);
                marqueTextView.setText("Currency   is   Converted    From   "+leftCurrencyTextView.getText().toString() +      "       To     "+ rightCurrencyTextView.getText().toString()+"                                  ");

                //this is for audio speech when one click arrowImageView
                playAudioSound();

            }
        });
    }


    private class MyCurrencyLayoutClickListener implements View.OnClickListener{
        public void onClick(View view){
            //when left or right currency linear Layout is Clicked
            Intent intent = new Intent(CurrencyActivity.this,AllCurrencyNameActivity.class);
            int clickedCurrencyLayoutId = view.getId();
            intent.putExtra("clicked_currency_layout_id",clickedCurrencyLayoutId);
            startActivityForResult(intent,mRequestCode);

        }
    }

    private class MyCurrencyButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.currency_convert_button:
                    Toast.makeText(CurrencyActivity.this, "Convert", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.currency_history_button:
                    Intent currencyHistoryIntent = new Intent(CurrencyActivity.this,CurrencyHistoryActivity.class);
                    startActivity(currencyHistoryIntent);
                    break;

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == mRequestCode && resultCode == RESULT_OK && data !=null){
            String selectedCurrencyName = data.getStringExtra("currency_name");
            int clickedCurrencyLayoutId = data.getIntExtra("clicked_currency_layout_id",-1);
            switch (clickedCurrencyLayoutId){
                case R.id.left_currency_layout:
                    if (rightCurrencyTextView.getText().toString().equalsIgnoreCase(selectedCurrencyName)){
                        rightCurrencyTextView.setText(leftCurrencyTextView.getText().toString());
                    }
                    leftCurrencyTextView.setText(selectedCurrencyName);
                    enterAmountEditText.setHint("Enter Amount ("+leftCurrencyTextView.getText().toString()+")");
                    break;

                case R.id.right_currency_layout:
                    if (leftCurrencyTextView.getText().toString().equalsIgnoreCase(selectedCurrencyName)){
                        leftCurrencyTextView.setText(rightCurrencyTextView.getText().toString());
                    }
                    rightCurrencyTextView.setText(selectedCurrencyName);
                    break;
            }
            marqueTextView.setText("Currency   is   Converted    From   "+leftCurrencyTextView.getText().toString() +      "       To     "+ rightCurrencyTextView.getText().toString()+"                                 ");
            //this is for audio speech when one select leftSpinnerItem or right itemSpinner
            playAudioSound();
        }


    }




    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftCurrencyTextView.getText().toString();
        String rightTextViewValue = rightCurrencyTextView.getText().toString();
        String text = "Currency is converted from "+leftTextViewValue+" to "+rightTextViewValue;
        String soundState = soundStateSharedPreference.getSoundState();
        if(soundState.equalsIgnoreCase(getString(R.string.enable))) {
            //The soundState saved in sharedPreference  if enabled then only text to speech converTion is performed
            textSpeaker.speak(text);
        }
    }





    @Override
    protected void onStart() {
        if (navigationDrawerView != null){
            navigationDrawerView.setCheckedItem(R.id.home);
        }
        //To changed the state of sound Image Icon in toolbar.Because when we back to our frequency converter Activity from frequency history Activity
        //this is Important
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);
        super.onStart();
    }




}
