package com.example.gpsreminder.activityCreate.ui.combo;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gpsreminder.R;
import com.example.gpsreminder.activityCreate.ui.time.TimeFragment;
import com.example.gpsreminder.databinding.*;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class ComboFragment extends Fragment {

    private FragmentComboRemindsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ComboViewModel comboViewModel =
                new ViewModelProvider(this).get(ComboViewModel.class);

        binding = FragmentComboRemindsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.timeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Для биндинга
        binding.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Сменить время", Toast.LENGTH_SHORT).show();
            }
        });

        binding.createComdoType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.Name.getText().toString() != binding.time.getText().toString()) {
                    Snackbar.make(container, "Напоминание " + binding.Name.getText() + ". \n Установлено на время " + binding.time.getText() + ".", BaseTransientBottomBar.LENGTH_SHORT).show();
                }
            }

        });

        //конец

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}