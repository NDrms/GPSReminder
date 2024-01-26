package com.example.gpsreminder.activityCreate;

import com.example.gpsreminder.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gpsreminder.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gpsreminder.databinding.ActivityCreateBinding;

public class CreateActivity extends AppCompatActivity {

    private ActivityCreateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateActivity.super.onBackPressed();
            }
        });
    }

}