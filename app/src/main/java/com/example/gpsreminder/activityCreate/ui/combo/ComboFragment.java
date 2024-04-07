package com.example.gpsreminder.activityCreate.ui.combo;

import static androidx.core.content.ContextCompat.getSystemService;

import static com.example.gpsreminder.activityCreate.CreateActivity.TimePickOnCombo;

import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.app.Notification;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gpsreminder.R;
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

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

//        binding.time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TimePickOnCombo();
//                Toast.makeText(getContext(), "Сменить время", Toast.LENGTH_SHORT).show();
//            }
//        });

        binding.createComdoType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String Created = R.string.reminder  + binding.Name.getText().toString() + R.string.was_sch + binding.time.getText().toString();
                String Created = "Напоминание\"" + binding.Name.getText().toString() + "\" успешно создано";
                Snackbar.make(container, Created, BaseTransientBottomBar.LENGTH_SHORT).show();
                if (!binding.Name.getText().toString().isEmpty() && !binding.rad.getText().toString().isEmpty()) {
                    NotificationManager notificationManager = getSystemService(getContext(),NotificationManager.class);
                    NotificationChannel channel = new NotificationChannel("GPSR", "Напоминание успешно создано", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(channel);
                    Notification notification = new NotificationCompat.Builder(getContext(), "REM_CRE")
                            .setContentTitle("Напоминание создано")
                            .setContentText(Created)
                            .setSmallIcon(R.drawable.ic_menu_camera)
                            .build();
                    notificationManager.notify(52,notification);
                } else Snackbar.make (container, R.string.fill_fields,BaseTransientBottomBar.LENGTH_SHORT).show();
            }

        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}