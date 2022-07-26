package com.example.and13_fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class SubFragment extends Fragment {
Button btn_subfragment;
    //기본적으로 프래그먼트 파일을 추가하게 되면 불필요한 코드가 많음.
    //우리가 필요한것은 onCreateView!만 있으면 됨.
    // onCreateView라는 메소드는 항상 View타입이 리턴되어야 한다

    //서브프래그먼트가 생성될때 상위 액티비티에서 받아오는 방식????
    Context context;
    //생성자를 이용해서 액티비티로 부터 Context를 받아온다.
    //※ 3번째 방법 필요한 기능(객체)이 있고 생성하거나 받아올수없는 상황이면,
    //객체가 생성 될때 해당하는 기능을 받아오면 된다.
    public SubFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sub, container, false);
        btn_subfragment = v.findViewById(R.id.btn_subfragment);
        btn_subfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Context 어떠한 기능을 사용하기위해서 상위 액티비티에서 무언가를 받아옴.
                //Toast.makeText(v.getContext(), "토스트 띄움", Toast.LENGTH_SHORT).show(); <= 오류가 날 소지가 많음 X
                //Toast.makeText(getContext(), "토스트 띄움", Toast.LENGTH_SHORT).show(); // 1. Fragment에서 Context기능을 받아오기 위한 첫번째 방법.
               // Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show(); // 2. Fragment에서 Context기능을 받아오기 위한 첫번째 방법.

                Toast.makeText(context, "띄움움움집", Toast.LENGTH_SHORT).show();
            }
        });















        return v;

        //return 밑에는 절대로 실행될 문장이 아니기때문에 코드 에러. 지우거나 return 위로 올려야함.
    }
}