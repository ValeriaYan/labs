package com.valeriayanycheva.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private int counter = 0;
    private int catsCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
    }

    public void onClickSayHi(View view) {
        textView.setText("Привет!");
    }

    public void onClickCount(View view) {
        textView.setText(String.format("Я насчитал %d ворон", ++counter));
    }

    public void onClickCountCats(View view) {
        textView2.setText(String.format("Я насчитал %d котов", ++catsCounter));
    }
}