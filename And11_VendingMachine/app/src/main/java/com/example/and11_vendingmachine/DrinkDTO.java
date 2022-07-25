package com.example.and11_vendingmachine;

import android.widget.TextView;

public class DrinkDTO {
    private String name ;
    private int price , cnt ;

    // private TextView tv_name , tv_price , tv_cnt;

    public DrinkDTO(String name, int price, int cnt) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
    }

    public String getNameCnt(){
        return name + " " + price + "원";
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
