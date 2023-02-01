package com.controller;

import com.dto.PhoneInfo;
import com.view.InOutClass;

import java.util.ArrayList;

public class PhoneController {
  //입출력 장치 객체
  private InOutClass io = new InOutClass();
  //연락처 저장 공간
  ArrayList<PhoneInfo> book = new ArrayList<>();


  // 전체 제어 메소드 반드시 public(메인에서 불러야하기 때문에)
  public void run(){
    //메뉴 번호 저장 변수
    int menu = -1;  //0번을 종료로 사용중이기 때문에, 사용하지 않는 번호로 초기화.

    //타이틀 출력
    io.twoPrint("연락처 관리 프로그램");
    io.twoPrint("==================");

    while (true) {
      //메뉴 출력
      menuShow();

      menu = io.inNum("입력>");

      //종료 처리
      if(menu == 0){
        io.twoPrint("프로그램 종료");
        break;
      }

      //메뉴 번호에 따라 기능 처리
      switch(menu){
        case 1 : //입력 메소드 실행
          inputData();
          break;
        case 2 : //출력 메소드 실행
          outputData();
          break;
        case 3 : //검색 메소드 실행
          searchData();
          break;
        case 4 : //수정 메소드 실행
          updateData();
          break;
        case 5 : //삭제 메소드 실행
          deleteData();
          break;
        default:
          io.twoPrint("0~5번까지 입력하세요.");
      }
    }//while end
  }//run end




  // 메뉴 출력 메소드
    private void menuShow(){
      io.twoPrint("1. 연락처 입력");
      io.twoPrint("2. 연락처 출력");
      io.twoPrint("3. 연락처 검색");
      io.twoPrint("4. 연락처 수정");
      io.twoPrint("5. 연락처 삭제");
      io.twoPrint("0. 종료");
    }
  // 입력 메소드
  private void inputData() {
    io.twoPrint("-- 연락처 입력 --");
    io.twoPrint("-------------------------------");

  //생성자를 사용할 경우, 먼저 입력을 모두 받아둔다.(constructor 사용 - 값을 먼저 받고, 그 값이 들어간 저장공간을 생성)
    String name = io.inStr("이름 : ");
    String phone = io.inStr("연락처 : ");
    String birth = io.inStr("생일(mm-dd) : ");
    int age = io.inNum("나이 : ");

    PhoneInfo pInfo = new PhoneInfo(name, phone, birth, age);

    /*
  //한명분의 연락처 생성(setter 사용 - 저장할 공간을 먼저 만들고 채워넣는 방식)
    PhoneInfo pInfo = new PhoneInfo()
    pInfo.setName(io.inStr("이름 : "));
    pInfo.setPhone(io.inStr("연락처 : "));
    pInfo.setBirth(io.inStr("생일(mm-dd) : "));
    pInfo.setAge(io.inNum("나이 : "));*/



    //연락처 목록에 연락처 추가
    book.add(pInfo);
    io.twoPrint("입력완료.\n");

  }


  //이하 메소드는 처음에 데이터가 있어야만 처리 할 수 있는 메소드이므로, 실행할때 데이터 유무를 먼저 확인한다.


  // 출력 메소드
  private void outputData() {
    //저장된 정보가 있는지 확인
    if(book.size() == 0){
      io.twoPrint("정보가 없습니다.\n");
      return;   //메소드 종료
    }
    io.twoPrint("--연락처 출력 --");
    io.twoPrint("-------------------------------");

    for(PhoneInfo p : book){



      /*
      io.twoPrint("이름 : " + p.getName());
      io.twoPrint("연락처 : " + p.getPhone());
      io.twoPrint("생일 : " + p.getBirth());
      io.twoPrint("나이 : " + p.getAge());
      */


      io.twoPrint(p.toString());    // dto에 적었던 toString()메소드 호출.

      io.twoPrint("-------------------------------");
    }
    io.twoPrint("출력완료.\n");
  }//outputData end


  // 검색 메소드
  private void searchData() {
    //저장된 데이터가 있는 지 확인
    if(book.size() == 0){
      io.twoPrint("정보가 없습니다.\n");
      return;   //메소드 종료
    }
    //1. 검색 키워드(이름)을 입력 받는다.
    String sname = io.inStr("검색할 이름 : ");

    //2. 목록에서 입력받은 키워드와 같은 데이터를 비교
    for(PhoneInfo p : book){
      if(sname.equals(p.getName())){
        io.twoPrint("--연락처 검색--");
        /*
        io.twoPrint("이름 : " + p.getName());
        io.twoPrint("연락처 : "+ p.getPhone());
        io.twoPrint("생일 : " + p.getBirth());
        io.twoPrint("나이 : " + p.getAge());*/
        io.twoPrint(p.toString());
        io.twoPrint("--검색완료--\n");
        return;   //찾는 이름이 있다면, return;에서 메서드가 끝남
      }//if end
    }//for end
    //다음 문장은 검색결과가 없을 경우만 실행된다.
    io.twoPrint("찾는 이름이 없습니다. \n");

  }//searchData end


  // 수정 메소드

  public void updateData(){
    //저장된 데이터가 있는 지 확인
    if(book.size() == 0){
      io.twoPrint("정보가 없습니다.\n");
      return;   //메소드 종료
    }
    io.twoPrint("--연락처 수정--");
    io.twoPrint("-------------------------------");

    //수정할 데이터 검색
    //검색한 내용 보여주기 / 검색한 내용이 없을경우, 없다는 거 출력/
    String sname = io.inStr("수정할 이름 : ");
    int i ;     //for문 밖에서 i를 사용하기 위해 for문 밖에 선언
    PhoneInfo p = null;     //여기서 p는 데이터를 직접 담고 있는 것이 아니라, 주소를 담고 있는 참조형 변수임.
    for(i = 0;i<book.size();i++){
      p = book.get(i);
      if(sname.equals(p.getName())){
        io.twoPrint("--연락처 검색--");
        /*
        io.twoPrint("이름 : " + p.getName());
        io.twoPrint("연락처 : "+ p.getPhone());
        io.twoPrint("생일 : " + p.getBirth());
        io.twoPrint("나이 : " + p.getAge());*/
        io.twoPrint(p.toString());
        io.twoPrint("-------------------------------");
        break; //for(루프)를 멈추는 break 사용. - 검색할땐 메소드를 종료하기 위해 return을 사용, 이번엔 추가작업(수정)을 하기위해 break으로 for문만 종료
      }
    }//for end

  //검색 결과가 없을 경우 처리
  if(i == book.size()){//위의 for문에서 선형검색을 완료했을 때까지 일치하는 값이 없을 경우.
    io.twoPrint("검색 결과가 없습니다.");
    return;  //메소드 종료.
   }

  //검색 결과의 연락처 수정 (연락처, 생일, 나이만 수정 가능하도록) - 이름도 변경가능하긴 한데, 본인을 식별할 수 있는 거 하나는 남겨놓는게 좋음.
  //아무것도 입력하지 않고 '엔터'를 치면 수정 안함
  io.twoPrint("수정할 내용이 없으면 엔터를 누르시오.");
  String ustr = io.inStr("연락처 : ");
  if(!ustr.equals("")){ //공백이랑 같지 않을때(입력을 했을 때) ->조건을 둘로 나누는 이유는 뭘 입력했는지 모두 처리하긴 어려우므로, 아무것도 입력하지 않은 것에 역으로 조건을 작성함.   //+)그냥 엔터만 눌렀을 경우 ""로 입력 받는다.
    p.setPhone(ustr); //위에서 선언한 p가져와서, 지정(검색한) 연락처를 변경
  }
  ustr = io.inStr("생일 : ");
  if(!ustr.equals("")){
    p.setBirth(ustr);
  }
  int a = io.inNum("나이: ");
  if(a !=-1){   //a에 아무것도 입력하지 않을 경우, -1을 반환하도록 했었음 (InOutClass)
    p.setAge(a);
  }

  io.twoPrint("수정완료. \n");
  }//updateDate end




  // 삭제 메소드

public void deleteData(){
  io.twoPrint("--연락처 삭제--");
  io.twoPrint("-------------------------------");

  String sname = io.inStr("삭제할 이름 : ");
  int i ;     //for문 밖에서 i를 사용하기 위해 for문 밖에 선언
  PhoneInfo p = null;     //여기서 p는 데이터를 직접 담고 있는 것이 아니라, 주소를 담고 있는 참조형 변수임.
  for(i = 0;i<book.size();i++){
    p = book.get(i);
    if(sname.equals(p.getName())){
      io.twoPrint("--연락처 검색--");
      /*
      io.twoPrint("이름 : " + p.getName());
      io.twoPrint("연락처 : "+ p.getPhone());
      io.twoPrint("생일 : " + p.getBirth());
      io.twoPrint("나이 : " + p.getAge());
      */
      io.twoPrint(p.toString());

      io.twoPrint("-------------------------------");
      break; //for(루프)를 멈추는 break 사용. - 검색할땐 메소드를 종료하기 위해 return을 사용, 이번엔 추가작업(수정)을 하기위해 break으로 for문만 종료
    }
  }//for end
  //검색 결과가 없을 경우 처리
  if(i == book.size()){//위의 for문에서 선형검색을 완료했을 때까지 일치하는 값이 없을 경우.
    io.twoPrint("검색 결과가 없습니다.");
    return;  //메소드 종료.
  }

  //삭제할 연락처를 검색 성공
  String yn = io.inStr("삭제하시겠습니까?(y)");

  if(yn.equals("y")){ //입력값이 "y"라면
    book.remove(i);//i번째 에서 찾는다면 해당 i 값에서 break되기 때문에, i번째 제거하면 원하는 값을 제거할 수 있음
    // book.remove(p)로 작성해도 같은 결과.(i번째에서 찾은 데이터의 참조 주소가 p에 담겨있음)
    io.twoPrint(("삭제완료.\n"));
    return;
  }
  //입력값이 "y"가 아니라면
  io.twoPrint("삭제 취소");

}








}
