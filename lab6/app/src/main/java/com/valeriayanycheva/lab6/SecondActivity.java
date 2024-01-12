package com.valeriayanycheva.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String USER = "com.valeriayanycheva.lab6.USER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String user = "User";
        String gift = "gift";
        String from = USER;

        user = getIntent().getExtras().getString("username");
        gift = getIntent().getExtras().getString("gift");
        from = getIntent().getExtras().getString("from");

        TextView mTextViewResponse = findViewById(R.id.text_view_response);
        mTextViewResponse.setText(user + ", вам передали " + gift + " от " + from);
    }
}