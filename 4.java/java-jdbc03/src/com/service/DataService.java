package com.service;

import com.dao.DataDao;
import com.dto.DataDto;

import java.util.List;

public class DataService {
  //Dao를 사용하여 DB에 data를 저장하고, 결과를 controller에게 알림.
  private DataDao dDao = new DataDao();

  public String insertData(DataDto data) {
    String msg = null;

    //Dao를 사용하여 저장
    int res = dDao.insertData(data);

    if(res ==0) {//삽입 실패.
      msg = "Insert Fail";
    }
    else{
      msg = "Insert Success";
    }

    return msg;
  }//insertData end

  public List<DataDto> getList() {
  //Dao에게 DB로부터 데이터를 검색하여, 목록을 가져오게 시킴.
    List<DataDto> gList = dDao.selectList();

    //받은 목록을 controller에게 전달.
    return gList;


  }

  public DataDto getData(int code) {  //리턴, 인자가 있을 경우, 리턴할 인스턴스 만들고, 리턴에 넣어두기. -> 프로그램 자체를 일단 실행시킬 수 있다.
    DataDto data = null;
    //전달 받은 검색값을 사용하여 DB select 작업을 수행 -> Dao
    data = dDao.selectData(code);
    //검색 결과 데이터를 controller에 전달(반환)

    return data;

  }

  public String updateData(DataDto data) {
    String msg = null;

    //dao에서 DB 수정 처리.
    int res = dDao.updateData(data);

    if( res > 0){
      msg = "Update Success.";
    }
    else{
      msg = "Update Failed";
    }


    return msg;
  }

  public String deleteData(int code) {
    int res = dDao.deleteData(code);
    String msg = null;
    if(res>0){
      msg = "Delete Success.";
    }
    else {
      msg = "Delete Failed.";
    }
    return msg;
  }
}//clase end
