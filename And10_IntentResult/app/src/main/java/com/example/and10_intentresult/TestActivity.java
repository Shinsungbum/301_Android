package com.example.and10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        intent.getStringExtra("name");
        intent.getIntExtra("yoonage", -1);
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dto");

        Log.d("String", intent.getStringExtra("name"));
        Log.d("int", intent.getIntExtra("yoonage", -1) + "");
        Log.d("DTO", dto.getId() + "");
        Log.d("DTO", dto.getPw());

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reIntent = new Intent();
                reIntent.putExtra("test", "테스트가 끝남");
                // 결과 코드 를 지정한다
                setResult(RESULT_OK, reIntent);

                //액티비티를 종료함(끔)
                finish();
            }
        });
    }
}