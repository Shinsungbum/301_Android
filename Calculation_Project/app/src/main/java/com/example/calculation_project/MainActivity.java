package com.example.calculation_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.InetAddresses;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_num1, edt_num2;
    Button btn_compare, btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        btn_compare = findViewById(R.id.btn_compare);
        btn_add = findViewById(R.id.btn_add);

        btn_compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int num1 = Integer.parseInt(edt_num1.getText() + "");
                int num2 = Integer.parseInt(edt_num2.getText() + "");

                String msg = "";
                if (num1 == num2) {
                    msg = "두수는 같음";
                } else if (num1 > num2) {
                    msg = num1 + "가 더큼";
                } else {
                    msg = num2 + "가 더큼";
                }
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("msg", msg);
                startActivity(intent);


            }

        });



    }

}