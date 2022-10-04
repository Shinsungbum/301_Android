package com.example.team_project01.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.team_project01.R;
import com.naver.maps.map.overlay.Overlay;

public class BillActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView bill_cash, bill_pay, bill_card;
    TextView bill_price, bill_price2, bill_payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        bill_cash = findViewById(R.id.bill_cash);
        bill_pay = findViewById(R.id.bill_pay);
        bill_card = findViewById(R.id.bill_card);
        bill_price = findViewById(R.id.bill_price);
        bill_price2 = findViewById(R.id.bill_price2);
        bill_payment = findViewById(R.id.bill_payment);

        Intent intent = getIntent();
        Order_infoVO vo = (Order_infoVO) intent.getSerializableExtra("vo");
        bill_price.setText( "+" + vo.getPrice());
        bill_price2.setText("-" + vo.getPrice());
        bill_cash.setOnClickListener(this);
        bill_pay.setOnClickListener(this);
        bill_card.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bill_cash){

        }else if (v.getId() == R.id.bill_pay){

        }else if(v.getId() == R.id.bill_card){

        }
    }
}