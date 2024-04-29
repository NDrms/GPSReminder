package com.example.gpsreminder.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.gpsreminder.R;

public class MyNotificationPublisher extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationId = intent.getIntExtra("notificationId", 0);

        // Создание уведомления
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel_id")
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Заголовок уведомления")
                .setContentText("Текст уведомления")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Отображение уведомления
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(notificationId, builder.build());
    }
}

