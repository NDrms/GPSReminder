package com.example.gpsreminder.activityCreate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.ActivityCreateBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yandex.mapkit.MapKitFactory;

public class CreateActivity extends AppCompatActivity {
    public static int H = 0;
    public static int M = 0;
    private static boolean TimePickOnCombo = false;

    public static void TimePickOnCombo(){
        TimePickOnCombo = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        MapKitFactory.setApiKey("7d848716-5181-4f5b-a7fe-c78131a93dc8");
        MapKitFactory.initialize(this);

        com.example.gpsreminder.databinding.ActivityCreateBinding binding = ActivityCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_create);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
//        binding.timeChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final DatePickerDialog datePickerDialog = new DatePickerDialog(CreateActivity.this);
//                final TimePickerDialog timePickerDialog = new TimePickerDialog(CreateActivity.this);
//
//                // Set the initial date and time
//                datePickerDialog.getDatePicker().updateDate(2023, 11, 15);
//                timePickerDialog.getTimePicker().setCurrentHour(10);
//                timePickerDialog.getTimePicker().setCurrentMinute(30);
//
//                // Set the callback to be called when the user selects a date
//                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        // Do something with the selected date
//                        Log.d(TAG, "Selected date: " + year + "-" + month + "-" + dayOfMonth);
//
//                        // Show the time picker dialog
//                        timePickerDialog.show();
//                    }
//                });
//
//                // Set the callback to be called when the user selects a time
//                timePickerDialog.setOnTimeSetListener(new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                        // Do something with the selected time
//                        Log.d(TAG, "Selected time: " + hourOfDay + ":" + minute);
//                    }
//                });
//
//                // Show the date picker dialog
//                datePickerDialog.show();
//            }
//        });
    }
}