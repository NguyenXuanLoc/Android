package com.example.locdaika.adidi.GoogleMap;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locdaika.adidi.Key.Key_intent;
import com.example.locdaika.adidi.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;

public class SetupDelivery_Activity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mMap;
    TextView txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_delivery);
        init();
        eventHandle();
    }

    private void init() {
        txtAddress = findViewById(R.id.txtAdd);
        Map();
    }

    private void eventHandle() {
        getDataIntent();
    }

    private void Map() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(SetupDelivery_Activity.this);
    }

    private void getDataIntent() {
        Intent intent = getIntent();
        String Address = intent.getStringExtra(Key_intent.keyTest);
        if (!Address.isEmpty()) {
            txtAddress.setText(Address);
        } else
            Toast.makeText(this, "Bạn phải chọn địa điểm trước khi thiết lập điểm giao hàng !!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
        }
        LatLng lng = new LatLng(21.039153, 105.774574);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lng, 14));
        mMap.setMyLocationEnabled(true);
    }
}
