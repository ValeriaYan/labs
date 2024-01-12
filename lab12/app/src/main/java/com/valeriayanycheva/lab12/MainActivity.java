package com.valeriayanycheva.lab12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        ImageView imageView = findViewById(R.id.imageView);

        button.setOnClickListener(viewClickListener);

        imageView.setOnClickListener(viewClickListener);
    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu);
        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(viewClickListener);

        popupMenu
                .setOnMenuItemClickListener(item -> {
                    while (true) {
                        if (item.getItemId() == R.id.red) {
                            textView.setText("Вы выбрали красный");
                            return true;
                        }
                        else if (item.getItemId() == R.id.yellow) {
                            textView.setText("Вы выбрали желтый");
                            return true;
                        }
                        else if (item.getItemId() == R.id.green) {
                            textView.setText("Вы выбрали зеленый");
                            return true;
                        }
                        else return false;
                    }
                });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupMenu.setForceShowIcon(true);
        }

        popupMenu.show();
    }
}