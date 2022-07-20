package com.example.and10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_01;
    //안드로이드의 4대 컴포넌트 : (현) 액티비티
    //4가지의 컴포넌트들 간의 통실을 담당 : Intent(전달)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_01 = findViewById(R.id.btn_01);

        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재위치에서 => 이동할위치 두개를 파라메터로 지정을 해둠.
                //직접 LoginActivity라는 액티비티를 하나만들고
                //메인 액티비티의 버튼을 클릭했을때
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("test", "넘길값");
                intent.putExtra("num", 100);
                LoginDTO dto = new LoginDTO(11, "admin");
                intent.putExtra("dto",dto);//직렬하 : Serializable
                ArrayList<LoginDTO> list = new ArrayList<>();
                for (int i = 0; i <10 ; i++) {
                    list.add(new LoginDTO(i, "pw" + i));
                }
                intent.putExtra("list", list);
                startActivity(intent);

                //Intent intent = new Intent(MainActivity.this, SubActivity.class);
                //startActivity(intent);

            }
        });

    }
}