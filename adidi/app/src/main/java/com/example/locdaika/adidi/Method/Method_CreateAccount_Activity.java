package com.example.locdaika.adidi.Method;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.locdaika.adidi.Activity.Create_Activity;
import com.example.locdaika.adidi.Activity.MainActivity;
import com.example.locdaika.adidi.Data.DataAccount;
import com.example.locdaika.adidi.R;

public class Method_CreateAccount_Activity extends AppCompatActivity {
    Context Context;
    boolean checked = true;
    DataAccount Account;
    String FirstName, LastName, Number, Email, Pass, Code;

    public Method_CreateAccount_Activity(Context context, DataAccount account) {
        this.Context = context;
        this.Account = account;
    }

    public void EventCreateAccount(Button btnCreate, final EditText edtFirstName, final EditText edtLastName, final EditText edtPhoneNumber, final EditText edtEmail, final EditText edtPass, final EditText edtCode) {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkError(edtFirstName, edtLastName, edtPhoneNumber, edtEmail, edtPass, edtCode);
                if (checked == true) {
                    Account.RemoveAcount(MainActivity.preferences, FirstName, LastName, Number, Email, Pass, Code);
                    FirstName = edtFirstName.getText().toString();
                    LastName = edtLastName.getText().toString();
                    Number = edtPhoneNumber.getText().toString();
                    Email = edtEmail.getText().toString();
                    Pass = edtPass.getText().toString();
                    Code = edtCode.getText().toString();
                    Account.RemoveAcount(MainActivity.preferences, DataAccount.FirstName, DataAccount.LastName, DataAccount.Number, DataAccount.Email, DataAccount.Pass, DataAccount.Code);
                    Account.CreateAcount(MainActivity.preferences, FirstName, LastName, Number, Email, Pass, Code);
                    Toast.makeText(Context, Context.getResources().getString(R.string.createAccountSuccess), Toast.LENGTH_SHORT).show();
//                    finish();
                } else {
                    Toast.makeText(Context, Context.getResources().getString(R.string.checkNull), Toast.LENGTH_SHORT).show();
                }
                checked = true;
            }
        });
    }

    private void checkError(final EditText edtFirstName, final EditText edtLastName, final EditText edtPhoneNumber, final EditText edtEmail, final EditText edtPass, final EditText edtCode) {
        if (edtFirstName.length() == 0) {
            edtFirstName.setError(Context.getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtLastName.length() == 0) {
            edtLastName.setError(Context.getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtPass.length() == 0) {
            edtPass.setError(Context.getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtPhoneNumber.length() == 0) {
            edtPhoneNumber.setError(Context.getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtEmail.length() == 0) {
            edtEmail.setError(Context.getResources().getString(R.string.notSpace));
            checked = false;
        }
        if (edtCode.length() == 0) {
            edtCode.setError(Context.getResources().getString(R.string.notSpace));
            checked = false;
        }
    }

    public void eventRules(TextView txtRules) {
        String text = "Bằng việc đăng ký tài khoản, tôi đồng ý với Điều " +
                "khoản và điều kiện và Chính sách bảo mật của ADIDI";
        SpannableString s = new SpannableString(text);
        ClickableSpan c1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Context.getResources().getColor(R.color.orange));
            }
        };
        ClickableSpan c2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Context.getResources().getColor(R.color.orange));
            }
        };
        s.setSpan(c1, 44, 67, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(c2, 71, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtRules.setText(s);
    }

}
