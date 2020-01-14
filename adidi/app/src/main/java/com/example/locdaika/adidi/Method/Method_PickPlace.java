package com.example.locdaika.adidi.Method;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.locdaika.adidi.Fragment_Service.Frag_Service_Oder;
import com.example.locdaika.adidi.R;

import java.io.IOException;
import java.util.List;

public class Method_PickPlace extends AppCompatActivity {
    Context context;
    public String address = "";
    public String city = "";
    public String state = "";
    public String zip = "";
    public String country = "";
    static String Eror = "Eror";

    public Method_PickPlace(Context context) {
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

