package com.example.locdaika.adidi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.locdaika.adidi.Activity.Service_Activity;
import com.example.locdaika.adidi.Key.Key_intent;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Service_model;

import java.io.Serializable;
import java.security.Key;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_service extends RecyclerView.Adapter<Adapter_service.Viewholder> {
    Context context;
    ArrayList<Service_model> arr;

    public Adapter_service(Context context, ArrayList<Service_model> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_service, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final Service_model model = arr.get(position);
        holder.img_service.setImageResource(model.getImage());
        holder.txt_service.setText(model.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Service_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Key_intent.Key_oder,model);
                intent.putExtra(Key_intent.Key_oder,bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        ImageView img_service;
        TextView txt_service;
        View view;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img_service = itemView.findViewById(R.id.img_service);
            txt_service = itemView.findViewById(R.id.txt_service);
            view = itemView;
        }
    }
}
