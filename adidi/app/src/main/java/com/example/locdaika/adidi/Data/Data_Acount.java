package com.example.locdaika.adidi.Data;

import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Data_Acount extends AppCompatActivity {
    public static String FirtName = "FirtName";
    public static String LastName = "LastName";
    public static String Number = "Number";
    public static String Email = "Email";
    public static String Pass = "Pass";
    public static String Code = "Code";

    public void CreateAcount(SharedPreferences preferences, String FirtName, String LastName, String Number, String Email, String Pass, String Code) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(this.FirtName, FirtName);
        editor.putString(this.LastName, LastName);
        editor.putString(this.Number, Number);
        editor.putString(this.Email, Email);
        editor.putString(this.Pass, Pass);
        editor.putString(this.Code, Code);
        editor.commit();
    }

    public void RemoveAcount(SharedPreferences preferences, String FirtName, String LastName, String Number, String Email, String Pass, String Code) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(FirtName);
        editor.remove(LastName);
        editor.remove(Number);
        editor.remove(Email);
        editor.remove(Pass);
        editor.remove(Code);
        editor.commit();
    }

    public boolean GetAcount(SharedPreferences preferences, String Number, String Pass) {
        String Num = preferences.getString(this.Number, "A");
        String Pas = preferences.getString(this.Pass, "A");
        if (Num.equalsIgnoreCase(Number) && Pas.equalsIgnoreCase(Pass)) return true;
        return false;
    }
}
