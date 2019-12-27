package com.example.locdaika.adidi.Fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.Adapter.Adapter_service;
import com.example.locdaika.adidi.Data.Data_Service;
import com.example.locdaika.adidi.Method.Method_Fragmain;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.Adapter.Pager_prom_Adapter;
import com.smarteist.autoimageslider.IndicatorView.PageIndicatorView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.AnimationType;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

public class Frag_main extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    Toolbar toolbar;
    String TAG = "SCROLL";
    View view;

    RecyclerView re_Service;
    Adapter_service adapter_service;
    NestedScrollView scrollView;

    ViewPager Pager_Prom;
    Pager_prom_Adapter Adapter_Prom;
    PageIndicatorView Dots_prom;

    ViewPager Pager_Discover;
    Pager_prom_Adapter Adapter_Discover;
    PageIndicatorView Dots_Discover;
    Data_Service data_service;
    Method_Fragmain methodSub;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        init();
        eventHandle();
        return view;
    }

    private void init() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        data_service = new Data_Service();
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

        adapter_service = new Adapter_service(getActivity(), Main_page.arr_Service);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3, RecyclerView.VERTICAL, false);
        re_Service = view.findViewById(R.id.re_service);
        re_Service.setAdapter(adapter_service);
        re_Service.setLayoutManager(manager);

    }

    private void DostPorm() {
        Dots_prom = view.findViewById(R.id.dots_prom);
        Dots_prom.setCount(5); // specify total count of indicators
        Dots_prom.setSelection(2);
        Dots_prom.setViewPager(Pager_Prom);
        Dots_prom.setAnimationType(AnimationType.DROP);
        Pager_Prom.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Dots_prom.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void DostDiscover() {
        Dots_Discover = view.findViewById(R.id.dots_discover);
        Dots_Discover.setCount(5); // specify total count of indicators
        Dots_Discover.setSelection(2);
        Dots_Discover.setViewPager(Pager_Discover);
        Dots_Discover.setAnimationType(AnimationType.DROP);
        Pager_Discover.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Dots_Discover.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void eventHandle() {
        methodSub = new Method_Fragmain(getActivity());
        data_service.add_service();
       // adapter_service.notifyDataSetChanged();
        methodSub.eventScroll(scrollView, toolbar);
        methodSub.eventRefresh(swipeRefreshLayout);
        DostPorm();
        DostDiscover();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradiant(Activity activity, int drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(drawable);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }
}
