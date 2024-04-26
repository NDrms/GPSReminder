package com.example.gpsreminder.activityCreate.ui.time;

import static androidx.navigation.Navigation.findNavController;
import static com.example.gpsreminder.activityCreate.CreateActivity.H;
import static com.example.gpsreminder.activityCreate.CreateActivity.M;
import static com.example.gpsreminder.activityCreate.ui.combo.ComboFragment.TF;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.MainActivity;
import com.example.gpsreminder.R;
import com.example.gpsreminder.background.PushNotificationScheduler;
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
        if (!String.valueOf(H).isEmpty()&&!String.valueOf(M).isEmpty()){
            String a;
            String b;
            if (H <10){
                a = "0"+ H;
            } else a = H +"";
            if (M <10){
                b = "0"+ M;
            } else b = M +"";
            binding.time.setText(a+":"+b);
        }
        binding.CreateTimeType.setOnClickListener(v -> {
            if (!binding.Name.getText().toString().isEmpty()) {
                PushNotificationScheduler.schedulePushNotification(requireContext(),H, M,binding.Name.getText().toString());
                Snackbar.make(container, "Успешно", BaseTransientBottomBar.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            } else
                Snackbar.make(container, R.string.fill_fields, BaseTransientBottomBar.LENGTH_SHORT).show();
        });
        TF = true;
        binding.time.setOnClickListener(v -> findNavController(requireView()).navigate(R.id.action_navigation_notifications_to_getTime));

        return root;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        if (!String.valueOf(H).isEmpty()&&!String.valueOf(M).isEmpty()){
            String a;
            String b;
            if (H <10){
                a = "0"+ H;
            } else a = H +"";
            if (M <10){
                b = "0"+ M;
            } else b = M +"";
            binding.time.setText(a+":"+b);
        }
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}