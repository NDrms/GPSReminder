package com.example.gpsreminder.background;

import static android.Manifest.permission.RECEIVE_BOOT_COMPLETED;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.gpsreminder.R;

public class PushNotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Получение имени из интента
        String name = intent.getStringExtra("name");

        // Здесь вы можете добавить код для отображения уведомления
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();

        // Создание уведомления
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "mychannel")
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Напоминание создано")
                .setContentText(name)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        // Проверка разрешения на отправку уведомлений
        if (ActivityCompat.checkSelfPermission(context, RECEIVE_BOOT_COMPLETED) != PackageManager.PERMISSION_GRANTED) {
            // Запрос разрешения на отправку уведомлений
            ActivityCompat.requestPermissions(/*Activity*/ null, new String[]{RECEIVE_BOOT_COMPLETED}, 999);
            return;
        }

        // Отображение уведомления
        notificationManager.notify(/*Notification ID*/ 0, builder.build());
    }
}