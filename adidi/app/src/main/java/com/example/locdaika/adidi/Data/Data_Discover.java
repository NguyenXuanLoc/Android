package com.example.locdaika.adidi.Data;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.locdaika.adidi.Activity.Main_page;
import com.example.locdaika.adidi.R;
import com.example.locdaika.adidi.model.Slider_model;

public class Data_Discover extends AppCompatActivity {
    Context context;

    public Data_Discover(Context context) {
        this.context = context;
    }

    public void add_discover() {
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
        Main_page.arr_discover.add(new Slider_model(R.drawable.discover_thacmac, title_thacmac, content_thacmac, ""));
        Main_page.arr_discover.add(new Slider_model(R.drawable.discover_vanchuyen, title_vanchuyen, content_vanchuyen, ""));
        Main_page.arr_discover.add(new Slider_model(R.drawable.discover_quockhanh, title_quockhanh, content_quockhanh, ""));
    }

}
