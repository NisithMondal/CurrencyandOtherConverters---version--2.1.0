package com.nisith.currencyandotherconverters;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
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

public class SpeedConverterActivity extends AppCompatActivity {

    private ImageView arrowImageView;
    private TextView leftSpeedTextView,rightSpeedTextView;
    private LinearLayout leftSpeedLayout,rightSpeedLayout;
    private TextView marqueTextView;
    private TextView resultTextView;
    private EditText speedValueEditText;
    private Spinner leftSpinner,rightSpinner;
    private Button speedConvertButton;
    private Button speedHistoryButton;
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
        setContentView(R.layout.activity_speed_converter);
        setConvertionFromXmlToJavaObject();
        marqueTextView.setSelected(true);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("Speed Converter");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
                finish();
            }
        });
        soundStateSharedPreference = new SoundStateSharedPreference(this);
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);//set toolbar sound icon state(voume off or volume on) at the begining of this activity
        attachAnimationToViews();
        setAdapterOnSpinner();
        leftSpinner.setOnItemSelectedListener(new MyLeftSpinnerItemSelected());
        rightSpinner.setOnItemSelectedListener(new MyRightSpinnerItemSelected());
        marqueTextView.setText("Speed   is   Converted    From   "+leftSpeedTextView.getText().toString() +      "       To     "+ rightSpeedTextView.getText().toString()+"                                  ");
        speedConvertButton.setOnClickListener(new MySpeedConvertButtonClick());
        speedValueEditText.addTextChangedListener(new MyTextWatcher());

        speedHistoryButton.setOnClickListener(new MySpeedHistoryButtonClick());
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
        leftSpeedLayout = findViewById(R.id.left_speed_layout);
        rightSpeedLayout = findViewById(R.id.right_speed_layout);
        leftSpeedTextView = findViewById(R.id.left_speed_text_view);
        rightSpeedTextView = findViewById(R.id.right_speed_text_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        resultTextView = findViewById(R.id.result_text_view);
        speedValueEditText = findViewById(R.id.edit_text);
        leftSpinner = findViewById(R.id.left_spinner);
        rightSpinner = findViewById(R.id.right_spinner);
        speedConvertButton = findViewById(R.id.speed_convert_button);
        speedHistoryButton = findViewById(R.id.speed_history_button);


    }



    private void attachAnimationToViews(){


        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftFrequencyTextViewValue = leftSpeedTextView.getText().toString();
                String rightFrequencyTextViewValue = rightSpeedTextView.getText().toString();
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);

                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftSpeedLayout);
                leftSpeedTextView.setText(rightFrequencyTextViewValue);
                speedValueEditText.setHint("Enter Value ("+leftSpeedTextView.getText().toString()+")");


                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightSpeedLayout);

                rightSpeedTextView.setText(leftFrequencyTextViewValue);
                marqueTextView.setText("Frequency   is   Converted    From   "+leftSpeedTextView.getText().toString() +      "       To     "+ rightSpeedTextView.getText().toString()+"                                  ");
                performSpeedConvertion();
                //this is for audio speech when one click arrowImageView
                playAudioSound();

            }
        });
    }



    private void setAdapterOnSpinner(){
        ArrayAdapter<CharSequence> spinnerLeftArrayAdapter = ArrayAdapter.createFromResource(this,R.array.speed_units_left,R.layout.spinner_item);
        ArrayAdapter<CharSequence> spinnerRightArrayAdapter = ArrayAdapter.createFromResource(this,R.array.speed_units_right,R.layout.spinner_item);
        spinnerLeftArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRightArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        leftSpinner.setAdapter(spinnerLeftArrayAdapter);
        rightSpinner.setAdapter(spinnerRightArrayAdapter);
    }


    private class MyLeftSpinnerItemSelected implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            leftSpeedTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Speed   is   Converted    From   "+leftSpeedTextView.getText().toString() +      "       To     "+ rightSpeedTextView.getText().toString()+"                                  ");
            performSpeedConvertion();
            speedValueEditText.setHint("Enter Value ("+leftSpeedTextView.getText().toString()+")");
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

            rightSpeedTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Speed   is   Converted    From   "+leftSpeedTextView.getText().toString() +      "       To     "+ rightSpeedTextView.getText().toString()+"                                  ");
            performSpeedConvertion();

            //this is for audio speech when one select rightSpinnerItem
            playAudioSound();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    private class MySpeedConvertButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            performSpeedConvertion();
            if (speedValueEditText.getText().toString().length()==0){
                Toast.makeText(SpeedConverterActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
            }else {
                closeKeyBoard();
            }

        }
    }

    private class MySpeedHistoryButtonClick implements View.OnClickListener{
        public void onClick(View view){
            //This method is called when frequencyHistoryButton is clicked
            final String activityName = "activity_name";
            final String convertionType = "convertion_type";
            Intent historyIntent = new Intent(SpeedConverterActivity.this, GeneralHistoryActivity.class);
            historyIntent.putExtra(activityName,"speed History");
            historyIntent.putExtra(convertionType,AllTables.ConvertionType.speed);
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
                textSpeaker.speakLastCharacterOfEditText(String.valueOf(s));
            }
            if (speedValueEditText.getText().toString().length()==0){
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

        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.speed);
    }



    private void performSpeedConvertion(){
        if (speedValueEditText.getText().toString().length()>0){
            String leftSpeedTextViewValue = leftSpeedTextView.getText().toString();
            String rightSpeedTextViewValue = rightSpeedTextView.getText().toString();
            double userInputData = Double.parseDouble(speedValueEditText.getText().toString());
            SpeedConverter speedConverter = new SpeedConverter();
            double result = speedConverter.getWeightConvertResult(leftSpeedTextViewValue,rightSpeedTextViewValue,userInputData);
            resultTextView.setVisibility(View.VISIBLE);
            resultTextView.setText(userInputData+"  "+leftSpeedTextViewValue+"  =  "+result+"  "+rightSpeedTextViewValue);
        }

    }

    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftSpeedTextView.getText().toString();
        String rightTextViewValue = rightSpeedTextView.getText().toString();

                /*Here I do this because I want to only get units name not it's  short form
                  for Example Hertz (HZ). In this case i only want to get Unit Hertz Not (HZ) and that's why I do following two lines of code */

        leftTextViewValue = leftTextViewValue.substring(0,leftTextViewValue.indexOf(" "));
        rightTextViewValue = rightTextViewValue.substring(0,rightTextViewValue.indexOf(" "));
        String text = "Speed is converted from "+leftTextViewValue+" to "+rightTextViewValue;
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
