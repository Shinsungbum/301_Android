package com.example.and11_vendingmachine;

import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class ViewDTO {
    // 위젯 중에 텍스트뷰2개와 버튼하나는 세트로 같이 추가되거나 같이 동작을해야한다.
    // 이러한 위젯들을 하나로 묶어서 사용하면 훨씬 편리함. <= ViewHolder(추후 사용)
    TextView tv_name , tv_cnt ;
    Button btn_order ;

    public ViewDTO(TextView tv_name, TextView tv_cnt, Button btn_order) {
        this.tv_name = tv_name;
        this.tv_cnt = tv_cnt;
        this.btn_order = btn_order;
    }

    public TextView getTv_name() {
        return tv_name;
    }

    public void setTv_name(TextView tv_name) {
        this.tv_name = tv_name;
    }

    public TextView getTv_cnt() {
        return tv_cnt;
    }

    public void setTv_cnt(TextView tv_cnt) {
        this.tv_cnt = tv_cnt;
    }

    public Button getBtn_order() {
        return btn_order;
    }

    public void setBtn_order(Button btn_order) {
        this.btn_order = btn_order;
    }
}
