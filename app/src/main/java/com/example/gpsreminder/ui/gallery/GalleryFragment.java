package com.example.gpsreminder.ui.gallery;

import static com.example.gpsreminder.MainActivity.APP_PREFERENCES_PREMIUM;

import android.content.Context;
import com.example.gpsreminder.MainActivity.*;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gpsreminder.databinding.FragmentPremiumBinding;

public class GalleryFragment extends Fragment {

    SharedPreferences mSettings;
    private FragmentPremiumBinding binding;
    private int c;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentPremiumBinding.inflate(inflater, container, false);
//            if (mSettings.getString(APP_PREFERENCES_PREMIUM, "")){
//            binding.premium.setVisibility(View.GONE);
//        }
        View root = binding.getRoot();
        binding.premium.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String j;
                int i = c;
                switch (i){
                    case 0:
                        j = "Премиум появится в следующих обновлениях";
                        break;
                    case 1:
                        j = "Премиума пока нет";
                        break;
                    case 2:
                        j = "Эй, почему бы тебе не создать еще одно напоминание?";
                        break;
                    case 3:
                        j = "Обновление еще не вышло";
                        break;
                    case 4:
                        j = "Я не могу дать тебе то, чего нет";
                        break;
                    case 5:
                        j = "Потрать свое время продуктивнее";
                        break;
                    case 6:
                        j = "Последнее предупреждение 😡";
                        break;
                    default:
                        j = "Оно того стоило?";
                        binding.premium.setVisibility(View.GONE);
                        SharedPreferences.Editor editor = mSettings.edit();
                        editor.putString(APP_PREFERENCES_PREMIUM, "false");
                        editor.apply();
                        break;
                }
                Toast toast = Toast.makeText(getContext(),j, Toast.LENGTH_LONG);
                toast.show();
                c++;
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