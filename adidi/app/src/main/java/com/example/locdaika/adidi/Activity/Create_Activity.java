package com.example.locdaika.adidi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locdaika.adidi.Data.DataAccount;
import com.example.locdaika.adidi.Method.Method_CreateAccount_Activity;
import com.example.locdaika.adidi.R;

public class Create_Activity extends AppCompatActivity {
    TextView txtRules;
    EditText edtFirstname, edtLastname, edtPhoneNumber, edtEmail, edtPass, edtCode;
    Button btnCreate;
    boolean checked = true;
    String FirstName, LastName, Number, Email, Pass, Code;
    ImageView img_back;
    DataAccount Account;
    Method_CreateAccount_Activity method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acount);
        init();
        eventHandle();
    }

    private void init() {
        Account = new DataAccount();
        method = new Method_CreateAccount_Activity(this, Account);
        img_back = findViewById(R.id.img_back);
        btnCreate = findViewById(R.id.btn_create);
        edtCode = findViewById(R.id.edt_code);
        edtEmail = findViewById(R.id.edt_email);
        edtFirstname = findViewById(R.id.edt_firstname);
        edtLastname = findViewById(R.id.edt_lastname);
        edtPhoneNumber = findViewById(R.id.edt_number);
        edtPass = findViewById(R.id.edt_pass);
        txtRules = findViewById(R.id.txtRules);
    }

    private void eventHandle() {
        method.eventRules(txtRules);
        method.EventCreateAccount(btnCreate, edtFirstname, edtLastname, edtPhoneNumber, edtEmail, edtPass, edtCode);
//        eventCreateAcount();
        eventBack();
    }

    private void eventBack() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void eventCreateAcount() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkError();
                if (checked == true) {
                    Account.RemoveAcount(MainActivity.preferences, FirstName, LastName, Number, Email, Pass, Code);
                    FirstName = edtFirstname.getText().toString();
                    LastName = edtLastname.getText().toString();
                    Number = edtPhoneNumber.getText().toString();
                    Email = edtEmail.getText().toString();
                    Pass = edtPass.getText().toString();
                    Code = edtCode.getText().toString();
                    Account.RemoveAcount(MainActivity.preferences, DataAccount.FirstName, DataAccount.LastName, DataAccount.Number, DataAccount.Email, DataAccount.Pass, DataAccount.Code);
                    Account.CreateAcount(MainActivity.preferences, FirstName, LastName, Number, Email, Pass, Code);
                    Toast.makeText(Create_Activity.this, getResources().getText(R.string.createAccountSuccess), Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(Create_Activity.this, getResources().getText(R.string.checkNull), Toast.LENGTH_SHORT).show();
                checked = true;
            }
        });
    }

    private void checkError() {
        if (edtFirstname.length() == 0) {
            edtFirstname.setError(getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtLastname.length() == 0) {
            edtLastname.setError(getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtPass.length() == 0) {
            edtPass.setError(getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtPhoneNumber.length() == 0) {
            edtPhoneNumber.setError(getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtEmail.length() == 0) {
            edtEmail.setError(getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtCode.length() == 0) {
            edtCode.setError(getResources().getString(R.string.notSpace));
            checked = false;
        }
    }
}
