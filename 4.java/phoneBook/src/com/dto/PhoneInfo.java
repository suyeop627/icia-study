package com.dto;

public class PhoneInfo {
  private String name;

  public PhoneInfo(String name, String phone, String birth, int age) {
    this.name = name;
    this.phone = phone;
    this.birth = birth;
    this.age = age;
  }

  private String phone; //전화번호를 숫자형으로 입력받으면, 010의 맨앞0이 저장되지 않아서 문자열로 받음. 산술계산할거 아니니까 ㄱㅊ
  private String birth;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }



  //출력할 때, toString()활용
  @Override
  public String toString() {
    String str = "이름 : " + name +"\n"
        + "연락처 : " + phone + "\n"
        +"생일 : " + birth + "\n"
        +"나이 : " + age;
    return str;
  }
}//class end
