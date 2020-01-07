package com.example.locdaika.adidi.GoogleMap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.example.locdaika.adidi.Method.Method_Service;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Service_model;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Locale;

public class PickaPlace_Activity extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;
    private static final int PLACE_PICKER_REQ_CODE = 1;
    androidx.appcompat.widget.Toolbar toolbar;
    private GoogleMap mMap;

    LocationManager locationManager;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    Geocoder geocoder;
    Method_Service method_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picka_place);

        test();
    }

    private void test() {
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(47.64299816, -122.14351988),
                new LatLng(47.64299816, -122.14351988));
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        builder.setLatLngBounds(latLngBounds);

        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQ_CODE);
        } catch (Exception e) {
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode == PLACE_PICKER_REQ_CODE){
            if (resultCode == RESULT_OK) {
               Place place = PlacePicker.getPlace(this, data);
//                name.setText(place.getName());
            }
        }
    }
}