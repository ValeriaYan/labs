package com.valeriayanycheva.lab26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView_setbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_main);
        Button button2 = findViewById(R.id.button_ringtone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSettings();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRingtoneSettings();
            }
        });
    }

    public void showSettings()
    {
        Intent intent = new Intent(this, MyPreferenceActivity.class);
        startActivity(intent);
    }

    public void showRingtoneSettings()
    {
        Intent intent = new Intent(this, RingtonePreferenceActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        int catHeight = sharedPreferences.getInt("height", 20);
        // Добавим TextView, в котором будем выводить значение настройки
        textView_setbox.setText("Высота кота = " + catHeight);
    }
}