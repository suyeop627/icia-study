package com.jsframe.springjsp01.controller;

import com.jsframe.springjsp01.dto.MemberDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Log    //제대로 처리되지 않았을 경우, 코드의 부분마다 출력용 코드를 사용.(System.out.println()을 사용해도 되지만, 시간, 경로 등 다양한 정보를 얻기 위해서 log를 사용한다.)
public class HomeController {
    //사용자 요청 url과 메소드 매핑
    @GetMapping("/")
    //시작시 url인 localhost:8080은 뒤에 '/'가 생략된 형태로, localhost:8080/ 이다. 포트번호 뒤의 '/'를 매핑하는 매서드. 즉, 로드됐을때 가장 처음 보여질 페이지를 리턴하는 메서드이다.
    public String start() { //접근제어자는 public으로 해야한다.
        log.info("start()");    //메소드가 실행됐음을 확인 할 수 있도록 log출력
        String viewName = "index";//출력할 파일의 이름

        return viewName;
    }

    @GetMapping("mp")   //a태그의 href 속성의 값을 작성.
    public String mypageMethod() {
        log.info("mypageMethod()");
        return "mypage";
    }

    @GetMapping("hobby")
    public String hobby() {
        log.info("hobby()");
        return "hobby";
    }

    @GetMapping("inputFrm")
    public String inputFrm() {
        log.info("inputFrm()");
        return "inputFrm";
    }

    @GetMapping("inputProc")
    public String inputProc(String str, String num) {
        log.info("inputProc()");
        log.info("str : " + str);
        log.info("num : " + num);
        //form태그에서 숫자로 입력을 받아도, String 타입으로 받아야 한다, 수학적 연산이 필요한 경우, 숫자로 변환한 위 처리(dto를 사용하지 않을 경우.)
        int n = Integer.parseInt(num);
        int data = n + 30;
        return "index";
    }

    @GetMapping("joinFrm")
    public String joinFrm(){
        log.info("joinFrm()");
        return "joinFrm";
    }

    @PostMapping("joinProc")
    public String joinProc(MemberDto member){
        log.info("joinProc()");
        log.info("id : " + member.getId());
        log.info("pwd : " + member.getPwd());
        log.info("name : " + member.getName());
        log.info("age : " + member.getAge());

        return "index";
    }

    @GetMapping("output")
    public String output(Model model){
        log.info("output()");
        model.addAttribute("data1", "첫번째 데이터");
        model.addAttribute("data2", 1000);
        String m = "보내는 메세지";
        model.addAttribute("msg", m);

        //Dto를 활용한 데이터 묶음 전달
        MemberDto member = new MemberDto();
        member.setId("test");
        member.setPwd("1234");
        member.setName("홍길동");
        member.setAge(30);

        model.addAttribute("mem", member);
        return "output";    //데이터가 가야할 목적지
    }



}
