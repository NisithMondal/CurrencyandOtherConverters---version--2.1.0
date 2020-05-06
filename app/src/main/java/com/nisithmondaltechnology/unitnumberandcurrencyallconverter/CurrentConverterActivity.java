package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentConverterActivity extends AppCompatActivity {

    private ImageView arrowImageView;
    private TextView leftCurrentTextView,rightCurrentTextView;
    private LinearLayout leftCurrentLayout,rightCurrentLayout;
    private TextView marqueTextView;
    private TextView resultTextView;
    private EditText currentValueEditText;
    private Spinner leftSpinner,rightSpinner;
    private Button currentConvertButton;
    private Button currentHistoryButton;
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
        setContentView(R.layout.activity_current_converter);
        setConvertionFromXmlToJavaObject();//initalized objects
        marqueTextView.setSelected(true);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("Current Converter");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                closeKeyBoard();
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
        marqueTextView.setText("Electric Current   is   Converted    From   "+leftCurrentTextView.getText().toString() +      "       To     "+ rightCurrentTextView.getText().toString()+"                                  ");
        currentConvertButton.setOnClickListener(new MyCurrentButtonClick());
        currentHistoryButton.setOnClickListener(new MyCurrentHistoryButtonClick());
        currentValueEditText.addTextChangedListener(new MyTextWatcher());
        resultTextView.addTextChangedListener(new MyResultTextViewTextWatcher());
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);
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
        leftCurrentLayout = findViewById(R.id.left_current_layout);
        rightCurrentLayout = findViewById(R.id.right_current_layout);
        leftCurrentTextView = findViewById(R.id.left_current_text_view);
        rightCurrentTextView = findViewById(R.id.right_current_text_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        resultTextView = findViewById(R.id.result_text_view);
        currentValueEditText = findViewById(R.id.edit_text);
        leftSpinner = findViewById(R.id.left_spinner);
        rightSpinner = findViewById(R.id.right_spinner);
        currentConvertButton = findViewById(R.id.current_convert_button);
        currentHistoryButton = findViewById(R.id.current_history_button);
    }




    private void attachAnimationToViews(){


        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftCurrencyTextViewValue = leftCurrentTextView.getText().toString();
                String rightCurrencyTextViewValue = rightCurrentTextView.getText().toString();
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);

                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftCurrentLayout);
                leftCurrentTextView.setText(rightCurrencyTextViewValue);
                currentValueEditText.setHint("Enter Value ("+leftCurrentTextView.getText().toString()+")");


                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightCurrentLayout);

                rightCurrentTextView.setText(leftCurrencyTextViewValue);
                marqueTextView.setText("Electric Current   is   Converted    From   "+leftCurrentTextView.getText().toString() +      "       To     "+ rightCurrentTextView.getText().toString()+"                                  ");
                performCutrrentConversion();
                //this is for audio speech when one click arrowImageView
                playAudioSound();

            }
        });
    }




    private void setAdapterOnSpinner(){
        ArrayAdapter<CharSequence> spinnerLeftArrayAdapter = ArrayAdapter.createFromResource(this,R.array.current_units_left,R.layout.spinner_item);
        ArrayAdapter<CharSequence> spinnerRightArrayAdapter = ArrayAdapter.createFromResource(this,R.array.current_units_right,R.layout.spinner_item);
        spinnerLeftArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRightArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        leftSpinner.setAdapter(spinnerLeftArrayAdapter);
        rightSpinner.setAdapter(spinnerRightArrayAdapter);
    }


    private class MyLeftSpinnerItemSelected implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            leftCurrentTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Electric Current    is   Converted    From   "+leftCurrentTextView.getText().toString() +      "       To     "+ rightCurrentTextView.getText().toString()+"                                  ");
            performCutrrentConversion();
            currentValueEditText.setHint("Enter Value ("+leftCurrentTextView.getText().toString()+")");
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
            rightCurrentTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Electric Current    is   Converted    From   "+leftCurrentTextView.getText().toString() +      "       To     "+ rightCurrentTextView.getText().toString()+"                                  ");
            performCutrrentConversion();
            //this is for audio speech when one select rightSpinnerItem
            playAudioSound();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }




    private class MyCurrentButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //I call perform temperatureConvertion() method here because I want to perform temperature Convertion when temperatureConvertButton is selected
            //Check if Internet is Available or Not
            if (isInternetAvailable()) {
                //Check if Edit text field is empty or not
                if (currentValueEditText.getText().toString().length()>0){
                    //Some Value in edit text
                    performCutrrentConversion();
                    closeKeyBoard();

                }else {
                    //if Empty
                    Toast.makeText(CurrentConverterActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
                }
            }else {
                //Internet not Available
                AlertDialogForInternetConnectionError dialog = new AlertDialogForInternetConnectionError();
                dialog.show(getSupportFragmentManager(),"current");
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


    private class MyCurrentHistoryButtonClick implements View.OnClickListener{
        public void onClick(View view){
            //This method is called when frequencyHistoryButton is clicked
            final String activityName = "activity_name";
            final String conversionType = "convertion_type";
            Intent historyIntent = new Intent(CurrentConverterActivity.this, GeneralHistoryActivity.class);
            historyIntent.putExtra(activityName,"Current History");
            historyIntent.putExtra(conversionType,AllTables.ConvertionType.current);
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
            if (currentValueEditText.getText().toString().length()==0){
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
        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.current);
    }



    private void performCutrrentConversion(){
        //Check internet is Available or not
        if (isInternetAvailable()) {
            if (currentValueEditText.getText().toString().length() > 0) {
                String leftCurrentTextViewValue = leftCurrentTextView.getText().toString();
                String rightCurrentTextViewValue = rightCurrentTextView.getText().toString();
                String editTextSting = currentValueEditText.getText().toString();
                if (editTextSting.length() == 1 && editTextSting.equalsIgnoreCase(".")){
                    Toast.makeText(this, "Enter more Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                double userInputData = Double.parseDouble(editTextSting);
                CurrentConverter currentConverter = new CurrentConverter();
                double resultInDouble = currentConverter.getResistanceConvertResult(leftCurrentTextViewValue, rightCurrentTextViewValue, userInputData);
                String result = String.valueOf(resultInDouble);
                if (result.endsWith(".0")) {
                    //This is because we want to remove .0 if the result contains .0 at last. For example if result is 12.0 ,then we only store 12 in result
                    result = result.substring(0, (result.length() - 2));
                }
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(editTextSting + "  " + leftCurrentTextViewValue + "  =  " + result + "  " + rightCurrentTextViewValue);
            }
        }else {
            //Internet is not available then,
            resultTextView.setVisibility(View.INVISIBLE);
        }

    }



    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftCurrentTextView.getText().toString();
        String rightTextViewValue = rightCurrentTextView.getText().toString();
        String text = "Electric Current  is converted from "+leftTextViewValue+" to "+rightTextViewValue;
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
