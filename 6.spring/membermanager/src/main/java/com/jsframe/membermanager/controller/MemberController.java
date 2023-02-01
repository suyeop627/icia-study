package com.jsframe.membermanager.controller;

import com.jsframe.membermanager.dto.MemberDto;
import com.jsframe.membermanager.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Log
public class MemberController {
  //service 자동 처리
  @Autowired
  MemberService mServ;

  //url 매핑 메서드
  //홈페이지(로그인)
  @GetMapping("/")
  public String home() {
    log.info("home()");
    return "home";
  }

  //회원가입 페이지
  @GetMapping("register")
  public String register() {
    log.info("register()");
    return "register";
  }

  @PostMapping("regProc")
  public String regProc(MemberDto member, RedirectAttributes rttr){
    log.info("regProc()");
    String view = mServ.regMember(member, rttr);
    return view;
  }

//id중복 확인
  @PostMapping("checkDuplicatedId")
  public @ResponseBody String checkDuplicatedId(String id){
    log.info("checkDuplicatedId()");
    String msg = mServ.checkId(id);
    return msg;
  }


  @PostMapping("loginProc")
  public String loginProc(MemberDto member, HttpSession session, RedirectAttributes rttr){
    log.info("loginProc");
    String view = mServ.loginProc(member,session, rttr);

    return view;
  }

  @GetMapping("main")
  public ModelAndView main(){
    log.info("main");

    ModelAndView mv=new ModelAndView();
    //데이터를 담아서 넘길 부분
    mv.setViewName("main");
    return mv;
  }

  //logout
  @GetMapping("logoutProc")
  public String llogoutProc(HttpSession session, RedirectAttributes rttr){
    log.info("logoutProc()");
    //session안에 있는 meme만 지우고, 세션 자체는 유효시간이 경과하여 사라지게끔 하는 방식
    //session.removeAttribute("mem");

    //세션 자체를 제거
    session.invalidate();
    rttr.addFlashAttribute("msg", "로그아웃 됐습니다.");
    return "redirect:/";

    //로그아웃하고나서 뒤로가기 누르면, 로그인이 된 상태로 보일 수 있다. -> session interseptor 로 처리(추후 배울 예정)
  }

//수정
  @PostMapping("updateProc")
  public String updateProc(MemberDto member, HttpSession session, RedirectAttributes rttr){
    log.info("updateProc()");
    String view=mServ.updateMember(member, session, rttr);

    return view;
  }

  //삭제
@GetMapping("resignProc")
  public String resignProc(HttpSession session, RedirectAttributes rttr){
    log.info("resignProc()");
    String view = mServ.resignMember(session, rttr);
    return view;
}



}
