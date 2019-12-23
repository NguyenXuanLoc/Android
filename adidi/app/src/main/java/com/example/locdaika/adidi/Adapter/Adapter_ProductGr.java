package com.example.locdaika.adidi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locdaika.adidi.Activity.test;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Product_model;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_ProductGr extends RecyclerView.Adapter<Adapter_ProductGr.Viewholder> {
    Context context;
    ArrayList<Product_model> arr;
    private int lastSelectedPosition = -1;

    public Adapter_ProductGr(Context context, ArrayList<Product_model> arr) {
        this.context = context;
        this.arr = arr;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_product_gr, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, final int position) {
        holder.txt_Product.setText(arr.get(position).getName());
        holder.radio.setChecked(lastSelectedPosition == position);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        RadioButton radio;
        TextView txt_Product;
        View view;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            radio = itemView.findViewById(R.id.radio);
            radio.setEnabled(false);
            txt_Product = itemView.findViewById(R.id.txt_productGr);
            view = itemView;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}
