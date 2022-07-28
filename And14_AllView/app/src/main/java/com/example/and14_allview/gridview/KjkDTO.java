package com.example.and14_allview.gridview;

public class KjkDTO {

    //R.drawble.image이름 == R.int형으로 저장되어 있음.
    private int no, img_id;
    private String category,name;

    public KjkDTO(int no, int img_id, String category, String name) {
        this.no = no;
        this.img_id = img_id;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}//class
