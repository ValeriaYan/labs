package com.valeriayanycheva.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float mBackLightValue = 0.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_screen = findViewById(R.id.button_screen);
        Button button_res = findViewById(R.id.button_res);
        Button button_brightness = findViewById(R.id.button_brightness);
        TextView text_info = findViewById(R.id.text_info);
        SeekBar seekBar = findViewById(R.id.seekBar);

        // Настройки - Экран
        button_screen.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        // Размеры экрана и его ориентация
        button_res.setOnClickListener(view -> {
            Display display = getWindowManager().getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int screenWidth = point.x;
            int screenHeight = point.y;

            // Теперь получим необходимую информацию
            String width = Integer.toString(screenWidth);
            String height = Integer.toString(screenHeight);

            String info = "Ширина: " + width + "; Высота: " + height;

            text_info.setText(info);
        });

        // Получить текущее значение яркости экрана
        button_brightness.setOnClickListener(view -> {
            try {
                int curBrightnessValue = Settings.System.getInt(
                        getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS);
                text_info.setText("Текущая яркость экрана: " + curBrightnessValue);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        });

        // Установить яркость экрана
        int brightness = getBrightness();
        seekBar.setProgress(brightness);

        boolean canWrite = Settings.System.canWrite(this);

        // Если приложению не разрешено записывать системные настройки
        if (!canWrite) {
            seekBar.setEnabled(false);
            allowWritePermission();
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text_info.setText("Яркость: " + progress);
                setBrightness(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void allowWritePermission() {
        Intent intent = new Intent(
                Settings.ACTION_MANAGE_WRITE_SETTINGS,
                Uri.parse("package:" + getPackageName())
        );
        startActivity(intent);
    }

    private int getBrightness() {
        return Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
    }

    public void setBrightness(int value) {
        Settings.System.putInt(
                getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS,
                value
        );
    }
}