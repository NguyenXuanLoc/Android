package com.example.locdaika.adidi.Method_Fragment;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.locdaika.adidi.R;

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
}
