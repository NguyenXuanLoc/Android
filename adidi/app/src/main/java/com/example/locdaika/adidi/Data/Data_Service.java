package com.example.locdaika.adidi.Data;

import com.example.locdaika.adidi.Activity.Main_page;
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
        Main_page.arr_Service.clear();
        Main_page.arr_Service.add(new Service_model(R.drawable.service_delivery, Method_Fragmain.TwoWord(service_delivery)));
        Main_page.arr_Service.add(new Service_model(R.drawable.service_installation, Method_Fragmain.TwoWord(service_install)));
        Main_page.arr_Service.add(new Service_model(R.drawable.service_ship, Method_Fragmain.TwoWord(service_ship)));
        Main_page.arr_Service.add(new Service_model(R.drawable.service_guarantee, Method_Fragmain.TwoWord(service_guarantee)));
        Main_page.arr_Service.add(new Service_model(R.drawable.service_rent, Method_Fragmain.TwoWord(service_rent)));
    }
}
