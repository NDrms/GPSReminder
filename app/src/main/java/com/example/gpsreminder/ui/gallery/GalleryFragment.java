package com.example.gpsreminder.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.databinding.FragmentPremiumBinding;

public class GalleryFragment extends Fragment {

    private FragmentPremiumBinding binding;
    private int c;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPremiumBinding.inflate(inflater, container, false);

        View root = binding.getRoot();
        binding.premium.setOnClickListener(v -> {
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
                    break;
            }
            Toast toast = Toast.makeText(getContext(),j, Toast.LENGTH_SHORT);
            toast.show();
            c++;
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}