package com.view;

import java.util.Scanner;

public class InOutClass {
  //InOutClass의 기능
  //1. 키보드로부터 데이터를 입력받는다.
  private Scanner scan = new Scanner(System.in);

  //문자열 입력 메소드 (String(이름, 연락처, 생일), Integer(나이))
  public String inStr(String str) {
    //입력 유도용 안내문구(str)를 출력하고 입력값을 받아서 넘긴다.
    onePrint(str);
    String s = scan.nextLine();
    return s;
  }

  //정수 입력 메소드
  public int inNum(String str) {
    onePrint(str); //안내문구
    String s = scan.nextLine();
    int num = -1;
    //아무것도 입력하지 않을 경우
    if (s.equals("")) {
      num = -1;
      return num; //메소드 종료
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

  //2. 모니터로 데이터를 출력한다.
  //줄바꿈 안하는 출력 메소드
  public void onePrint(String str) {
    System.out.print(str);      //코드 분할 : 나중에 수정이나 대체가 필요한 부분이 포함된 코드는 분할해서 작성해야 나중에 수정하기 수월하다. 이 경우, view에서 수정이 예상돼서 코드를 분할했음
  }

  //줄바꿈 하는 출력 메소드
  public void twoPrint(String str) {

    System.out.println(str);
  }
}