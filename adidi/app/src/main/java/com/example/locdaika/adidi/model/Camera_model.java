package com.example.locdaika.adidi.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Camera_model implements Serializable {
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
