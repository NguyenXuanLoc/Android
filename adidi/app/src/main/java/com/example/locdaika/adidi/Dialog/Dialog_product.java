package com.example.locdaika.adidi.Dialog;

import android.app.Dialog;
import android.content.Context;

import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.Adapter.Adapter_ProductGr;
import com.example.locdaika.adidi.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dialog_product extends AppCompatActivity {
    Context context;

    public Dialog_product(Context context) {
        this.context = context;
    }

    public void Dialog_ProductGr(Dialog dialog) {
        RecyclerView ry_proguctGr;
        dialog.setTitle("Lựa chọn nhóm sản phẩm");
        dialog.setContentView(R.layout.dialog_product_group);
        ry_proguctGr = dialog.findViewById(R.id.ry_productGr);
        LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        Adapter_ProductGr adapter_productGr = new Adapter_ProductGr(context, Main_page.arr_Product);
        ry_proguctGr.setAdapter(adapter_productGr);
        ry_proguctGr.setLayoutManager(manager);
        dialog.show();

    }
}
