package com.example.project03_last.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.project03_last.R;
import com.example.project03_last.conn.CommonConn;

public class JoinActivity extends AppCompatActivity {
    Button btn_member_join, btn_close;
    EditText edt_join_email, edt_join_pw, edt_join_name;
    RadioGroup rdo_gen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        btn_member_join = findViewById(R.id.btn_member_join);
        btn_close = findViewById(R.id.btn_close);
        edt_join_email = findViewById(R.id.edt_join_email);
        edt_join_pw = findViewById(R.id.edt_join_pw);
        edt_join_name = findViewById(R.id.edt_join_name);
        rdo_gen = findViewById(R.id.rdo_gen);

        btn_member_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}