package com.example.gpsreminder.activityCreate.ui.time;

import static androidx.navigation.Navigation.findNavController;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.timeH;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.timeM;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.FragmentTimeRemindsBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class TimeFragment extends Fragment {

    private FragmentTimeRemindsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimeRemindsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.CreateTimeType.setOnClickListener(v -> {
            String Created = "Напоминание \"" + binding.Name.getText().toString() + "\" успешно создано";
            if (!binding.Name.getText().toString().isEmpty()) {
                Snackbar.make(container, Created, BaseTransientBottomBar.LENGTH_SHORT).show();
            } else
                Snackbar.make(container, R.string.fill_fields, BaseTransientBottomBar.LENGTH_SHORT).show();
        });

        binding = FragmentTimeRemindsBinding.inflate(inflater, container, false);
        binding.time.setOnClickListener(v -> findNavController(requireView()).navigate(R.id.action_navigation_notifications_to_getTime));
        if (!String.valueOf(timeH).isEmpty() && !String.valueOf(timeM).isEmpty()) {
            String a;
            String b;
            if (timeH < 10) {
                a = "0" + timeH;
            } else a = timeH + "";
            if (timeM < 10) {
                b = "0" + timeM;
            } else b = timeM + "";
            binding.time.setText(a + ":" + b);
        }
        return root;
    }

    @Override
    public void onResume() {
        if (!String.valueOf(timeH).isEmpty() && !String.valueOf(timeM).isEmpty()) {
            String a;
            String b;
            if (timeH < 10) {
                a = "0" + timeH;
            } else a = timeH + "";
            if (timeM < 10) {
                b = "0" + timeM;
            } else b = timeM + "";
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