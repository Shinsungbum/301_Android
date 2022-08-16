package com.example.calculation_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        tv_result = findViewById(R.id.tv_result);

        Intent intent = getIntent();
        tv_result.setText(intent.getStringExtra("msg"));
    }
}