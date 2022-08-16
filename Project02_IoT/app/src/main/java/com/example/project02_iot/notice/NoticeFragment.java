package com.example.project02_iot.notice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class NoticeFragment extends Fragment {

    //애니메이션 객체를 준비함.
    Animation flowAnim;
    //2. load속성을 이용해서 만들어둔 애니메이션 로딩.

    //3. 위젯에다가 연결.

    ViewPager2 pager2;
    RecyclerView recv_noti;
    ArrayList<Integer> img_list = new ArrayList<>();
    WormDotsIndicator indicator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notice, container, false);
        pager2 = v.findViewById(R.id.pager2);
        indicator = v.findViewById(R.id.indicator);
        recv_noti = v.findViewById(R.id.recv_noti);
        img_list.add(new Integer(R.drawable.banner1));
        img_list.add(new Integer(R.drawable.banner2));
        img_list.add(new Integer(R.drawable.banner3));
        img_list.add(new Integer(R.drawable.banner4));
        img_list.add(new Integer(R.drawable.banner5));
        // img_list를 이용하여 (size, bind) Pager2Adapter라는 어댑터를 만들기 ↑

        Pager2Adapter adapter = new Pager2Adapter(getLayoutInflater(), img_list);
        pager2.setAdapter(adapter);
        indicator.setViewPager2(pager2);
        pager2.setPageTransformer(new ZoomOutPageTransformer());



        /*애니메이션*/
        /*
        flowAnim = AnimationUtils.loadAnimation(getContext(), R.anim.flow);
        tv_test.startAnimation(flowAnim);*/
        recv_notice();
        autoSlide();
        return v;
    }
    //공지글 연결
    public void recv_notice(){
        CommonConn conn = new CommonConn("list.no", getContext());
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult) {
                    Log.d("공지글리스트", "onResult: 성공");
                    ArrayList<NoticeVO> list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<NoticeVO>>(){}.getType());
                    NoticeAdapter adapter = new NoticeAdapter(getLayoutInflater(), list);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recv_noti.setAdapter(adapter);
                    recv_noti.setLayoutManager(manager);
                }
            }
        });
    }

    public void autoSlide(){
        // new Handler <- SplashActivity 페이지 전환용으로 사용.
        // runOnUiThread(Activity 에서만 접근 가능) <- 페이지 내부에서 디자인이 바뀌는 용으로 쓰레드 사용 시
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < img_list.size(); i++) {
                    final int value = i;
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pager2.setCurrentItem(value);
                        }
                    });

                    //몇초동안 보여줄것인지
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//try

                    //처음부터 다시(무한 반복)
                    if (i == img_list.size() -1) {
                        i = -1;
                    }

                }

            }
        }).start();
        }

    public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

}