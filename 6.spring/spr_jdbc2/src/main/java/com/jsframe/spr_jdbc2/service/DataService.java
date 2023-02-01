package com.jsframe.spr_jdbc2.service;

import com.jsframe.spr_jdbc2.dao.DataDao;
import com.jsframe.spr_jdbc2.dto.DataDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service   //스프링 컨테이너에 Service를 등록하기 위한 annotation
@Log
public class DataService {
  //Dao 사용 : Autowired로 자동 처리
  @Autowired
  DataDao dDao;

  public String inputData(DataDto data, RedirectAttributes rttr) {
    log.info("inputData()");
    String msg = null;
    String view = null;
    try {
      dDao.insertData(data);
      msg = "입력성공";      //사용자 화면에 출력할 메세지.
      view = "redirect:/";
    } catch (Exception e) {
      //e.printStackTrace(); //에러 문구를 콘솔창에 출력

      msg = "입력 실패";
      view = "redirect:inputFrm";   //입력 화면을 다시 보이게 함
    }
    rttr.addFlashAttribute("msg", msg); //"이름표", 데이터
    return view;  //이동할 화면.
  }

  //Service에서는 ModelAndView를 만들어서 사용하는게 편하다. Model을 사용할경우, 인자로 받아서 전달해줘야함
  public ModelAndView outputList() {   //데이터 목록을 받는 메서드js
    log.info("outputList()");
    List<DataDto> dList = dDao.selectList();
    ModelAndView mv = new ModelAndView();

    //addObject에 저장할때, 데이터를 꺼낼 때 사용할 이름과 저장한 데이터의 변수명이 같을 필요는 없지만, 같으면 편함.
    mv.addObject("dList", dList);
    mv.setViewName("dataList");
    return mv;
  }

  public ModelAndView outputData(int code) {
    log.info("outputData");
    DataDto data = dDao.selectData(code);
    ModelAndView mv = new ModelAndView("detail", "data", data);
    //mv.addObject("data", data);
    //mv.setViewName("detail");
    return mv;
  }

  public String updateData(DataDto data, RedirectAttributes rttr) {
    log.info("updateData()");
    String msg = null;
    String view = null;

    try {
      dDao.updateData(data);
      msg = "수정 성공";
      view = "redirect:detail?code="; //detail.jsp로 넘어가려면, 코드가 있어야 하기 때문에, url에 페러미터로 넘겨준다.
    } catch (Exception e) {
      //e.printStackTrace();
      msg = "수정 실패";
      view = "redirect:updateFrm?code=";
    } finally{
      view += data.getM_code();
    }
    rttr.addFlashAttribute("msg", msg);
    return view;
  }


  //parameter적을 때, Model, RedirectAttributes는 가장 뒤쪽에 배치
  public String deleteData(int code, RedirectAttributes rttr){
    log.info("deleteData()");
    String msg = null;
    String view = null;
    try{
      dDao.deleteData(code);
      msg = "삭제 성공";
      view = "redirect:/dataList";
    } catch (Exception e) {
      //e.printStackTrace();
      msg = "삭제 실패";
      view="redirect:detail?code="+code;
    }
    rttr.addFlashAttribute("msg", msg);
    return view;
  }
}