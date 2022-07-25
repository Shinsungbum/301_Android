package com.example.and11_vendingmachine;

import android.widget.Toast;

import java.util.ArrayList;

public class DrinkDAO {

    // DrinkDTO두건을 가진 ArrayList를 return하는 메소드 initDrinks를 만드세요.<

    public ArrayList<DrinkDTO> initDrinks(){
        ArrayList<DrinkDTO> list = new ArrayList<>();
        //DrinkDTO dto = new DrinkDTO("콜라",1000 , 10);
        //DrinkDTO dto = new DrinkDTO("콜라",1000 , 10);
        list.add(new DrinkDTO("환타",1000 , 10));
        list.add(new DrinkDTO("사이다",900 , 8));

        return list ;
    }

    //ArrayList<ViewDTO> <- 텍스트이름1 , 수량1 , 버튼1 , ..2 , 2, 2
    //ArrayList<DrinkDTO>를 입력받아 ArrayList<ViewDTO>의 내용을 세팅할수있는 메소드를 만드세요.
    // 두개의 ArrayList는 Size가 같기때문에 index(주소)를 잘활용하면 데이터 매칭이 편리하다.
    /*
    public void setData(ViewDTO dto){
        //dto.getTv_name().setText("테스트");
    }*/


    public  void  setData(ArrayList<DrinkDTO>list , ArrayList<ViewDTO> v_list){
        for (int i = 0; i < v_list.size(); i++) {
            v_list.get(i).getTv_name().setText(list.get(i).getNameCnt());
            v_list.get(i).getTv_cnt().setText(list.get(i).getCnt() + "개 남음");
        }
    }

    //list와 index를 가지고와서 작업.
    //Dto만 가지고와서 작업.
    //ViewDTO 묶어놓은 ArrayList
    public void setMinusDrink(ArrayList<DrinkDTO>list , int index){
        //수량 체크 , 금액 체크(별도 메소드 이용)
        if(list.get(index).getCnt() == 0) {
            

        }else {
            list.get(index).setCnt(list.get(index).getCnt() - 1);

        }
    }








}
