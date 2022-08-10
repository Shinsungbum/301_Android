package com.example.project02_iot.etc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.project02_iot.R;
import com.google.android.material.tabs.TabLayout;

public class TAbActivity extends AppCompatActivity {
    TabLayout tabs;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        toolbar = findViewById(R.id.toolbar);
        /* actionbar <- 현재 상태 NOActionbar 우리가 만든 툴바를 이용해서 액션바를 대체한다*/
        setSupportActionBar(toolbar);


        tabs = findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));
        tabs.addTab(tabs.newTab().setText("차단목록"));

        //getSupportFragmentManager().beginTransaction().replace(R.id.container , new CallFragment()).commit();
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition(); // 0번부터임

                    getSupportFragmentManager().beginTransaction().replace(R.id.container , new CallFragment(pos+1)).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // onCreate메소드가 끝나면 옵션메뉴를 붙일수있는 수명주기가 따로있음
    // override를 통해 재정의를 해놨으면 실행을 해줌


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int pos = 0;
        if(item.getItemId() == R.id.menu1) {
            pos =1;
        }else if(item.getItemId() == R.id.menu2){
            pos =2;
        }else if(item.getItemId() == R.id.menu3){
            pos =3;
        }else if(item.getItemId() == R.id.menu4){
            pos =4;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CallFragment(pos)).commit();

        return super.onOptionsItemSelected(item);
    }
}