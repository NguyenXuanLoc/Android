package com.example.locdaika.adidi.Data;

import android.content.Context;

import com.example.locdaika.adidi.Activity.MainPage_Activity;
import com.example.locdaika.adidi.model.Product_model;

import androidx.appcompat.app.AppCompatActivity;

public class Data_Product_gr extends AppCompatActivity {
    Context context;

    public Data_Product_gr(Context context) {
        this.context = context;
    }
    public void add(){
        MainPage_Activity.arrProduct.add(new Product_model("Phổ thông"));
        MainPage_Activity.arrProduct.add(new Product_model("Điện máy"));
        MainPage_Activity.arrProduct.add(new Product_model("Tivi"));
        MainPage_Activity.arrProduct.add(new Product_model("Tủ lạnh"));
        MainPage_Activity.arrProduct.add(new Product_model("Máy giặt"));
        MainPage_Activity.arrProduct.add(new Product_model("Máy sấy"));
        MainPage_Activity.arrProduct.add(new Product_model("Điều hòa"));
        MainPage_Activity.arrProduct.add(new Product_model("Tủ đông"));
        MainPage_Activity.arrProduct.add(new Product_model("Máy nước nóng"));
        MainPage_Activity.arrProduct.add(new Product_model("Máy lọc nước"));
        MainPage_Activity.arrProduct.add(new Product_model("Máy hút bụi"));
        MainPage_Activity.arrProduct.add(new Product_model("Máy hút mùi"));
        MainPage_Activity.arrProduct.add(new Product_model("Ghế massage"));
        MainPage_Activity.arrProduct.add(new Product_model("Máy chạy bộ"));
    }
}
