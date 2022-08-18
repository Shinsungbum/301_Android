package com.example.cloneappproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {
    LinearLayout bot_menu1, bot_menu2, bot_menu3, bot_menu4, bot_menu5, bot_menu6;
    ImageButton side_munu;
    DrawerLayout drawerLayout;
    RelativeLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bot_menu1 = findViewById(R.id.bot_menu1);
        bot_menu2 = findViewById(R.id.bot_menu2);
        bot_menu3 = findViewById(R.id.bot_menu3);
        bot_menu4 = findViewById(R.id.bot_menu4);
        bot_menu5 = findViewById(R.id.bot_menu5);
        bot_menu6 = findViewById(R.id.bot_menu6);

        changeFragment(new HomeFragment());

        side_munu = findViewById(R.id.side_munu);
        drawerLayout = findViewById(R.id.drawerLayout);
        drawer = findViewById(R.id.drawer);



        bot_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new HomeFragment());
                bot_menu1.setBackgroundColor(123456);
            }
        });





    }



    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }


    public void onClick(View view) {
        drawerLayout.openDrawer(drawer);
    }
}

