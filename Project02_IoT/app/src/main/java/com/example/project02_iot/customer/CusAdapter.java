package com.example.project02_iot.customer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    CusFragment cusFragment; // new <- 새로운 메모리 번지수를 만들고 참조를 시작한다.

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

            holder.btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CusDetailActivity.class);
                    intent.putExtra("id", list.get(i).getId());
                    intent.putExtra("isEnable", true);

                    context.startActivity(intent);
                }
            });


            holder.btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // confirm(web) <=> AlertDialog(And) <- 유저가 어떠한 액션을 했을때 정말로 할것인지 를 최종적으로
                    //한번 더 확인하기 위한 알림창.
                    checkDelete(list.get(i).getId());
                }
            });
        }//bind


        public void checkDelete(int id){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("고객 정보 삭제")
                    .setMessage("정말로 삭제하시겠습니까?")
                    .setIcon(R.drawable.male);
            builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //사용자가 "네" 라는 메세지를 클릭했을 때 처리를 위한것
                    CommonConn conn = new CommonConn("delete.cu", context);
                    conn.addParams("id", id);
                    conn.excuteConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            cusFragment.recv_select();
                        }
                    });
                }
            });

            builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //사용자가 "아니오" 라는 메세지를 클릭했을 때 처리를 위한것
                    Toast.makeText(context, "취소 되었습니다", Toast.LENGTH_SHORT).show();
                }
            });


            AlertDialog dialog = builder.create();//dialog가 생성이 완료됨
            dialog.show();



        }


    }


}
