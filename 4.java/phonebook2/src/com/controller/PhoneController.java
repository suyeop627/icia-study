package com.controller;

import com.dao.PhoneDao;
import com.dto.PhoneComInfo;
import com.dto.PhoneInfo;
import com.dto.PhoneSchInfo;
import com.view.InOutClass;

public class PhoneController {
  private InOutClass io = new InOutClass();
  private PhoneDao pDao = new PhoneDao();

  //전체 제어 메소드
  public void run() {
    int menu = -1;
    //타이틀 출력

    io.twoPrint("연락처 관리 프로그램_v2");
    io.twoPrint("=======================");

    while (true) {
      menuShow();
      menu = io.inNum("입력>");

      if (menu == 0) {
        io.twoPrint("프로그램 종료");
        break;
      }
      //전 버전은 입력이 한가지 였지만, v2에선 3개의 카테고리로 나뉘어서 정보를 입력받는다.
      //메뉴->서브메뉴
      //서브 메뉴 내에서도 무한루프가 생성돼야 한다.
      switch (menu) {
        case 1: //입력 메소드 실행
          inputData();
          break;
        case 2: //출력 메소드 실행
          outputData();
          break;
        case 3: //검색 메소드 실행

          break;
        case 4: //수정 메소드 실행

          break;
        case 5: //삭제 메소드 실행

          break;
        default:
          io.twoPrint("0~5번까지 입력하세요.");
      }
    }//while end

  }//run end

  private void outputData() {
    //저장된 데이터가 없을 때 처리

    if(pDao.pListSize(1)==0 && pDao.pListSize(2) == 0 && pDao.pListSize(3) == 0){
      io.twoPrint("저장된 연락처가 없습니다. \n");
      return;
    }


    int submenu = -1;
    //서브타이틀 출력
    io.twoPrint("<<연락처 출력>>");
    io.twoPrint("------------------");

    while (true) {
      //출력 하위
      io.twoPrint("1. 전체 출력");
      io.twoPrint("2. 구분 출력");
      io.twoPrint("0. 돌아가기");

      submenu = io.inNum("입력>");
      if (submenu == 0) {
        io.twoPrint("메인메뉴로 돌아갑니다. \n");
        break;
      }
      switch (submenu) {
        case 1: //1. 전체 출력 -> 기능이 많아서 메소드로 정의해서 사용.
          outputTotal();
          break;

        case 2:
          break;


        default:
          io.twoPrint("0~2까지만 입력하세요.");
      }

    }

    //1. 전체 출력
    //2. 구분 출력(일반, 학교, 회사)
    //3.


  }

  private void outputTotal() {
    //전체 출력 메소드
    //io.twoPrint();
    io.twoPrint("<전체출력>");
    io.twoPrint("------------------");
    //일반 출력>학교 출력>회사 출력
    for (int i = 0; i < pDao.pListSize(1); i++) {       //for문 여러개 작성한거 하나로 합쳐보기
      io.twoPrint(pDao.getPhoneInfo(i).toString());
      io.twoPrint("------------------");
    }
    for (int j = 0; j < pDao.pListSize(2); j++) {
      io.twoPrint(pDao.getSchInfo(j).toString());
      io.twoPrint("------------------");
    }
    for (int k = 0; k < pDao.pListSize(3); k++) {
      io.twoPrint(pDao.getComInfo(k).toString());
      io.twoPrint("------------------");
    }io.twoPrint("출력완료");
  }

  //입력 메소드
  private void inputData() {  //서브메뉴를 위해서, PhoneController.run 메소드와 같은 구조를 갖게 한다
    int submenu = -1;
    //서브 타이틀 출력
    io.twoPrint("<<연락처 입력>>");
    io.twoPrint("------------------");

    while (true) {
      subMenuShow();
      submenu = io.inNum("입력>");

      if (submenu == 0) {
        io.twoPrint("메인메뉴로 돌아갑니다.\n");
        break;
      }
      switch (submenu) {
        case 1:
          inputNormal();
          break;

        case 2:
          inputSchool();
          break;

        case 3:

          inputCompany();
          break;

        default:
          io.twoPrint("0~3까지만 입력하세요.");
      }


    }//while end
  }//inputData end

  private void inputCompany() {
    int no = 0;
    if (pDao.pListSize(3) == 0) {
      no = 1;
    } else {
      no = pDao.getLastNum(3) + 1;
    }

    PhoneComInfo pInfo = new PhoneComInfo();
    //반복되는 코드를 뽑아서 메서드로 만들 수도 있다. 아래의 이름~나이까지는 동일한 문장의 반복이므로 메서드로 활용 가능 //pInfo를 매개변수로 받아서 set하면 될듯?
    pInfo.setNo(no); //일련번호 저장
    pInfo.setName(io.inStr("이름 : "));
    pInfo.setPhone(io.inStr("연락처 : "));
    pInfo.setBirth(io.inStr("생일 : "));
    pInfo.setAge(io.inNum("나이 : "));

    pInfo.setCompany(io.inStr("회사명 : "));
    pInfo.setDept(io.inStr("부서명 : "));
    pInfo.setLevel(io.inStr("직급 : "));

    pDao.inputData(pInfo);
  }

  private void inputSchool() {
    int no = 0;
    if (pDao.pListSize(2) == 0) {
      no = 1;
    } else {
      no = pDao.getLastNum(2) + 1;  //마지막 데이터의 번호에 +1 - 멤버변수에 no를 넣어도 프로그램이 종료되면 모두 초기화 되기 때문에, 매번 no를 구해야한다.
    }
    PhoneSchInfo pInfo = new PhoneSchInfo();
    pInfo.setNo(no); //일련번호 저장
    pInfo.setName(io.inStr("이름 : "));
    pInfo.setPhone(io.inStr("연락처 : "));
    pInfo.setBirth(io.inStr("생일 : "));
    pInfo.setAge(io.inNum("나이 : "));
    pInfo.setSname(io.inStr("학교 : "));
    pInfo.setMajor(io.inStr("전공 : "));
    pInfo.setYear(io.inNum("학년 : "));

    pDao.inputData(pInfo);
  }

  private void inputNormal() {
    //각 구분별 연락처(일반, 학교, 회사)별 일련번호 처리.
    int no = 0;
    if (pDao.pListSize(1) == 0) {
      no = 1;
    } else {
      no = pDao.getLastNum(1) + 1;  //마지막 데이터의 번호에 +1 - 멤버변수에 no를 넣어도 프로그램이 종료되면 모두 초기화 되기 때문에, 매번 no를 구해야한다.
    }

    PhoneInfo pInfo = new PhoneInfo();
    pInfo.setNo(no); //일련번호 저장
    pInfo.setName(io.inStr("이름 : "));
    pInfo.setPhone(io.inStr("연락처 : "));
    pInfo.setBirth(io.inStr("생일 : "));
    pInfo.setAge(io.inNum("나이 : "));

    pDao.inputData(pInfo);

  }


  //서브메뉴 출력 메소드
  private void subMenuShow() {
    io.twoPrint("1. 일반 연락처");
    io.twoPrint("2. 학교 연락처");
    io.twoPrint("3. 회사 연락처");
    io.twoPrint("0. 돌아가기");
  }


  // 메뉴 출력 메소드
  private void menuShow() {
    io.twoPrint("1. 연락처 입력");
    io.twoPrint("2. 연락처 출력");
    io.twoPrint("3. 연락처 검색");
    io.twoPrint("4. 연락처 수정");
    io.twoPrint("5. 연락처 삭제");
    io.twoPrint("0. 종료");
  }


}//class end
