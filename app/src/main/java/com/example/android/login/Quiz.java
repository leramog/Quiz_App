package com.example.android.login;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.login.R.id.username;


public class Quiz extends AppCompatActivity {

    public static final String VALID_TAG_VALUE = "valid";
    private RadioGroup Q1, Q2, Q3,  Q5;
    private CheckBox Q4a;
    private CheckBox Q4b;
    private CheckBox Q4c;
    private CheckBox Q4d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setupView();}

    private void setupView() {
        final Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButton();
            }
        });

        Q1 = (RadioGroup) findViewById(R.id.question_1);
        Q2 = (RadioGroup) findViewById(R.id.question_2);
        Q3 = (RadioGroup) findViewById(R.id.question_3);
        Q5 = (RadioGroup) findViewById(R.id.question_5);

        Q4a = (CheckBox) findViewById(R.id.button_4a);
        Q4b = (CheckBox) findViewById(R.id.button_4b);
        Q4c = (CheckBox) findViewById(R.id.button_4c);
        Q4d = (CheckBox) findViewById(R.id.button_4d);

    }

    private void submitButton() {
        int mResult = 0;
        if (Q1.getCheckedRadioButtonId() == R.id.button1a) {
            mResult += 10;
        } else if (Q1.getCheckedRadioButtonId() == -1) {
            showError();
            return;

        }
        if (Q2.getCheckedRadioButtonId() == R.id.button_2d) {
            mResult += 10;
        } else if (Q2.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }
        if (Q3.getCheckedRadioButtonId() == R.id.button_3a) {
            mResult += 10;
        } else if (Q3.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }
        if (Q4a.isChecked() == false && Q4c.isChecked() == false &&
               Q4b.isChecked() == false && Q4d.isChecked() == false) {
            showError();
            return;
        }

        if (Q4b.isChecked()) {
            mResult += 5;
        }
        if (Q4a.isChecked()) {
            mResult += 5;
        }
        if (Q5.getCheckedRadioButtonId() == R.id.button_5c) {
            mResult += 10;
        } else if (Q5.getCheckedRadioButtonId() == -1) {
            showError();
            return;
        }

        displayMessage(mResult);
    }

    void displayMessage(int score) {
        String message ="Your score is: " + String.valueOf(score) + " ofÅ 50";
        message += "\n" + quizResultMessage(score);

        new AlertDialog.Builder(this).setMessage(message).show();
    }

    String quizResultMessage(int score) {
        if (score <= 20) {
            return getString(R.string.result_0_20);
        } else if (score > 20 && score <= 40) {
            return getString(R.string.result_20_40);
        } else {
            return getString(R.string.result_40_50);
        }
    }

        void showError() {
            // Show an error message as a toast
            Toast.makeText(this, "Answer all the Questions!", Toast.LENGTH_SHORT).show();
        }



        }