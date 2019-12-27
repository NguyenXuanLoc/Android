package com.example.locdaika.adidi.Fragment_Service;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.Activity.Service_Activity;
import com.example.locdaika.adidi.Adapter.Adapter_ImgCamera;
import com.example.locdaika.adidi.Adapter.Adapter_ProductGr;
import com.example.locdaika.adidi.Data.Data_Product_gr;
import com.example.locdaika.adidi.Dialog.Dialog_product;
import com.example.locdaika.adidi.Method_Fragment.Method_Frag_Oder;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Address_model;
import com.example.locdaika.adidi.model.Camera_model;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Frag_Oder extends Fragment {
    private static final int CAM_REQUEST = 1;
    View view;
    Method_Frag_Oder oder;
    LinearLayout layout_ProductGr;
    RecyclerView ry_proguctGr;

    Adapter_ProductGr adapter_productGr;
    Data_Product_gr dataProductGr;
    Dialog_product dialog_product;
    Dialog dialog;
    TextView txt_Adress;
    ImageView imgCamera;

    Adapter_ImgCamera adapterImgCamera;
    RecyclerView ryCamera;
    ArrayList<Camera_model> arrCamera;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_oder, container, false);
        init();
        handleEvent();
        return view;
    }

    private void init() {
        arrCamera = new ArrayList<>();
        ryCamera = view.findViewById(R.id.rycamera);
        adapterImgCamera = new Adapter_ImgCamera(getActivity(), arrCamera);
        LinearLayoutManager managerCamera = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        ryCamera.setLayoutManager(managerCamera);
        ryCamera.setAdapter(adapterImgCamera);

        imgCamera = view.findViewById(R.id.img_camera);
        txt_Adress = view.findViewById(R.id.txt_Add);
        dialog = new Dialog(getActivity(), R.style.Dialog);
        dialog.setTitle("Lựa chọn nhóm sản phẩm");
        dialog.setContentView(R.layout.dialog_product_group);
        ry_proguctGr = dialog.findViewById(R.id.ry_productGr);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        Adapter_ProductGr adapter_productGr = new Adapter_ProductGr(getActivity(), Main_page.arr_Product);
        ry_proguctGr.setAdapter(adapter_productGr);
        ry_proguctGr.setLayoutManager(manager);

        dataProductGr = new Data_Product_gr(getActivity());
        dataProductGr.add();
        layout_ProductGr = view.findViewById(R.id.layout_ProductGr);
        oder = new Method_Frag_Oder(getActivity());
    }

    private void handleEvent() {
        eventProduct();
        eventImgCamera();
    }

    private void eventProduct() {
        layout_ProductGr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResultReceived(String result) {
        txt_Adress.setText(result.toString());
    }

    public void eventImgCamera() {
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAM_REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAM_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            arrCamera.add(new Camera_model(bitmap));
            adapterImgCamera.notifyDataSetChanged();
        }
    }
}
