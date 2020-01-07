package com.example.locdaika.adidi.Data;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Slider_model;

public class Data_Prom extends AppCompatActivity {
    Context context;

    public Data_Prom(Context context) {
        this.context = context;
    }

    public void add_prom() {
        String vesinh = "VỆ SINH MÁY LẠNH- PHÁ ĐẢO CƠN NÓNG NGAY NÀO";
        String content_vs = "Nóng quá phải làm sao đây? Tại sao máy lạnh không lạnh?" +
                "\n Máy lạnh quá bẩn" +
                "\n Máy lạnh thiếu ga" +
                "\n Máy lạnh bị hỏng tụ" +
                "\n Và cả +" + "trăm ngàn" + " lý do khác nữa";
        String donhang = "ĐƠN HÀNG TRAO TAY, NHẬN NGAY TIỀN THƯỞNG";
        String content_dh = "Chẳng ngại bão tố, chẳng ngại cồng kềnh, chẳng ngại đèo núi gian nan vì" +
                "đã có ADiDi phục vụ nhanh chóng với nhứng ưu đãi 'siêu sịn xò':"
                + "\n Tặng ngay 100k vào ví tài khoản dành riêng cho thành viên mới của ADiDi" +
                "\n Áp dụng cho khách hàng đăng  ký ADiDi và phát sinh đơn hàng đầu tiên";
        String giaohang = "VI VU GIAO HÀNG - THỔI BAY CƠN NÓNG CÙNG ADiDi";
        String content_gh = "Đã có ADiDi, luôn sẵn sàng vi vu trên những cung đường, giúp bạn hoàng thành" +
                "những đơn hàng từ nhỏ đến cồng kềnh, với đội ngũ phương tiện đa dạng. Việc vận chuyển những đơn" +
                " hàng mùa nắng nóng không còn là gánh nặng vì đã có ADiDi.";
        Main_page.arr_prom.add(new Slider_model(R.drawable.prom_vesinh, vesinh, content_vs, "R.drawable.prom_vesinh"));
        Main_page.arr_prom.add(new Slider_model(R.drawable.prom_donhang, donhang, content_dh, "R.drawable.prom_donhang"));
        Main_page.arr_prom.add(new Slider_model(R.drawable.prom_giaohang, giaohang, content_gh, "R.drawable.prom_giaohang"));
    }

}
