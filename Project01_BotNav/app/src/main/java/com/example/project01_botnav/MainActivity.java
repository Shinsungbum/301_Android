package com.example.project01_botnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.project01_botnav.main.MainFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_nav;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btm_nav = findViewById(R.id.btm_nav);

        actionBar = getSupportActionBar();
        actionBar.setTitle("친구");

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();

        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //id <- 사용하면 더좋음 , title은 필요에 따라서 자주 바뀔 가능성이 있음 ( 개발초기 )
                if (item.getItemId() == R.id.tab1) {
                    Log.d("탭1", "onNavigationItemSelected: 탭1");
                    actionBar.setTitle("친구");
                }else if (item.getItemId() == R.id.tab2) {
                    Log.d("탭2", "onNavigationItemSelected: 탭2");
                    actionBar.setTitle("채팅");
                }else if (item.getItemId() == R.id.tab3){
                    Log.d("탭3", "onNavigationItemSelected: 탭3");
                    actionBar.setTitle("뷰");
                }else if (item.getItemId() == R.id.tab4){
                    Log.d("탭4", "onNavigationItemSelected: 탭4");
                    actionBar.setTitle("쇼핑");
                }else if(item.getItemId() == R.id.tab5){
                    Log.d("탭5", "onNavigationItemSelected: 탭5");
                    actionBar.setTitle("더보기");
                }


                return true;
            }
        });
    }
}