package com.example.locdaika.adidi.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
public class NetworkUtil {
    public static String getConnectivityStatusString(Context context) {
        String status = null;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                status = "1";
              //  status = "Wifi enabled";
                return status;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                status = "1";
            //    status = "Mobile data enabled";
                return status;
            }
        } else {
            status = "0";
        //    status = "No internet is available";
            return status;
        }
        return status;
    }
}