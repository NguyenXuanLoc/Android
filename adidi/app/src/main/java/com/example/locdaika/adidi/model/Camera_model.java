package com.example.locdaika.adidi.model;

import android.graphics.Bitmap;

public class Camera_model {
    Bitmap Image;

    public Camera_model() {
    }

    public Bitmap getImage() {

        return Image;
    }

    public void setImage(Bitmap image) {
        Image = image;
    }

    public Camera_model(Bitmap image) {

        Image = image;
    }
}
