package com.example.locdaika.adidi.Method;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
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
    public void eventScroll(NestedScrollView scrollView, final androidx.appcompat.widget.Toolbar toolbar) {
        if (scrollView != null) {
            scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if (scrollY > oldScrollY) {
                        toolbar.setBackgroundColor(context.getResources().getColor(R.color.whilte));
                    }
                    if (scrollY == 0) {
                     //   Log.d(TAG, "TOP SCROLL");
                        toolbar.setBackground(context.getResources().getDrawable(R.drawable.color_toolbar));
                    //    setStatusBarGradiant(getActivity(), R.drawable.color_statusbar);
                        //  toolbar.setBackgroundColor(getResources().getColor(R.color.orange));
                    }
                }
            });
        }
    }

}
