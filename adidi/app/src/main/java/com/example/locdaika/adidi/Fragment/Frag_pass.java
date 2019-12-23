package com.example.locdaika.adidi.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locdaika.adidi.Activity.MainActivity;
import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.Data.Data_Acount;
import com.example.locdaika.adidi.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_pass extends Fragment {
    TextView txt_forgot_pass;
    View view;
    EditText edt_Number, edt_Pass;
    Button btnLogin;
    Data_Acount acount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pass, container, false);
        init();
        handeEvent();
        return view;

    }

    private void init() {
        acount = new Data_Acount();
        edt_Number = view.findViewById(R.id.edt_number);
        edt_Pass = view.findViewById(R.id.edt_pass);
        btnLogin = view.findViewById(R.id.btn_Login);
        txt_forgot_pass = view.findViewById(R.id.txt_forgot);

    }

    private void handeEvent() {
        eventForgot();
        eventLogin();
    }

    private void eventForgot() {
        SpannableString content = new SpannableString("Quên mật khẩu");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        txt_forgot_pass.setText(content);
    }

    private void eventLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkNull() == true) {
                    String Email = edt_Number.getText().toString();
                    String Pass = edt_Pass.getText().toString();
                    if (acount.GetAcount(MainActivity.preferences, Email, Pass) == true) {
                        Intent intent = new Intent(getActivity(), Main_page.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(getActivity(), getResources().getText(R.string.wrongLogin), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkNull() {
        int check = 1;
        if (edt_Pass.getText().length() == 0) {
            edt_Pass.setError(getResources().getString(R.string.check));
            check = 0;
        }
        if (edt_Number.getText().length() == 0) {
            edt_Number.setError(getResources().getString(R.string.check));
            check = 0;
        }
        if (check == 0) return false;
        return true;
    }
}
