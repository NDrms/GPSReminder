
package com.example.gpsreminder.background;

import java.util.Calendar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.core.app.NotificationCompat;

import com.example.gpsreminder.R;

public class TimeChecker {
    private Handler handler;
    private Runnable timeComparison;
    private Context context;
    private int targetHour;
    private int targetMinute;

    public TimeChecker(Context context, String message, int hours, int minutes) {
        this.context = context;
        this.targetHour = hours;
        this.targetMinute = minutes;
        handler = new Handler(Looper.getMainLooper());
        timeComparison = new Runnable() {
            @Override
            public void run() {
                // Получаем текущее время
                Calendar calendar = Calendar.getInstance();
                int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                int currentMinute = calendar.get(Calendar.MINUTE);

                // Сравниваем текущее время с целевым
                if (currentHour == targetHour && currentMinute == targetMinute) {
                    // Отправляем уведомление, если текущее время совпадает с целевым
                    sendNotification("Напоминание по времени", message);
                    stopChecking();
                } else {
                    // Повторяем проверку каждую минуту
                    handler.postDelayed(this, 60000);
                }
            }
        };
    }

    public void startChecking() {
        // Запускаем проверку времени в новом потоке
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Сначала определяем, сколько времени до следующей минуты
                Calendar calendar = Calendar.getInstance();
                int secondsUntilNextMinute = 60 - calendar.get(Calendar.SECOND);

                // Запускаем проверку через определенное количество секунд
                handler.postDelayed(timeComparison, secondsUntilNextMinute * 1000);
            }
        }).start();
    }

    public void stopChecking() {
        // Удаляем все колбэки из очереди сообщений для handler'а
        handler.removeCallbacksAndMessages(null);
    }

    private void sendNotification(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "gpsr_channel";
        String channelName = "GPSReminder";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        notificationManager.notify(1, builder.build());
    }
}
