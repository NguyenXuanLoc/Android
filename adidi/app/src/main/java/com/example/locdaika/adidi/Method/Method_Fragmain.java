package com.example.locdaika.adidi.Method;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.Toolbar;

import com.example.locdaika.adidi.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class Method_Fragmain extends AppCompatActivity {
    Context context;

    public Method_Fragmain(Context context) {
        this.context = context;
    }

    public static String TwoWord(String Service) {
        String[] arr = Service.split(" ");
        String Result = "";
        int dem = 0;
        for (int i = 0; i < arr.length; i++) {
            if (dem > 0 && i % 2 == 0) {
                Result += "\n";
            }
            Result += arr[i] + " ";
            dem++;
        }
        return Result;
    }

    public void eventRefresh(final SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeColors(context.getResources().getColor(R.color.orange));
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

    public void eventScroll(NestedScrollView scrollView, final androidx.appcompat.widget.Toolbar toolbar, final Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        }
        if (scrollView != null) {
            scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if (scrollY > oldScrollY) {
                        toolbar.setBackgroundColor(context.getResources().getColor(R.color.white));
                    }
                    if (scrollY == 0) {
                        toolbar.setBackground(context.getResources().getDrawable(R.drawable.color_toolbar));
                    }
                }
            });
        }
    }

    private void changeColorStatus(int drawable, Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setBackgroundDrawable(getResources().getDrawable(drawable));
        }
    }
}
