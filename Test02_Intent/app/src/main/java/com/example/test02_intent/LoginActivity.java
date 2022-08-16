package com.example.test02_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView tv_id, tv_pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_id = findViewById(R.id.tv_id);
        tv_pw = findViewById(R.id.tv_pw);


        Intent intent = getIntent();
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dto");
        tv_id.setText(dto.getId());
        tv_pw.setText(dto.getPw());


    }
}