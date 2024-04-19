package com.example.gpsreminder.activityCreate.ui.GPS;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.*;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class GPSFragment extends Fragment {

    private FragmentGpsRemindsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GPSViewModel GPSViewModel =
                new ViewModelProvider(this).get(GPSViewModel.class);

        binding = FragmentGpsRemindsBinding.inflate(inflater, container, false);
        binding.CreateGPSType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String Created = R.string.reminder  + binding.Name.getText().toString() + R.string.was_sch + binding.time.getText().toString();
                String Created = "Напоминание \"" + binding.Name.getText().toString() + "\" успешно создано";
                if (!binding.Name.getText().toString().isEmpty() && !binding.rad.getText().toString().isEmpty()) {
                    Snackbar.make(container, Created, BaseTransientBottomBar.LENGTH_SHORT).show();
                } else Snackbar.make (container, R.string.fill_fields,BaseTransientBottomBar.LENGTH_SHORT).show();
            }

        });
        binding.GPS.setOnClickListener(v -> findNavController(requireView()).navigate(R.id.action_navigation_dashboard_to_mapsFragment));
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}