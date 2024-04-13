package com.example.gpsreminder.activityCreate.ui.combo;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.FragmentComboRemindsBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class ComboFragment extends Fragment {

    private FragmentComboRemindsBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentComboRemindsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.createComboType.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
//                String Created = "Напоминание \"" + binding.Name.getText().toString() + "\" успешно создано";
                if (!binding.Name.getText().toString().isEmpty() && !binding.rad.getText().toString().isEmpty()) {
                    Snackbar.make(container, "Успешно", BaseTransientBottomBar.LENGTH_SHORT).show();
/*                    NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "mychannel")
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
//                    notificationManager.notify(NOTIFY_ID, builder.build());*/
                } else
                    Snackbar.make(container, R.string.fill_fields, BaseTransientBottomBar.LENGTH_SHORT).show();
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