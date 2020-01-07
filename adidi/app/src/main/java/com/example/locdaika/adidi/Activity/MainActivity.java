package com.example.locdaika.adidi.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.SearchPlace.SearchAdd_Activity;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_create, btn_login;
    public static SharedPreferences preferences;
    LinearLayout mlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        handleEvent();
        Intent intent = new Intent(this, Main_page.class);
        startActivity(intent);
    }

    private void handleEvent() {
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Create_Activity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login_activity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        mlayout = findViewById(R.id.mylayout);
        preferences = getSharedPreferences("Acount", MODE_PRIVATE);
        btn_create = findViewById(R.id.btn_create);
        btn_login = findViewById(R.id.btn_login);
    }


}
