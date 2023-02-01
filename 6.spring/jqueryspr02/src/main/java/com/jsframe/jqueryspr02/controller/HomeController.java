package com.jsframe.jqueryspr02.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {
  @GetMapping("/")
  public String home(){
    log.info("home()");
    return "effect02";
  }
  @GetMapping("jqueryEffectPractice")
  public String practice(){
    log.info("jqueryEffectPractice()");
    return "jqueryEffectPractice";
  }
  @GetMapping("attr")
  public String attr(){
    log.info("attr()");
    return "attr";
  }
  @GetMapping("bb")
  public String bb(){
    log.info("bb()");
    return "baseballVer2";
  }
}
