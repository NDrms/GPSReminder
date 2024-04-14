package com.example.gpsreminder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Handler;
import android.widget.Toast;

public class MyService extends Service {

    private int alarmHour;
    private int alarmMinute;

    private Handler handler = new Handler();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            alarmHour = intent.getIntExtra("hour", 0);
            alarmMinute = intent.getIntExtra("minute", 0);

            handler.postDelayed(showToastRunnable, calculateDelay());
        }

        return START_NOT_STICKY;
    }

    private Runnable showToastRunnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(getApplicationContext(), "Alarm time reached!", Toast.LENGTH_SHORT).show();
        }
    };

    private long calculateDelay() {
        long currentTime = System.currentTimeMillis();
        long alarmTime = System.currentTimeMillis();
        alarmTime = alarmTime + (alarmHour * 60 + alarmMinute) * 60 * 1000;
        return alarmTime - currentTime;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}