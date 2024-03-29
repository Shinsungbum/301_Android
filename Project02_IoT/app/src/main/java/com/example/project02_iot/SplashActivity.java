package com.example.project02_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.project02_iot.member.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Context context;
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
              startActivity(intent);
              finish();
          }
      }, 1000);

    }
}