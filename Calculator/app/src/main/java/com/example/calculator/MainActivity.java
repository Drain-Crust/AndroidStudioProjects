package com.example.calculator;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldString = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldString.substring(0, cursorPos);
        String rightStr = oldString.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void number_clear_button(View view){
        display.setText("");

    }
    public void number_parenthases_button(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLength = display.getText().length();

        for (int i =0; i < closedPar; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar +=1;
            }
            else if (display.getText().toString().substring(i, i+1).equals("(")) {
                closedPar += 1;
            }
        }

        if (openPar == closedPar || display.getText().toString().substring(textLength-1, textLength).equals("(")){
            updateText("(");
        }
        else {
            if (closedPar < openPar && !display.getText().toString().substring(textLength - 1, textLength).equals("(")) {
                updateText(")");
            }
        }
        display.setSelection(cursorPos + 1);
    }
    public void number_exponent_button(View view){
        updateText("^");

    }
    public void number_divide_button(View view){
        updateText("/");

    }
    public void number_seven_button(View view){
        updateText("7");

    }
    public void number_eight_button(View view){
        updateText("8");

    }
    public void number_nine_button(View view){
        updateText("9");

    }
    public void number_multiply_button(View view){
        updateText("*");

    }
    public void number_four_button(View view){
        updateText("4");

    }
    public void number_five_button(View view){
        updateText("5");

    }
    public void number_six_button(View view){
        updateText("6");

    }
    public void number_subtract_button(View view){
        updateText("-");

    }
    public void number_one_button(View view){
        updateText("1");

    }
    public void number_two_button(View view){
        updateText("2");

    }
    public void number_three_button(View view){
        updateText("3");

    }
    public void number_add_button(View view){
        updateText("+");

    }
    public void number_plusMinus_button(View view){
        updateText("+/-");

    }
    public void number_zero_button(View view){
        updateText("0");

    }
    public void number_point_button(View view){
        updateText(".");

    }
    public void number_equals_button(View view){
        updateText("=");

    }
    public void number_backspace_button(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }

}