package com.valeriayanycheva.lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView secondTextView = findViewById(R.id.text2);
        TextView thirdTextView = findViewById(R.id.text3);
        TextView fourTextView = findViewById(R.id.text4);

        ImageView right_bottom_image = findViewById(R.id.cat1);
        right_bottom_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] phrases = {"Уже 6 часов утра, Наташ",
                        "Вставай, мы там всё уронили",
                        "Мы уронили вообще всё, Наташ, честно",
                        "Наташ, ты чё опять лежишь?",
                        "Часики-то тикают",
                        "Мужика-то хоть нашла себе?",
                        "Уже дитачек пора рожать вообще-то"};

                shuffleArray(phrases); // перемешиваем

                secondTextView.setText(phrases[0]);
                thirdTextView.setText(phrases[1]);
                fourTextView.setText(phrases[2]);
            }
        });
    }

    void shuffleArray(String[] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}