package com.example.android.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }

    public void startTheQuiz (View v) {
        Intent startNewActivity = new Intent(this, Quiz.class);
        startActivity(startNewActivity);
    }
}
