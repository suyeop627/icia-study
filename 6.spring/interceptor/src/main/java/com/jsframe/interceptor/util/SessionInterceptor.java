package com.jsframe.interceptor.util;


import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log
@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request //pre만 쓰면 자동완성 됨
      , HttpServletResponse response
      , Object handler) throws Exception {

    log.info("preHandle()");
    HttpSession session = request.getSession();  //session은 request에 담겨서 전달된다.

    String mid = (String) session.getAttribute("mb");
    if (mid == null || !mid.equals("admin")) {
      //세션의 mid가 비었거나(로그인을 하지 않았거나),  admin이 아닐 경우
      log.info("인터셉트 생김");
      response.sendRedirect("/");
      return false;
    }
    return true;
  }


  //브라우저의 뒤로가기버튼으로 전페이지가 보이는걸 막기
  //뒤로가기버튼은 서버를 거치지 않고 저장된 화면을 불러와서 main페이지가 보임
  //페이지의 cache 가 남기 때문
  @Override

  public void postHandle(HttpServletRequest request
      , HttpServletResponse response
      , Object handler, ModelAndView modelAndView) throws Exception {
    log.info("postHandle()");

    //브라우저에 저장된 페이지(캐쉬)를 삭제하도록 명령.
    //현재 웹 프로토콜 버전 1.0과 1.1이 혼용

    if (request.getProtocol().equals("HTTP/1.1")){
      response.setHeader("Cache-Control",
          "no-cache, no-store, must-revalidate"); //캐시없고 저장하지말고 꼭 삭제해라
    }else {
      response.setHeader("Pragma", "no-cache");
    }
    response.setDateHeader("Expires",0);

  }


}
