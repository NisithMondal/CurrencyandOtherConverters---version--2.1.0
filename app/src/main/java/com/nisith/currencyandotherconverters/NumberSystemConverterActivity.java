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
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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

public class NumberSystemConverterActivity extends AppCompatActivity implements OnKeypadDoneButtonClickListener {


    private ImageView arrowImageView;
    private TextView leftNumberSystemTextView,rightNumberSystemTextView;
    private LinearLayout leftNumberSystemLayout,rightNumberSystemLayout;
    private TextView marqueTextView;
    private EditText numberSystemValueEditText;
    private TextView resultTextView;
    private Button numberSystemConvertButton;
    private Button numberSystemHistoryButton;
    private Spinner leftSpinner,rightSpinner;
    // I used sharedPreference to store sound icon state (enable or dissable) instead of using database
    private SoundStateSharedPreference soundStateSharedPreference;
    private ToolbarSoundIconHandaler toolbarSoundIconHandaler;
    private TextSpeaker textSpeaker;
    private ImageView toolbarSoundIconImageView;
    private Toolbar appToolbar;
    private TextView toolbarTitle;
    private FrameLayout frameLayoutForKeypad;
    private View octalViewObjectForKeypad,binaryViewObjectForKeypad,hexaDecimalObjectForKeypad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_system_converetr);
        setConvertionFromXmlToJavaObject();
        marqueTextView.setSelected(true);
        setSupportActionBar(appToolbar);
        setTitle("");
        toolbarTitle.setText("Number System Converter");
        appToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        appToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
                if (frameLayoutForKeypad.getVisibility() == View.VISIBLE)
                {
                    //To hide Binary or Octal Number System Keypad on Back Pressed
                    frameLayoutForKeypad.setVisibility(View.GONE);
                }
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
        marqueTextView.setText("Number System   is   Converted    From   "+leftNumberSystemTextView.getText().toString() +      "       To     "+ rightNumberSystemTextView.getText().toString()+"                                  ");
        numberSystemConvertButton.setOnClickListener(new MyNumberSystemConvertButtonClick());
        numberSystemHistoryButton.setOnClickListener(new MyNumberSystemHistoryButtonClick());
        numberSystemValueEditText.addTextChangedListener(new MyTextWatcher());
        resultTextView.addTextChangedListener(new MyResultTextViewTextWatcher());
        toolbarSoundIconImageView.setOnClickListener(toolbarSoundIconHandaler);
        //The following code is for different number System keypad handeling
        BinaryNumberSystemKeypadHandeler binaryNumberSystemKeypadHandeler = new BinaryNumberSystemKeypadHandeler(this,numberSystemValueEditText);
        OctalNumberSystemKeypadHandeler octalNumberSystemKeypadHandeler = new OctalNumberSystemKeypadHandeler(this,numberSystemValueEditText);
        HexaDecimalNumberSystemKeypadHandeler hexaDecimalNumberSystemKeypadHandeler = new HexaDecimalNumberSystemKeypadHandeler(this,numberSystemValueEditText);
         octalViewObjectForKeypad = octalNumberSystemKeypadHandeler.getView();
         binaryViewObjectForKeypad = binaryNumberSystemKeypadHandeler.getView();
         hexaDecimalObjectForKeypad = hexaDecimalNumberSystemKeypadHandeler.getView();
         numberSystemValueEditText.setOnClickListener(new MyNumberSystemEditTextClick());
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
        frameLayoutForKeypad = findViewById(R.id.frame_layout);
        leftNumberSystemLayout = findViewById(R.id.left_number_system_layout);
        rightNumberSystemLayout = findViewById(R.id.right_number_system_layout);
        leftNumberSystemTextView = findViewById(R.id.left_number_system_text_view);
        rightNumberSystemTextView = findViewById(R.id.right_number_system_text_view);
        marqueTextView = findViewById(R.id.marque_text_view);
        numberSystemValueEditText = findViewById(R.id.edit_text);
        leftSpinner = findViewById(R.id.left_spinner);
        rightSpinner = findViewById(R.id.right_spinner);
        resultTextView = findViewById(R.id.result_text_view);
        numberSystemConvertButton = findViewById(R.id.number_system_convert_button);
        numberSystemHistoryButton = findViewById(R.id.number_system_history_button);

    }





    private void attachAnimationToViews(){


        arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String leftCurrencyTextViewValue = leftNumberSystemTextView.getText().toString();
                String rightCurrencyTextViewValue = rightNumberSystemTextView.getText().toString();
                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(arrowImageView);

                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(leftNumberSystemLayout);
                leftNumberSystemTextView.setText(rightCurrencyTextViewValue);
                numberSystemValueEditText.setHint("Enter Value ("+leftNumberSystemTextView.getText().toString()+")");


                YoYo.with(Techniques.RotateIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(rightNumberSystemLayout);

                rightNumberSystemTextView.setText(leftCurrencyTextViewValue);
                marqueTextView.setText("Number System   is   Converted    From   "+leftNumberSystemTextView.getText().toString() +      "       To     "+ rightNumberSystemTextView.getText().toString()+"                                  ");
                //this is for audio speech when one click arrowImageView
                playAudioSound();
                //The following code is because if anybody click arrow image view the both keypad will invisible
                closeKeyBoard();
                //To Clear all input user data from edit text
                numberSystemValueEditText.setText("");
                //To show Left Spinner Specified number System Keyboard
                numberSystemKeyPadCotroller();


            }
        });
    }




    private void setAdapterOnSpinner(){
        ArrayAdapter<CharSequence> spinnerLeftArrayAdapter = ArrayAdapter.createFromResource(this,R.array.number_system_units_left,R.layout.spinner_item);
        ArrayAdapter<CharSequence> spinnerRightArrayAdapter = ArrayAdapter.createFromResource(this,R.array.number_system_units_right,R.layout.spinner_item);
        spinnerLeftArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRightArrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        leftSpinner.setAdapter(spinnerLeftArrayAdapter);
        rightSpinner.setAdapter(spinnerRightArrayAdapter);
    }

    @Override
    public void onKeypadDoneButtonClick() {
        //This callback method will executed when binary,octal,hexadecimal number System keypad done button is clicked
        frameLayoutForKeypad.setVisibility(View.GONE);
    }


    private class MyLeftSpinnerItemSelected implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            leftNumberSystemTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Number System   is   Converted    From   "+leftNumberSystemTextView.getText().toString() +      "       To     "+ rightNumberSystemTextView.getText().toString()+"                                  ");
            numberSystemValueEditText.setHint("Enter Value ("+leftNumberSystemTextView.getText().toString()+")");
            //this is for audio speech when one select leftSpinnerItem
            playAudioSound();
            //The following code is because if anybody select an item in left spinner ,then both keypad will invisible.
            closeKeyBoard();
            //To Clear all input user data from edit text
            numberSystemValueEditText.setText("");
            //To show Left Spinner Specified number System Keyboard
            numberSystemKeyPadCotroller();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    private class MyRightSpinnerItemSelected implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            rightNumberSystemTextView.setText(parent.getItemAtPosition(position).toString());
            marqueTextView.setText("Number System   is   Converted    From   "+leftNumberSystemTextView.getText().toString() +      "       To     "+ rightNumberSystemTextView.getText().toString()+"                                  ");
            performNumberSystemConvertion();
            //this is for audio speech when one select rightSpinnerItem
            playAudioSound();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }






    private class MyNumberSystemConvertButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //I call perform numberSystemConvertion() method here because I want to perform numberSystem Convertion when numberSystemConvertButton is selected
            //Check if Internet is Available or Not
            if (isInternetAvailable()) {
                //Check if Edit text field is empty or not
                if (numberSystemValueEditText.getText().toString().length()>0){
                    //Some Value in edit text
                    performNumberSystemConvertion();
                    closeKeyBoard();

                }else {
                    //if Empty
                    Toast.makeText(NumberSystemConverterActivity.this, "Please Enter Value in Text Filed", Toast.LENGTH_SHORT).show();
                }
            }else {
                //Internet not Available
                AlertDialogForInternetConnectionError dialog = new AlertDialogForInternetConnectionError();
                dialog.show(getSupportFragmentManager(),"numberSystem");
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



    private class MyNumberSystemHistoryButtonClick implements View.OnClickListener{
        public void onClick(View view){
            //This method is called when numberSystemHistoryButton is clicked
            final String activityName = "activity_name";
            final String convertionType = "convertion_type";
            Intent historyIntent = new Intent(NumberSystemConverterActivity.this, GeneralHistoryActivity.class);
            historyIntent.putExtra(activityName,"Number System History");
            historyIntent.putExtra(convertionType,AllTables.ConvertionType.number_system);
            startActivity(historyIntent);

        }
    }


    private class MyTextWatcher implements TextWatcher {

        //text watcher for Edit Text
        String beforeTextChangedValue = "";
        CustomKeypadValueChecking customKeypadValueChecking = new CustomKeypadValueChecking();

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //Store edit Text Value before text Changed
            beforeTextChangedValue = s.toString();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //Call decimalNumberKeypadTotalEnteringCharacterChecking() method
            boolean isOK = decimalNumberKeypadTotalEnteringCharacterChecking(beforeTextChangedValue,s);
            if (! isOK){
                //if is not ok then return i.e. finish this method here.
                return;
            }
            //To get editText String
            String editTextText = s.toString();
            //To get leftNumberSystemTextViewValue selected value.
            String leftNumberSystemTextViewValue = leftNumberSystemTextView.getText().toString();
            if (leftNumberSystemTextViewValue.equalsIgnoreCase("BINARY") && editTextText.length()>0 && count==1){
                //if count=1 means user enter value in edit text. If count=0 means character is removed from edit text.
                //To Get the recent Entered Character in EditText.
                String enteredCharacter = String.valueOf(s.charAt(start));
                boolean isOk = customKeypadValueChecking.isBinaryKeypadEnteringValueOK(enteredCharacter);
                if (! isOk) {
                    //If Entered Character is Not Ok, then do the following
                    //Set the edit text whatever was before editText text changed i.e. the set the value of beforeEditTextChangeString.
                    numberSystemValueEditText.setText(beforeTextChangedValue);
                    Toast.makeText(NumberSystemConverterActivity.this, "Enter Only Binary Number i.e. '1' or '0'", Toast.LENGTH_SHORT).show();
                    //if is not ok then return ,i.e. finish this method here.
                    return;
                }

            }else if (leftNumberSystemTextViewValue.equalsIgnoreCase("OCTAL") && editTextText.length()>0 && count==1){
                //if count=1 means user enter value in edit text. If count=0 means character is removed from edit text.
                //To Get the recent Entered Character in EditText.
                String enteredCharacter = String.valueOf(s.charAt(start));
                boolean isOk = customKeypadValueChecking.isOctalKeypadEnteringValueOK(enteredCharacter);
                if (! isOk) {
                    //If Entered Character is Not Ok, then do the following
                    //Set the edit text whatever was before editText text changed i.e. the set the value of beforeEditTextChangeString.
                    numberSystemValueEditText.setText(beforeTextChangedValue);
                    Toast.makeText(NumberSystemConverterActivity.this, "Enter Only Octal Numbers i.e. from '0' To '7'", Toast.LENGTH_SHORT).show();
                    //if is not ok then return ,i.e. finish this method here.
                    return;
                }
            }else if (leftNumberSystemTextViewValue.equalsIgnoreCase("HexaDecimal") && editTextText.length()>0 && count==1){
                //To Get the recent Entered Character in EditText.
                String enteredCharacter = String.valueOf(s.charAt(start));
                //Check If the entered character is equal to point(.) and the EditText does not contains any point before Edit Text Text changed
                if (enteredCharacter.equalsIgnoreCase(".") && beforeTextChangedValue.contains(".")){
                    //Set the edit text whatever was before editText text changed i.e. set the value of beforeEditTextChangeString.
                    numberSystemValueEditText.setText(beforeTextChangedValue);
                    return;
                }
                //Check the entered Character in EditText isOk or not
                boolean isOk = customKeypadValueChecking.isHexaDecimalKeypadEnteringValueOK(enteredCharacter);
                if (! isOk) {
                    //If Entered Character is Not Ok, then do the following
                    //Set the edit text whatever was before editText text changed i.e. set the value of beforeEditTextChangeString.
                    numberSystemValueEditText.setText(beforeTextChangedValue);
                    Toast.makeText(NumberSystemConverterActivity.this, "Enter Only HexaDecimal Numbers i.e. from '0' To '9' and 'A','B','C','D','E','F'", Toast.LENGTH_SHORT).show();
                    //if is not ok then return ,i.e. finish this method here.
                    return;
                }
            }

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
            if (numberSystemValueEditText.getText().toString().length()==0){
                resultTextView.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    }


    private boolean decimalNumberKeypadTotalEnteringCharacterChecking(String beforeEditTextChangeString,CharSequence s){
        /*If the leftNumberSystemTextView selected value is "DECIMAL" ,then this Method checked
          if  total number of Character before Point in EditText is more than 16 or not. This Restriction is Because in Decimal to Other Converter
          can handel maximum 16 digits before point otherwise it will arise an error. After point There is no Digits Limits. That's why we only
          handel before point digits.This Method will return false only when the Total Number of Digits before Point will greater than 16.  */
        boolean isOk = true;
        String editTextText = s.toString();
        /* Checked if the leftNumberSystemTextView selected value is "DECIMAL" and if EditText total Digits is more than 15 ,then This condition will true
           Here we use editTextText.length() >15 because if total number of Digits is less than 15 or less, there is no meaning of checking
           this Condition. */
        if (leftNumberSystemTextView.getText().toString().equalsIgnoreCase("decimal") && editTextText.length() >15) {
            //If The editTextText contains point(.), then this condition will true
            if (editTextText.contains(".")) {
                int length = editTextText.substring(0,editTextText.indexOf(".")).length();
                //If length of Digits before Point is more then 16.
                if (length>16){
                    //Set the edit text whatever was before editText text changed i.e. the set the value of beforeEditTextChangeString.
                    numberSystemValueEditText.setText(beforeEditTextChangeString);
                    Toast.makeText(NumberSystemConverterActivity.this, "Maximum 16 Digits is Possible Before Point", Toast.LENGTH_SHORT).show();
                    isOk = false;
                }
            } else {
                //If editTextText does not contains any point(.), then this condition will true
                if (editTextText.length()>16){
                    numberSystemValueEditText.setText(beforeEditTextChangeString);
                    Toast.makeText(NumberSystemConverterActivity.this, "Maximum 16 Digits is Possible Before Point", Toast.LENGTH_SHORT).show();
                    isOk = false;
                }
            }
        }
        return isOk;
    }


    private class MyNumberSystemEditTextClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //If anybody click on Edit text, then.........
            numberSystemKeyPadCotroller();

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

        myDatabaseHelper.insertDataToDatabase(convertionText,currentDate,currentTime,AllTables.ConvertionType.number_system);
    }



    private void performNumberSystemConvertion(){
        //Check internet is Available or not
        if (isInternetAvailable()) {
            if (numberSystemValueEditText.getText().toString().length() > 0) {
                String leftNumberSystemTextViewValue = leftNumberSystemTextView.getText().toString();
                String rightNumberSystemTextViewValue = rightNumberSystemTextView.getText().toString();
                String userInputData = numberSystemValueEditText.getText().toString();
                if (userInputData.length() == 1 && userInputData.equalsIgnoreCase(".")){
                    Toast.makeText(this, "Enter more Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                NumberSystemConverter numberSystemConverter = new NumberSystemConverter();
                String result = numberSystemConverter.getNumberSystemConvertResult(leftNumberSystemTextViewValue, rightNumberSystemTextViewValue, userInputData);
                ////
                if (result.endsWith(".0")) {
                    //This is because we want to remove .0 if the result contains .0 at last. For example if result is 12.0 ,then we only store 12 in result
                    result = result.substring(0, (result.length() - 2));
                }

                resultTextView.setVisibility(View.VISIBLE);
                resultTextView.setText(userInputData + "    in " + leftNumberSystemTextViewValue + "  =  " + result + "    in " + rightNumberSystemTextViewValue);
            }
        } else {
            //Internet is not available then,
            resultTextView.setVisibility(View.INVISIBLE);
        }

    }


    private void playAudioSound(){
        //this function convert text to audio sound
        String leftTextViewValue = leftNumberSystemTextView.getText().toString();
        String rightTextViewValue = rightNumberSystemTextView.getText().toString();
        String text = "Number System is converted from "+leftTextViewValue+" to "+rightTextViewValue;
        String soundState = soundStateSharedPreference.getSoundState();
        if(soundState.equalsIgnoreCase(getString(R.string.enable))) {
            //The soundState saved in sharedPreference  if enabled then only text to speech converTion is performed
            textSpeaker.speak(text);
        }
    }


    private void numberSystemKeyPadCotroller(){
        //This method Controll the different number Systems like binary,decimal,octal etc. different KeyPad....
        //Here we visible the frame layout
        frameLayoutForKeypad.setVisibility(View.VISIBLE);
        String text = leftNumberSystemTextView.getText().toString();
        if (text.equalsIgnoreCase("Binary")){
            numberSystemValueEditText.setInputType(EditorInfo.TYPE_NUMBER_FLAG_DECIMAL | EditorInfo.TYPE_CLASS_NUMBER);
            //If left number system Text view is selected as Binary then......
            closeKeyBoard();
            /*If the binary view is already added to parent view i.e. frame Layout , then remove the view from parent layout and then again add the view
             to frame Layout. Otherwise it throws an Exception. */
            frameLayoutForKeypad.removeView(binaryViewObjectForKeypad);
            frameLayoutForKeypad.addView(binaryViewObjectForKeypad);
        }else if (text.equalsIgnoreCase("Octal")){
            numberSystemValueEditText.setInputType(EditorInfo.TYPE_NUMBER_FLAG_DECIMAL | EditorInfo.TYPE_CLASS_NUMBER);
            //If left number system Text view is selected as Octal then......
            closeKeyBoard();
            /*If the octal view is already added to parent view i.e. frame Layout , then remove the view from parent layout and then again add the view
             to frame Layout. Otherwise it throws an Exception. */
            frameLayoutForKeypad.removeView(octalViewObjectForKeypad);
            frameLayoutForKeypad.addView(octalViewObjectForKeypad);

        }else if (text.equalsIgnoreCase("HexaDecimal")){
            numberSystemValueEditText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
            //If left number system Text view is selected as HexaDecimal then......
            closeKeyBoard();
            /*If the hexaDecimal view is already added to parent view i.e. frame Layout , then remove the view from parent layout and then again add the view
             to frame Layout. Otherwise it throws an Exception. */
            frameLayoutForKeypad.removeView(hexaDecimalObjectForKeypad);
            frameLayoutForKeypad.addView(hexaDecimalObjectForKeypad);

        }else {
            numberSystemValueEditText.setInputType(EditorInfo.TYPE_NUMBER_FLAG_DECIMAL | EditorInfo.TYPE_CLASS_NUMBER);//////////////////////////////////////////debug////////
            openKeyBoard();
            //If left number system Text view is selected as Decimal then......
            if (frameLayoutForKeypad.getVisibility() == View.VISIBLE)
            {
                //To hide Binary or Octal Number System Keypad on Back Pressed
                frameLayoutForKeypad.setVisibility(View.GONE);
            }
        }
    }



    private void openKeyBoard(){
        //Open System key Board
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(view,0);
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

    @Override
    public void onBackPressed() {
        if (frameLayoutForKeypad.getVisibility() == View.VISIBLE)
        {
            //To hide Binary or Octal Number System Keypad on Back Pressed
            frameLayoutForKeypad.setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }
    }
}
