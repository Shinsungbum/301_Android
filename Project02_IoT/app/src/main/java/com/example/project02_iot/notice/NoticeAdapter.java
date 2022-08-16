package com.example.project02_iot.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHoler> {
LayoutInflater inflater;
ArrayList<NoticeVO> list;

    public NoticeAdapter(LayoutInflater inflater, ArrayList<NoticeVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_notice, parent, false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder{
        TextView tv_title, tv_content, tv_writer, tv_writerdate;
        public ViewHoler(@NonNull View v) {
            super(v);
            tv_title = v.findViewById(R.id.tv_title);
            tv_content = v.findViewById(R.id.tv_content);
            tv_writer = v.findViewById(R.id.tv_writer);
            tv_writerdate = v.findViewById(R.id.tv_writerdate);
        }


        public void bind(@NonNull ViewHoler holder, int i){
            tv_title.setText(list.get(i).getTitle());
            tv_content.setText(list.get(i).getContent());
            tv_writer.setText(list.get(i).getWriter());
            tv_writerdate.setText(list.get(i).getWritedate());
        }
    }
}
