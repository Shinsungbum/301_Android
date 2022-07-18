package com.example.test01_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img_01,img_02,img_03,img_04,img_05,img_06;
    Button btn_01, btn_02;
    int num1 = 1;
    int num2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);
        img_01 = findViewById(R.id.img_01);
        img_02 = findViewById(R.id.img_02);
        img_03 = findViewById(R.id.img_03);
        img_04 = findViewById(R.id.img_04);
        img_05 = findViewById(R.id.img_05);
        img_06 = findViewById(R.id.img_06);

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (num1 == 1){
                    img_01.setVisibility(View.GONE);
                    img_02.setVisibility(View.VISIBLE);
                    num1++;
                }else if(num1 == 2){
                    img_02.setVisibility(View.GONE);
                    img_03.setVisibility(View.VISIBLE);
                    num1++;
                }else if(num1 == 3){
                    img_03.setVisibility(View.GONE);
                    img_01.setVisibility(View.VISIBLE);
                    num1 = 1;
                }



            }
        });


        btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num2 == 1){
                    img_04.setVisibility(View.GONE);
                    img_05.setVisibility(View.VISIBLE);
                    num2++;
                }else if(num2 == 2){
                    img_05.setVisibility(View.GONE);
                    img_06.setVisibility(View.VISIBLE);
                    num2++;
                }else if(num2 == 3){
                    img_06.setVisibility(View.GONE);
                    img_04.setVisibility(View.VISIBLE);
                    num2 = 1;
                }
            }
        });



    }
}