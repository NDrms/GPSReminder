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
    public static int hours = 0;
    public static double radius;
    public static double latitude;
    public static double longitude;
    public static String Message = "";
    public static int minutes = 0;
    private static boolean TimePickOnCombo = false;

    public static void TimePickOnCombo() {
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
                R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_create);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}