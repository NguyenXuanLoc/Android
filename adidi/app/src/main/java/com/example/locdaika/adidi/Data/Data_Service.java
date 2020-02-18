package com.example.locdaika.adidi.Data;

import com.example.locdaika.adidi.Activity.MainPage_Activity;
import com.example.locdaika.adidi.Method.Method_Fragmain;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Service_model;

import androidx.appcompat.app.AppCompatActivity;

public class Data_Service extends AppCompatActivity {
    public static String service_delivery = "Giao hàng";
    public static String service_install = "Lắp đặt vệ sinh";
    public static String service_ship = "Giao hàng lắp đặt";
    public static String service_guarantee = "Bảo hành sửa chữa";
    public static String service_rent = "Thuê kho chia sẻ";

    public Data_Service() {
    }

    public void add_service() {
        MainPage_Activity.arr_Service.clear();
        MainPage_Activity.arr_Service.add(new Service_model(R.drawable.service_delivery, Method_Fragmain.TwoWord(service_delivery)));
        MainPage_Activity.arr_Service.add(new Service_model(R.drawable.worker, Method_Fragmain.TwoWord(service_install)));
        MainPage_Activity.arr_Service.add(new Service_model(R.drawable.delivery, Method_Fragmain.TwoWord(service_ship)));
        MainPage_Activity.arr_Service.add(new Service_model(R.drawable.insurance, Method_Fragmain.TwoWord(service_guarantee)));
        MainPage_Activity.arr_Service.add(new Service_model(R.drawable.pallet, Method_Fragmain.TwoWord(service_rent)));
    }
}
