package com.valeriayanycheva.lab11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        TextView infoTextView = findViewById(R.id.textView);

        // Операции для выбранного пункта меню

        if (id == R.id.action_cat1) {
            infoTextView.setText("Вы выбрали кота!");
            return true;
        }else if (id == R.id.action_cat2) {
            infoTextView.setText("Вы выбрали кошку!");
            return true;
        }else if (id == R.id.action_cat3) {
            infoTextView.setText("Вы выбрали котёнка!");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void onSettingsMenuClick(MenuItem item) {
        TextView infoTextView = (TextView) findViewById(R.id.textView);
        infoTextView.setText("Вы выбрали пункт Settings, лучше бы выбрали кота");
    }

}