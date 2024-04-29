package com.example.gpsreminder.background;

import com.example.gpsreminder.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Создание уведомления
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Заголовок уведомления")
                .setContentText("Текст уведомления")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Отображение уведомления
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());
    }

}