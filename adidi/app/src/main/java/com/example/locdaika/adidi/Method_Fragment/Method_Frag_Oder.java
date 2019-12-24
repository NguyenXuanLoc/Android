package com.example.locdaika.adidi.Method_Fragment;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Acount_model;
import com.example.locdaika.adidi.model.Address_model;

import androidx.appcompat.app.AppCompatActivity;

public class Method_Frag_Oder extends AppCompatActivity {
    Context context;

    public Method_Frag_Oder(Context context) {
        this.context = context;
    }

    public void Spinner(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.Spinner_Grounp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void getAddress(Address_model model){
//        Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
//        Toast.makeText(context, model.getAddress(), Toast.LENGTH_SHORT).show();
//    }
}
