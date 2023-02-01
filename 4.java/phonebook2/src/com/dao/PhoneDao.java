package com.dao;

import com.controller.PhoneController;
import com.dto.PhoneComInfo;
import com.dto.PhoneInfo;
import com.dto.PhoneSchInfo;

import java.util.ArrayList;

public class PhoneDao {
  /*
  DAO : Data Access Object
  원래는 Database와 연동하여 처리하는 객체.
  Database가 없으므로 여기에서 저장 관련 작업을 처리(ArrayList로 대체)
  */

  //일반 연락처 저장용
  private ArrayList<PhoneInfo> pList = new ArrayList<>();
  //학교 연락처 저장용
  private ArrayList<PhoneSchInfo> pSchList = new ArrayList<>();
  //회사 연락처 저장용
  private ArrayList<PhoneComInfo> pComList = new ArrayList<>();



  //method overloading
  public void inputData(PhoneInfo phone) {
    pList.add(phone);
  }

  public void inputData(PhoneSchInfo phone) {
    pSchList.add(phone);
  }

  public void inputData(PhoneComInfo phone) {
    pComList.add(phone);
  }

  //각 연락처 목록의 크기를 구하는 메소드
  public int pListSize(int cate) {
    int size = 0;
    switch (cate) {
      case 1:
        size = pList.size();
        break;
      case 2:
        size = pSchList.size();
        break;
      case 3:
        size = pComList.size();
        break;
    }
    return size;

  }//pListSize end

  //각 list의 마지막 번호를 구하는 메소드
  public int getLastNum(int cate){
    int lno = 0;
    switch(cate){
      case 1:
        //마지막 연락처의 일련번호(no)구하기
        lno = pList.get(pList.size()-1).getNo();  //<-메서드 체인(여러개의 메서드를 '.'으로 연결

        /* int n = pList.size();
        PhoneInfo p = pList.get(n-1);
        lno = p.getNo();
         */
        //    ArrayList 데이터 가져오기 : get(idx)

        break;
      case 2 :
        lno = pSchList.get(pSchList.size()-1).getNo();
        break;
      case 3:
        lno = pSchList.get(pComList.size()-1).getNo();
        break;

    }
    return lno;
  }//getLastNum end

  public PhoneInfo getPhoneInfo(int idx){
    return pList.get(idx);  //idx를 입력받아서, 해당 idx에 해당하는 PhoneInfo의 객체 반환.
  }
  public PhoneSchInfo getSchInfo(int idx){
    return pSchList.get(idx);
  }
  public PhoneComInfo getComInfo(int idx){
    return pComList.get(idx);
  }


  //반환형 -> 넘기는 데이터의 자료형.
  //반환형에 클래스가 온다는 것은, return으로 넘기는 데이터가 인스턴스라는 것.
  //type의 정의 =>자료를 저장하는 공간에 크기
  //클래스는 정의할때, 변수를 선언하는데 해당 변수들이 로딩되면서 메모리에 저장된 공간을 확보함. 선언한 변수들의 저장 크기에 따라서 공간이 할당됨.
  //=>클래스는 사용자가 만든 자료형이라고도 할 수 있다.









}//dao class end



