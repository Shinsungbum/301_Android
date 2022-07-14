package com.example.and05_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{
    Button btn_img;
    ImageView imgv1, imgv2, imgv3;
    int num = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_img = findViewById(R.id.btn_img);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);

        //버튼 클릭이벤트 메소드
        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {



                    if (num == 1) {
                        imgv2.setVisibility(View.GONE);
                        imgv1.setVisibility(View.VISIBLE);
                        num++;
                    } else if (num == 2) {
                        imgv1.setVisibility(View.GONE);
                        imgv3.setVisibility(View.VISIBLE);
                        num++;
                    } else if (num == 3) {
                        imgv3.setVisibility(View.GONE);
                        imgv2.setVisibility(View.VISIBLE);
                        num = 1;
                    }

                    Log.d("TAG", ": num: " + num);
                }

        });


    }





}