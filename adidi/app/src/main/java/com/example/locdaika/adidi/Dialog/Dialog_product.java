package com.example.locdaika.adidi.Dialog;

import android.app.Dialog;
import android.content.Context;

import com.example.locdaika.adidi.Activity.MainPage_Activity;
import com.example.locdaika.adidi.Adapter.Adapter_ProductGr;
import com.example.locdaika.adidi.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dialog_product extends AppCompatActivity {
    Context context;


    public Dialog_product(Context context) {
        this.context = context;
    }

    public void Dialog_ProductGr(Dialog dialog) {
        RecyclerView ryProductGroup;
        dialog.setTitle("Lựa chọn nhóm sản phẩm");
        dialog.setContentView(R.layout.dialog_product_group);
        ryProductGroup = dialog.findViewById(R.id.ryProductGr);
        LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        Adapter_ProductGr adapter_productGr = new Adapter_ProductGr(context, MainPage_Activity.arrProduct);
        ryProductGroup.setAdapter(adapter_productGr);
        ryProductGroup.setLayoutManager(manager);
        dialog.show();
    }

    public void Dialog_getImage(Dialog dialog) {
        dialog.setContentView(R.layout.dialog_getimgage);
        dialog.show();
    }
}
