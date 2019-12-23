package com.example.locdaika.adidi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.locdaika.adidi.Adapter.Adapter_ProductGr;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Product_model;

import java.util.ArrayList;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ArrayList<Product_model> arrayList = new ArrayList<>();
        arrayList.add(new Product_model("A"));
        RecyclerView ry_proguctGr = findViewById(R.id.ry_productGr);
        GridLayoutManager manager = new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false);
        Adapter_ProductGr adapter_productGr = new Adapter_ProductGr(this, Main_page.arr_Product);
        ry_proguctGr.setAdapter(adapter_productGr);
        ry_proguctGr.setLayoutManager(manager);
    }
}
