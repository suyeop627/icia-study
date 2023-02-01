package controller;

//import java.util.*; - 유틸 안에있는 객체들 모두 사용할 수 있게 import할 수도 있지만 굳이 할필요까진 없다.
import dto.DataDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerClass {
  //멤버로 스캐너 작성 (전체가 사용? ->찾아볼것)
  Scanner scan = new Scanner(System.in);
  //데이터 저장 공간(ArrayList) - 정수배열
  ArrayList<Integer> nums = new ArrayList<>();   //데이터를 정리하는 거- 참조변용함 //길이를 지정하지 않아도 수 사무한히 담을수 있는 배열..? ->찾아볼것
  public void run(){
    DataDto dd = new DataDto();//dto DataDto import

    //dd.number = 100; : private으로 돼있어서 불러올 수 없음 - 정보 은닉 기능

    //지역변수는 가급적 초기화를 하자
    String menu = null; //String(객체)은 null

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
        break; //또는 return;
      }
      switch(menu){//정수변수, 문자열변수, 문자변수
        case "1":
          //하나에 모든 프로그램을 담으면 나중에 유지보수도 어렵고, 협업상황에서도 좋지 않음. 기능별이나 구조적으로 분할해서 작업하는게 좋음
          inputData();

          break;
        case "2":
          outputData();
            break;
        default://잘못된 입력 처리
          System.out.println("0~1번 중에 하나를 입력하세요.");

      }
    }//while end
  }//run end
      //입력처리용 메소드
    void inputData(){
      System.out.println("☆입력(숫자입력)☆"); //서브타이틀
      System.out.println("-----------------"); //서브타이틀
      System.out.print("값 입력 : "); //서브메뉴

      String invalue = scan.nextLine();
      int num = Integer.parseInt(invalue);    //스캐너 오류방지하려고 nextLine()만 사용할 예정 ->숫자형으로 변환하는 거 추가
      //만약 사용자가 숫자가 아닌 값을 입력한다면?
      try{
        num = Integer.parseInt((invalue));

      }catch(NumberFormatException nfe){        //NumberFormatException->Exception으로 처리 가능
        System.out.println("숫자를 입력하세요.");
        return;
      }
      //ArrayList에 값 추가 : add()
      nums.add(num);    //push와 같은일을 하는 메소드 - 가장 뒤에 하나씩 넣어줌
      System.out.println("입력완료. 이전 메뉴로 돌아갑니다.");//32에 bp찍고, num의 값과 nums의 크기 확인해보기
    }//inputData end

  void outputData(){
    System.out.println("☆ 전체 출력 ☆");//서브타이틀
    System.out.println("-----------------");//서브타이틀
    int sum = 0;

    //데이터의 유무를 확인해서 없을 경우 메소드를 종료한다.
    // (입력을 받아야 총합을 구할 수 있음, 되긴 하는데 합해서0인건지 데이터가 없어서 0인건지 명확히 하기위함.
    if(nums.size()==0) { //배열.size() - length랑 비슷한거 : 찾아보기
      System.out.println("데이터가 없습니다.");
      return;       //반복문이 시행중인게 아니라서 break;는 사용할 수 없다. return;은 메소드를 끝내버리므로, 아래의 while문 아래 실행해야하는 문장이 있다면, return;을 사용하면 안된다.
    }

    for(int n : nums){      //향상된 for문
      System.out.println(n);
      sum +=n;
    }
    System.out.println("총합 : " + sum);
    System.out.println("출력 완료. 이전 메뉴로 돌아갑니다.");

  }

}//class end
