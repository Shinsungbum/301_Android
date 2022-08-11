package com.example.project02_iot.customer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;

import java.util.ArrayList;


public class CusAdapter extends RecyclerView.Adapter<CusAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<CustomerVO> list;
    Context context;
    CusFragment cusFragment;

    public CusAdapter(LayoutInflater inflater, ArrayList<CustomerVO> list, Context context, CusFragment cusFragment) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
        this.cusFragment = cusFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_cus_recv, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bine(holder, position);
        //데이터가 있을때 처리해야되는 부분
    }

    @Override
    public int getItemCount() {
        return list.size();
    }






    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_cus;
        TextView tv_no, tv_name, tv_phone;
        Button btn_detail, btn_update, btn_delete;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_cus = v.findViewById(R.id.imgv_cus);
            tv_no = v.findViewById(R.id.tv_no);
            tv_name = v.findViewById(R.id.tv_name);
            tv_phone = v.findViewById(R.id.tv_phone);
            btn_detail = v.findViewById(R.id.btn_detail);
            btn_update = v.findViewById(R.id.btn_update);
            btn_delete = v.findViewById(R.id.btn_delete);
        }

        public void bine(@NonNull ViewHolder holder, int i){
            holder.tv_no.setText(list.get(i).getId() + "");
            holder.tv_name.setText(list.get(i).getName());
            holder.tv_phone.setText(list.get(i).getPhone());
            if(list.get(i).getGender().equals("남")){
                holder.imgv_cus.setImageResource(R.drawable.male);
            }else{
                holder.imgv_cus.setImageResource(R.drawable.female);
            }
            btn_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CusDetailActivity.class);
                    //정보중에 선택 된 정보를 => CusDetailActivity로 전송 해보기
                    //1. id값을 보내고 detailActivity에서 미들웨어를 통해 다시 조회해오기(1건)
                    //2. 데이터 1건의 정보를 모두 detailActivity에 보내기(1건)
                    intent.putExtra("id", list.get(i).getId());
                    intent.putExtra("vo", list.get(i));
                    intent.putExtra("isEnable", false);
                    context.startActivity(intent);
                }
            });

            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CusDetailActivity.class);
                    intent.putExtra("id", list.get(i).getId());
                    intent.putExtra("isEnable", true);

                    context.startActivity(intent);
                }
            });


            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CommonConn conn = new CommonConn("delete.cu", context);
                    String id = new Gson().toJson(list.get(i).getId());
                    conn.addParams("id", list.get(i).getId());
                    conn.excuteConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            cusFragment.recv_select();
                        }
                    });

                }
            });
        }
    }


}
