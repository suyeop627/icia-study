package com.jsframe.jsp02.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        //콘솔에 로그를 출력하기 위해 log 클래스 import
        log.info("home()");

        //jsp로 데이터 전달(model 을 사용)
        model.addAttribute("d", "서버에서 보내는 데이터");

        //화면에 보여질 페이지(jsp 의 이름을 vinewName 에 저장. 확장자는 Application 에서 viewResolver (sufix 로 적었던거)에서 붙여준다.
        String viewName = "home";

        return viewName;
    }
}
