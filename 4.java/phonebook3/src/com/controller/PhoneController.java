package com.controller;

import com.dto.PhoneCInfo;
import com.dto.PhoneInfo;
import com.dto.PhoneSinfo;
import com.view.InOutClass;

import java.util.ArrayList;
import java.util.Date;

public class PhoneController {
  //저장 공간 (통합) - 부모 클래스로 생성
  ArrayList<PhoneInfo> pList = new ArrayList<>();

  InOutClass io = new InOutClass();

  public void run() {
    int menu = -1;
    io.twoPrint("간단 연락처 프로그램");

    while (true) {
      io.twoPrint("메뉴>");
      io.twoPrint("1. 학교 연락처");
      io.twoPrint("2. 회사 연락처");
      io.twoPrint("3. 전체출력");
      io.twoPrint("0.종료");
      menu = io.inNum("번호>");

      if (menu == 0) {
        io.twoPrint("프로그램 종료");
        break;
      }

      switch (menu) {
        case 1: //학교 연락처 입력
          inputSchool();
          break;
        case 2:
          inputCompany();
          break;
        case 3:
          outputTotal();
          break;
        default:
      }
    }//while end
  }//run end

  private void outputTotal() {
    if (pList.size() == 0) {
      io.twoPrint("연락처 없음. \n");
      return;
    }
    for (PhoneInfo p : pList) {       //PhoneInfo로 저장된 걸 PhoneSInfo나 PhoneCInfo로 바꾸기
      io.twoPrint("이름 :" + p.getName());
      io.twoPrint("연락처 :" + p.getPhone());
      if (p instanceof PhoneSinfo) {
        PhoneSinfo ps = (PhoneSinfo) p;
        io.twoPrint("전공 : " + ps.getMajor());
      } else {
        PhoneCInfo pc = (PhoneCInfo) p;
        io.twoPrint("부서 : " + pc.getDept());
      }
      io.twoPrint("-----------------------");
    }
  }


    private void inputCompany() {
      io.twoPrint("학교 연락처 입력");
      PhoneCInfo ps = new PhoneCInfo();
      ps.setName(io.inStr("이름 : "));
      ps.setPhone(io.inStr("연락처 : "));
      ps.setDept(io.inStr("부서 : "));
      pList.add(ps);
      io.twoPrint("입력완료 \n");
    }

    private void inputSchool () {
      io.twoPrint("학교 연락처 입력");
      PhoneSinfo ps = new PhoneSinfo();
      ps.setName(io.inStr("이름 : "));
      ps.setPhone(io.inStr("연락처 : "));
      ps.setMajor(io.inStr("전공 : "));
      pList.add(ps);
      io.twoPrint("입력완료 \n");


    }
  }//class end
