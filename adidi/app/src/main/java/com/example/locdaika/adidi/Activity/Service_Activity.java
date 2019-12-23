package com.example.locdaika.adidi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.locdaika.adidi.Fragment_Service.Frag_Oder;
import com.example.locdaika.adidi.Key.Key_intent;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Service_model;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class Service_Activity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnCameraIdleListener, GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnCameraMoveListener, GoogleMap.OnCameraMoveCanceledListener {
    private static final int REQUEST_LOCATION = 1;
    androidx.appcompat.widget.Toolbar toolbar;
    private GoogleMap mMap;
    Fragment fragment;
    LinearLayout layout;
    private FusedLocationProviderClient providerClient;

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
        Location();
    }

    private void init() {
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
        LatLng lng = new LatLng(21.093089, 105.681761);
        mMap.addMarker(new MarkerOptions().position(lng).title("Khu sinh thái"));
        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.location)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lng, 14));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
        }
        // Đường đi
        //mMap.addPolyline();
//        mMap.setOnCameraMoveCanceledListener(new GoogleMap.OnCameraMoveCanceledListener() {
//            @Override
//            public void onCameraMoveCanceled() {
//                Toast.makeText(Service_Activity.this, "Stop", Toast.LENGTH_SHORT).show();
//            }
//        });
        mMap.setMyLocationEnabled(true);
    }

    public void get_Intent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Key_intent.Key_oder);
        if (bundle!=null){
            Service_model model = (Service_model) bundle.getSerializable(Key_intent.Key_oder);
            toolbar.setTitle(model.getName());
        }
        //  Create_Frag(model.getName());
        fragment = new Frag_Oder();
        getSupportFragmentManager().beginTransaction().replace(R.id.mylayout, fragment).commit();

    }

    public void Create_Frag(String name) {
        Fragment fragment = null;
        switch (name) {
            case "Giao hàng": {
                fragment = new Frag_Oder();
                break;
            }
            case "Lắp đặt vệ sinh": {

            }
            case "Giao hàng lắp đặt": {

            }
            case "Bảo hành sửa chữa": {
            }
            case "Thuê kho chia sẻ": {

            }
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.mylayout, fragment).commit();
    }

    @Override
    public void onCameraIdle() {
        layout.setVisibility(View.VISIBLE);
        Log.d("Move", "Stop");
    }

    @Override
    public void onCameraMoveStarted(int i) {

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
    private void Location() {
        providerClient = LocationServices.getFusedLocationProviderClient(this);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        if (ActivityCompat.checkSelfPermission(Service_Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        providerClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    Log.d("Location", location.toString());
                } else Log.d("Location", "NULL");

            }
        });
    }
}
