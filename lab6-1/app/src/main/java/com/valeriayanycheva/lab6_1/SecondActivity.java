package com.valeriayanycheva.lab6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    public final static String THIEF = "com.valeriayanycheva.lab6_1.THIEF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onRadioClick(View v) {
        Intent answerIntent = new Intent();

        if(v.getId() == R.id.radio_dog) {
            answerIntent.putExtra(THIEF, "Пёсик");
        }
        if(v.getId() == R.id.radio_crow) {
            answerIntent.putExtra(THIEF, "Ворона");
        }
        if(v.getId() == R.id.radio_cat) {
            answerIntent.putExtra(THIEF, "Лошадь Пржевальского");
        }

        setResult(RESULT_OK, answerIntent);
        finish();
    }
}