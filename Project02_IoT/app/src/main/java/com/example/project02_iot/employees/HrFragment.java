package com.example.project02_iot.employees;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class HrFragment extends Fragment {
    RecyclerView recv_hr;
    SwipeRefreshLayout swipe_emp;
    SearchView search_emp;
    String keyword = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hr, container, false);
        recv_hr = v.findViewById(R.id.recv_hr);


        swipe_emp = v.findViewById(R.id.swipe_emp);
        swipe_emp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Refresh는 스와이프가 되서 동작하는 상태가 되면 처리할 이벤트를 작성.
                // ※ swipe_emp.setRefreshing(false); <- 를 안주면 계속 해서 돌아감.
                searchEmp();
                swipe_emp.setRefreshing(false);
            }
        });

        //검색 기능
        search_emp = v.findViewById(R.id.search_emp);
        search_emp.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //돋보기 버튼(submit) 전송버튼을 누름ㄴ 실행되는 곳 ( query 라는 변수는 입력된 값이 String 있음 )
                keyword = query;
                searchEmp();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                keyword = newText;
                searchEmp();
                return false;
            }
        });

        searchEmp();
        return v;
    }




    public void searchEmp() {
        // 액티비티 안에서 interfae(메소드 안) 액티비티.this
        //액티비티 <= this
        //프래그먼트에서 컨텍스트를 가져오려면 getContext(); <- 메소드 사용하면 됨
        // json [ <- 대괄호 List구조
        // json { <- 객체 Object
        CommonConn conn = new CommonConn("list.hr", getContext());
        conn.addParams("keyword", keyword);
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if (isResult) { //서버와 통신이 성공적으로 끝났을때.
                    Log.d("고객리스트", "onResult: " + data);
                    ArrayList<HrVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<HrVO>>(){}.getType());
                    Log.d("사이즈", "onResult: " + list.size());
                    HrAdapter adapter = new HrAdapter(getLayoutInflater(), list, getContext(), HrFragment.this);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recv_hr.setLayoutManager(manager);
                    recv_hr.setAdapter(adapter);
                    swipe_emp.setRefreshing(false);
                }
            }
        });


    }



}