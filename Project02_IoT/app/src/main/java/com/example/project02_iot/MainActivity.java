package com.example.project02_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.project02_iot.common.CommonVal;
import com.example.project02_iot.conn.CommonAskTask;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CommonAskTask askTask = new CommonAskTask(this, "list.cu");
        askTask.addParams("data", "SSB");
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallBack() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("데이터", "onResult: " + data);
            }
        });
        if(CommonVal.loginInfo != null){
            Log.d("로그", "onCreate: 로그인 정보가 있음");
        }else {
            //로그인 화면으로 다시 이동을 시키거나 토스트 창을 보여준뒤
            Log.d("로그", "onCreate: 로그인 정보가 없음");
        }



    }
}