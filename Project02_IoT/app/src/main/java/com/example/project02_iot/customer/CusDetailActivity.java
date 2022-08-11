package com.example.project02_iot.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CusDetailActivity extends AppCompatActivity {
    TextView tv_info;
    RadioButton rdo_man, rdo_woman;
    RadioGroup rdo_grp;
    EditText edt_email, edt_phone;
    Button btn_update,btn_close;
    CustomerVO vo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_detail);

        tv_info = findViewById(R.id.tv_info);
        rdo_man = findViewById(R.id.rdo_man);
        rdo_woman = findViewById(R.id.rdo_woman);
        edt_email = findViewById(R.id.edt_email);
        edt_phone = findViewById(R.id.edt_phone);
        btn_update = findViewById(R.id.btn_update);
        btn_close = findViewById(R.id.btn_close);
        rdo_grp = findViewById(R.id.rdo_grp);

        rdo_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(i == R.id.rdo_man){
                    vo.setGender("남");
                }else{
                    vo.setGender("여");
                }
            }
        });


        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        boolean isEnable = intent.getBooleanExtra("isEnable", false);
        CommonConn conn = new CommonConn("detail.cu", this);
        conn.addParams("id",id);
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                vo = new Gson().fromJson(data, CustomerVO.class);
                setWidget(vo, isEnable);
            }
        });




        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonConn conn = new CommonConn("update.cu", CusDetailActivity.this);

                vo.setEmail(edt_email.getText() + "");
                vo.setPhone(edt_phone.getText() + "");

                String result = new Gson().toJson(vo);
                conn.addParams("data", result);
                conn.excuteConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){
                            finish();
                        }

                    }
                });

            }
        });

    }


        public void setWidget(CustomerVO vo, boolean isEnable){
        if (isEnable) {
            btn_update.setVisibility(View.VISIBLE);
        }else{
            btn_update.setVisibility(View.INVISIBLE);//<= 버튼이 보이지 않게 처리
        }

                tv_info.setText(vo.getName() + "의 고개 정보");
                if (vo.getGender().equals("남")) {
                    rdo_man.setChecked(isEnable);
                } else {
                    rdo_woman.setChecked(isEnable);
                }
                rdo_man.setEnabled(isEnable);// Enabled <- 수정 못하게 하기
                rdo_woman.setEnabled(isEnable);
                edt_email.setText(vo.getEmail());
                edt_email.setEnabled(isEnable);
                edt_phone.setText(vo.getPhone());
                edt_phone.setEnabled(isEnable);

            }



}


