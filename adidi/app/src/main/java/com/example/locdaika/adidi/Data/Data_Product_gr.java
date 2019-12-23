package com.example.locdaika.adidi.Data;

import android.content.Context;

import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.model.Product_model;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Data_Product_gr extends AppCompatActivity {
    Context context;

    public Data_Product_gr(Context context) {
        this.context = context;
    }

    public void add(){
        Main_page.arr_Product.add(new Product_model("Phổ thông"));
        Main_page.arr_Product.add(new Product_model("Điện máy"));
        Main_page.arr_Product.add(new Product_model("Tivi"));
        Main_page.arr_Product.add(new Product_model("Tủ lạnh"));
        Main_page.arr_Product.add(new Product_model("Máy giặt"));
        Main_page.arr_Product.add(new Product_model("Máy sấy"));
        Main_page.arr_Product.add(new Product_model("Điều hòa"));
        Main_page.arr_Product.add(new Product_model("Tủ đông"));
        Main_page.arr_Product.add(new Product_model("Máy nước nóng"));
        Main_page.arr_Product.add(new Product_model("Máy lọc nước"));
        Main_page.arr_Product.add(new Product_model("Máy hút bụi"));
        Main_page.arr_Product.add(new Product_model("Máy hút mùi"));
        Main_page.arr_Product.add(new Product_model("Ghế massage"));
        Main_page.arr_Product.add(new Product_model("Máy chạy bộ"));
    }
}
