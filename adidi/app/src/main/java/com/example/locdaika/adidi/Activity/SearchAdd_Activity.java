package com.example.locdaika.adidi.Activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.SearchPlace.PlaceAutoSuggestAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class SearchAdd_Activity extends AppCompatActivity {
    AutoCompleteTextView autoSearch;
    final int Request_Speech = 1;
    ImageView imgMic;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_add_);
        init();
        eventHandle();
    }

    private void eventHandle() {
        autoSearch.setAdapter(new PlaceAutoSuggestAdapter(SearchAdd_Activity.this, android.R.layout.simple_list_item_1));
        imgMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void init() {
        imgMic = findViewById(R.id.imgMic);
        autoSearch = findViewById(R.id.edtSearch);
    }

    public void speak() {
        //intent to show speẹch dialog
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, Request_Speech);
        } else
            Toast.makeText(this, "YOUR DEVICE DONT SUPPORT SPEECH LANGUAGE !!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Request_Speech) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                Toast.makeText(this, result.get(0).trim(), Toast.LENGTH_SHORT).show();
                autoSearch.setText(result.get(0));
            }
        }

    }
}