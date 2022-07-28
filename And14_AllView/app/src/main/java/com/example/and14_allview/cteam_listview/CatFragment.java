package com.example.and14_allview.cteam_listview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and14_allview.R;
import com.example.and14_allview.listview.List_Adapter;

import java.util.ArrayList;

public class CatFragment extends Fragment {

ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        ArrayList<CatDTO> list = new ArrayList<>();
        list.add(new CatDTO("07-27", "오월", 1,R.drawable.cat1, "gf58_g58", R.drawable.userid1));
        list.add(new CatDTO("07-28", "유월", 2,R.drawable.cat2, "rt253_7uy", R.drawable.userid2));
        list.add(new CatDTO("07-29", "엘리자벳스", 3,R.drawable.cat3, "sdlkj_12", R.drawable.userid3));
        list.add(new CatDTO("07-30", "김톰", 4,R.drawable.cat3, "hm_sou7", R.drawable.userid4));
        list.add(new CatDTO("07-31", "나제리", 5,R.drawable.cat3, "ss_madifld", R.drawable.userid5));
        list.add(new CatDTO("08-01", "로잘린", 6,R.drawable.cat2, "ddd_0512", R.drawable.yhj));
        list.add(new CatDTO("08-02", "봄", 7,R.drawable.cat2, "d4_afd56h", R.drawable.userid1));
        list.add(new CatDTO("08-03", "겨울", 8,R.drawable.cat1, "df541_1xcsf", R.drawable.userid3));
        list.add(new CatDTO("08-04", "가을", 9,R.drawable.cat1 , "25df_s,l", R.drawable.userid6));
        list.add(new CatDTO("08-05", "여름", 10,R.drawable.cat3, "xs26_5", R.drawable.userid5));

        View v = inflater.inflate(R.layout.fragment_cat, container, false);
        listView = v.findViewById(R.id.cat_listview);

        Cat_Adapter adapter = new Cat_Adapter(list, inflater);
        listView.setAdapter(adapter);

        return v;

       
        
        

    }
}