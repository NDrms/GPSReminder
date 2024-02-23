package com.example.gpsreminder.activityCreate.ui.GPS;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gpsreminder.databinding.*;

public class GPSFragment extends Fragment {

    private FragmentGpsRemindsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GPSViewModel GPSViewModel =
                new ViewModelProvider(this).get(GPSViewModel.class);

        binding = FragmentGpsRemindsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}