package com.example.team_project01.store;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.team_project01.R;
import com.example.team_project01.common.BasketVO;

import java.util.ArrayList;

public class StoreMenuAdapter extends RecyclerView.Adapter<StoreMenuAdapter.ViewHolder> {

    ArrayList<StoreMenuDTO> list;
    LayoutInflater inflater;
    Activity activity;
    BasketVO basketDTO;


    public StoreMenuAdapter(ArrayList<StoreMenuDTO> list, LayoutInflater inflater, Activity activity, BasketVO basketDTO) {
        this.list = list;
        this.inflater = inflater;
        this.activity = activity;
        this.basketDTO = basketDTO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_store_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_menu_image;
        TextView tv_menu_name, tv_menu_price;
        LinearLayout menu_cho;


        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_menu_image = v.findViewById(R.id.imgv_menu_image);
            tv_menu_name = v.findViewById(R.id.tv_menu_name);
            tv_menu_price = v.findViewById(R.id.tv_menu_price);
            menu_cho = v.findViewById(R.id.menu_cho);


        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.tv_menu_name.setText(list.get(i).getMenu_name());
            h.tv_menu_price.setText(list.get(i).getPrice() + "");




            //메뉴 클릭시 다이얼로그 뛰우기
            menu_cho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogInterface.OnClickListener confirm = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.d("TAG", "onClick: 네");
                        }
                    };
                    DialogInterface.OnClickListener cancle = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.d("TAG", "onClick: 아니요");
                        }
                    };

                    new AlertDialog.Builder(activity)
                            .setTitle(h.tv_menu_name.getText() + " 를 장바구니에 담으시겠습니까")
                            .setPositiveButton("네", confirm)
                            .setNegativeButton("아니요", cancle)
                            .show();
                }
            });
        }
    }
}