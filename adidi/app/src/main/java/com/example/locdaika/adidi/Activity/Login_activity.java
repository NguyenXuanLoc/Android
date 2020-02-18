package com.example.locdaika.adidi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.locdaika.adidi.Data.DataAccount;
import com.example.locdaika.adidi.Fragment.Frag_Otp;
import com.example.locdaika.adidi.Fragment.Frag_pass;
import com.example.locdaika.adidi.R;
import com.google.android.material.tabs.TabLayout;

public class Login_activity extends AppCompatActivity {
    TabLayout tabLayout;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        init();
        eventHandle();
    }

    private void init() {
        img_back = findViewById(R.id.img_back);
        FragmentTransaction transaction;
        Fragment fragment = new Frag_pass();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout, fragment);
        transaction.commit();
        tabLayout = findViewById(R.id.tab_layout);
    }

    public void eventHandle() {
        eventTab();
        eventImg();
    }

    private void eventImg() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void eventTab() {
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                if (tab.getPosition() == 0)
                    fragment = new Frag_pass();
                else fragment = new Frag_Otp();
                load_Fragment(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public boolean load_Fragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.layout, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
        return false;
    }
}
