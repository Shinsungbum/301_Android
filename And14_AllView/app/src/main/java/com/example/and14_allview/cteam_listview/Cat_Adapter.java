package com.example.and14_allview.cteam_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class Cat_Adapter extends BaseAdapter {

    ArrayList<CatDTO> list ;
    LayoutInflater inflater;

    public Cat_Adapter(ArrayList<CatDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.iteam_cat_listview, parent, false );

        ImageView imageView = convertView.findViewById(R.id.img_id1);
        imageView.setImageResource(list.get(position).getImg_id());

        ImageView imageView1 = convertView.findViewById(R.id.profile_image);
        imageView1.setImageResource(list.get(position).getUser_img());

        TextView tv_name, tv_no, tv_date, user_id;
        tv_name = convertView.findViewById(R.id.name);
        tv_name.setText(list.get(position).getName());

        tv_no = convertView.findViewById(R.id.no);
        tv_no.setText(list.get(position).getNo()+"");

        tv_date = convertView.findViewById(R.id.date);
        tv_date.setText(list.get(position).getDate());

        user_id = convertView.findViewById(R.id.user_id);
        user_id.setText(list.get(position).getUserid());


        return convertView;
    }
}//class
