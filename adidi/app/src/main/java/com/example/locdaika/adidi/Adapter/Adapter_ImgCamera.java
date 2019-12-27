package com.example.locdaika.adidi.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Camera_model;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_ImgCamera extends RecyclerView.Adapter<Adapter_ImgCamera.Viewholder> {
    Context context;
    ArrayList<Camera_model> arr;

    public Adapter_ImgCamera(Context context, ArrayList<Camera_model> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_camera, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Camera_model data_camera = arr.get(position);
        holder.imgCamera.setImageBitmap(data_camera.getImage());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        ImageView imgCamera, imgRemove;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgCamera = itemView.findViewById(R.id.img_camera);
            imgRemove = itemView.findViewById(R.id.img_remove);
        }
    }
}
