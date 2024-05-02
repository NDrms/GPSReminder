package com.example.gpsreminder.activityCreate.ui.getTime;

import static androidx.navigation.Navigation.findNavController;
import static com.example.gpsreminder.activityCreate.CreateActivity.hours;
import static com.example.gpsreminder.activityCreate.CreateActivity.minutes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.FragmentGettimeBinding;

public class GetTime extends Fragment {

    private FragmentGettimeBinding binding;

    private String mParam1;
    private String mParam2;

    public GetTime() {
        // Required empty public constructor
    }

    public static GetTime newInstance(String param1, String param2) {
        GetTime fragment = new GetTime();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(v -> {
            hours = binding.timePicker.getHour();
            minutes = binding.timePicker.getMinute();
                findNavController(requireView()).navigate(R.id.action_getTime_to_navigation_notifications);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGettimeBinding.inflate(inflater, container, false);
        binding.timePicker.setIs24HourView(true);
        return binding.getRoot();
    }
}