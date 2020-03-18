package com.nisith.currencyandotherconverters;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


//This class handel Binary Number System click Events


public class BinaryNumberSystemKeypadHandeler {
    private Button buttonOne,buttonZero,buttonPoint,buttonCross,buttonDone;
    private RelativeLayout buttonKeyPadLayout;
    private View view;
    private EditText numberSystemValueEditText;
    private OnKeypadDoneButtonClickListener onKeypadDoneButtonClickListener;


    public BinaryNumberSystemKeypadHandeler(AppCompatActivity appCompatActivity, EditText numberSystemValueEditText){
        this.numberSystemValueEditText = numberSystemValueEditText;
        this.onKeypadDoneButtonClickListener = (NumberSystemConverterActivity) appCompatActivity;
        LayoutInflater layoutInflater = appCompatActivity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.binary_number_keypad_layout,null,false);
        buttonOne = view.findViewById(R.id.button_one);
        buttonZero = view.findViewById(R.id.button_zero);
        buttonPoint = view.findViewById(R.id.button_point);
        buttonCross = view.findViewById(R.id.button_cross);
        buttonDone = view.findViewById(R.id.button_done);
        buttonKeyPadLayout = view.findViewById(R.id.keypad_layout);
        buttonOne.setOnClickListener(new MyKeypadButtonsClick());
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
