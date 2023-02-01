package com.controller;

import com.dto.DataDto;
import com.service.DataService;
import com.view.DataView;

import java.util.List;

public class DataController {
  //컨트롤러가 제어하는 view와 service의 인스턴스 생성
  private DataView dView = new DataView();
  private DataService dServ = new DataService();


  //프로그램 전체 제어 메소드
  public void run() {
    int menu = -1;


    //종료 명령이 있을 때 반복.
    while (true) {
      //타이틀 출력, 메뉴 출력, 메뉴 번호 입력 -> view
      menu = dView.showFirst();

      //종료 처리
      if (menu == 0) {
        //종료 메세지 출력 -> view
        dView.printMsg("Bye~~");
        break;
      }



      //나머지 메뉴 처리
      switch (menu) {
        case 1: //데이터 입력
          inputData();
          break;
        case 2://데이터 검색(전체 출력)
          outputData();
          break;
        case 3://데이터 검색(개별 데이터 출력)
          searchData();
          break;
        case 4://데이터 수정  = 검색 + 입력 + 수정
          updateData();
          break;
        case 5://데이터 삭제 = 검색 + 삭제
          deleteData();
          break;
        default :
            dView.printMsg("Input Error!");
      }//switch end
    }//while end
  }//run end

  private void deleteData() {
  //삭제 코드 검색
    int code = dView.searchCode("Delete Data");
    DataDto data = dServ.getData(code);
    dView.outData(data);

    if(data !=null){
      String yn = dView.isDelete();
      if(yn.equals("y")){
        //service로 code를 넘겨 삭제처리하고 결과를 받는다.
       String msg =  dServ.deleteData(code);
        dView.printMsg(msg);
      }
    }
  }

  private void updateData() { //프로그램 내부적으로는 모든 값을 수정하지만, 기존값을 불러와서 새로 넣는 것도 있다.
  //검색
    int code = dView.searchCode("Update Data");
    DataDto data = dServ.getData(code);
    dView.outData(data);

    //data가 null이 아닌 경우(즉, 데이터가 있는 경우) - 수정
    if(data != null){
      //수정할 값 입력 -> view
      dView.updateInput(data);
      //DB를 수정하기 위해 service로 전달하고 결과 메세지를 받는다.
      String msg =dServ.updateData(data);
      //결과 메세지를 출력 -> view
      dView.printMsg(msg);

    }
  }

  private void searchData() {
    //검색 값을 입력 받는다. -> view
    //현재 테이블의 기본키를 검색으로 활용. - 정수(int)
    int code = 0; //선언 이후, 바로 입력을 받는 경우에는 초기화(사용하지 않거나, 연산에 영향을 끼치지 않는 값)를 하지 않아도 됨. 하지만, 입력을 받지않고 사용해야하는 경우에는 초기화 필요.(기본적으로 지역변수는 초기화함)
    code = dView.searchCode("Data Search");
    //겁색 값 service로 전달하여 해당 데이터 가져오기. -> service
    DataDto data = dServ.getData(code);
    //해당 데이터를 화면에 출력 -> view
    dView.outData(data);
  }

  private void outputData() {
    //service에게 전체 목록(list)을 가져오도록 위임.
    List<DataDto> dList = dServ.getList();  //arrayList의 부모 인터페이스

    //목록을 view가 출력하도록 넘김.
    dView.outputList(dList);
  }

  private void inputData() {
    //3가지 데이터를 입력받는다. (str, int, date)
    DataDto data = new DataDto(); //데이터 입력 공간

    //view에서 입력처리.
    dView.inputData(data);

    //DB에 저장 -> service로 전달(성공/실패에 대한 메세지를 받아야 하기 때문에, String으로 반환.)
    String msg = dServ.insertData(data);

    //메세지 출력 -> view
    dView.printMsg(msg);
  }
}//class end
