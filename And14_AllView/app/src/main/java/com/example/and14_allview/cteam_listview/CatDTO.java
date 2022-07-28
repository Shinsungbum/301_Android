package com.example.and14_allview.cteam_listview;

import com.example.and14_allview.R;

public class CatDTO {
    private String date, name, userid;
    private int no, img_id, user_img;
//list.add(new CatDTO("07-27", "오월", 1,R.drawable.cat1, "gf58_g58", R.drawable.userid1));

    public CatDTO(String date, String name, int no ,int img_id,  String userid, int user_img) {
        this.date = date;
        this.name = name;
        this.userid = userid;
        this.no = no;
        this.img_id = img_id;
        this.user_img = user_img;
    }

    public int getUser_img() {
        return user_img;
    }

    public void setUser_img(int user_img) {
        this.user_img = user_img;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}//class
