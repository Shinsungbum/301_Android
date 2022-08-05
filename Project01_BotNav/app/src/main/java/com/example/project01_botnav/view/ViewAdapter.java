package com.example.project01_botnav.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_botnav.R;
import com.example.project01_botnav.SplashActivity;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<ViewDTO> list;
    Context context;

    public ViewAdapter(LayoutInflater inflater, ArrayList<ViewDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
    h.bind(h, i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_banner, img_pr;
        TextView tv_name, tv_title, tv_content;
        public ViewHolder(@NonNull View v) {
            super(v);

            img_banner = v.findViewById(R.id.img_banner);
            img_pr = v.findViewById(R.id.img_pr);
            tv_name = v.findViewById(R.id.tv_name);
            tv_title = v.findViewById(R.id.tv_title);
            tv_content = v.findViewById(R.id.tv_content);
        }
        public void bind(@NonNull ViewHolder h, int i){
            img_banner.setImageResource(list.get(i).getImg_banner());
            img_pr.setImageResource(list.get(i).getImg_pr());
            tv_name.setText(list.get(i).getTv_name());
            tv_title.setText(list.get(i).getTv_title());
            tv_content.setText(list.get(i).getTv_content());
            // => DetailActivity 상세정보를 볼수있는 액티비티
            //Intent intent = new Intent(현재위치(컨텍스트), 다음액티비티클래스)
            h.tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SplashActivity.class    );
                    context.startActivity(intent);
                }
            });
        }

    }
}
