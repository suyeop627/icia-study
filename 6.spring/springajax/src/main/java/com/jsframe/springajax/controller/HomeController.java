package com.jsframe.springajax.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log
public class HomeController {
  @GetMapping("/")
  public String home() {
    log.info("home()");
    return "home";
  }

  @GetMapping("idcheck")
  @ResponseBody
  public String idcheck(String data) { //jsp에서 보내는 데이터명과 일치하도록 변수명 작성
    log.info("idcheck()");

    String res = "ok"; //중복 확인 처리 후의 결과값이라 가정.
    log.info(data);
    return res;
  }
}
