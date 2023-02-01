package com.service;

import com.dao.DataDao;
import com.dto.DataDto;

import java.util.List;

public class DataService {
  //DB 관련 작업용 부품 - DAO
  private DataDao dDao = new DataDao();

  //입력 받은 데이터를 DB에 삽입 서비스
  public String insertData(DataDto data){ //데이터 삽입 성공 유무를 controller에 전달하기 위해서 retrun type = String
    String msg = null;

    //DAO에게 데이터 삽입 명령.
    int res = dDao.insertData(data);
    if(res !=0){
      msg="입력 성공";
    }
    else{
      msg = "입력 실패";
    }
    return msg;
  }//insertData end

  public List<DataDto> getList(){ //arrayList의 부모 클래스
    //Dao 의 전체 목록을 가져오는 메소드 실행
    List<DataDto> dList = dDao.selectList();

    //Dao에게서 받은 목록을 controller에게 전달.
    return dList;
  }//getList end

  //입력받은 코드의 데이터를 가져오는 메소드
  public DataDto getData(int code){
    //받은 코드로 dao에 전달하여 해당 데이터를 가져오도록 한다.
    DataDto data = dDao.getData(code);
    return data;
  }


  public String deleteDate(int code) {
    String msg = null;

    //dao로 코드를 넘겨서 DB삭제.
    int res = dDao.deleteData(code);

    if(res>0){
      msg = "삭제 성공";
    }else{
      msg = "삭제 실패";
    }
    return msg;

  }
}
