package com.nisith.currencyandotherconverters;

import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

//This class handel Octal Number System click Events
public class OctalNumberSystemKeypadHandeler {
    private Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,
                   buttonZero,buttonPoint,buttonCross,buttonDone;
    private RelativeLayout buttonKeyPadLayout;
    private View view;
    private EditText numberSystemValueEditText;
    private OnKeypadDoneButtonClickListener onKeypadDoneButtonClickListener;




    public OctalNumberSystemKeypadHandeler(AppCompatActivity appCompatActivity, EditText numberSystemValueEditText){
        this.numberSystemValueEditText = numberSystemValueEditText;
        this.onKeypadDoneButtonClickListener = (NumberSystemConverterActivity) appCompatActivity;
        LayoutInflater layoutInflater = appCompatActivity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.octal_number_keypad_layout,null,false);
        buttonOne = view.findViewById(R.id.button_one);
        buttonTwo = view.findViewById(R.id.button_two);
        buttonThree = view.findViewById(R.id.button_three);
        buttonFour = view.findViewById(R.id.button_four);
        buttonFive = view.findViewById(R.id.button_five);
        buttonSix = view.findViewById(R.id.button_six);
        buttonSeven = view.findViewById(R.id.button_seven);
        buttonZero = view.findViewById(R.id.button_zero);
        buttonPoint = view.findViewById(R.id.button_point);
        buttonCross = view.findViewById(R.id.button_cross);
        buttonDone = view.findViewById(R.id.button_done);
        buttonKeyPadLayout = view.findViewById(R.id.keypad_layout);
        buttonOne.setOnClickListener(new MyKeypadButtonsClick());
        buttonTwo.setOnClickListener(new MyKeypadButtonsClick());
        buttonThree.setOnClickListener(new MyKeypadButtonsClick());
        buttonFour.setOnClickListener(new MyKeypadButtonsClick());
        buttonFive.setOnClickListener(new MyKeypadButtonsClick());
        buttonSix.setOnClickListener(new MyKeypadButtonsClick());
        buttonSeven.setOnClickListener(new MyKeypadButtonsClick());
        buttonZero.setOnClickListener(new MyKeypadButtonsClick());
        buttonPoint.setOnClickListener(new MyKeypadButtonsClick());
        buttonCross.setOnClickListener(new MyKeypadButtonsClick());
        buttonDone.setOnClickListener(new MyKeypadButtonsClick());

    }


    private class MyKeypadButtonsClick implements View.OnClickListener{

        public void onClick(View view){
            //To get cursor position of the editText text
            int editTextCursorPosition = numberSystemValueEditText.getSelectionStart();
            switch (view.getId()){

                case R.id.button_one:
                    //To Insert One at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"1");
                    break;
                case R.id.button_two:
                    //To Insert Two at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"2");
                    break;
                case R.id.button_three:
                    //To Insert Three at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"3");
                    break;
                case R.id.button_four:
                    //To Insert Four at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"4");
                    break;
                case R.id.button_five:
                    //To Insert Five at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"5");
                    break;
                case R.id.button_six:
                    //To Six at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"6");
                    break;
                case R.id.button_seven:
                    //To Insert Seven at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"7");
                    break;
                case R.id.button_zero:
                    //To Insert Zero at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"0");
                    break;
                case R.id.button_point:
                    String text = numberSystemValueEditText.getText().toString();
                    //Check wheather edit text is already contains point (.) or not. If contains point ,then condition will false
                    if (!text.contains(".")){
                        numberSystemValueEditText.getText().insert(editTextCursorPosition,".");
                    }
                    break;
                case R.id.button_cross:
                    if (editTextCursorPosition > 0){
                        //To remove one character from editText text when keyPad cross button is Clicked
                        numberSystemValueEditText.getText().replace(editTextCursorPosition-1,numberSystemValueEditText.getSelectionStart(),"");
                    }
                    break;
                case R.id.button_done:
                    //When keypad done button is clicked ,then onKeypadDoneButtonClick() is Called
                    onKeypadDoneButtonClickListener.onKeypadDoneButtonClick();
                    break;

            }


        }

    }

    public View getView(){
        return view;
    }


}
