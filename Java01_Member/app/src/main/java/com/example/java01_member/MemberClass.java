package com.example.java01_member;

public class MemberClass {
    //접근제한자 , static 멤버 구분자 의 기능을 이해하기.
    // 메인 액티비티에서 세개의 변수에 모두 접근을 시도해보고 된다면 왜 되는지 , 안된다면 왜 안되는지 이유를 알기.
    String default_str; // 접근제한자_변수명 == default 같은 패키지 내에서
    public String public_str; // 어디서든
    private String private_str; // 같은 맴버안에서 (클래스 안에서 사용이 가능 )
    // protected 생략

    //디폴트메소드, 퍼블릭메소드, 프라이빗메소드
    //private에 접근하기위해서 getter& setter를 만드는데
    // getter & setter는 반드시 접근이 되야해서 기본적으로 public <- 으로 만들어짐

    //default
    void memberMethod(){

    }

    public void memberMethodI(){

    }

    private void memberMethodII(){

    }

}
