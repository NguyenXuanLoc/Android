package com.example.locdaika.adidi.Method;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.util.Log;

import com.example.locdaika.adidi.Fragment_Service.Frag_Oder;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Address_model;


import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Method_Service extends AppCompatActivity {
    Context context;
    public String address = "";
    public String city = "";
    public String state = "";
    public String zip = "";
    public String country = "";
    static String Eror = "Eror";

    public Method_Service(Context context) {
        this.context = context;
    }

    public void getAddress(Geocoder geocoder, double latitude, double longitude) throws IOException {
        List<Address> addresses = null;
        addresses = geocoder.getFromLocation(latitude, longitude, 1);
        address = addresses.get(0).getAddressLine(0);
        city = addresses.get(0).getLocality();
        state = addresses.get(0).getAdminArea();
        country = addresses.get(0).getCountryName();
    }

    public void Create_Frag(String name) {
        Fragment fragment = null;
        switch (name) {
            case "Giao hàng": {
                fragment = new Frag_Oder();
                break;
            }
            case "Lắp đặt vệ sinh": {

            }
            case "Giao hàng lắp đặt": {

            }
            case "Bảo hành sửa chữa": {
            }
            case "Thuê kho chia sẻ": {

            }
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.mylayout, fragment).commit();
    }
    public boolean isGPSEnabled(Activity activity) {
        LocationManager lm = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            Log.d(Eror, "gps provider error : " + e.getMessage());
        }

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            Log.d(Eror, "network provider error : " + e.getMessage());
        }
        return !(!gps_enabled && !network_enabled);
    }
}
