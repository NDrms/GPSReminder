package com.example.gpsreminder.activityCreate.ui.combo;

import static androidx.navigation.Navigation.findNavController;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Dialog;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.MyService;
import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.FragmentComboRemindsBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class ComboFragment extends Fragment {

    public static int forCreateComboH;
    public static int forCreateComboM;

    private FragmentComboRemindsBinding binding;


    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentComboRemindsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if (!String.valueOf(forCreateComboH).isEmpty()&&!String.valueOf(forCreateComboM).isEmpty()){
            String a;
            String b;
            if (forCreateComboH<10){
                a = "0"+forCreateComboH;
            } else a = forCreateComboH+"";
            if (forCreateComboM<10){
                b = "0"+forCreateComboM;
            } else b = forCreateComboM+"";
            binding.Time.setText(a+":"+b);
        }
        binding.createComboType.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
                if (!binding.Name.getText().toString().isEmpty() && !binding.rad.getText().toString().isEmpty()) {
                    Snackbar.make(container, "Успешно", BaseTransientBottomBar.LENGTH_SHORT).show();
                    Intent serviceIntent = new Intent(getContext(), MyService.class);
                    serviceIntent.putExtra("hour", forCreateComboH); // Замените "a" на нужное вам значение часов
                    serviceIntent.putExtra("minute", forCreateComboM); // Замените "b" на нужное вам значение минут
                    getContext().startService(serviceIntent);
//                   NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "mychannel")
//                            .setSmallIcon(R.drawable.ic_menu_camera)
//                            .setContentTitle("Напоминание создано")
//                            .setContentText(Created)
//                            .setPriority(NotificationCompat.PRIORITY_HIGH);
//
//                    NotificationManagerCompat notificationManager =
//                            NotificationManagerCompat.from(requireContext());
//                    if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//                        //    ActivityCompat#requestPermissions
//                        // here to request the missing permissions, and then overriding
//                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                        //                                          int[] grantResults)
//                        // to handle the case where the user grants the permission. See the documentation
//                        // for ActivityCompat#requestPermissions for more details.
//                        requireActivity().requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 999);
//
//                        return;
//                    }
//                    notificationManager.notify(NOTIFY_ID, builder.build());
                } else
                    Snackbar.make(container, R.string.fill_fields, BaseTransientBottomBar.LENGTH_SHORT).show();
            }

        });
        binding.Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(requireView()).navigate(R.id.action_navigation_home_to_getTime);
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        if (!String.valueOf(forCreateComboH).isEmpty()&&!String.valueOf(forCreateComboM).isEmpty()){
            String a;
            String b;
            if (forCreateComboH<10){
                a = "0"+forCreateComboH;
            } else a = forCreateComboH+"";
            if (forCreateComboM<10){
                b = "0"+forCreateComboM;
            } else b = forCreateComboM+"";
            binding.Time.setText(a+":"+b);
        }
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}