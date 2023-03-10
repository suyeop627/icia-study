package com.jsframe.interceptor.controller;

import com.jsframe.interceptor.dto.MemberDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Log
public class HomeController {
  @GetMapping("/")
  public String home() {
    log.info("home()");
    return "home";
  }

  @GetMapping("loginFrm")
  public String loginFrm() {
    log.info("loginFrm()");
    return "loginFrm";
  }

  @PostMapping("loginProc")
  public String loginProc(MemberDto member, HttpSession session) {
    log.info("loginProc()");
    // 서비스 생략, 로그인 성공했다고 가정.
    session.setAttribute("mb", member);
    return "redirect:main";
  }

  @GetMapping("main")
  public String mainFrm(){
    log.info("mainFrm()");
    return "main";
  }

  @GetMapping("logout")
  public String logout(HttpSession session){
    log.info("logout()");
    session.invalidate();
    return "redirect:/";
  }

}
