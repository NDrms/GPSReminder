package com.example.gpsreminder.activityCreate.ui.combo;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import static com.example.gpsreminder.activityCreate.CreateActivity.CHANNEL_ID;
import static com.example.gpsreminder.activityCreate.CreateActivity.NOTIFY_ID;

import android.Manifest;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gpsreminder.MainActivity;
import com.example.gpsreminder.R;
import com.example.gpsreminder.activityCreate.ui.time.TimeFragment;
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
        binding.timeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Для биндинга
        binding.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Сменить время", Toast.LENGTH_SHORT).show();
            }
        });

        binding.createComdoType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Следующая строка почему-то не работает, поэтому хардкод
                //String Created = R.string.reminder  + binding.Name.getText().toString() + R.string.was_sch + binding.time.getText().toString();
                String Created = "Напоминание\"" + binding.Name.getText().toString() + "\" установлено на время: " + binding.time.getText().toString();
                if (!binding.Name.getText().toString().isEmpty() && !binding.rad.getText().toString().isEmpty()) {
                    NotificationCompat.Builder builder =
                            new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                                    .setContentTitle("Создано напоминание")
                                    .setContentText(Created)
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    NotificationManagerCompat notificationManager =
                            NotificationManagerCompat.from(getContext());
                    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    notificationManager.notify(NOTIFY_ID, builder.build());
                    //Snackbar.make(container, Created, BaseTransientBottomBar.LENGTH_SHORT).show();
                } else Snackbar.make (container, R.string.fill_fields,BaseTransientBottomBar.LENGTH_SHORT).show();
            }

        });

        //конец

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}