package com.example.locdaika.adidi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

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
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.example.locdaika.adidi.Fragment_Service.Frag_Service_Oder;
import com.example.locdaika.adidi.Key.Key_intent;
import com.example.locdaika.adidi.Method.Method_Service;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Service_model;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;


import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Locale;

public class Service_Activity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnCameraIdleListener, GoogleMap.OnCameraMoveStartedListener,
        GoogleMap.OnCameraMoveListener, GoogleMap.OnCameraMoveCanceledListener,
        LocationListener {
    private static final int REQUEST_LOCATION = 1;
    androidx.appcompat.widget.Toolbar toolbar;
    private GoogleMap mMap;
    Fragment fragment;
    LinearLayout layout;

    LocationManager locationManager;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    Method_Service method_service;
    Geocoder geocoder;
    public static String test = "OK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_);
        init();
        handle();
    }

    private void handle() {
        Map();
        get_Intent();
    }

    @SuppressLint("MissingPermission")
    private void init() {
        geocoder = new Geocoder(this, Locale.getDefault());
        method_service = new Method_Service(this);
        locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this); //You can also use LocationManager.GPS_PROVIDER and LocationManager.PASSIVE_PROVIDER
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        layout = findViewById(R.id.mylayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.black_24dp);
        toolbar.setTitleTextColor(getResources().getColor(R.color.whilte));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.me_service, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void Map() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(Service_Activity.this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnCameraIdleListener(this);
        mMap.setOnCameraMoveStartedListener(this);
        mMap.setOnCameraMoveListener(this);
        mMap.setOnCameraMoveCanceledListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
        }
//        LatLng lng = new LatLng(21.039153, 105.774574);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lng, 16));
//        mMap.setMyLocationEnabled(true);
    }

    public void get_Intent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Key_intent.Key_oder);
        if (bundle != null) {
            Service_model model = (Service_model) bundle.getSerializable(Key_intent.Key_oder);
            toolbar.setTitle(model.getName());
        }
        //  Create_Frag(model.getName());
        fragment = new Frag_Service_Oder();
        getSupportFragmentManager().beginTransaction().replace(R.id.mylayout, fragment).commit();

    }

    @Override
    public void onCameraIdle() {
        layout.setVisibility(View.VISIBLE);
        Log.d("Move", "Stop");
    }

    @Override
    public void onCameraMoveStarted(int i) {
        Log.d("Move", "Start");
    }

    @Override
    public void onCameraMove() {
        layout.setVisibility(View.INVISIBLE);
        Log.d("Move", "Move");
    }

    @Override
    public void onCameraMoveCanceled() {
        Log.d("Move", "Stop");
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onLocationChanged(Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15);
        mMap.animateCamera(cameraUpdate);
        locationManager.removeUpdates(this);
        try {
            method_service.getAddress(geocoder, location.getLatitude(), location.getLongitude());
            Log.d("location", method_service.address + toString());
            if (!method_service.address.isEmpty()) {
                EventBus.getDefault().post(method_service.address.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
