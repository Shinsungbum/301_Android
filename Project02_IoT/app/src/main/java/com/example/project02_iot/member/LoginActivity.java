package com.example.project02_iot.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project02_iot.MainActivity;
import com.example.project02_iot.R;
import com.example.project02_iot.common.CommonMethod;
import com.example.project02_iot.common.CommonVal;
import com.example.project02_iot.conn.CommonAskTask;
import com.example.project02_iot.member.MemberVO;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
// -1. Spring을 이용한 Login처리.
// -2. SharedPrefrerences <- 공유 자원 ( 캐시 지우기 , 데이터 지우기 앱)를 하면 없어지는 부분


    EditText edt_id , edt_pw ;
    Button btn_login , btn_join;
    CheckBox chk_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);
        chk_login = findViewById(R.id.chk_login);

        // btn_login 클릭 시 에딧텍스트 id , pw에 있는값을 로그에 출력해보기.
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이디 비밀번호가 null이 아니게 넘어가게끔 작업
                if(CommonMethod.isCheckEditText(edt_id) && CommonMethod.isCheckEditText(edt_pw)){
                   //미들웨어 접근
                    CommonAskTask task = new CommonAskTask(LoginActivity.this,"login");
                    task.addParams("userid" , edt_id.getText()+"");
                    task.addParams("userpw" , edt_pw.getText()+"");
                    task.excuteAsk(new CommonAskTask.AsynckTaskCallBack() {
                        @Override
                        public void onResult(String data, boolean isResult) {
                            Log.d("데이터", "onResult: " + data);
                            Log.d("데이터", "onResult: " + isResult);
                            if(isResult){
                                CommonVal.loginInfo = new Gson().fromJson(data,MemberVO.class);
                                Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();//뒤로가기 클릭 시 로그인화면이 다시 나오는게 아니라 종료 되게끔 처리
                            }else{
                                Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}