package com.valeriayanycheva.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void onClickButtonSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        EditText mEditTextDesc = findViewById(R.id.edit_text_desc);
        EditText mEditTextWhom = findViewById(R.id.edit_text_whom);
        EditText mEditTextFrom = findViewById(R.id.edit_text_from);
        intent.putExtra("username", mEditTextWhom.getText().toString());
        intent.putExtra("gift", mEditTextDesc.getText().toString());
        intent.putExtra("from", mEditTextFrom.getText().toString());
        startActivity(intent);
    }
}