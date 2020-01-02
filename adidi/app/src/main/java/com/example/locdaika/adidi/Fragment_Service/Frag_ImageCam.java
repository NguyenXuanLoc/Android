package com.example.locdaika.adidi.Fragment_Service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Camera_model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Frag_ImageCam extends Fragment {
    ImageView imgCam;
    View view;
    Camera_model model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_image_cam, container, false);
        init();
        getIntent();
        return view;
    }

    public void init() {
        imgCam = view.findViewById(R.id.imgCam);
    }
    public void getIntent() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            model = (Camera_model) bundle.getSerializable("data");
            imgCam.setImageBitmap(model.getImage());
        }
    }

}
