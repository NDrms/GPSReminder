package com.example.gpsreminder.background;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Handler;
import android.os.Looper;

import androidx.core.app.NotificationCompat;

import com.example.gpsreminder.R;

import java.util.Calendar;

public class GPSChecker {
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371000; // радиус Земли в метрах
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double deltaPhi = Math.toRadians(lat2 - lat1);
        double deltaLambda = Math.toRadians(lon2 - lon1);

        double a = Math.sin(deltaPhi / 2) * Math.sin(deltaPhi / 2) +
                Math.cos(phi1) * Math.cos(phi2) *
                        Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
    public void onSensorChanged (SensorEvent event){
        double userLatitude = 0.1;
        double userLongitude = 0.1;
        double dist = calculateDistance(latitude,longitude,userLatitude,userLongitude);

    }
    private Handler handler;
    private Runnable timeComparison;
    private Context context;
    private double latitude;
    private double longitude;

    public GPSChecker(Context context, String message, double latitude, double longitude) {
        this.context = context;
        this.latitude = latitude;
        this.longitude = longitude;
        handler = new Handler(Looper.getMainLooper());

        timeComparison = new Runnable() {
            @Override
            public void run() {
                // Получаем текущее местоположение
                double latitudeL = 0;
                double longitudeL = 0;
                // Сравниваем текущее местоположение с целевым
                if (latitude == latitudeL && longitude == longitudeL) {
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
                .setSmallIcon(R.drawable.ic_home_black_24dp)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        notificationManager.notify(1, builder.build());
    }
}
