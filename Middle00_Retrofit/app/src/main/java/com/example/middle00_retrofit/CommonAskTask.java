package com.example.middle00_retrofit;


import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

//비동기 처리를 위한 객체
// extends AsyncTask 상속받으면 됨 => 상속시 클래스를 3개 넘겨줘야만함.
public class CommonAskTask extends AsyncTask<String , String , String> {

    @Override
    protected void onPreExecute() {
        Log.d("작업 시작 전 실행 됨", "onPreExecute: ");
    }

    // 실제 작업부 ※
    @Override
    protected String doInBackground(String... strings) {
        ApiInterface apiInterface = ApriClient.getApiclient().create(ApiInterface.class);
        HashMap<String,Object> map = new HashMap<>();
        map.put("data" , "kym");
        try {
            String rtnData = apiInterface.getData("list.cu", map).execute().body();
            Log.d("데이터 ", "doInBackground: " + rtnData);
            return rtnData;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("작업 끝나고 나서 실행 됨", "onPostExecute: 콜백");
    }
}
