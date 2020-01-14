package com.example.locdaika.adidi.Network;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.example.locdaika.adidi.R;

public class MyReceiver extends BroadcastReceiver {
    CardView cardNetwork;
    Context context;
    Dialog dialog;

    @Override
    public void onReceive(final Context context, Intent intent) {
        this.context = context;
        String status = NetworkUtil.getConnectivityStatusString(context);
        dialog = new Dialog(context);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_checknetwork);
        cardNetwork = dialog.findViewById(R.id.cardNetwork);
        cardNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
            }
        });
        if (status.isEmpty()) {
            status = "0";
        }
        if (status.equals("0")) {
            Toast.makeText(context, "Turn off", Toast.LENGTH_SHORT).show();
            dialog.show();
        } else if (status.equals("1")){
            Toast.makeText(context, "Turn on", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }
    }
}