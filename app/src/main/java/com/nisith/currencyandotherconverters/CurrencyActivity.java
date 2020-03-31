package com.nisith.currencyandotherconverters;

import android.content.ActivityNotFoundException;
import android.content.Context;
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

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CurrencyActivity extends AppCompatActivity implements MyInterstitialAd.OnInterstitialAdCloseListener,NavigationView.OnNavigationItemSelectedListener, CurrencyNetworkOperation.OnFinishServerOperationIListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationDrawerView;
    private ImageView arrowImageView;
    private LinearLayout leftCurrencyLayout,rightCurrencyLayout;
    private TextView leftCurrencyTextView,rightCurrencyTextView;
    private EditText enterAmountEditText;
    private TextView resultTextView;
    private Toolbar appToolbar;
    private int mRequestCode = 123;
    private TextView marqueTextView;
    private SoundStateSharedPreference soundStateSharedPreference;//this is use to store the state(Enable or dissable) of the audio sound of text to speech
    private TextSpeaker textSpeaker;
    // I used sharedPreference to store sound icon state (enable or dissable) instead of using database
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private ImageView toolbarSoundIconImageView;
    private ProgressBar progressBar;
    private Button currencyConvertButton,currencyHistoryButton;
    private ArrayList<CurrencyInfoHolder> allCurrencyInfoArrayList;
    //For InterstitialAd
    private int interstitialAdStartingTime = 0;
    private boolean isInterstitialAdAlreadyShown = false;
    private MyInterstitialAd myInterstitialAd;
    private final int twoInterstitialAdsIntervalTime = 2; //In Minute



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
        resultTextView = findViewById(R.id.result_text_view);
        navigationDrawerView = findViewById(R.id.navigation_drawer_view);
        leftCurrencyLayout = findViewById(R.id.left_currency_layout);
        rightCurrencyLayout = findViewById(R.id.right_currency_layout);
        leftCurrencyTextView = findViewById(R.id.left_currency_text_view);
        rightCurrencyTextView = findViewById(R.id.right_currency_text_view);
        currencyConvertButton = findViewById(R.id.currency_convert_button);
        currencyHistoryButton = findViewById(R.id.currency_history_button);
        arrowImageView = findViewById(R.id.arrow_image_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        progressBar = findViewById(R.id.progressbar);
        marqueTextView.setText("Currency   is   Converted   From   USD   To   EUR                                          ");
        marqueTextView.setSelected(true);
        soundStateSharedPreference = new SoundStateSharedPreference(this);
        if (soundStateSharedPreference.getSoundState().equalsIgnoreCase("empty")){
            //at the first time when this app in installed then this condition will true only for once
            soundStateSharedPreference.setSoundState("enable");
        }
        textSpeaker = new TextSpeaker(getApplicationContext());// initalization of textSpeaker
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this,textSpeaker);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);//set toolbar sound icon state(voume off or volume on) at the begining of this activity
        progressBar.setVisibility(View.GONE);
        addNavigationDrawer();
        attachAnimationToViews();
        leftCurrencyLayout.setOnClickListener(new MyCurrencyLayoutClickListener());
        rightCurrencyLayout.setOnClickListener(new MyCurrencyLayoutClickListener());
        currencyConvertButton.setOnClickListener(new MyCurrencyButtonClickListener());
        currencyHistoryButton.setOnClickListener(new MyCurrencyButtonClickListener());
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);
        enterAmountEditText.addTextChangedListener(new MyTextWatcher());
        resultTextView.addTextChangedListener(new MyResultTextViewTextWatcher());

        //To show Ads
        showSmallBannerAd();
        showLargeBannerAd();
        myInterstitialAd = new MyInterstitialAd(this);



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


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
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
    protected void onDestroy() {
        super.onDestroy();

        if (textSpeaker != null) {
            //this will release memory of textSpeaker object from Ram. This is Important
            textSpeaker.closeTextSpeaker();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){



            case R.id.currency:
                break;

            case R.id.length:
                Intent lengthIntent = new Intent(CurrencyActivity.this,LengthConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    //If ad is Loaded
                    int length_converter_id = 10001;
                    showInterstitialAd(lengthIntent,length_converter_id);
                }else {
                    //If ad is not loaded
                    startActivity(lengthIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.area:
                Intent areaIntent = new Intent(CurrencyActivity.this,AreaConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    //If ad is Loaded
                    int area_converter_id = 10002;
                    showInterstitialAd(areaIntent,area_converter_id);
                }else {
                    //If ad is not loaded
                    startActivity(areaIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.volume:
                Intent volumeIntent = new Intent(CurrencyActivity.this,VolumeConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int volume_converter_id = 10003;
                    showInterstitialAd(volumeIntent,volume_converter_id);
                }else {
                    startActivity(volumeIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.pressure:
                Intent pressureIntent = new Intent(CurrencyActivity.this,PressureConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int pressure_converter_id = 10004;
                    showInterstitialAd(pressureIntent,pressure_converter_id);
                }else {
                    startActivity(pressureIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.weight:
                Intent weightIntent = new Intent(CurrencyActivity.this,WeightConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int weight_converter_id = 10005;
                    showInterstitialAd(weightIntent,weight_converter_id);
                }else {
                    startActivity(weightIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.angle:
                Intent angleIntent = new Intent(CurrencyActivity.this,AngleConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int angle_converter_id = 10006;
                    showInterstitialAd(angleIntent,angle_converter_id);
                }else {
                    startActivity(angleIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.temperature:
                Intent temperatureIntent = new Intent(CurrencyActivity.this,TemperatureConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int temperature_converter_id = 10007;
                    showInterstitialAd(temperatureIntent,temperature_converter_id);
                }else {
                    startActivity(temperatureIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.number_system:
                Intent numberSystemIntent = new Intent(CurrencyActivity.this,NumberSystemConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int number_system_converter_id = 10008;
                    showInterstitialAd(numberSystemIntent,number_system_converter_id);
                }else {
                    startActivity(numberSystemIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.speed:
                Intent speedIntent = new Intent(CurrencyActivity.this,SpeedConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int speed_converter_id = 10009;
                    showInterstitialAd(speedIntent,speed_converter_id);
                }else {
                    startActivity(speedIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.time:
                Intent timeIntent = new Intent(CurrencyActivity.this,TimeConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int time_converter_id = 100010;
                    showInterstitialAd(timeIntent,time_converter_id);
                }else {
                    startActivity(timeIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.frequency:
                Intent frequencyIntent = new Intent(CurrencyActivity.this,FrequencyConverterActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int frequency_converter_id = 100011;
                    showInterstitialAd(frequencyIntent,frequency_converter_id);
                }else {
                    startActivity(frequencyIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.help:
                Intent helpIntent = new Intent(CurrencyActivity.this,HelpActivity.class);
                startActivity(helpIntent);
                break;

            case R.id.about_app:
                Intent aboutAppIntent = new Intent(CurrencyActivity.this,AboutAppActivity.class);
                if (myInterstitialAd.isAdLoaded()){
                    int about_app_converter_id = 100012;
                    showInterstitialAd(aboutAppIntent,about_app_converter_id);
                }else {
                    startActivity(aboutAppIntent);
                    //Load Interstitial Ad
                    myInterstitialAd.loadInterstitialAd();
                }
                break;

            case R.id.app_rating:
                giveRatingThisApplication();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



    private void showInterstitialAd(Intent converterIntent,int converterId){
        //This method shows Interstitial ad in the following condition
        /*Lets take twoInterstitialAdsIntervalTime = 2. This method mainly do, if ad is not already shown, then it shows the ad.
          If ad is already shown ,then after 2 minute later if anybody click on any converter option, then only it will show ad.
          If anybody click on any converter option and time is less than 2 minute the ad will not shown. Only that converter activity will open.  */
        if (isInterstitialAdAlreadyShown){
            //If Interstitial ad is already shown, then do the following
            //get System Current minute.
            int currentMinute = getCurrentSystemMinute();
            //If (currentMinute - interstitialAdStartingTime) >= twoInterstitialAdsIntervalTime, then only we want to show Interstitial ad.
            if (currentMinute - interstitialAdStartingTime >= twoInterstitialAdsIntervalTime){
                //From here we sent converter id like length_converter_id, area_converter_id etc.
                myInterstitialAd.showInterstitialAd(converterId);
                interstitialAdStartingTime = currentMinute;
            }else {
                //If above time is less than twoInterstitialAdsIntervalTime value, then do the following
                startActivity(converterIntent);
            }
        }else {
            //If Interstitial ad is already not shown, then do the following
            //From here we sent converter id like length_converter_id, area_converter_id etc.
            myInterstitialAd.showInterstitialAd(converterId);
            interstitialAdStartingTime = getCurrentSystemMinute();
            isInterstitialAdAlreadyShown = true;
        }
    }

    @Override
    public void onInterstitialAdClose(int clickedConverterId) {
        //This method is belong to OnInterstitialAdCloseListener , which is present in MyInterstitialAd.java class
        //This callback method is called when anyone close interstitial ad. So here we have to start new Activity.......
        /*When anybody clicked length converter option of drawer ,then if all are right then ad will shown. After Closing that ad ,
          length converter activity will open act. This method pass  clickedConverterId i.e. which converter is clicked. And this is same for other converters. */
        switch (clickedConverterId){
            case 10001:
                //Open Length converter
                startActivity(new Intent(CurrencyActivity.this,LengthConverterActivity.class));
                break;

            case 10002:
                //Open Area converter
                startActivity(new Intent(CurrencyActivity.this,AreaConverterActivity.class));
                break;

            case 10003:
                //Open Volume converter
                startActivity(new Intent(CurrencyActivity.this,VolumeConverterActivity.class));
                break;

            case 10004:
                //Open Pressure converter
                startActivity(new Intent(CurrencyActivity.this,PressureConverterActivity.class));
                break;

            case 10005:
                //Open Weight converter
                startActivity(new Intent(CurrencyActivity.this,WeightConverterActivity.class));
                break;

            case 10006:
                //Open Angle converter
                startActivity(new Intent(CurrencyActivity.this,AngleConverterActivity.class));
                break;

            case 10007:
                //Open Temperature converter
                startActivity(new Intent(CurrencyActivity.this,TemperatureConverterActivity.class));
                break;

            case 10008:
                //Open Number System converter
                startActivity(new Intent(CurrencyActivity.this,NumberSystemConverterActivity.class));
                break;

            case 10009:
                //Open Speed converter
                startActivity(new Intent(CurrencyActivity.this,SpeedConverterActivity.class));
                break;

            case 100010:
                //Open Time converter
                startActivity(new Intent(CurrencyActivity.this,TimeConverterActivity.class));
                break;

            case 100011:
                //Open Frequency converter
                startActivity(new Intent(CurrencyActivity.this,FrequencyConverterActivity.class));
                break;

            case 100012:
                //Open About app converter
                startActivity(new Intent(CurrencyActivity.this,AboutAppActivity.class));
                break;
        }
    }




    private int getCurrentSystemMinute(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
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
        navigationDrawerView.setCheckedItem(R.id.currency);
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

                //I call performCurrencyConvertion() method here because I want to perform Currency Convertion when ArrowImageView is Clicked
                performCurrencyConvertion(allCurrencyInfoArrayList);

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
                    //if Currency Converter Button is Clicked
                    //Check if Internet is Available or not
                    if (isInternetAvailable()){
                        //Check if Edit text field is empty or not
                        if (enterAmountEditText.getText().toString().length()>0){
                            //Some Value in edit text
                            /*When allCurrencyInfoArrayList,which is a variable of this class is null, then only we fetch all Currency Information
                              from server.allCurrencyInfoArrayList will null in when this activity is Created. */
                            resultTextView.setVisibility(View.INVISIBLE);
                            if (allCurrencyInfoArrayList == null){
                                CurrencyNetworkOperation currencyNetworkOperation = new CurrencyNetworkOperation(CurrencyActivity.this);
                                currencyNetworkOperation.performCurrencyNetworkOperation();
                                progressBar.setVisibility(View.VISIBLE);
                                currencyConvertButton.setEnabled(false);
                                currencyHistoryButton.setEnabled(false);
                                enterAmountEditText.setEnabled(false);

                            }else {
                                /*Else allCurrencyInfoArrayList is not null means all currencies Information is present in that arrayList.
                                  That's why simpley perform currency Convertion */
                                performCurrencyConvertion(allCurrencyInfoArrayList);
                            }
                            closeKeyBoard();

                        }else {
                            //if Empty
                            Toast.makeText(CurrencyActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        AlertDialogForInternetConnectionError dialog = new AlertDialogForInternetConnectionError();
                        dialog.show(getSupportFragmentManager(),"currency");
                    }
                    break;


                case R.id.currency_history_button:
                    //If Currency HISTORY Button is Clicked
                    final String activityName = "activity_name";
                    final String convertionType = "convertion_type";
                    Intent historyIntent = new Intent(CurrencyActivity.this, GeneralHistoryActivity.class);
                    historyIntent.putExtra(activityName,"Currency History");
                    historyIntent.putExtra(convertionType,AllTables.ConvertionType.currency);
                    startActivity(historyIntent);
                    break;

            }
        }
    }


    @Override
    public void onFinishServerOperation(ArrayList<CurrencyInfoHolder> mAllcurrencyInfoArrayList, final String resultStatus) {
        /*This is a callBack Method belongs to interface OnFinishServerOperationIListener, which is present in CurrencyNetworkOperation.java
          class.This CurrencyActivity implements that interface and this is the method which is override.
          This Method is called when CurrencyNetworkOperation is completed.This method not run on mainThread
          because this method is called from CurrencyNetworkOperation class's background thread. That's why we write runOnUiThread() method.
          Because views can only be accessiable from UI Thread i.e. mainThread and Toast message also shows in mainThread. Otherwise it arise errors...
        */
        if (resultStatus.equalsIgnoreCase("ok")) {
            //If Server result is ok, then perform currency convertion
            allCurrencyInfoArrayList = mAllcurrencyInfoArrayList;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    performCurrencyConvertion(allCurrencyInfoArrayList);
                    progressBar.setVisibility(View.GONE);
                    currencyConvertButton.setEnabled(true);
                    currencyHistoryButton.setEnabled(true);
                    enterAmountEditText.setEnabled(true);
                }
            });

        }else if (resultStatus.equalsIgnoreCase("not successful")){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    resultTextView.setVisibility(View.VISIBLE);
                    resultTextView.setText("Convertion Failed. Please Try Again");
                    progressBar.setVisibility(View.GONE);
                    currencyConvertButton.setEnabled(true);
                    currencyHistoryButton.setEnabled(true);
                    enterAmountEditText.setEnabled(true);
                }
            });
        }else if (resultStatus.equalsIgnoreCase("failed")){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    resultTextView.setVisibility(View.VISIBLE);
                    resultTextView.setText("Currency Convertion Failed. Check Your Internet Connection and Try Again.....");
                    progressBar.setVisibility(View.GONE);
                    currencyConvertButton.setEnabled(true);
                    currencyHistoryButton.setEnabled(true);
                    enterAmountEditText.setEnabled(true);
                }
            });
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
            //I call performCurrencyConvertion() method here because I want to perform Currency Convertion when leftSpinner or rightSpinner Item is selected
            performCurrencyConvertion(allCurrencyInfoArrayList);
            //this is for audio speech when one select leftSpinnerItem or right itemSpinner
            playAudioSound();
        }


    }



    private class MyTextWatcher implements TextWatcher {

        //text watcher for Edit Text

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String soundState = soundStateSharedPreference.getSoundState();
            if(soundState.equalsIgnoreCase(getString(R.string.enable))) {
                //The soundState saved in sharedPreference  if enabled then only text to speech converTion is performed
                 /*This Method will tells the last enter Character in search View or Edit text. But it will not speak anything when character is removed from
                  edit text Field */
                if (count==1) {
                    //if count=1 means user enter value in edit text. If count=0 means character is removed from edit text.
                    textSpeaker.speakEditTextCharacter(String.valueOf(s.charAt(start)));
                }
            }
            if (enterAmountEditText.getText().toString().length()==0){
                //If the edit text has no number i.e. empty then hide result text view
                resultTextView.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }



    private class MyResultTextViewTextWatcher implements TextWatcher{

        //text watcher for result Text View
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        @Override
        public void afterTextChanged(Editable s) {
            //This method is called after result Text View Text value is Changed
            //Here performed DataBase Operation is performed.
            String resultTextViewValue = resultTextView.getText().toString();
            if (resultTextViewValue.length()>0){
                storeDataInDatabase(resultTextViewValue);
            }
        }
    }



    private void storeDataInDatabase(String convertionText){
        //Just a method to store data in Database
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.getTime());
        SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();
        String currentTime = format.format(date);
        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.currency);
    }



    private void performCurrencyConvertion(ArrayList<CurrencyInfoHolder> mAllCurrencyInfoArrayList){
        //This method perform Currency Convertion Operation
        //Check if Internet is Available or not
        if (isInternetAvailable()){
            //If internet is available do Something
            //Check if Edit text field is empty or not
            if (enterAmountEditText.getText().toString().length()>0){
                //Some Value in edit text .Do something
                if (allCurrencyInfoArrayList != null){
                    //If All Currencies name and rates are Available in the allCurrencyInfoArrayList ArrayList
                    resultTextView.setVisibility(View.VISIBLE);
                    String leftCurrencyTextViewValue = leftCurrencyTextView.getText().toString();
                    String rightCurrencyTextViewValue = rightCurrencyTextView.getText().toString();
                    String editTextString = enterAmountEditText.getText().toString();
                    if (editTextString.length() == 1 && editTextString.equalsIgnoreCase(".")){
                        Toast.makeText(this, "Enter more Number", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    double edittextValue = Double.parseDouble(editTextString);
                    //Perform Currency Convertion
                    CurrencyConverterActivity currencyConverterActivity = new CurrencyConverterActivity();
                    String result = currencyConverterActivity.getCurrencyConvertionResult(leftCurrencyTextViewValue,rightCurrencyTextViewValue,edittextValue,mAllCurrencyInfoArrayList);
                    //If Convertion is Filed
                    if (result.equalsIgnoreCase("FAILED")){
                      resultTextView.setText("Currency Not Available");
                    }else {
                      resultTextView.setText(editTextString+"  "+leftCurrencyTextViewValue+"  =  "+result+"  "+rightCurrencyTextViewValue);
                 }
                }
            }
        }else {
            //Internet is not available then,
            resultTextView.setVisibility(View.INVISIBLE);
        }
    }


    private boolean isInternetAvailable() {
        //This method check if the internet is available or not
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
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

    private void giveRatingThisApplication(){
        //This Method open Google Play Store to give rating this Application ///////////////////baki
        try{
            //If play store app is installed in that device, then do the following
            Intent playStroreIntent = new Intent();
            playStroreIntent.setAction(Intent.ACTION_VIEW);
            playStroreIntent.setData(Uri.parse("market://details?id="+"com.android.chrome"));
            startActivity(playStroreIntent);
        }catch (ActivityNotFoundException e){
            //If play store app is not installed in that device, then the following code open play store app in web browser.
            Intent playStoreIntent1 = new Intent();
            playStoreIntent1.setAction(Intent.ACTION_VIEW);
            playStoreIntent1.setData(Uri.parse("http://play.google.com/store/apps/details?id="+"com.android.chrome"));
            startActivity(playStoreIntent1);
        }

    }





    @Override
    protected void onStart() {
        if (navigationDrawerView != null){
            navigationDrawerView.setCheckedItem(R.id.currency);
        }
        //To changed the state of sound Image Icon in toolbar.Because when we back to our frequency converter Activity from frequency history Activity
        //this is Important
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);
        super.onStart();
    }

    @Override
    protected void onPause() {
        if (resultTextView != null){
            resultTextView.setVisibility(View.INVISIBLE);
        }
        super.onPause();
    }
}
