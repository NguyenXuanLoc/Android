package com.example.locdaika.adidi.Fragment_Service;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.locdaika.adidi.Adapter.Adapter_ImgCamera;
import com.example.locdaika.adidi.Data.Data_Product_gr;
import com.example.locdaika.adidi.Dialog.Dialog_product;
import com.example.locdaika.adidi.Method_Fragment.Method_Frag_Oder;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.Activity.SearchAdd_Activity;
import com.example.locdaika.adidi.model.Camera_model;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Frag_Service_Oder extends Fragment {
    final int CAM_REQUEST = 1;
    final int GETIMG_REQUEST = 2;
    RelativeLayout layoutCam, layoutLir;
    View view;
    Method_Frag_Oder oder;
    LinearLayout layout_ProductGr;

    Data_Product_gr dataProductGr;
    Dialog_product dialog_product;
    Dialog dialog;
    Dialog dialogCam;
    TextView txt_Adress;
    ImageView imgCamera;

    Adapter_ImgCamera adapterImgCamera;
    RecyclerView ryCamera;
    ArrayList<Camera_model> arrCamera;
    LinearLayout layoutplace;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_servive_oder, container, false);
        init();
        handleEvent();
        return view;
    }

    private void init() {
        layoutplace = view.findViewById(R.id.layoutPlace);
        dialogCam = new Dialog(getActivity());
        dialogCam.setContentView(R.layout.dialog_getimgage);
        layoutCam = dialogCam.findViewById(R.id.layout_Cam);
        layoutLir = dialogCam.findViewById(R.id.layout_Lir);
        arrCamera = new ArrayList<>();
        ryCamera = view.findViewById(R.id.ryImageCamera);
        adapterImgCamera = new Adapter_ImgCamera(getActivity(), arrCamera);
        LinearLayoutManager managerCamera = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        ryCamera.setLayoutManager(managerCamera);
        ryCamera.setAdapter(adapterImgCamera);

        imgCamera = view.findViewById(R.id.imgCamera);
        txt_Adress = view.findViewById(R.id.txt_Add);
        dialog = new Dialog(getActivity(), R.style.Dialog);
        dialog_product = new Dialog_product(getActivity());
        dataProductGr = new Data_Product_gr(getActivity());
        dataProductGr.add();
        layout_ProductGr = view.findViewById(R.id.layout_ProductGr);
        oder = new Method_Frag_Oder(getActivity());
    }

    private void handleEvent() {
        eventProduct();
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCam.show();
            }
        });
        layoutplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchAdd_Activity.class));
            }
        });
        eventGetImg();
    }

    private void eventProduct() {
        layout_ProductGr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_product.Dialog_ProductGr(dialog);
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

    public void eventGetImg() {
        layoutCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, CAM_REQUEST);
                    dialogCam.dismiss();
                } catch (Exception e) {
                    Log.d("Error", e.toString());
                }
//                Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
            }
        });
        layoutLir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GETIMG_REQUEST);
                dialogCam.dismiss();
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResultReceived(String result) {
        txt_Adress.setText(result.toString());
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAM_REQUEST) {
            if (data != null) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                arrCamera.add(new Camera_model(bitmap));
                adapterImgCamera.notifyDataSetChanged();
            }
        }
        if (requestCode == GETIMG_REQUEST) {
            if (data != null) {
                Uri imageUri = data.getData();
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                arrCamera.add(new Camera_model(bitmap));
                adapterImgCamera.notifyDataSetChanged();
            }
        }
    }
}
