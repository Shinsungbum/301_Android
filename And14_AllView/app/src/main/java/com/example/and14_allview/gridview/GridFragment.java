package com.example.and14_allview.gridview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.and14_allview.R;

import java.util.ArrayList;


public class GridFragment extends Fragment {
    GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_grid, container, false);

        gridView = v.findViewById(R.id.gridview);

        ArrayList<KjkDTO> list = new ArrayList<>();
        list.add(new KjkDTO(1, R.drawable.cat1, "고양", "겨울"));
        list.add(new KjkDTO(2, R.drawable.cat2, "고양", "봄"));
        list.add(new KjkDTO(3, R.drawable.cat3, "고양", "여름"));
        list.add(new KjkDTO(4, R.drawable.cat4, "고양", "가을"));
        list.add(new KjkDTO(5, R.drawable.cat5, "고양", "오월"));
        list.add(new KjkDTO(6, R.drawable.cat6, "고양", "구월"));

        List_Adapter adapter = new List_Adapter(list, inflater);
        gridView.setAdapter(adapter);



        return v;
    }
}