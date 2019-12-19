package com.example.locdaika.adidi.model;

public class Slider_model {
    int Image;
    String Title, Content;
    String Image_Content;

    public Slider_model(int image, String title, String content) {
        Image = image;
        Title = title;
        Content = content;
    }

    public Slider_model(int image, String title, String content, String image_Content) {
        Image = image;
        Title = title;
        Content = content;
        Image_Content = image_Content;
    }

    public Slider_model() {
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
