package com.jsframe.spr_jdbc2.controller;

import com.jsframe.spr_jdbc2.dto.DataDto;
import com.jsframe.spr_jdbc2.service.DataService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
@Log
public class DataController {
  //Service 사용 : 자동으로 처리되도록
  @Autowired
  private DataService dServ;


  @GetMapping("/")
  public String home(Model model) {
    log.info("home()");
    GregorianCalendar cal = new GregorianCalendar();
    String nowDate = cal.get(Calendar.YEAR) + "-" +
        (cal.get(Calendar.MONTH) + 1) + "-" +
        cal.get(Calendar.DATE) + " " +
        cal.get(Calendar.HOUR) + ":" +
        cal.get(Calendar.MINUTE) + ":" +
        cal.get(Calendar.SECOND);
    model.addAttribute("nowTime", nowDate);
    return "home";
  }

  //home->inputFrm
  @GetMapping("inputFrm")
  public String inputFrm() {
    log.info("inputFrm()");
    return "inputFrm";
  }

  @GetMapping("inputProc")
  //Model이나 RedirectAttributes는 어디서 보내지 않아도 인자로 받아 사용할 수 있음.
  public String inputProc(DataDto data, RedirectAttributes rttr) {
    log.info("inputProc");
    //서비스->dao->db 저장
    String view = dServ.inputData(data, rttr);
    return view;
  }

  @GetMapping("dataList")
  //service에서 ModelAndView로 반환했으므로, 여기서는 그대로 받아서 넘기기만 하면 된다.
  public ModelAndView dataList() {
    log.info("dataList()");
    ModelAndView mv = dServ.outputList();
    return mv;
  }

  @GetMapping("detail")
  public ModelAndView detail(int code) {
    log.info("detail()");
    ModelAndView mv = dServ.outputData(code);
    return mv;
  }



  //수정
  @GetMapping("updateFrm")
  public ModelAndView updateFrm(int code){
    ModelAndView mv = dServ.outputData(code);

    //outputData 메서드로 반환받은 ModelAndView의 viewName에는 'detail'이 저장돼있으므로, updateFrm으로 수정한다.
    mv.setViewName("updateFrm");
    return mv;
  }


  @GetMapping("updateProc")
  public String updateProc(DataDto data, RedirectAttributes rttr){
    log.info("updateProc()");
    String view = dServ.updateData(data, rttr);
    return view;
  }

  @GetMapping("deleteProc")
  public String deleteProc(int code, RedirectAttributes rttr){
    log.info("deleteProc()");
    String view = dServ.deleteData(code, rttr);
    return view;
  }
}



