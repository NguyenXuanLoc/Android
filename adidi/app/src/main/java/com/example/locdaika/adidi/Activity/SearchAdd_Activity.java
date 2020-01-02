package com.example.locdaika.adidi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.locdaika.adidi.R;

public class SearchAdd_Activity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imgBack, imgMic, imgClear;
    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_add_);
        init();
        eventHandle();
    }

    private void eventHandle() {
        imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSearch.getText().length() > 0)
                    edtSearch.setText("");
            }
        });
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        imgBack = findViewById(R.id.imgback);
        imgClear = findViewById(R.id.imgClear);
        imgMic = findViewById(R.id.imgMic);
        edtSearch = findViewById(R.id.edtSearch);
    }

}
