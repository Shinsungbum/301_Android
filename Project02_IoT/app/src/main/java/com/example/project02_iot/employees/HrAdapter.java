package com.example.project02_iot.employees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;

import java.util.ArrayList;

public class HrAdapter extends RecyclerView.Adapter<HrAdapter.ViewHoler> {
    LayoutInflater inflater;
    ArrayList<HrVO> list;
    Context context;
    HrFragment hrFragment; // new <- 새로운 메모리 번지수를 만들고 참조를 시작한다.

    public HrAdapter(LayoutInflater inflater, ArrayList<HrVO> list, Context context, HrFragment hrFragment) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
        this.hrFragment = hrFragment;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_hr_recv, parent, false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        LinearLayout ln_emp;
        ImageView imgv_hr;
        TextView tv_name_id, tv_deptn, tv_email;

        public ViewHoler(@NonNull View v) {
            super(v);
            imgv_hr = v.findViewById(R.id.imgv_hr);
            tv_name_id = v.findViewById(R.id.tv_name_id);
            tv_deptn = v.findViewById(R.id.tv_deptn);
            tv_email = v.findViewById(R.id.tv_email);
            ln_emp = v.findViewById(R.id.ln_emp);

        }
        public void bind(@NonNull ViewHoler holder, int i){
            holder.tv_name_id.setText(list.get(i).getFirst_name()+ " " + list.get(i).getLast_name() + " ( " + list.get(i).getEmployee_id() + " ) ");
            holder.tv_deptn.setText(list.get(i).getDepartment_name());
            holder.tv_email.setText(list.get(i).getEmail());
            if (list.get(i).getSalary() < 5000){
                holder.imgv_hr.setImageResource(R.drawable.d);
            }else if (list.get(i).getSalary() < 10000){
                holder.imgv_hr.setImageResource(R.drawable.pro3);
            }else if (list.get(i).getSalary() < 15000){
                holder.imgv_hr.setImageResource(R.drawable.pro2);
            }else if (list.get(i).getSalary() < 20000){
                holder.imgv_hr.setImageResource(R.drawable.pro1);
            }else {
                holder.imgv_hr.setImageResource(R.drawable.s);
            }
            holder.ln_emp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HrDialog dialog = new HrDialog(context);
                    dialog.show();
                }
            });

        }

    }
}
