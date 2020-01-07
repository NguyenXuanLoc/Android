package com.example.locdaika.adidi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.locdaika.adidi.Adapter.Adapter_ProductGr;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Address_model;
import com.example.locdaika.adidi.model.Product_model;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class test extends AppCompatActivity {
    Button button;
    LinearLayout mlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        snackbar();
    }
    private void snackbar() {
        mlayout = findViewById(R.id.layout);
        Snackbar snackbar = Snackbar.make(mlayout, "", Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        View snackview = getLayoutInflater().inflate(R.layout.snack_gps, null);
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)layout.getLayoutParams();
        params.gravity = Gravity.TOP;
        layout.setLayoutParams(params);
        layout.setPadding(0, 0, 0, 0);
        layout.addView(snackview, 0);
        snackbar.show();
    }
}

