package com.nisith.currencyandotherconverters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

public class PressureConverterActivity extends AppCompatActivity {

    private ImageView arrowImageView;
    private TextView leftPressureTextView,rightPressureTextView;
    private LinearLayout leftPressureLayout,rightPressureLayout;
    private TextView marqueTextView;
    private TextView resultTextView;
    private EditText pressureValueEditText;
    private Spinner leftSpinner,rightSpinner;
    private Button pressureConvertButton;
    private Button pressureHistoryButton;
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
        setContentView(R.layout.activity_pressure_converter);
        setConvertionFromXmlToJavaObject();
        marqueTextView.setSelected(true);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("Pressure Converter");
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
        marqueTextView.setText("Pressure   is   Converted    From   "+leftPressureTextView.getText().toString() +      "       To     "+ rightPressureTextView.getText().toString()+"                                  ");
        pressureConvertButton.setOnClickListener(new MyPressureConvertButtonClick());
        pressureValueEditText.addTextChangedListener(new MyTextWatcher());


        pressureHistoryButton.setOnClickListener(new MySpeedHistoryButtonClick());
        resultTextView.addTextChangedListener(new MyResultTextViewTextWatcher());
        textSpeaker = new TextSpeaker(getApplicationContext());// initalization of textSpeaker
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
        leftPressureLayout = findViewById(R.id.left_pressure_layout);
        rightPressureLayout = findViewById(R.id.right_pressure_layout);
        leftPressureTextView = findViewById(R.id.left_pressure_text_view);
        rightPressureTextView = findViewById(R.id.right_pressure_text_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        resultTextView = findViewById(R.id.result_text_view);
        pressureValueEditText = findViewById(R.id.edit_text);
        leftSpinner = findViewById(R.id.left_spinner);
        rightSpinner = findViewById(R.id.right_spinner);
        pressureConvertButton = findViewById(R.id.pressure_convert_button);
        pressureHistoryButton = findViewById(R.id.pressure_history_button);


    }



    private void attachAnimationToViews(){


        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftPressureTextViewValue = leftPressureTextView.getText().toString();
                String rightPressureTextViewValue = rightPressureTextView.getText().toString();
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);

                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftPressureLayout);
                leftPressureTextView.setText(rightPressureTextViewValue);
                pressureValueEditText.setHint("Enter Value ("+leftPressureTextView.getText().toString()+")");


                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightPressureLayout);

                rightPressureTextView.setText(leftPressureTextViewValue);
                marqueTextView.setText("Pressure   is   Converted    From   "+leftPressureTextView.getText().toString() +      "       To     "+ rightPressureTextView.getText().toString()+"                                  ");
                performPressureConvertion();

                //this is for audio speech when one click arrowImageView
                playAudioSound();

            }
        });
    }


    private void setAdapterOnSpinner(){
        ArrayAdapter<CharSequence> spinnerLeftArrayAdapter = ArrayAdapter.createFromResource(this,R.array.pressure_units_left,R.layout.spinner_item);
        ArrayAdapter<CharSequence> spinnerRightArrayAdapter = ArrayAdapter.createFromResource(this,R.array.pressure_units_right,R.layout.spinner_item);
        spinnerLeftArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRightArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        leftSpinner.setAdapter(spinnerLeftArrayAdapter);
        rightSpinner.setAdapter(spinnerRightArrayAdapter);
    }




    private class MyLeftSpinnerItemSelected implements AdapterView.OnItemSelectedListener{


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            leftPressureTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Pressure   is   Converted    From   "+leftPressureTextView.getText().toString() +      "       To     "+ rightPressureTextView.getText().toString()+"                                  ");
            performPressureConvertion();
            pressureValueEditText.setHint("Enter Value ("+leftPressureTextView.getText().toString()+")");
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
            rightPressureTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Pressure   is   Converted    From   "+leftPressureTextView.getText().toString() +      "       To     "+ rightPressureTextView.getText().toString()+"                                  ");
            performPressureConvertion();
            //this is for audio speech when one select rightSpinnerItem
            playAudioSound();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    private class MyPressureConvertButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            performPressureConvertion();
            if (pressureValueEditText.getText().toString().length()==0){
                Toast.makeText(PressureConverterActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
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
            Intent historyIntent = new Intent(PressureConverterActivity.this, GeneralHistoryActivity.class);
            historyIntent.putExtra(activityName,"Pressure History");
            historyIntent.putExtra(convertionType,AllTables.ConvertionType.pressure);
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
            if (pressureValueEditText.getText().toString().length()==0){
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

        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.pressure);
    }



    private void performPressureConvertion(){
        if (pressureValueEditText.getText().toString().length()>0){
            String leftPressureTextViewValue = leftPressureTextView.getText().toString();
            String rightPressureTextViewValue = rightPressureTextView.getText().toString();
            double userInputData = Double.parseDouble(pressureValueEditText.getText().toString());
            PressureConverter pressureConverter = new PressureConverter();
            double result = pressureConverter.getLengthConvertResult(leftPressureTextViewValue,rightPressureTextViewValue,userInputData);
            resultTextView.setVisibility(View.VISIBLE);
            resultTextView.setText(userInputData+"  "+leftPressureTextViewValue+"  =  "+result+"  "+rightPressureTextViewValue);
        }

    }

    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftPressureTextView.getText().toString();
        String rightTextViewValue = rightPressureTextView.getText().toString();
        String text = "Pressure is converted from "+leftTextViewValue+" to "+rightTextViewValue;
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
