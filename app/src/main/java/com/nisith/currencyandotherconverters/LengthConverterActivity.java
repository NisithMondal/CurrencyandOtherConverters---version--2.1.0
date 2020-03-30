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

public class LengthConverterActivity extends AppCompatActivity {

    private ImageView arrowImageView;
    private TextView leftLengthTextView,rightLengthTextView;
    private LinearLayout leftLengthLayout,rightLengthLayout;
    private TextView marqueTextView;
    private TextView resultTextView;
    private EditText lengthValueEditText;
    private Spinner leftSpinner,rightSpinner;
    private Button lengthConvertButton;
    private Button lengthHistoryButton;
    // I used sharedPreference to store sound icon state (enable or dissable) instead of using database
    private SoundStateSharedPreference soundStateSharedPreference;
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private TextSpeaker textSpeaker;
    private ImageView toolbarSoundIconImageView;
    private Toolbar appToolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_converter);
        setConvertionFromXmlToJavaObject();
        marqueTextView.setSelected(true);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("Length Converter");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
                finish();
            }
        });
        textSpeaker = new TextSpeaker(getApplicationContext());// initalization of textSpeaker
        soundStateSharedPreference = new SoundStateSharedPreference(this);
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this,textSpeaker);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);//set toolbar sound icon state(voume off or volume on) at the begining of this activity
        attachAnimationToViews();
        setAdapterOnSpinner();
        leftSpinner.setOnItemSelectedListener(new MyLeftSpinnerItemSelected());
        rightSpinner.setOnItemSelectedListener(new MyRightSpinnerItemSelected());
        marqueTextView.setText("Length   is   Converted    From   "+leftLengthTextView.getText().toString() +      "       To     "+ rightLengthTextView.getText().toString()+"                                  ");
        lengthConvertButton.setOnClickListener(new MyLengthConvertButtonClick());
        lengthValueEditText.addTextChangedListener(new MyTextWatcher());
        lengthHistoryButton.setOnClickListener(new MyLengthHistoryButtonClick());
        resultTextView.addTextChangedListener(new MyResultTextViewTextWatcher());
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
        leftLengthLayout = findViewById(R.id.left_length_layout);
        rightLengthLayout = findViewById(R.id.right_length_layout);
        leftLengthTextView = findViewById(R.id.left_length_text_view);
        rightLengthTextView = findViewById(R.id.right_length_text_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        lengthValueEditText = findViewById(R.id.edit_text);
        resultTextView = findViewById(R.id.result_text_view);
        leftSpinner = findViewById(R.id.left_spinner);
        rightSpinner = findViewById(R.id.right_spinner);
        lengthConvertButton = findViewById(R.id.length_convert_button);
        lengthHistoryButton = findViewById(R.id.length_history_button);


    }


    private void attachAnimationToViews(){


        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftCurrencyTextViewValue = leftLengthTextView.getText().toString();
                String rightCurrencyTextViewValue = rightLengthTextView.getText().toString();
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);

                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftLengthLayout);
                leftLengthTextView.setText(rightCurrencyTextViewValue);
                lengthValueEditText.setHint("Enter Value ("+leftLengthTextView.getText().toString()+")");


                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightLengthLayout);

                rightLengthTextView.setText(leftCurrencyTextViewValue);
                marqueTextView.setText("Length   is   Converted    From   "+leftLengthTextView.getText().toString() +      "       To     "+ rightLengthTextView.getText().toString()+"                                  ");
                perFormLengthConvertion();
                //this is for audio speech when one click arrowImageView
                playAudioSound();
            }
        });
    }

    private void setAdapterOnSpinner(){
        ArrayAdapter<CharSequence> spinnerLeftArrayAdapter = ArrayAdapter.createFromResource(this,R.array.length_units_left,R.layout.spinner_item);
        ArrayAdapter<CharSequence> spinnerRightArrayAdapter = ArrayAdapter.createFromResource(this,R.array.length_units_right,R.layout.spinner_item);
        spinnerLeftArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRightArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        leftSpinner.setAdapter(spinnerLeftArrayAdapter);
        rightSpinner.setAdapter(spinnerRightArrayAdapter);
    }

    private class MyLeftSpinnerItemSelected implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            leftLengthTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Length   is   Converted    From   "+leftLengthTextView.getText().toString() +      "       To     "+ rightLengthTextView.getText().toString()+"                                  ");
            perFormLengthConvertion();
            lengthValueEditText.setHint("Enter Value ("+leftLengthTextView.getText().toString()+")");
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
            rightLengthTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Length   is   Converted    From   "+leftLengthTextView.getText().toString() +      "       To     "+ rightLengthTextView.getText().toString()+"                                  ");
            perFormLengthConvertion();
            //this is for audio speech when one select rightSpinnerItem
            playAudioSound();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class MyLengthConvertButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //I call perform lengthConvertion() method here because I want to perform length Convertion when lengthConvertButton is selected
            //Check if Internet is Available or Not
            if (isInternetAvailable()) {
                //Check if Edit text field is empty or not
                if (lengthValueEditText.getText().toString().length()>0){
                    //Some Value in edit text
                    perFormLengthConvertion();
                    closeKeyBoard();

                }else {
                    //if Empty
                    Toast.makeText(LengthConverterActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
                }
            }else {
                //Internet not Available
                AlertDialogForInternetConnectionError dialog = new AlertDialogForInternetConnectionError();
                dialog.show(getSupportFragmentManager(),"length");
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



    private class MyLengthHistoryButtonClick implements View.OnClickListener{
        public void onClick(View view){
            //This method is called when frequencyHistoryButton is clicked
            final String activityName = "activity_name";
            final String convertionType = "convertion_type";
            Intent historyIntent = new Intent(LengthConverterActivity.this, GeneralHistoryActivity.class);
            historyIntent.putExtra(activityName,"Length History");
            historyIntent.putExtra(convertionType,AllTables.ConvertionType.length);
            startActivity(historyIntent);

        }
    }





    private class MyTextWatcher implements TextWatcher{

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
            if (lengthValueEditText.getText().toString().length()==0){
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

        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.length);
    }



    private void perFormLengthConvertion(){
        //Check internet is Available or not
        if (isInternetAvailable()) {
            if (lengthValueEditText.getText().toString().length() > 0) {
                String leftLengthTextViewValue = leftLengthTextView.getText().toString();
                String rightLengthTextViewValue = rightLengthTextView.getText().toString();
                String editTextSting = lengthValueEditText.getText().toString();
                double userInputData = Double.parseDouble(editTextSting);
                LengthConverter lengthConverter = new LengthConverter();
                double resultInDouble = lengthConverter.getLengthConvertResult(leftLengthTextViewValue, rightLengthTextViewValue, userInputData);
                String result = String.valueOf(resultInDouble);
                if (result.endsWith(".0")) {
                    //This is because we want to remove .0 if the result contains .0 at last. For example if result is 12.0 ,then we only store 12 in result
                    result = result.substring(0, (result.length() - 2));
                }
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(editTextSting + "  " + leftLengthTextViewValue + "  =  " + result + "  " + rightLengthTextViewValue);
            }
        }else {
            //Internet is not available then,
            resultTextView.setVisibility(View.INVISIBLE);
        }

    }


    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftLengthTextView.getText().toString();
        String rightTextViewValue = rightLengthTextView.getText().toString();
        /*this is for better lesitening exprence . Because if leftTextViewValue or rightTextViewValue is 'm' then audio sound will be only 'm'
           that's why we do this. In this case if value is 'm' then audio will be sounded as meter, 'km' as kiloMeter and likewise.....  */
        if (leftTextViewValue.equalsIgnoreCase("m")){
            leftTextViewValue = "meter";
        } else if (leftTextViewValue.equalsIgnoreCase("cm")){
            leftTextViewValue = "centiMeter";
        }else if (leftTextViewValue.equalsIgnoreCase("km")){
            leftTextViewValue = "kiloMeter";
        }else if (leftTextViewValue.equalsIgnoreCase("mm")){
            leftTextViewValue = "milliMeter";
        }

        if (rightTextViewValue.equalsIgnoreCase("m")){
            rightTextViewValue = "meter";
        } else if (rightTextViewValue.equalsIgnoreCase("cm")){
            rightTextViewValue = "centiMeter";
        }else if (rightTextViewValue.equalsIgnoreCase("km")){
            rightTextViewValue = "kiloMeter";
        }else if (rightTextViewValue.equalsIgnoreCase("mm")){
            rightTextViewValue = "milliMeter";
        }
        String text = "Length is converted from "+leftTextViewValue+" to "+rightTextViewValue;
        String soundState = soundStateSharedPreference.getSoundState();
        if(soundState.equalsIgnoreCase(getString(R.string.enable))) {
            //The soundState saved in sharedPreference  if enabled then only text to speech converTion is performed
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
