package com.example.locdaika.adidi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Pager_prom_Adapter;
import com.example.locdaika.adidi.model.Slider_model;

import java.util.ArrayList;

public class test extends AppCompatActivity {
    ViewPager pager_Prom;
    Pager_prom_Adapter prom_adapter;
    ArrayList<Slider_model> arr_prom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        arr_prom = new ArrayList<>();
        pager_Prom= findViewById(R.id.viewpager);
        prom_adapter = new Pager_prom_Adapter(arr_prom,test.this);
        pager_Prom.setAdapter(prom_adapter);
        arr_prom.add(new Slider_model(R.drawable.prom_vesinh, "Vệ sinh", "a"));
        arr_prom.add(new Slider_model(R.drawable.prom_vesinh, "Vệ sinh", "a"));
        arr_prom.add(new Slider_model(R.drawable.prom_vesinh, "Vệ sinh", "a"));
        prom_adapter.notifyDataSetChanged();
    }
}
