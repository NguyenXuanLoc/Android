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
import com.example.locdaika.adidi.Activity.MainPage_Activity;
import com.example.locdaika.adidi.Data.DataAccount;
import com.example.locdaika.adidi.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_pass extends Fragment {
    TextView txt_forgot_pass;
    View view;
    EditText edtPhoneNumber, edtPass;
    Button btnLogin;
    DataAccount acount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pass, container, false);
        init();
        handeEvent();
        return view;

    }

    private void init() {
        acount = new DataAccount();
        edtPhoneNumber = view.findViewById(R.id.edtPhoneNumber);
        edtPass = view.findViewById(R.id.edtPass);
        btnLogin = view.findViewById(R.id.btnLogin);
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
                    String Email = edtPhoneNumber.getText().toString();
                    String Pass = edtPass.getText().toString();
                    if (acount.GetAcount(MainActivity.preferences, Email, Pass) == true) {
                        Intent intent = new Intent(getActivity(), MainPage_Activity.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(getActivity(), getResources().getText(R.string.wrongLogin), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkNull() {
        int check = 1;
        if (edtPass.getText().length() == 0) {
            edtPass.setError(getResources().getString(R.string.notSpace));
            check = 0;
        }
        if (edtPhoneNumber.getText().length() == 0) {
            edtPhoneNumber.setError(getResources().getString(R.string.notSpace));
            check = 0;
        }
        if (check == 0) return false;
        return true;
    }
}
