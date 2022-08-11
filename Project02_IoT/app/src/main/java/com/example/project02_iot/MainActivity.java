package com.example.project02_iot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.project02_iot.common.CommonVal;
import com.example.project02_iot.conn.CommonAskTask;
import com.example.project02_iot.conn.CommonConn;
import com.example.project02_iot.customer.CusFragment;
import com.example.project02_iot.etc.TAbActivity;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(new CusFragment());

    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }
}