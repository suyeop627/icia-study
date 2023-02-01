package com.view;

import java.util.Scanner;

public class InOutClass {

  private Scanner scan = new Scanner(System.in);

  //문자열 입력 메소드
  public String inStr(String str) {
    onePrint(str);
    String s = scan.nextLine();
    return s;
  }

  //정수 입력 메소드
  public int inNum(String str) {
    onePrint(str);
    String s = scan.nextLine();
    int num = -1;
    //아무것도 입력하지 않을 경우
    if (s.equals("")) {
      num = -1;
      return num;
    }
    //숫자가 아닌 문자가 입력되었을 경우의 처리
    try {
      num = Integer.parseInt(s);
    } catch (Exception e) {
      twoPrint("잘못된 입력!");
      num = -1;
    }
    return num;
  }

  //줄바꿈 안하는 출력 메소드
  public void onePrint(String str) {
    System.out.print(str);
  }

  //줄바꿈 하는 출력 메소드
  public void twoPrint(String str) {

    System.out.println(str);
  }
}