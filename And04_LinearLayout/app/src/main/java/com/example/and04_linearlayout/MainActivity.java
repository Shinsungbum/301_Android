package com.example.and04_linearlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
/* 1. 디자인 파일에 있는 버튼과 에딧텍스트를 자바코드에서 사용할수 있게 찾아주기
*  2. ※버튼 클릭 이벤트를 만들고 log찍어보기
* */
    Button btn_login, btn_join;
    EditText et_id, et_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btn_login = findViewById(R.id.btn1);
        btn_join = findViewById(R.id.btn2);
        et_id =findViewById(R.id.et1);
        et_pw = findViewById(R.id.et2);

       // btn_login.setOnClickListener(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = String.valueOf(et_id.getText());
                String pw = String.valueOf(et_pw.getText());
                if(id.equals("admin")&& pw.equals("admin1234")){
                    Log.d("로그인", ": 로그인 성공");
                    //Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_LONG).show();
                }else {
                    Log.d("로그인", ": 아이디 또는 비밀번호를 확인해주세요");
                }

            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //admin <= id , admin1234 <= pw
                //edt<- . getText <= String타입으로 바꾸고 비교해보기

                Log.d("로그찍기", ": 로그인눌림");
            }
        });

    }


    @Override
    public void onClick(View v) {
        Log.d("로그찍기", ": 아무값 ");
   }
}