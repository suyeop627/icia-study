package com.view;

import com.dto.DataDto;

import java.util.List;

public class DataView {
  //입출력을 위한 부품.(InOutClass)
  private InOutClass ioc = new InOutClass();

  //타이틀, 메뉴 출력, 메뉴번호 입력
  public int showFirst(){ //선택할 메뉴에 해당하는 정수값을 입력받으므로, return type = int
    int m = -1;

    ioc.twoPrint(""); //첫줄 띄기.
    ioc.twoPrint("<<DB 연동 데이터 관리 프로그램>>");
    ioc.twoPrint("----------------------------------------");
    ioc.twoPrint("메뉴>");
    ioc.twoPrint("1. Data input");
    ioc.twoPrint("2. Data output"); //전체 출력
    ioc.twoPrint("3. Data search");  //개별 출력
    ioc.twoPrint("4. Data update");
    ioc.twoPrint("5. Data delete");
    ioc.twoPrint("0. Quit");
    m = ioc.inNum("Select>");

    return m;
  }//showFirst end

  //메세지 출력용 메소드
  public void printMsg(String msg){
    ioc.twoPrint(msg);
  }

  //데이터 입력 메소드
  public void inputData(DataDto data){
    //m_code는 자동증가이므로, 데이터를 따로 입력받을 필요가 없다.
    ioc.twoPrint("<Data input>");
    ioc.twoPrint("----------------------------------------");
    data.setM_str(ioc.inStr("STRING : "));
    data.setM_int(ioc.inNum("INT : "));
    data.setM_date(ioc.inStr("DATE(yyyy-mm-dd) : "));
  }//inputData end

//전체 출력용 메소드
  public void outputList(List<DataDto> dList){
    ioc.twoPrint("<Data output>");
    ioc.twoPrint("----------------------------------------");
    if(dList.size() ==0){
      ioc.twoPrint("데이터가 없습니다.");
    }

    //목록 출력(반복)
    for(DataDto d : dList){
      ioc.twoPrint("code : " + d.getM_code());
      ioc.twoPrint("string : " + d.getM_str());
      ioc.twoPrint("integer : "+d.getM_int());
      ioc.twoPrint("date : " +d.getM_date());
      ioc.twoPrint("----------------------------------------");
/*
두 메소드 모두 Object의 값을 String으로 변환하지만 변경하고자 하는Object가 null인 경우 다르다.
toString()과 같은 경우 Null PointerException(NPE)을 발생시키지만 valueOf는 "null"이라는 문자열로 처리한다.

즉 비교해서 정리하자면
String.valueOf() - 파라미터가 null이면 문자열 "null"을 만들어서 반환한다.
toString() - 대상 값이 null이면 NPE를 발생시키고 Object에 담긴 값이 String이 아니여도 출력한다.

대상을 문자열로 바꾸는 다른 방법은 +""를 붙이는 것.

 */
    }
  }//outputList end


  //검색코드 입력 메소드
  public int searchCode(String str){
    int code = 0;  //DB에서 auto increment 로 생성되는 번호는 1부터 시작하므로, 사용되지 않는 값인 0으로 초기화.

    ioc.twoPrint("<Data search>");
    ioc.twoPrint("----------------------------------------");
    code = ioc.inNum(str);
      return code;

  }//searchCode end

  public void outputData(DataDto data){


    ioc.twoPrint("<검색 결과>");
    ioc.twoPrint("----------------------------------------");

    if (data ==null){

      ioc.twoPrint("검색 결과 없음");
      ioc.twoPrint("----------------------------------------");
    }else {
      ioc.twoPrint("code : " + data.getM_code());
      ioc.twoPrint("string : " + data.getM_str());
      ioc.twoPrint("integer : "+data.getM_int());
      ioc.twoPrint("date : " +data.getM_date());
      ioc.twoPrint("----------------------------------------");
    }
  }






}//class end
