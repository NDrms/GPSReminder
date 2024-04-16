package com.example.gpsreminder;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.timeH;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.timeM;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class TimePick extends AppCompatActivity {
    private TimePicker timePicker;
    private TextView infoTextView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_time_pick);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(androidx.leanback.R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            timePicker = (TimePicker) findViewById(R.id.timePicker);
            infoTextView = (TextView) findViewById(R.id.textView);

            Calendar now = Calendar.getInstance();

            timePicker.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
            timePicker.setCurrentMinute(now.get(Calendar.MINUTE));

            timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                @Override
                public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                    Toast.makeText(getApplicationContext(), "onTimeChanged", Toast.LENGTH_SHORT).show();
                    infoTextView.setText(hourOfDay + ":" + minute);
                }
            });
            return insets;
        });
    }
}