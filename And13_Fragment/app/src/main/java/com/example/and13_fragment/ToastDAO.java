package com.example.and13_fragment;

import android.content.Context;
import android.widget.Toast;

public class ToastDAO {
/*    Context context;

    Context의 기능을 여러 메소드에서 (ToastDAO) 사용한다면 생성자를 사용해서
    Context자체를 필드로 두고 사용하는것이 편하고,
    showToast라는 메소드 내부에서만 사용을 할때는 파라메터로 입력만 받는게 편하다.

    public ToastDAO(Context context) {
        this.context = context;
    }*/

    public void showToast(Context context , String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
