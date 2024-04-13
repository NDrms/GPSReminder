package com.example.gpsreminder.activityCreate.ui.time;

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
            } else Snackbar.make (container, R.string.fill_fields,BaseTransientBottomBar.LENGTH_SHORT).show();
        });

        binding = FragmentTimeRemindsBinding.inflate(inflater, container, false);
        binding.time.setOnClickListener(v -> Toast.makeText(getContext(), "Сменить время", Toast.LENGTH_SHORT).show());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}