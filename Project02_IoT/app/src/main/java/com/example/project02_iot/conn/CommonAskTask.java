package com.example.project02_iot.conn;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.project02_iot.conn.ApiInterface;
import com.example.project02_iot.conn.ApriClient;

import java.io.IOException;
import java.util.HashMap;

// 백그라운드에서 작업을 비동기로 함 => 결과가 나올때까지 서브 쓰레드가 대기상태여서 메인도 같이 기다림.
// 데이터 건수가 많을때는  ↓ 사용할 예정
public class CommonAskTask extends AsyncTask<String , String , String> {
    public AsynckTaskCallBack callBack;
    Context context; // 토스트 메세지나 , 프로그레스 다이얼로그 사용 시 필요함.
    ProgressDialog dialog;
    HashMap<String, Object> params;
    String url ;

    public CommonAskTask(Context context, String url) {
        this.context = context;
        this.url = url;
        this.dialog = new ProgressDialog(context);
        this.params = new HashMap<>();
    }

    public  void addParams(String key, Object value){
        this.params.put(key , value);
    }

    public  void excuteAsk(AsynckTaskCallBack callBack){
        this.callBack = callBack;
        this.execute();
    }


    /*
    public CommonAskTask( Context context, AsynckTaskCallBack callBack) {
        this.callBack = callBack;
        this.context = context;
        this.dialog = new ProgressDialog(context); // 여기에 사용할려고 Context 받아옴
    }*/

    //작업 시작전 프로그레스 다이얼로그를 보여줌
    @Override
    protected void onPreExecute() {
        if(dialog == null) return;
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("데이터 처리");
        dialog.setMessage("데이터를 가져오는 중...");
        dialog.show(); //<= 실제 보이게 처리 ※
    }

    // 재사용이 가능하려면 바뀌어야 하는 부분들이 있는데
    // 어디를 바꿔줘야할까????
    // list.cu<=고객목록을 조회해옴.
    // list.hr , list.no 등등의 맵핑을 다양하게 활용하려면???
    @Override
    protected String doInBackground(String... strings) {
        String rtnData = null;
        ApiInterface apiInterface = ApriClient.getApiclient().create(ApiInterface.class);

        try {
            rtnData = apiInterface.getData(url , params).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rtnData;


        //return "콜백";
    }

    @Override
    protected void onPostExecute(String data) {
        if(dialog == null) return;
        dialog.dismiss();
        Log.d("콜백데이터"  , "onPostExecute: " + data);
        //실행부 ( 구현해놓은 구현부를 실행해야하는 시점에 넣어주는 코드 )
        if(data== null || data.length() == 0 || data.equals("null")){
            callBack.onResult(data, false);
        }else{
            callBack.onResult(data, true);
        }

    }

    //다시 콜백을 주기위한 (인터페이스) // 정의
    public interface AsynckTaskCallBack{
        void onResult(String data, boolean isResult);
    }



}
