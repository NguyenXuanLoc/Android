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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.locdaika.adidi.Adapter.Adapter_ProductGr;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Address_model;
import com.example.locdaika.adidi.model.Product_model;
import java.util.ArrayList;

public class test extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button = findViewById(R.id.btn_Click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   EventBus.getDefault().post(new Address_model("Hà nội","","",""));
            }
        });
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void eventToast(Address_model model) {
//        Toast.makeText(this, model.getAddress(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }
}

