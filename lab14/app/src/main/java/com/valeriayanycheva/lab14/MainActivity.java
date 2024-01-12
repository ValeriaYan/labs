package com.valeriayanycheva.lab14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int counter = 101;

    private static String CHANNEL_ID = "Cat channel";
    private NotificationManager notificationManager;

    @Override
    @SuppressLint("MissingPermission")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Button button_notify = findViewById(R.id.button_notify);
        Button button_clear = findViewById(R.id.button_clear);

        long[] vibrate = new long[] { 1000, 1000, 1000, 1000, 1000 };
        String bigText = "Это я, почтальон Печкин. Принёс для вас посылку. "
                + "Только я вам её не отдам. Потому что у вас документов нету. ";

        button_notify.setOnClickListener(view -> {
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_pets_black_24dp)
                            .setContentTitle("Напоминание")
                            .setContentText("Пора покормить кота")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(contentIntent)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                    R.drawable.cat))
                            .setAutoCancel(true)
                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                            .setVibrate(vibrate)
                            .addAction(R.drawable.lock_open_black_24dp, "Открыть", contentIntent)
                            .addAction(R.drawable.ic_refresh_white_24dp, "Отказаться", contentIntent)
                            .addAction(R.drawable.ic_pets_black_24dp, "Другой вариант", contentIntent)
                            .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                            .setPriority(NotificationCompat.PRIORITY_HIGH);

            createChannelIfNeeded(notificationManager);
            notificationManager.notify(counter++, builder.build());
        });

        button_clear.setOnClickListener(view -> {
            notificationManager.cancelAll();
        });
    }

    public static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}