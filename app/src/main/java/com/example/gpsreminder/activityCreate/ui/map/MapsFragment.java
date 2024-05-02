package com.example.gpsreminder.activityCreate.ui.map;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.FragmentMapsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.image.ImageProvider;

public class MapsFragment extends Fragment {//} implements OnMapReadyCallback {

    private FragmentMapsBinding binding;
    PlacemarkMapObject mark;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        BottomNavigationView navView = getActivity().findViewById(R.id.nav_view);

        navView.setVisibility(View.GONE);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.mapview.getMapWindow().getMap().move(
                new CameraPosition(
                        new Point(56.85781891, 35.9153214),//(, 37.629540),
                        /* zoom = */ 17.0f,
                        /* azimuth = */ 150.0f,
                        /* tilt = */ 30.0f
                )
        );

        binding.mapview.getMapWindow().getMap().addInputListener(new InputListener() {
            @Override
            public void onMapTap(@NonNull Map map, @NonNull Point point) {

                if (mark == null) {
                    mark = binding.mapview.getMapWindow().getMap().getMapObjects().addPlacemark(placemarkMapObject -> {
                        placemarkMapObject.setGeometry(point);
                        placemarkMapObject.setIcon(ImageProvider.fromResource(MapsFragment.this.getContext(), R.drawable.ic_map_pin));
                        IconStyle style = new IconStyle();
                        style.setAnchor(new PointF(0.5f, 0.84f));
                        style.setScale(0.25f);
                        placemarkMapObject.setIconStyle(style);


                    });
                } else {
                    mark.setGeometry(point);
                }
            }

            @Override
            public void onMapLongTap(@NonNull Map map, @NonNull Point point) {
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        MapKitFactory.getInstance().onStart();
        binding.mapview.onStart();

    }

    @Override
    public void onPause() {
        super.onPause();
        MapKitFactory.getInstance().onStop();
        binding.mapview.onStop();
    }

}
