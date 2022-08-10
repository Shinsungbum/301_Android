package com.example.project02_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.project02_iot.common.CommonVal;
import com.example.project02_iot.conn.CommonAskTask;
import com.example.project02_iot.etc.TAbActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_tab = findViewById(R.id.btn_tab);

        btn_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TAbActivity.class);
                startActivity(intent);
            }
        });

    }
}