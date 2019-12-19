package com.example.locdaika.adidi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Slider_model;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class Adapter_Slider extends SliderViewAdapter<Adapter_Slider.Viewhoder> {
    Context context;
    ArrayList<Slider_model> arr;

    public Adapter_Slider(Context context, ArrayList<Slider_model> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public Viewhoder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_slider, parent, false);
        return new Viewhoder(view);
    }

    @Override
    public void onBindViewHolder(Viewhoder viewHolder, int position) {
        Slider_model slider_model = arr.get(position);
        viewHolder.img_Promtion.setImageResource(slider_model.getImage());
        viewHolder.txt_Name.setText(slider_model.getTitle());
        viewHolder.txt_Infor.setText(slider_model.getContent());
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    class Viewhoder extends SliderViewAdapter.ViewHolder {
        ImageView img_Promtion;
        TextView txt_Name, txt_Infor, txt_Seermore;

        public Viewhoder(View itemView) {
            super(itemView);
            img_Promtion = itemView.findViewById(R.id.img_promotion);
            txt_Name = itemView.findViewById(R.id.txt_name_promtion);
            txt_Infor = itemView.findViewById(R.id.txt_Info_promtion);
            txt_Seermore = itemView.findViewById(R.id.txt_seemore_promtion);
        }
    }
}
