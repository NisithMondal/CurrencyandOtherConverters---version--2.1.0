package com.nisith.currencyandotherconverters;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class HexaDecimalNumberSystemKeypadHandeler {
    private Button buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,
                   buttonZero,buttonA,buttonB,buttonC,buttonD,buttonE,buttonF,buttonPoint,buttonCross,buttonDone;
    private RelativeLayout buttonKeyPadLayout;
    private View view;
    private EditText numberSystemValueEditText;
    private OnKeypadDoneButtonClickListener onKeypadDoneButtonClickListener;
    public HexaDecimalNumberSystemKeypadHandeler(AppCompatActivity appCompatActivity, EditText numberSystemValueEditText){
        this.numberSystemValueEditText = numberSystemValueEditText;
        this.onKeypadDoneButtonClickListener = (NumberSystemConverterActivity) appCompatActivity;
        LayoutInflater layoutInflater = appCompatActivity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.hexadecimal_number_keypad_layout,null,false);
        buttonOne = view.findViewById(R.id.button_one);
        buttonTwo = view.findViewById(R.id.button_two);
        buttonThree = view.findViewById(R.id.button_three);
        buttonFour = view.findViewById(R.id.button_four);
        buttonFive = view.findViewById(R.id.button_five);
        buttonSix = view.findViewById(R.id.button_six);
        buttonSeven = view.findViewById(R.id.button_seven);
        buttonEight = view.findViewById(R.id.button_eight);
        buttonNine = view.findViewById(R.id.button_nine);
        buttonZero = view.findViewById(R.id.button_zero);
        buttonA = view.findViewById(R.id.button_a);
        buttonB = view.findViewById(R.id.button_b);
        buttonC = view.findViewById(R.id.button_c);
        buttonD = view.findViewById(R.id.button_d);
        buttonE = view.findViewById(R.id.button_e);
        buttonF = view.findViewById(R.id.button_f);
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
        buttonEight.setOnClickListener(new MyKeypadButtonsClick());
        buttonNine.setOnClickListener(new MyKeypadButtonsClick());
        buttonZero.setOnClickListener(new MyKeypadButtonsClick());
        buttonA.setOnClickListener(new MyKeypadButtonsClick());
        buttonB.setOnClickListener(new MyKeypadButtonsClick());
        buttonC.setOnClickListener(new MyKeypadButtonsClick());
        buttonD.setOnClickListener(new MyKeypadButtonsClick());
        buttonE.setOnClickListener(new MyKeypadButtonsClick());
        buttonF.setOnClickListener(new MyKeypadButtonsClick());
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
                    //To Insert our at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"4");
                    break;
                case R.id.button_five:
                    //To Insert Five at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"5");
                    break;
                case R.id.button_six:
                    //To Insert Six at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"6");
                    break;
                case R.id.button_seven:
                    //To Insert Seven at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"7");
                    break;
                case R.id.button_eight:
                    //To Insert Eight at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"8");
                    break;
                case R.id.button_nine:
                    //To Insert Nine at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"9");
                    break;
                case R.id.button_zero:
                    //To Insert Zero at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"0");
                    break;
                case R.id.button_a:
                    Log.d("AAAAA","BUTTON A IS CLICKED");
                    //To Insert A at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"A");
                    break;
                case R.id.button_b:
                    //To Insert B at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"B");
                    break;
                case R.id.button_c:
                    //To Insert C at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"C");
                    break;
                case R.id.button_d:
                    //To Insert D at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"D");
                    break;
                case R.id.button_e:
                    //To Insert E at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"E");
                    break;
                case R.id.button_f:
                    //To Insert F at the current Cursor Position
                    numberSystemValueEditText.getText().insert(editTextCursorPosition,"F");
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
