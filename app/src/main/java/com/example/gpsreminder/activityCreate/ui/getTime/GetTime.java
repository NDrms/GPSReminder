package com.example.gpsreminder.activityCreate.ui.getTime;

import static androidx.navigation.Navigation.findNavController;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.TF;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.timeH;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.timeM;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gpsreminder.R;
import com.example.gpsreminder.activityCreate.ui.combo.ComboFragment;
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

        binding.button.setOnClickListener(v -> {timeH = binding.timePicker.getHour();
            timeM = binding.timePicker.getMinute();
            if (TF){
                TF = false;
                findNavController(requireView()).navigate(R.id.action_getTime_to_navigation_notifications);
            } else {

            findNavController(requireView()).navigate(R.id.action_getTime_to_navigation_home);}
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