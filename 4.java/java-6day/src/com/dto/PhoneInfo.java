package com.dto;

public class PhoneInfo {
  private String name;
  private String phone;
  private String birth;
  private int age;


  //생성자 - generate 메뉴에 보면 Constructor가 있음 +)매개변수로 setter를 대신 할 수 있다.
  public PhoneInfo(String name, String phone, String birth, int age) {
    this.name = name;
    this.phone = phone;
    this.birth = birth;
    this.age = age;
  }

}
