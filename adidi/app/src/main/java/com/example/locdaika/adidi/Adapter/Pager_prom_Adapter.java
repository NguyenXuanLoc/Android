package com.example.locdaika.adidi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Slider_model;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Pager_prom_Adapter extends PagerAdapter {
    ArrayList<Slider_model> arr;
    LayoutInflater inflater;
    Context context;

    public Pager_prom_Adapter(ArrayList<Slider_model> arr, Context context) {
        this.arr = arr;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.row_slider, container, false);
        ImageView img_Promtion;
        TextView txt_Name, txt_Infor, txt_Seermore;
        img_Promtion = view.findViewById(R.id.img_promotion);
        txt_Name = view.findViewById(R.id.txtTitlePromotion);
        txt_Infor = view.findViewById(R.id.txtInfoPromotion);
        txt_Seermore = view.findViewById(R.id.txtSeeMore);
        Slider_model model = arr.get(position);
        img_Promtion.setImageResource(model.getImage());
        txt_Infor.setText(model.getContent());
        txt_Name.setText(model.getTitle());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
