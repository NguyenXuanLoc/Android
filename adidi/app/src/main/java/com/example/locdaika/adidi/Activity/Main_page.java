package com.example.locdaika.adidi.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.locdaika.adidi.Fragment_Service.Frag_Oder;
import com.example.locdaika.adidi.Fragment.Frag_main;
import com.example.locdaika.adidi.Fragment.Frag_notification;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Product_model;
import com.example.locdaika.adidi.model.Service_model;
import com.example.locdaika.adidi.model.Slider_model;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Main_page extends AppCompatActivity {
    BottomNavigationView btnNa;
    public static ArrayList<Slider_model> arr_prom;
    public static ArrayList<Slider_model> arr_discover;
    public static ArrayList<Service_model> arr_Service;
    public static ArrayList<Product_model> arr_Product;
//public static ArrayList<Camer_da>
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        init();
        eventHandle();
    }

    private void init() {
        arr_Product = new ArrayList<>();
        arr_Service = new ArrayList<>();
        arr_discover = new ArrayList<>();
        arr_prom = new ArrayList<>();
        btnNa = findViewById(R.id.btnNa);
        btnNa.clearAnimation();
        getSupportActionBar().hide();
    }

    private void eventHandle() {
        getSupportFragmentManager().beginTransaction().replace(R.id.layout, new Frag_main()).commit();
        eventBotom();
        add_prom();
        add_discover();
    }

    private void eventBotom() {
        btnNa.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.me_main: {
                        Toast.makeText(Main_page.this, "A", Toast.LENGTH_SHORT).show();
                        fragment = new Frag_main();
                        break;
                    }
                    case R.id.me_oder: {
                        Toast.makeText(Main_page.this, "B", Toast.LENGTH_SHORT).show();
                        fragment = new Frag_Oder();
                        break;
                    }
                    case R.id.me_no: {
                        fragment = new Frag_notification();
                        break;
                    }
                    case R.id.me_funtion: {
                        fragment = new Frag_notification();
                        break;
                    }
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.layout, fragment).commit();
                return true;
            }
        });
    }

    public static void add_prom() {
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
        arr_prom.add(new Slider_model(R.drawable.prom_vesinh, vesinh, content_vs, "R.drawable.prom_vesinh"));
        arr_prom.add(new Slider_model(R.drawable.prom_donhang, donhang, content_dh, "R.drawable.prom_donhang"));
        arr_prom.add(new Slider_model(R.drawable.prom_giaohang, giaohang, content_gh, "R.drawable.prom_giaohang"));
    }

    private void add_discover() {
        String title_quockhanh = "CHÀO MỪNG NGÀY QUỐC KHÁNH 2/9";
        String content_quockhanh = "ADiDi xin kính chúc toàn thể quý khách hàng và đối tác một ngày nghỉ tràn đầy hứng hòa " +
                "chung niềm vui với toàn dân tộc";
        String title_vanchuyen = "BÍ KÍP TIẾT KIỆM CHI PHÍ VÂN CHUYỂN";
        String content_vanchuyen = "Bạn là Shop Online, bạn là doanh nghiệp bán hàng, bạn đang đau đầu vì phải tiết kiệm" +
                "chi phí vận chuyển mà vẫn phải giao đủ hàng hóa tới khách hàng ??? Đừng lo!!! Chỉ có tại ADiDi - Dịch vụ Giao Hàng với tiện ích tối ưu hóa hành trình giúp bạn có thể tiết kieemk chi phí một cách tốt nhất." +
                "\n Chỉ bằng thao tác đơn giản đặt đơn hàng tại App ADiDi và chọn tối ưu hành trình là bạn đã nhận được vô vàn các tiện ích chỉ có tại ADiDi:" +
                "\n-Tiết kiệm chi phí \n-Tự động sắp xếp hợp lý các điểm giao hàng" +
                "\n-Cộng nghệ 4.0 tối ưu rút ngắn khoảng cách \n-Vận chuyển hàng hóa nhanh hơn" +
                "\n-Tiết kiệm thời gian, vận chuyển một cách hiệu quả";
        String title_thacmac = "THẮC MẮC VỀ MỘT NGÀY LÀM VIỆC CỦA CÁC ANH ĐỐI TÁC ";
        String content_thacmac = "ADiDi LÀ NHƯ THẾ NÀO?\", \"Thì sáng sớm ra cafe, tối khuya trở về nhà, còn trong khoảng từ sáng tới tối thì tất bật ngang dọc đẻ\" +\n" +
                "                \"mang đến cho khách hàng những dịch vụ tối ưu nhất vì với ADiDi sự hài lòng, tin tưởng của khách hàng là ưu tiên hàng đầu!!!!";
        arr_discover.add(new Slider_model(R.drawable.discover_thacmac, title_thacmac, content_thacmac, ""));
        arr_discover.add(new Slider_model(R.drawable.discover_vanchuyen, title_vanchuyen, content_vanchuyen, ""));
        arr_discover.add(new Slider_model(R.drawable.discover_quockhanh, title_quockhanh, content_quockhanh, ""));
    }
}
