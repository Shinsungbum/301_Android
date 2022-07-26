package com.example.and12_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn ;
    //모든 수명주기에 관련 된 메소드는 부모 클래스로부터 재정의 하여 사용한다.



    // Override == 재정의 ( 기존 기능 + 기능 , 형태는 같으나 내부를 완전히 바꿈  , 수정 )
    // OverLoading == 메소드의 중복 된 이름을 사용하는 방법 ( 파라메터 갯수 , 순서를 바꿔서 같은이름의 메소드를 여러개 만들수있는것)
    @Override // <= Override , OverLoading 의 차이점
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("수명주기", "onCreate: 1번");
        btn = findViewById(R.id.btn);

    } // 1번

    @Override
    protected void onStart() {
        super.onStart();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });
        Log.d("수명주기", "onStart: 2번");
    }//2번

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("수명주기", "onResume: 3번");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("수명주기", "onPause: 4번");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("수명주기", "onStop: 5번");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //어떤 작업을 하고있다면 작업을 종료하거나 또는 작업내용을 저장시키거나 하는 작업을 할때 많이 씀.
        Log.d("수명주기", "onStop: 6번");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //데이터베이스를 연동해서 다른 액티비티에서 데이터 인서트나 업데이트 등의 과정이 일어났을때
        //해당 된 변경사항을 바로 적용하기 위해서 시점을 사용할수가있다.
        Log.d("수명주기", "onRestart: 0번");
    }
}