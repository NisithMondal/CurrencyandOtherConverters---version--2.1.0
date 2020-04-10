package com.nisithmondaltechnology.unitnumberandcurrencyallconverter;

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

public class FrequencyConverterActivity extends AppCompatActivity {


    private ImageView arrowImageView;
    private TextView leftFrequencyTextView,rightFrequencyTextView;
    private LinearLayout leftFrequencyLayout,rightFrequencyLayout;
    private TextView marqueTextView;
    private TextView resultTextView;
    private EditText frequencyValueEditText;
    private Spinner leftSpinner,rightSpinner;
    private Button frequencyConvertButton;
    private Button frequencyHistoryButton;
    private TextSpeaker textSpeaker;
    // I used sharedPreference to store sound icon state (enable or dissable) instead of using database
    private SoundStateSharedPreference soundStateSharedPreference;
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private ImageView toolbarSoundIconImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequency_converter);
        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        TextView toolbarTitle = findViewById(R.id.app_toolbar_title);
        toolbarSoundIconImageView = appToolbar.findViewById(R.id.audio_enable_image_view);
        arrowImageView = findViewById(R.id.arrow_image_view);
        leftFrequencyLayout = findViewById(R.id.left_frequency_layout);
        rightFrequencyLayout = findViewById(R.id.right_frequency_layout);
        leftFrequencyTextView = findViewById(R.id.left_frequency_text_view);
        rightFrequencyTextView = findViewById(R.id.right_frequency_text_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        resultTextView = findViewById(R.id.result_text_view);
        frequencyValueEditText = findViewById(R.id.edit_text);
        leftSpinner = findViewById(R.id.left_spinner);
        rightSpinner = findViewById(R.id.right_spinner);
        frequencyConvertButton = findViewById(R.id.frequency_convert_button);
        frequencyHistoryButton = findViewById(R.id.frequency_history_button);
        marqueTextView.setSelected(true);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("Frequency Converter");
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
        textSpeaker = new TextSpeaker(getApplicationContext());// initalization of textSpeaker
        soundStateSharedPreference = new SoundStateSharedPreference(this);
        toolbarSoundIconHandaler = new ToolbarSoundIconHandaler(this,textSpeaker);
        toolbarSoundIconHandaler.setToolbarSoundIconState(toolbarSoundIconImageView);//set toolbar sound icon state(voume off or volume on) at the begining of this activity
        attachAnimationToViews();
        setAdapterOnSpinner();
        leftSpinner.setOnItemSelectedListener(new MyLeftSpinnerItemSelected());
        rightSpinner.setOnItemSelectedListener(new MyRightSpinnerItemSelected());
        marqueTextView.setText("Frequency   is   Converted    From   "+leftFrequencyTextView.getText().toString() +      "       To     "+ rightFrequencyTextView.getText().toString()+"                                  ");
        frequencyConvertButton.setOnClickListener(new MyFrequencyConvertButtonClick());
        frequencyHistoryButton.setOnClickListener(new MyFrequencyHistoryButtonClick());
        frequencyValueEditText.addTextChangedListener(new MyTextWatcher());
        resultTextView.addTextChangedListener(new MyResultTextViewTextWatcher());
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);
        //To show Ads
//        showLargeBannerAd();


    }




    private void showLargeBannerAd(){
        //For showing Large Banner Ads
//        AdView largeBannerAdView = findViewById(R.id.large_banner_ad);
//        largeBannerAdView.loadAd(new AdRequest.Builder().build());
    }





    private void closeKeyBoard(){
        //this method hide the key board on android device if the keyBoard was visible
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }




    private void attachAnimationToViews(){
        /* In this method I attached Animation onto the arrowImageView,leftFrequencyLayout and rightFrequencyLayout */
        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftFrequencyTextViewValue = leftFrequencyTextView.getText().toString();
                String rightFrequencyTextViewValue = rightFrequencyTextView.getText().toString();
                //Here animation is attached to arrowImageView
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);
                //Here animation is attached to leftFrequencyLayout
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftFrequencyLayout);
                leftFrequencyTextView.setText(rightFrequencyTextViewValue);
                frequencyValueEditText.setHint("Enter Value ("+leftFrequencyTextView.getText().toString()+")");

                //Here animation is attached to rightFrequencyLayout
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightFrequencyLayout);

                rightFrequencyTextView.setText(leftFrequencyTextViewValue);
                marqueTextView.setText("Frequency   is   Converted    From   "+leftFrequencyTextView.getText().toString() +      "       To     "+ rightFrequencyTextView.getText().toString()+"                                  ");

                //I call performFrequencyConvertion() method here because I want to perform Frequency Convertion when ArrowImageView is Clicked
                performFrequencyConvertion();
                //this is for audio speech when one click arrowImageView
                  playAudioSound();
            }
        });
    }



    private void setAdapterOnSpinner(){
        /* In this method we add Adapter in left and right spinner */
        ArrayAdapter<CharSequence> spinnerLeftArrayAdapter = ArrayAdapter.createFromResource(this,R.array.frequency_units_left,R.layout.spinner_item);
        ArrayAdapter<CharSequence> spinnerRightArrayAdapter = ArrayAdapter.createFromResource(this,R.array.frequency_units_right,R.layout.spinner_item);
        spinnerLeftArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRightArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        leftSpinner.setAdapter(spinnerLeftArrayAdapter);
        rightSpinner.setAdapter(spinnerRightArrayAdapter);
    }


    private class MyLeftSpinnerItemSelected implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // This method is Called when any left Spinner's Item is selected
            leftFrequencyTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Frequency   is   Converted    From   " + leftFrequencyTextView.getText().toString() + "       To     " + rightFrequencyTextView.getText().toString() + "                                  ");
            //I call performFrequencyConvertion() method here because I want to perform Frequency Convertion when leftSpinner Item is selected
            performFrequencyConvertion();
            //Here Edit text hint is hanged when left Spinner item is changed
            frequencyValueEditText.setHint("Enter Value (" + leftFrequencyTextView.getText().toString() + ")");
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
            // This method is Called when any right Spinner's Item is selected

            rightFrequencyTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Frequency   is   Converted    From   "+leftFrequencyTextView.getText().toString() +      "       To     "+ rightFrequencyTextView.getText().toString()+"                                  ");
            //I call performFrequencyConvertion() method here because I want to perform Frequency Convertion when rightSpinner Item is selected
            performFrequencyConvertion();
            //this is for audio speech when one select rightSpinnerItem
              playAudioSound();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    private class MyFrequencyConvertButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //I call performFrequencyConvertion() method here because I want to perform Frequency Convertion when frequencyConvertButton is selected
           if (isInternetAvailable()) {
               //Check if Edit text field is empty or not
               if (frequencyValueEditText.getText().toString().length()>0){
                   //Some Value in edit text
                   performFrequencyConvertion();
                   closeKeyBoard();

               }else {
                   //if Empty
                   Toast.makeText(FrequencyConverterActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
               }
           }else {
               //Internet not Available
               AlertDialogForInternetConnectionError dialog = new AlertDialogForInternetConnectionError();
               dialog.show(getSupportFragmentManager(),"frequency");
           }
        }
    }




    private class MyFrequencyHistoryButtonClick implements View.OnClickListener{
        public void onClick(View view){
            //This method is called when frequencyHistoryButton is clicked
            final String activityName = "activity_name";
            final String convertionType = "convertion_type";
            Intent historyIntent = new Intent(FrequencyConverterActivity.this, GeneralHistoryActivity.class);
            historyIntent.putExtra(activityName,"Frequency History");
            historyIntent.putExtra(convertionType,AllTables.ConvertionType.frequency);
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
            if (frequencyValueEditText.getText().toString().length()==0){
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



    private void performFrequencyConvertion(){
        //This method perform Frequency Conversion
        //Check internet is Available or not
        if (isInternetAvailable()) {
            if (frequencyValueEditText.getText().toString().length() > 0) {
                //If edit text is not Empty
                String leftFrequencyTextViewValue = leftFrequencyTextView.getText().toString();
                String rightFrequencyTextViewValue = rightFrequencyTextView.getText().toString();
                //whatever Inserted by User in Edit Text Field
                String editTextSting = frequencyValueEditText.getText().toString();
                if (editTextSting.length() == 1 && editTextSting.equalsIgnoreCase(".")){
                    Toast.makeText(this, "Enter more Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                double userInputData = Double.parseDouble(editTextSting);
                //FrequencyConvert class's methods are responsible to perform frequency Convertion. For more Information Go to that class
                FrequencyConverter frequencyConverter = new FrequencyConverter();
                double resultInDouble = frequencyConverter.getFrequencyConvertResult(leftFrequencyTextViewValue, rightFrequencyTextViewValue, userInputData);
                String result = String.valueOf(resultInDouble);
                if (result.endsWith(".0")){
                    //This is because we want to remove .0 if the result contains .0 at last. For example if result is 12.0 ,then we only store 12 in result
                    result = result.substring(0,(result.length()-2));
                }
                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(editTextSting + "  " + leftFrequencyTextViewValue + "  =  " + result + "  " + rightFrequencyTextViewValue);
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

    private void storeDataInDatabase(String convertionText){
        //Just a method to store data in Database
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.getTime());
        SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
        Date date = new Date();
        String currentTime = format.format(date);
        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.frequency);
    }




    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftFrequencyTextView.getText().toString();
        String rightTextViewValue = rightFrequencyTextView.getText().toString();
        /*Here I do this because I want to only get units name not it's  short form
          for Example Hertz (HZ). In this case i only want to get Unit Hertz Not (HZ) and that's why I do following two lines of code */
        leftTextViewValue = leftTextViewValue.substring(0,leftTextViewValue.indexOf(" "));
        rightTextViewValue = rightTextViewValue.substring(0,rightTextViewValue.indexOf(" "));
        String text = "Frequency is converted from "+leftTextViewValue+" to "+rightTextViewValue;
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
