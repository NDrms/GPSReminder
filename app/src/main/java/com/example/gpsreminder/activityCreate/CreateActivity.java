package com.example.gpsreminder.activityCreate;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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