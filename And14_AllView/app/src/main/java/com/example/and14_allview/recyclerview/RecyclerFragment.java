package com.example.and14_allview.recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and14_allview.R;
import com.example.and14_allview.gridview.KjkDTO;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    RecyclerView recview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        recview = v.findViewById(R.id.rec_view);
        ArrayList<KjkDTO> list = new ArrayList<>();
        // 5건 추가하기.
        list.add(new KjkDTO(1, R.drawable.flower1, "화관", "하양"));
        list.add(new KjkDTO(2, R.drawable.flower2, "화관", "빨강"));
        list.add(new KjkDTO(3, R.drawable.flower3, "화관", "새"));
        list.add(new KjkDTO(4, R.drawable.flower2, "풍경", "풍경"));
        list.add(new KjkDTO(5, R.drawable.flower1, "인물", "인물"));

        Rec_Adapter adapter = new Rec_Adapter(inflater, list);
        recview.setAdapter(adapter);
        /* Layoutmanager <- 가로인지 세로인지를 설정해서 넣을수가 있음 필수*/

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getContext(), RecyclerView.HORIZONTAL , false
        );
        recview.setLayoutManager(layoutManager);
        /*1. 목록을 가지는 모든 뷰는 Adapter가 필요함.
         *       - 1-1. 한칸마다 보여질 데이터를 묶어놓은 객체 == DTO(ArrayList)
         *       - 1-2. 한칸마다 보여질 데이터를 디자인해놓은 파일 == res\layout\xml
         * 2. Adapter 생성 ※※※※※※ 리사이클러뷰는 별도의 어댑터를 사용한다. ※※※※※※
         *       -2-1. 클래스를 추가한다.
         *       -2-2. extends(상속)을 받아서 어댑터가 된다.
         * 3.ListView <=> Adapter 연결
         * */
        return v;
    }
}