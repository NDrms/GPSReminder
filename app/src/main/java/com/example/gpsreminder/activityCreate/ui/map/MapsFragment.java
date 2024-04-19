package com.example.gpsreminder.activityCreate.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.gpsreminder.R;
import com.example.gpsreminder.databinding.FragmentMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.geometry.Point;

public class MapsFragment extends Fragment{//} implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FragmentMapsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.mapview.getMap().move(
                new CameraPosition(
                        new Point(-34.0, 151.0),//(55.751225, 37.629540),
                        /* zoom = */ 17.0f,
                        /* azimuth = */ 150.0f,
                        /* tilt = */ 30.0f
                )
        );
//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
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

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        LatLng sydney = new LatLng(-34.0, 151.0);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }

}
