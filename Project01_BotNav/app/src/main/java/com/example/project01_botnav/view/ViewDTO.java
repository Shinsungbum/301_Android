package com.example.project01_botnav.view;

public class ViewDTO {
    private int img_banner, img_pr;
    private String tv_name, tv_title, tv_content, tv_date;

    public ViewDTO(int img_banner, int img_pr, String tv_name, String tv_title, String tv_content, String tv_date) {
        this.img_banner = img_banner;
        this.img_pr = img_pr;
        this.tv_name = tv_name;
        this.tv_title = tv_title;
        this.tv_content = tv_content;
        this.tv_date = tv_date;
    }

    public int getImg_banner() {
        return img_banner;
    }

    public void setImg_banner(int img_banner) {
        this.img_banner = img_banner;
    }

    public int getImg_pr() {
        return img_pr;
    }

    public void setImg_pr(int img_pr) {
        this.img_pr = img_pr;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }

    public String getTv_date() {
        return tv_date;
    }

    public void setTv_date(String tv_date) {
        this.tv_date = tv_date;
    }
}
