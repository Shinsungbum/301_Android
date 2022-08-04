package com.example.project01_botnav.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_botnav.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    RecyclerView recv_main;
    ArrayList<MainDTO> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        recv_main = v.findViewById(R.id.recv_main);

        list.add(new MainDTO(R.drawable.gear, "신성범", "infp"));
        list.add(new MainDTO(R.drawable.user, "김성범", "enfp", true));
        list.add(new MainDTO(R.drawable.etc, "박석범", "isfp"));
        list.add(new MainDTO(R.drawable.logo, "홍성범", "infp", true));
        list.add(new MainDTO(R.drawable.shopping, "나성범", "isfp"));
        list.add(new MainDTO(R.drawable.and, "강성범", "infj", true));
        list.add(new MainDTO(R.drawable.ic_launcher_background, "강성범", "infj"));
        list.add(new MainDTO(R.drawable.ic_launcher_foreground, "이성범", "enfp", true));
        list.add(new MainDTO(R.drawable.talk, "윤성범", "enfp"));
        list.add(new MainDTO(R.drawable.splashlogo, "남성범", "enfj", true));


        MainAdapter adapter = new MainAdapter(inflater, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL, false);


        recv_main.setAdapter(adapter);
        recv_main.setLayoutManager(manager);


        return v;
    }
}