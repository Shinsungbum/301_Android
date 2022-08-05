package com.example.project01_botnav.chat;

public class ChatDTO {
    private int img_res; //0
    private  String name, msg, time; //null
    private  boolean isPin, isNoti; //false

    public ChatDTO(int img_res, String name, String msg, String time) {
        this.img_res = img_res;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPin() {
        return isPin;
    }

    public void setPin(boolean pin) {
        isPin = pin;
    }

    public boolean isNoti() {
        return isNoti;
    }

    public void setNoti(boolean noti) {
        isNoti = noti;
    }
}
