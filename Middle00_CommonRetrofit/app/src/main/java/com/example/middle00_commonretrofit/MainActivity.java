package com.example.middle00_commonretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 고객 목록중에 한건의 데이터만 가져오게끔 처리해보기( SelectOne )
        // 재사용 <-


        //구현부
        //인터페이스가 어떤 결과를 받고나서 처리를 만들어둠
        CommonAskTask askTask = new CommonAskTask(this, "detail.cu");
        askTask.addParams("date", "SSB");
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallBack() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("데이터", "onResult: " + data);
            }
        });

        askTask = new CommonAskTask(this, "list.cu");
        askTask.addParams("date", "SSB");
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallBack() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("데이터", "onResult: " + data);
            }
        });
    /*    CommonAskTask askTask = new CommonAskTask(this, new CommonAskTask.AsynckTaskCallBack() {
            @Override
            public void onResult(String result) {
                Log.d("로그", "onResult: " + result);
            }
        });*/
        /*askTask.execute(); *///.get();// 비동기 x , 동기 처리를 강제로 함 <- 여러번 사용하면 OS는 해당앱이 이상하다는걸
        //감지를 하고 NetWork 오류를 발생시키고 앱을 강제 종료처리함

    }
}