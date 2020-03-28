package com.nisith.currencyandotherconverters;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TemperatureConverterActivity extends AppCompatActivity {


    private ImageView arrowImageView;
    private TextView leftTemperatureTextView,rightTemperatureTextView;
    private LinearLayout leftTemperatureLayout,rightTemperatureLayout;
    private TextView marqueTextView;
    private TextView resultTextView;
    private EditText temperatureValueEditText;
    private Spinner leftSpinner,rightSpinner;
    private Button temperatureConvertButton;
    private Button temperatureHistoryButton;
    private TextSpeaker textSpeaker;
    // I used sharedPreference to store sound icon state (enable or dissable) instead of using database
    private SoundStateSharedPreference soundStateSharedPreference;
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private ImageView toolbarSoundIconImageView;
    private Toolbar appToolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        setConvertionFromXmlToJavaObject();//initalized objects
        marqueTextView.setSelected(true);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("Temperature Converter");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                closeKeyBoard();
            }
        });

        soundStateSharedPreference = new SoundStateSharedPreference(this);
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);//set toolbar sound icon state(voume off or volume on) at the begining of this activity
        attachAnimationToViews();
        setAdapterOnSpinner();
        leftSpinner.setOnItemSelectedListener(new MyLeftSpinnerItemSelected());
        rightSpinner.setOnItemSelectedListener(new MyRightSpinnerItemSelected());
        marqueTextView.setText("Temperature   is   Converted    From   "+leftTemperatureTextView.getText().toString() +      "       To     "+ rightTemperatureTextView.getText().toString()+"                                  ");
        temperatureConvertButton.setOnClickListener(new MyTemperatureButtonClick());
        temperatureHistoryButton.setOnClickListener(new MyTemperatureHistoryButtonClick());
        temperatureValueEditText.addTextChangedListener(new MyTextWatcher());
        resultTextView.addTextChangedListener(new MyResultTextViewTextWatcher());
        textSpeaker = new TextSpeaker(getApplicationContext());// initalization of textSpeaker
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);
        //To show Ads
        showSmallBannerAd();
        showLargeBannerAd();
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




    private void closeKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }



    private void setConvertionFromXmlToJavaObject(){
        appToolbar = findViewById(R.id.app_toolbar);
        toolbarTitle = findViewById(R.id.app_toolbar_title);
        toolbarSoundIconImageView = appToolbar.findViewById(R.id.audio_enable_image_view);
        arrowImageView = findViewById(R.id.arrow_image_view);
        leftTemperatureLayout = findViewById(R.id.left_temperature_layout);
        rightTemperatureLayout = findViewById(R.id.right_temperature_layout);
        leftTemperatureTextView = findViewById(R.id.left_temperature_text_view);
        rightTemperatureTextView = findViewById(R.id.right_temperature_text_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        resultTextView = findViewById(R.id.result_text_view);
        temperatureValueEditText = findViewById(R.id.edit_text);
        leftSpinner = findViewById(R.id.left_spinner);
        rightSpinner = findViewById(R.id.right_spinner);
        temperatureConvertButton = findViewById(R.id.temperature_convert_button);
        temperatureHistoryButton = findViewById(R.id.temperature_history_button);
    }



    private void attachAnimationToViews(){


        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftCurrencyTextViewValue = leftTemperatureTextView.getText().toString();
                String rightCurrencyTextViewValue = rightTemperatureTextView.getText().toString();
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);

                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftTemperatureLayout);
                leftTemperatureTextView.setText(rightCurrencyTextViewValue);
                temperatureValueEditText.setHint("Enter Value ("+leftTemperatureTextView.getText().toString()+")");


                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightTemperatureLayout);

                rightTemperatureTextView.setText(leftCurrencyTextViewValue);
                marqueTextView.setText("Temperature   is   Converted    From   "+leftTemperatureTextView.getText().toString() +      "       To     "+ rightTemperatureTextView.getText().toString()+"                                  ");
                performTemperatureConvertion();
                //this is for audio speech when one click arrowImageView
                playAudioSound();

            }
        });
    }



    private void setAdapterOnSpinner(){
        ArrayAdapter<CharSequence> spinnerLeftArrayAdapter = ArrayAdapter.createFromResource(this,R.array.temperature_units_left,R.layout.spinner_item);
        ArrayAdapter<CharSequence> spinnerRightArrayAdapter = ArrayAdapter.createFromResource(this,R.array.temperature_units_right,R.layout.spinner_item);
        spinnerLeftArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRightArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        leftSpinner.setAdapter(spinnerLeftArrayAdapter);
        rightSpinner.setAdapter(spinnerRightArrayAdapter);
    }



    private class MyLeftSpinnerItemSelected implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            leftTemperatureTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Temperature   is   Converted    From   "+leftTemperatureTextView.getText().toString() +      "       To     "+ rightTemperatureTextView.getText().toString()+"                                  ");
            performTemperatureConvertion();
            temperatureValueEditText.setHint("Enter Value ("+leftTemperatureTextView.getText().toString()+")");
            //this is for audio speech when one select leftSpinnerItem
            playAudioSound();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class MyRightSpinnerItemSelected implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            rightTemperatureTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Temperature   is   Converted    From   "+leftTemperatureTextView.getText().toString() +      "       To     "+ rightTemperatureTextView.getText().toString()+"                                  ");
            performTemperatureConvertion();
            //this is for audio speech when one select rightSpinnerItem
            playAudioSound();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    private class MyTemperatureButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //I call perform temperatureConvertion() method here because I want to perform temperature Convertion when temperatureConvertButton is selected
            //Check if Internet is Available or Not
            if (isInternetAvailable()) {
                //Check if Edit text field is empty or not
                if (temperatureValueEditText.getText().toString().length()>0){
                    //Some Value in edit text
                    performTemperatureConvertion();
                    closeKeyBoard();

                }else {
                    //if Empty
                    Toast.makeText(TemperatureConverterActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
                }
            }else {
                //Internet not Available
                AlertDialogForInternetConnectionError dialog = new AlertDialogForInternetConnectionError();
                dialog.show(getSupportFragmentManager(),"temperature");
            }
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


    private class MyTemperatureHistoryButtonClick implements View.OnClickListener{
        public void onClick(View view){
            //This method is called when frequencyHistoryButton is clicked
            final String activityName = "activity_name";
            final String convertionType = "convertion_type";
            Intent historyIntent = new Intent(TemperatureConverterActivity.this, GeneralHistoryActivity.class);
            historyIntent.putExtra(activityName,"Temperature History");
            historyIntent.putExtra(convertionType,AllTables.ConvertionType.temperature);
            startActivity(historyIntent);

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
            if (temperatureValueEditText.getText().toString().length()==0){
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

        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.temperature);
    }


    private void performTemperatureConvertion(){
        if (temperatureValueEditText.getText().toString().length()>0){
            String leftTemperatureTextViewValue = leftTemperatureTextView.getText().toString();
            String rightTemperatureTextViewValue = rightTemperatureTextView.getText().toString();
            String editTextSting = temperatureValueEditText.getText().toString();
            double userInputData = Double.parseDouble(editTextSting);
            TemperatureConverter temperatureConverter = new TemperatureConverter();
            double resultInDouble = temperatureConverter.getTemperatureConvertResult(leftTemperatureTextViewValue,rightTemperatureTextViewValue,userInputData);
            String result = String.valueOf(resultInDouble);
            if (result.endsWith(".0")){
                //This is because we want to remove .0 if the result contains .0 at last. For example if result is 12.0 ,then we only store 12 in result
                result = result.substring(0,(result.length()-2));
            }
            resultTextView.setVisibility(View.VISIBLE);
            resultTextView.setText(editTextSting+"  "+leftTemperatureTextViewValue+"  =  "+result+"  "+rightTemperatureTextViewValue);
        }

    }



    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftTemperatureTextView.getText().toString();
        String rightTextViewValue = rightTemperatureTextView.getText().toString();
              /*Here I do this because I want to only get units name not it's  short form
                  for Example Hertz (HZ). In this case i only want to get Unit Hertz Not (HZ) and that's why I do following two lines of code */
        leftTextViewValue = leftTextViewValue.substring(0,leftTextViewValue.indexOf(" "));
        rightTextViewValue = rightTextViewValue.substring(0,rightTextViewValue.indexOf(" "));
        String text = "Temperature is converted from "+leftTextViewValue+" to "+rightTextViewValue;
        String soundState = soundStateSharedPreference.getSoundState();
        //The soundState saved in sharedPreference  if enabled then only text to speech converTion is performed
        if(soundState.equalsIgnoreCase(getString(R.string.enable))) {
            textSpeaker.speak(text);
        }
    }





    @Override
    protected void onStart() {
        super.onStart();
        //To changed the state of sound Image Icon in toolbar.Because when we back to our frequency converter Activity from frequency history Activity
        //this is Important
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);
    }



    @Override
    protected void onDestroy() {
        if (textSpeaker != null) {
            //this will release memory of textSpeaker object from Ram. This is Important
            textSpeaker.closeTextSpeaker();
        }
        super.onDestroy();

    }

}
