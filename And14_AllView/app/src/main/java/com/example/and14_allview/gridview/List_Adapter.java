package com.example.and14_allview.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class List_Adapter extends BaseAdapter {
    ArrayList<KjkDTO> list;
    LayoutInflater inflater;

    public List_Adapter(ArrayList<KjkDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //convertView 부분은 우리한테 내용물을 넣으라고 null인상태로 비워져서 들어오는 변수 return해주면 알아서 붙임(os)
    //parent getCount만큼 나눈 공간을 position별로 한칸씩 우리한테 줌.
    // ↑ 두가지는 붙일 내용물과 붙일 공간. ※LayoutInflater ※
    // ViewHolder라는 것을 만들어보기 ! (View(위젯)용 DTO) <= RecyclerView에서는 ViewHolder를 강제함.
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_gridview, parent, false);
        GridViewHolder gridViewHolder = new GridViewHolder(convertView);
        gridViewHolder.bind(list.get(i));
        return convertView;
    }


    //? Inner Class < GridAdapter에 GridViewHolder라는 클래스
    public class GridViewHolder{
        ImageView img_id1;
        TextView no1, category1, name;


        public GridViewHolder(View convertView) {

            img_id1 = convertView.findViewById(R.id.img_id1);
            no1 = convertView.findViewById(R.id.no1);
            category1 = convertView.findViewById(R.id.category1);
            name = convertView.findViewById(R.id.name);
        }

        public void bind(KjkDTO dto){
            img_id1.setImageResource(dto.getImg_id());
            no1.setText(dto.getNo()+"");
            category1.setText(dto.getCategory());
            name.setText(dto.getName());

        }//bind
    }



}
