package com.example.team_project01.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import com.example.team_project01.MainActivity;
import com.example.team_project01.R;
import com.example.team_project01.common.CommonVal;
import com.example.team_project01.conn.CommonAskTask;
import com.google.gson.Gson;

import retrofit2.http.HEAD;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText login_email, login_pw;
    Button btn_login;
    Intent intent;
    ImageView login_back;


    //자동로그인 salt
    //소셜로그인 아이디 중복체크


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_email = findViewById(R.id.login_email);
        login_pw = findViewById(R.id.login_pw);
        btn_login = findViewById(R.id.btn_login);
        login_back = findViewById(R.id.login_back);

        btn_login.setOnClickListener(this);
        login_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() ==R.id.btn_login){
            login(login_email.getText().toString(), login_pw.getText().toString(), "N");
        }else if(v.getId() == R.id.login_back) {
            onBackPressed();
        }
    }

    public void login(String email, String pw, String social_yn) {

        CommonAskTask task = new CommonAskTask(LoginActivity.this, "andLogin");

        task.addParams("email",email);  //여기가 고정되면 안돼 edt_getText()+"" -> email 파라메터로 바꿔주기
        task.addParams("pw",pw);
        task.excuteAsk(new CommonAskTask.AsynckTaskCallBack() {
            @Override
            public void onResult(String data, boolean isResult) {

                Log.d("로그인", "onResult: " + data);
                CommonVal.loginInfo = new Gson().fromJson(data, MemberVO.class);
               if (CommonVal.loginInfo !=null){  //로그인 성공
                   Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();

                   intent = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(intent);

               }else if(CommonVal.loginInfo == null) {
                   Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();

               }else {
                    Log.d("로그", "onResult: 세개의 이프문모두 실패!!");
                }
            }
        });
    }
}