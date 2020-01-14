package com.example.locdaika.adidi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.locdaika.adidi.Data.Data_Discover;
import com.example.locdaika.adidi.Data.Data_Prom;
import com.example.locdaika.adidi.Fragment.Frag_Function;
import com.example.locdaika.adidi.Fragment.Frag_oder;
import com.example.locdaika.adidi.Fragment_Service.Frag_Service_Oder;
import com.example.locdaika.adidi.Fragment.Frag_main;
import com.example.locdaika.adidi.Fragment.Frag_notification;
import com.example.locdaika.adidi.Network.MyReceiver;
import com.example.locdaika.adidi.Network.NetworkUtil;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Product_model;
import com.example.locdaika.adidi.model.Service_model;
import com.example.locdaika.adidi.model.Slider_model;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Main_page extends AppCompatActivity {
    BottomNavigationView btnNa;
    LinearLayout layoutSnack, mlayout;
    public static ArrayList<Slider_model> arr_prom;
    public static ArrayList<Slider_model> arr_discover;
    public static ArrayList<Service_model> arr_Service;
    public static ArrayList<Product_model> arr_Product;
    Data_Prom data_prom;
    Data_Discover data_discover;
    BroadcastReceiver MyReceiver = null; // Thành phần chạy ngầm kierm tra Internet
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        init();
        eventHandle();
    }

    private void init() {
        mlayout = findViewById(R.id.layout);
        data_discover = new Data_Discover(this);
        data_prom = new Data_Prom(this);
        layoutSnack = findViewById(R.id.layoutsnack);
        arr_Product = new ArrayList<>();
        arr_Service = new ArrayList<>();
        arr_discover = new ArrayList<>();
        arr_prom = new ArrayList<>();
        btnNa = findViewById(R.id.btnNa);
        btnNa.clearAnimation();
    }
    private void eventHandle() {
        getSupportFragmentManager().beginTransaction().replace(R.id.layout, new Frag_main()).commit();
        eventBotom();
        data_prom.add_prom();
        data_discover.add_discover();
        checkGPS();
        MyReceiver= new MyReceiver();
        registerReceiver(MyReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
    private void eventBotom() {
        btnNa.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.me_main: {
                        fragment = new Frag_main();
                        break;
                    }
                    case R.id.me_oder: {
                        fragment = new Frag_oder();
                        break;
                    }
                    case R.id.me_no: {
                        fragment = new Frag_notification();
                        break;
                    }
                    case R.id.me_funtion: {
                        fragment = new Frag_Function();
                        break;
                    }
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.layout, fragment).commit();
                return true;
            }
        });
    }
    private void checkGPS() {
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!enabled) {
            snackbar();
        }
    }
    private void snackbar() {
        final Snackbar snackbar = Snackbar.make(layoutSnack, "", Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        View snackview = getLayoutInflater().inflate(R.layout.snack_gps, null);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layout.getLayoutParams();
        params.gravity = Gravity.TOP;
        layout.setLayoutParams(params);
        snackview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                snackbar.dismiss();
            }
        });
        layout.setPadding(0, 0, 0, 0);
        layout.addView(snackview, 0);
        snackbar.show();

    }
}
