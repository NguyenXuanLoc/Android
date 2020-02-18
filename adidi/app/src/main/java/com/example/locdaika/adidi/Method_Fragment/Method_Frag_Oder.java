package com.example.locdaika.adidi.Method_Fragment;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.locdaika.adidi.Adapter.Adapter_ImgCamera;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Acount_model;
import com.example.locdaika.adidi.model.Address_model;
import com.example.locdaika.adidi.model.Camera_model;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Method_Frag_Oder extends AppCompatActivity {
    Context context;

    public Method_Frag_Oder(Context context) {
        this.context = context;
    }
    public void Spinner(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.spinnerGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
