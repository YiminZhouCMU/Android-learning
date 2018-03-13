package com.kindergarten.android.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    //declare the buttons
    private Button digit1;
    private Button digit2;
    private Button digit3;
    private Button digit4;
    private Button digit5;
    private Button digit6;
    private Button digit7;
    private Button digit8;
    private Button digit9;
    private Button digit0;
    private Button add;
    private Button minus;
    private Button times;
    private Button divide;
    private Button point;
    private Button equals;
    private Button delete;
    private Button clear;

    private TextView display;
    boolean clearflag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView)findViewById(R.id.display);

        //instantiate the buttons
        digit0 = (Button)findViewById(R.id.digit0);
        digit1 = (Button)findViewById(R.id.digit1);
        digit2 = (Button)findViewById(R.id.digit2);
        digit3 = (Button)findViewById(R.id.digit3);
        digit4 = (Button)findViewById(R.id.digit4);
        digit5 = (Button)findViewById(R.id.digit5);
        digit6 = (Button)findViewById(R.id.digit6);
        digit7 = (Button)findViewById(R.id.digit7);
        digit8 = (Button)findViewById(R.id.digit8);
        digit9 = (Button)findViewById(R.id.digit9);
        add = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        times = (Button)findViewById(R.id.times);
        divide = (Button)findViewById(R.id.divide);
        point = (Button)findViewById(R.id.decimalpoint);
        equals = (Button)findViewById(R.id.equals);
        delete = (Button)findViewById(R.id.delete);
        clear = (Button)findViewById(R.id.clear);


        //set onclicklistner to each button
        digit0.setOnClickListener(this);
        digit1.setOnClickListener(this);
        digit2.setOnClickListener(this);
        digit3.setOnClickListener(this);
        digit4.setOnClickListener(this);
        digit5.setOnClickListener(this);
        digit6.setOnClickListener(this);
        digit7.setOnClickListener(this);
        digit8.setOnClickListener(this);
        digit9.setOnClickListener(this);
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        times.setOnClickListener(this);
        divide.setOnClickListener(this);
        point.setOnClickListener(this);
        equals.setOnClickListener(this);
        delete.setOnClickListener(this);
        clear.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String input = display.getText().toString();
        //logic code for calculator
        switch (view.getId()) {
            case R.id.digit0:
            case R.id.digit1:
            case R.id.digit2:
            case R.id.digit3:
            case R.id.digit4:
            case R.id.digit5:
            case R.id.digit6:
            case R.id.digit7:
            case R.id.digit8:
            case R.id.digit9:
            case R.id.decimalpoint:
                if (clearflag) {
                    clearflag = false;
                    input = "";
                    display.setText("");
                }
                display.setText(input+((Button)view).getText().toString());
                break;

            case R.id.plus:
            case R.id.minus:
            case R.id.times:
            case R.id.divide:
                if (clearflag) {
                    clearflag = false;
                    input = "";
                    display.setText("");
                }
                display.setText(input+" " +((Button)view).getText().toString()+ " ");
                break;

            case R.id.equals:

                getResult();
                clearflag = true;
                break;

            case R.id.delete:
                if (clearflag) {
                    clearflag = false;
                    input = "";
                    display.setText("");
                } else if (input != null && input.length() != 0) {
                    display.setText(input.substring(0, input.length() - 1));
                }
                break;

            case R.id.clear:
                clearflag = false;
                display.setText("");
                break;

        }
    }

    private void getResult() {
        String input = display.getText().toString();
        double result = 0;
        if (input == null || input.length() == 0) {
            return;
        }
        if (!input.contains(" ")) {
            return;
        }
        String number1 = input.substring(0, input.indexOf(" "));
        String op = input.substring(input.indexOf(" ")+1, input.indexOf(" ")+2);
        String number2 = input.substring(input.indexOf(" ")+3);
        if (number1.length() != 0 && number2.length() != 0) {
            double n1 = Double.parseDouble(number1);
            double n2 = Double.parseDouble(number2);
            if (op.equals("+")) {
                result = n1 + n2;
            } else if (op.equals("-")) {
                result = n1 - n2;
            } else if (op.equals("*")) {
                result = n1 * n2;
            } else if (op.equals("/")) {
                if (n2 == 0) {
                    result = 0;
                } else {
                    result = n1 / n2;
                }
            }
            display.setText(result + "");
        } else if (number2.length() == 0) {
            display.setText(number1);
        } else if (number1.length() == 0) {
            double n2 = Double.parseDouble(number2);
            if (op.equals("+")) {
                result = 0 + n2;
            } else if (op.equals("-")) {
                result = 0 - n2;
            } else if (op.equals("*")) {
                result = 0 * n2;
            } else if (op.equals("/")) {
                result = 0;
            }
            display.setText(result + "");
        } else {
            display.setText("");
        }
    }
}
