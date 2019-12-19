package com.example.locdaika.adidi.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Service_model{
    int Image;
    String Name;

    public Service_model() {
    }

    public int getImage() {

        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Service_model(int image, String name) {

        Image = image;
        Name = name;
    }
}
