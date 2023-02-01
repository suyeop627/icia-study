package com.jsframework.spr_jdbc.service;

import com.jsframework.spr_jdbc.dao.DataDao;
import com.jsframework.spr_jdbc.dto.DataDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service  //스프링 컨테이너에 Service를 등록하기 위한 annotation
@Log
public class DataService {
  //DB와 연계된 작업을 수행할 땐, Dao 클래스를 사용한다.
  @Autowired
  private DataDao dDao;

  public String inputData(DataDto data) {
    String msg = null;
    int result = 0;
    //SQL의 insert는 결과값이 정수이므로, 결과 판단을 위한 변수 result를 0으로 초기화해서 선언.

    result = dDao.insertData(data);

    return msg;
  }


  //데이터 목록을 받는 메서드
  public ModelAndView outputList() {
    log.info("outputList()");
    ModelAndView mv = new ModelAndView();
    List<DataDto> dList = dDao.selectList();

    mv.addObject("dList", dList);
    mv.setViewName("dataList");

    return mv;

  }
}
