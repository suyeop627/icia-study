package com.jsframe.springjsp02.controller;

import com.jsframe.springjsp02.dto.CalDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@Log

public class HomeController {
  @GetMapping("/")    //첫 페이지를 보여주는 역할을 하는 메서드(실행과 동시에 처리해야할 실행문을 작성할 수도 있다.
  public String home() {
    log.info("home");
    return "index";
  }

  @GetMapping("calProc")
  public String calProc(CalDto cData, Model model) {   //모델은 인자의 가장 마지막에 작성한다(받는 것은 앞에, 보내는 것은 뒤에 작성).
    log.info("calProc()");
    log.info("num1 : " + cData.getNum1());
    log.info("num2 : " + cData.getNum2());

    int n1 = cData.getNum1();
    int n2 = cData.getNum2();
    int res = 0;

    switch (cData.getOp()) {
      case "+":
        res = n1 + n2;
        break;
      case "-":
        res = n1 - n2;
        break;
      case "*":
        res = n1 * n2;
        break;
      case "/":
        res = n1 / n2;
        break;
      case "%":
        res = n1 % n2;
    }

    cData.setResult(res);

    //model에 결과 담기
    model.addAttribute("result", cData);

    return "result";
  }

  @RequestMapping("dateProc")
  public ModelAndView dateProc() { //ModelAndView 객체를 사용할 땐, Model 객체처럼 매개변수를 따로 지정하지 않는다.
    log.info("dateProc()");

    ModelAndView mv = new ModelAndView();   //보낼 데이터와 경로를 함께 저장한다.
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E)");
    String nowDate = sdf.format(now);
    log.info(nowDate);

    //ModelAndView에 데이터 담기 : addObject("이름표", 데이터);
    mv.addObject("date", nowDate);

    //view 지정
    mv.setViewName("nowdate");

    return mv;
  }

  @GetMapping("oldjsp")
  public String oldjsp() {
    log.info("oldjsp()");
    return "oldjsp";
  }

  @GetMapping("elop")
  public ModelAndView elop() {
    log.info("elop()");
    ModelAndView mv = new ModelAndView();
    mv.addObject("d1", 10);
    mv.addObject("d2", 20);

    //로그인에 성공하면, (db에 저장된 id가 있을 경우,)
    //mv.addObject("id", "user01");
    mv.setViewName("el_op");

    return mv;

  }

}





