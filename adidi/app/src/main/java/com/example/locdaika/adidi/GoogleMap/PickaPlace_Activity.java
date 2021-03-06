package com.example.locdaika.adidi.GoogleMap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locdaika.adidi.Key.Key_intent;
import com.example.locdaika.adidi.Method.Method_PickPlace;
import com.example.locdaika.adidi.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class PickaPlace_Activity extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    private GoogleMap mMap;
    LocationManager locationManager;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    public ArrayList<LatLng> listpoint;
    Geocoder geocoder;
    Method_PickPlace method_pickPlace;
    Button btnPick;
    TextView txtAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picka_place);
        init();
        eventHandle();
    }

    @SuppressLint("MissingPermission")
    private void init() {
        txtAdd = findViewById(R.id.txtAdd);
        btnPick = findViewById(R.id.btnPickPlace);
        method_pickPlace = new Method_PickPlace(this);
        geocoder = new Geocoder(this, Locale.getDefault());
        listpoint = new ArrayList<>();
        locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this); //You can also use LocationMana
        Map();
    }

    private void Map() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(PickaPlace_Activity.this);
    }

    private void eventHandle() {
        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PickaPlace_Activity.this, method_pickPlace.getAddress().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PickaPlace_Activity.this, SetupDelivery_Activity.class);
                intent.putExtra(Key_intent.keyTest, method_pickPlace.getAddress());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (listpoint.size() == 1) {
                    listpoint.clear();
                    mMap.clear();
                }
                listpoint.add(latLng);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                if (listpoint.size() == 1) {
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    try {
                        method_pickPlace.getAddress(geocoder, latLng.latitude, latLng.longitude);
                        txtAdd.setText(method_pickPlace.getAddress());
                        // Toast.makeText(PickaPlace_Activity.this, method_pickPlace.getAddress(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mMap.addMarker(markerOptions);
            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);
        mMap.moveCamera(cameraUpdate);
        locationManager.removeUpdates(this);
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
    }
}