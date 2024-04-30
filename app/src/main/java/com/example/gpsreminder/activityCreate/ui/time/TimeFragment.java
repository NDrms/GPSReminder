package com.example.gpsreminder.activityCreate.ui.time;

import static androidx.navigation.Navigation.findNavController;
import static com.example.gpsreminder.activityCreate.CreateActivity.Message;
import static com.example.gpsreminder.activityCreate.CreateActivity.hours;
import static com.example.gpsreminder.activityCreate.CreateActivity.minutes;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.TF;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.R;
import com.example.gpsreminder.background.TimeRem;
import com.example.gpsreminder.databinding.FragmentTimeRemindsBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class TimeFragment extends Fragment {
    private FragmentTimeRemindsBinding binding;


    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimeRemindsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if (!String.valueOf(hours).isEmpty() && !String.valueOf(minutes).isEmpty()) {
            String a;
            String b;
            if (hours < 10) {
                a = "0" + hours;
            } else a = hours + "";
            if (minutes < 10) {
                b = "0" + minutes;
            } else b = minutes + "";
            binding.time.setText(a + ":" + b);
        }
        binding.Name.setText(Message);
        binding.CreateTimeType.setOnClickListener(v -> {
            if (!binding.Name.getText().toString().isEmpty()) {
                TimeRem timeRem = new TimeRem(getContext(),
                        binding.Name.getText().toString(),
                        hours,
                        minutes);
                Snackbar.make(container, "Успешно", BaseTransientBottomBar.LENGTH_SHORT).show();
                timeRem.startChecking(); // Начать проверку
                // Когда нужно остановить проверку:
                // trueChecker.stopChecking();
            } else
                Snackbar.make(container, R.string.fill_fields, BaseTransientBottomBar.LENGTH_SHORT).show();
        });
        TF = true;
        binding.time.setOnClickListener(v -> {
            Message = binding.Name.getText().toString();
            findNavController(requireView()).navigate(R.id.action_navigation_notifications_to_getTime);
        });

        return root;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        binding.Name.setText(Message);
        if (!String.valueOf(hours).isEmpty() && !String.valueOf(minutes).isEmpty()) {
            String a;
            String b;
            if (hours < 10) {
                a = "0" + hours;
            } else a = hours + "";
            if (minutes < 10) {
                b = "0" + minutes;
            } else b = minutes + "";
            binding.time.setText(a + ":" + b);
        }
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}