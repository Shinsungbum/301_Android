package com.example.project02_iot.customer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.project02_iot.MainActivity;
import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class CusFragment extends Fragment {
    RecyclerView recv_cus;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cus, container, false);
        recv_cus = v.findViewById(R.id.recv_cus);
        recv_select();
        //안쪽에 들어갈 아이템(layout)
        //어댑터 (adapter)
        //모양을 확인 후 => VO(DTO) ArrayList나



        return v;
    }

    public void recv_select(){
        // 액티비티 안에서 interfae(메소드 안) 액티비티.this
        //액티비티 <= this
        //프래그먼트에서 컨텍스트를 가져오려면 getContext(); <- 메소드 사용하면 됨
        // json [ <- 대괄호 List구조
        // json { <- 객체 Object
        CommonConn conn = new CommonConn("list.cu", getContext());
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult) { //서버와 통신이 성공적으로 끝났을때.
                    Log.d("고객리스트", "onResult: " + data);
                    ArrayList<CustomerVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<CustomerVO>>(){}.getType());
                    Log.d("사이즈", "onResult: " + list.size());
                    CusAdapter adapter = new CusAdapter(getLayoutInflater(), list, getContext(), CusFragment.this);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recv_cus.setLayoutManager(manager);
                    recv_cus.setAdapter(adapter);

                }
            }
        });





    }

    //DetailActivity가 종료가 되고 프래그 먼트와 메인택티비티가 다시보임.
    //어떻게 우리는 알수가 있을까? ↑


    @Override
    public void onStart() {
        super.onStart();
        Log.d("프래그먼트", "onStart: ");
        recv_select();
    }



}