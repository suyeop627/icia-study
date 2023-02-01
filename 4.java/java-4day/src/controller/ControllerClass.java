package controller;

//import java.util.*; - 유틸 안에있는 객체들 모두 사용할 수 있게 import할 수도 있지만 굳이 할필요까진 없다.

import dto.DataDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerClass {
  //멤버로 스캐너 작성 (전체가 사용? ->찾아볼것)
  Scanner scan = new Scanner(System.in);
  //데이터 저장 공간(ArrayList) - Dto 배열 (DataDto)
  ArrayList<DataDto> datas = new ArrayList<>();
  public void run(){


    String menu = null;

    System.out.println("☆☆ 관리 프로그램 ☆☆");
    System.out.println("=====================");
    while(true){
      System.out.println("1.입력");
      System.out.println("2.출력");
      System.out.println("0.종료");
      System.out.println("입력>");
      menu = scan.nextLine();

      if(menu.equals("0")){
        System.out.println("프로그램 종료");
        break;
      }
      switch(menu){
        case "1":

          inputData();

          break;
        case "2":
          outputData();
          break;
        default:
          System.out.println("0~1번 중에 하나를 입력하세요.");

      }
    }//while end
  }//run end
  //입력처리용 메소드
  void inputData(){
    System.out.println("☆입력(숫자입력)☆");
    System.out.println("-----------------");
    String inValue = null;
    int num = 0;
    float fnum = 0.0f;
    DataDto data = null;

    try{

      data = new DataDto();
      System.out.print("정수 입력 : ");
      inValue = scan.nextLine();
      num = Integer.parseInt((inValue));
      data.setNumber(num);

      System.out.print("문자열 입력 : ");
      inValue = scan.nextLine();
      data.setStr(inValue);

      System.out.print("실수 입력 : ");
      inValue = scan.nextLine();
      fnum = Float.parseFloat(inValue);
      data.setFnumber(fnum);


    }catch(NumberFormatException nfe){
      System.out.println("숫자를 입력하세요.");
      return;
    }

    //ArrayList에 값 추가 : add()
    datas.add(data);


    System.out.println("입력완료. 이전 메뉴로 돌아갑니다.");
  }//inputData end

  void outputData(){
    System.out.println("☆ 전체 출력 ☆");
    System.out.println("-----------------");
    int sum = 0;


    if(datas.size()==0) {
      System.out.println("데이터가 없습니다.");
      return;
    }

    for(DataDto d : datas){
      System.out.println(d.getNumber() + ", "+d.getStr()+ ", " + d.getFnumber());
      System.out.println("정수 : " + d.getNumber());
      System.out.println("문자열 : " + d.getStr());
      System.out.println("실수 : " + d.getFnumber());

      sum +=d.getNumber();
      System.out.println("------------------------");
    }
    System.out.println("총합 : " + sum);
    System.out.println("출력 완료. 이전 메뉴로 돌아갑니다.");

  }

}//class end
