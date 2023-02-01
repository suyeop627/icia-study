package com.controller;

import com.dto.DataDto;
import com.service.DataService;
import com.view.DataView;

import java.util.List;

public class DataController {
  private DataView dView = new DataView();//화면 입출력
  private DataService dServ = new DataService();//기능 처리

  //전체 프로그램 제어 메소드
  public void run(){
   int menu = -1;

   //종료 명령이 있을 때까지 무한 반복
    while(true){
      //타이틀, 메뉴 출력, 메뉴번호 입력
      menu = dView.showFirst();

      if(menu == 0){
        dView.printMsg("프로그램 종료");  //controller class에서는 직접 InOutClass를 사용하지 않으므로, View class에서
        break;
      }
      switch(menu){
        case 1:
          inputData();
          break;
        case 2:
          outputData();
          break;
        case 3:
          searchData();
          break;
        case 4: //데이터 수정 : 검색 + 수정  (수정입력 + 처리)
          break;
        case 5: // 데이터 삭제 : 검색 + 삭제
          deleteData();
          break;
        default:
          dView.printMsg("0~5 사이 숫자 입력 !");
      }
    }
  }//run end

  private void deleteData() {
    //검색과정
    int code = dView.searchCode("삭제 코드 : ");
    DataDto data = dServ.getData(code);
    dView.outputData(data);


    if(data !=null){//코드에 해당하는 결과가 있을 경우에만 실행.

      //삭제 과정(service로 해당 코드를 넘겨서 처리)
      String msg = dServ.deleteDate(code);


      dView.printMsg(msg);

    }
  }

  private void searchData() {
    //검색 : 키값(m_code)을 사용.
    //검색 값 입력 -> service 전달하여 해당 값을 검색
    int code = dView.searchCode("검색 코드 : ");
    DataDto data = dServ.getData(code);

    //검색 결과 출력 -> view
    dView.outputData(data);


  }

  private void outputData() {
    //service의 전체 데이터를 가져오는 메소드를 실행
    //받는 데이터는 목록 형태, ArrayList활용
    List<DataDto> dList = dServ.getList();

    //목록 출력
    dView.outputList(dList);

  }

  private void inputData() {
    //키보드로 데이터 받기(view) -> DB 저장(service)
    //데이터를 담을 공간 만들기
    DataDto data = new DataDto();

    //공간을 view에 넘겨서 데이터를 받게함.
     dView.inputData(data);

    //데이터가 담긴 공간을 service로 전달.
    String msg = dServ.insertData(data);
    dView.printMsg(msg);
  }
}
