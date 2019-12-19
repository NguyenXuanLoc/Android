package com.example.locdaika.adidi.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.locdaika.adidi.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_Otp extends Fragment {
    EditText edt_number, edt_pass;
    TextView txt_forgot;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_otp,container,false);
       init();
        return view;
    }

    private void init() {
    edt_number = view.findViewById(R.id.edt_number);
    edt_pass  = view.findViewById(R.id.edt_pass);
    txt_forgot = view.findViewById(R.id.txt_forgot);
    }

}
