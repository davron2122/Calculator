package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String operator = "";

    boolean isFirstNumber = true;

    TextView taskTextView;


    String number1 = "", number2 = "", taskString = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskTextView = findViewById(R.id.taskTextView);
    }


        public void numberClicked (View view){

            String tempString = ((TextView) view).getText().toString();

            if (isFirstNumber) {
                number1 += tempString;
            } else {
                number2 += tempString;
            }
            taskString += tempString;
            taskTextView.setText(taskString);

        }


        public void operatorClicked (View view){
            if (!isFirstNumber) return;

            isFirstNumber = false;
            operator = ((TextView) view).getText().toString();
            taskString += operator;
            taskTextView.setText(taskString);
        }

        public void clearClicked (View view){
            isFirstNumber = true;
            taskString = "";
            number1 = "";
            number2 = "";
            operator = "";
            taskTextView.setText(taskString);

        }


        public void equalClick (View view){
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);
            int total;

            switch (operator) {
                case "%":
                    total = num1 % num2;
                    break;
                case "+":
                    total = num1 + num2;
                    break;
                case "-":
                    total = num1 - num2;
                    break;
                case "x":
                    total = num1 * num2;
                    break;
                case "/":
                    total = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Operator");
            }

            taskString += "=" + total;


            taskTextView.setText(taskString);

        }



    }

