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

import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Acount_model;

public class Create_Activity extends AppCompatActivity {
    TextView txt_rules;
    EditText edt_Firstname, edt_Lastname, edt_Number, edt_Email, edt_Pass, edt_Code;
    Button btn_Create;
    boolean checked = true;
    String FirtName, LastName, Number, Email, Pass, Code;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acount);
        init();
        handeEvent();
    }

    private void init() {
        img_back = findViewById(R.id.img_back);
        btn_Create = findViewById(R.id.btn_create);
        edt_Code = findViewById(R.id.edt_code);
        edt_Email = findViewById(R.id.edt_email);
        edt_Firstname = findViewById(R.id.edt_firstname);
        edt_Lastname = findViewById(R.id.edt_lastname);
        edt_Number = findViewById(R.id.edt_number);
        edt_Pass = findViewById(R.id.edt_pass);
        txt_rules = findViewById(R.id.rules);
    }

    private void handeEvent() {
        EventRules();
        EventButon();
        EventImg();
    }

    private void EventImg() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void EventButon() {
        btn_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventEditext();
                if (checked == true) {
                    FirtName = edt_Firstname.getText().toString();
                    LastName = edt_Lastname.getText().toString();
                    Number = edt_Number.getText().toString();
                    Email = edt_Email.getText().toString();
                    Pass = edt_Pass.getText().toString();
                    Code = edt_Code.getText().toString();
                    Acount_model model = new Acount_model(FirtName,LastName,Number,Email,Pass,Code);
                    if (checkAcount(Number,Email,model)== true){
                        MainActivity.arr_acount.add(new Acount_model(FirtName, LastName, Number, Email, Pass, Code));
                        Toast.makeText(Create_Activity.this, getResources().getText(R.string.createAcountSuccess), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(Create_Activity.this, getResources().getText(R.string.createAcountFail), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(Create_Activity.this, getResources().getText(R.string.checkNull), Toast.LENGTH_SHORT).show();
                checked = true;
            }
        });
    }

    private void EventEditext() {
        if (edt_Firstname.length() == 0) {
            edt_Firstname.setError(getResources().getString(R.string.check));
            checked = false;
        }
        if (edt_Lastname.length() == 0) {
            edt_Lastname.setError(getResources().getString(R.string.check));
            checked = false;
        }
        if (edt_Pass.length() == 0) {
            edt_Pass.setError(getResources().getString(R.string.check));
            checked = false;
        }
        if (edt_Number.length() == 0) {
            edt_Number.setError(getResources().getString(R.string.check));
            checked = false;
        }
        if (edt_Email.length() == 0) {
            edt_Email.setError(getResources().getString(R.string.check));
            checked = false;
        }
        if (edt_Code.length() == 0) {
            edt_Code.setError(getResources().getString(R.string.check));
            checked = false;
        }
    }

    private boolean checkAcount(String Number, String Email, Acount_model modelAdd) {
        for (int i = 0; i < MainActivity.arr_acount.size(); i++) {
            Acount_model model = MainActivity.arr_acount.get(i);
            if (Number.equalsIgnoreCase(model.getNumber()) ||
                    Email.equalsIgnoreCase(model.getEmail())) {
                Toast.makeText(this, getResources().getText(R.string.exist), Toast.LENGTH_SHORT).show();
                return false;
            } else {
                MainActivity.arr_acount.add(modelAdd);
                return true;
            }
        }
        return true;
    }

    private void EventRules() {
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
                ds.setColor(getResources().getColor(R.color.orange));
            }
        };
        ClickableSpan c2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(getResources().getColor(R.color.orange));
            }
        };
        s.setSpan(c1, 44, 67, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s.setSpan(c2, 71, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt_rules.setText(s);
    }
}
