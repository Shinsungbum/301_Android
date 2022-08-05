package com.example.project01_botnav.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_botnav.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ViewFragment extends Fragment {
    TabLayout tabs;
    RecyclerView recv_view;
    ArrayList<ViewDTO> list = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_view, container, false);

        tabs = v.findViewById(R.id.tabs);
        recv_view = v.findViewById(R.id.recv_view);

        tabs.addTab(tabs.newTab().setText("My뷰"));
        tabs.addTab(tabs.newTab().setText("발견"));
        tabs.addTab(tabs.newTab().setText("카카오 TV"));
        tabs.addTab(tabs.newTab().setText("코로나19"));
        tabs.addTab(tabs.newTab().setText("잔여백신"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // 포커싱이 되었을때 ( 선택함 )
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    Log.d("탭", "onTabSelected: 탭 선택됨");
                }else if(tab.getPosition()==1){
                    Log.d("탭", "onTabSelected: 탭 선택됨");
                }
            }
            // 포커싱을 읽었을때 ( 선택해제 )
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        list.add(new ViewDTO(R.drawable.splashlogo, R.drawable.user, "나는야 기자", "안드로이드 드디어 일내다!!", "정말 일을 냈습니다 큰일이다~!","3일전"));
        list.add(new ViewDTO(R.drawable.banner, R.drawable.profile, "피식충전소", "티나도 너무티난 배달앱 리뷰 주작", "딱 걸린 배달앱 리뷰 주작.jpg","2일전"));
        list.add(new ViewDTO(R.drawable.banner, R.drawable.and, "피식충전소", "티나도 너무티난 배달앱 리뷰 주작", "딱 걸린 배달앱 리뷰 주작.jpg","2일전"));
        list.add(new ViewDTO(R.drawable.splashlogo, R.drawable.user, "나는야 기자", "안드로이드 드디어 일내다!!", "정말 일을 냈습니다 큰일이다~!","3일전"));
        list.add(new ViewDTO(R.drawable.and, R.drawable.profile, "피식충전소", "티나도 너무티난 배달앱 리뷰 주작", "딱 걸린 배달앱 리뷰 주작.jpg","2일전"));


        ViewAdapter adapter = new ViewAdapter(inflater, list, getContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recv_view.setAdapter(adapter);
        recv_view.setLayoutManager(manager);


        return v;
    }
}