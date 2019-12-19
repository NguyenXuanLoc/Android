package com.example.locdaika.adidi.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.Adapter.Adapter_Slider;
import com.example.locdaika.adidi.Adapter.Adapter_service;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Pager_prom_Adapter;
import com.example.locdaika.adidi.model.Service_model;
import com.example.locdaika.adidi.model.Slider_model;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import static com.example.locdaika.adidi.R.drawable.active_dot;

public class Frag_main extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    Toolbar toolbar;
    String TAG = "SCROLL";
    View view;
    RecyclerView re_Service;
    Adapter_service adapter_service;
    ArrayList<Service_model> arr;
    NestedScrollView scrollView;

    ViewPager Pager_Prom;
    Pager_prom_Adapter Adapter_Prom;
    SpringDotsIndicator Dots_prom;

    ViewPager Pager_Discover;
    Pager_prom_Adapter Adapter_Discover;
    SpringDotsIndicator Dots_Discover;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        init();
        eventHandle();
        return view;
    }

    private void init() {
        swipeRefreshLayout = view.findViewById(R.id.Refreshlayout);
        Dots_Discover = view.findViewById(R.id.dots_discover);
        Pager_Discover = view.findViewById(R.id.pager_discover);
        Adapter_Discover = new Pager_prom_Adapter(Main_page.arr_discover, getActivity());
        Pager_Discover.setAdapter(Adapter_Discover);
        Dots_Discover.setViewPager(Pager_Discover);
        Pager_Discover.setPadding(30, 0, 130, 0);

        Dots_prom = view.findViewById(R.id.dots_prom);
        Pager_Prom = view.findViewById(R.id.pager_Prom);
        Adapter_Prom = new Pager_prom_Adapter(Main_page.arr_prom, getActivity());
        Pager_Prom.setAdapter(Adapter_Prom);
        Dots_prom.setViewPager(Pager_Prom);
        Pager_Prom.setPadding(30, 0, 130, 0);
        toolbar = view.findViewById(R.id.toolbar);
        scrollView = view.findViewById(R.id.scrollView);
        arr = new ArrayList<>();
        adapter_service = new Adapter_service(getActivity(), arr);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3, RecyclerView.VERTICAL, false);
        re_Service = view.findViewById(R.id.re_service);
        re_Service.setAdapter(adapter_service);
        re_Service.setLayoutManager(manager);
    }

    private void eventHandle() {
        eventToolbar();
        eventScroll();
        add_service();
        eventRefresh();
    }

    private void eventRefresh() {
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 500);
            }
        });
    }

    private void eventScroll() {
        if (scrollView != null) {
            scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                    if (scrollY > oldScrollY) {
                        toolbar.setBackgroundColor(getResources().getColor(R.color.whilte));
                        Log.d(TAG, "Scroll DOWN");
                    }
                    if (scrollY == 0) {
                        Log.d(TAG, "TOP SCROLL");
                        toolbar.setBackgroundColor(getResources().getColor(R.color.orange));
                    }
                }
            });
        }
    }

    private void eventToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void add_service() {
        arr.add(new Service_model(R.drawable.service_delivery, getString(R.string.service_delivery)));
        arr.add(new Service_model(R.drawable.service_installation, getString(R.string.service_install)));
        arr.add(new Service_model(R.drawable.service_ship, getString(R.string.service_ship)));
        arr.add(new Service_model(R.drawable.service_guarantee, getString(R.string.service_guarantee)));
        arr.add(new Service_model(R.drawable.service_rent, getString(R.string.service_rent)));
        adapter_service.notifyDataSetChanged();
    }

    private void TwoWord(String text) {
        String t = "";
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (i < 2) {
                t += arr[i] + " ";
            } else t += "\n" + arr[i];
        }
        Toast.makeText(getActivity(), t, Toast.LENGTH_SHORT).show();
    }
}
