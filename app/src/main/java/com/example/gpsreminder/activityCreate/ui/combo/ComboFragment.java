package com.example.gpsreminder.activityCreate.ui.combo;

import static androidx.navigation.Navigation.findNavController;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
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

import java.io.IOException;
import java.util.List;

public class ComboFragment extends Fragment {
    public static boolean TF = false;
    public static int timeH;
    public static int timeM;
    private static double latitude;
    private static double longitude;

    private FragmentComboRemindsBinding binding;


    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentComboRemindsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if (!String.valueOf(timeH).isEmpty() && !String.valueOf(timeM).isEmpty()) {
            String a;
            String b;
            if (timeH < 10) {
                a = "0" + timeH;
            } else a = timeH + "";
            if (timeM < 10) {
                b = "0" + timeM;
            } else b = timeM + "";
            binding.Time.setText(a + ":" + b);
        }
        binding.createComboType.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
                if (!binding.Name.getText().toString().isEmpty() && !binding.rad.getText().toString().isEmpty()) {
                    if (binding.address.getText().toString().isEmpty()) {
                        Snackbar.make(container, "Успешно", BaseTransientBottomBar.LENGTH_SHORT).show();
                    } else
                        Snackbar.make(container, "Укажите местоположение", BaseTransientBottomBar.LENGTH_SHORT).show();
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
                binding.Time.setOnClickListener(v2 -> findNavController(requireView()).navigate(R.id.action_navigation_home_to_getTime));
            }

        });
        binding.search.setOnClickListener(v -> {
            String i = binding.address.getText().toString();
            String j = getString(Integer.parseInt(i)).replace(" ", "+");
            String addressSearch = "https://geocode-maps.yandex.ru/1.x/?apikey=cf619ae1-5b04-429a-9f02-659c42baef0a&geocode=" + j + "&format=json";
        });

        return root;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        if (!String.valueOf(timeH).isEmpty() && !String.valueOf(timeM).isEmpty()) {
            String a;
            String b;
            if (timeH < 10) {
                a = "0" + timeH;
            } else a = timeH + "";
            if (timeM < 10) {
                b = "0" + timeM;
            } else b = timeM + "";
            binding.Time.setText(a + ":" + b);
        }
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}