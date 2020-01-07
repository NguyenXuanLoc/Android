package com.example.locdaika.adidi.SearchPlace;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.locdaika.adidi.R;

public class SearchAdd_Activity extends AppCompatActivity {
    AutoCompleteTextView autoSearch;

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
    }

    private void init() {
        autoSearch = findViewById(R.id.edtSearch);
    }

}