package com.example.locdaika.adidi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Acount_model;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_create, btn_login;
    public static ArrayList<Acount_model> arr_acount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        handleEvent();
//        Intent intent = new Intent(this,Main_page.class);
//        startActivity(intent);
    }

    private void handleEvent() {
        add();
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
        btn_create = findViewById(R.id.btn_create);
        btn_login = findViewById(R.id.btn_login);
        arr_acount = new ArrayList<>();
    }

    private void add() {
        MainActivity.arr_acount.add(new Acount_model("a", "a", "a", "a", "a", "a"));
        MainActivity.arr_acount.add(new Acount_model("Loc", "Nguyen Xuan", "0966468393", "locduoi1998@gmail.com", "Loc31121", ""));
    }
}
