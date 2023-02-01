package com.jsframe.springjsp01.controller;


import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@Log
public class CalController {

    @GetMapping("/")
    public String load(){
        log.info("load()");
        String viewName = "index";
        return viewName;
    }
    @GetMapping("secondCalPage")
    public String goResult(){
        log.info("goResult()");
        return "secondCalPage";
    }



    @GetMapping("calProc")
    public String cal(Model model, String num1, String num2, String operator) {
        log.info("cal()");

        int fNum = Integer.parseInt(num1);
        int sNum = Integer.parseInt(num2);
        int result = 0;

        switch(operator){
            case "+":
                result = fNum+sNum;
                break;
            case "-":
                result = fNum-sNum;
                break;
            case "*":
                result = fNum*sNum;
                break;
            case "/":
                result = fNum/sNum;
                break;
        }
        model.addAttribute("num1", fNum);
        model.addAttribute("num2", sNum);
        model.addAttribute("op", operator);
        model.addAttribute("result", result);

        return "secondCalPage";
    }

}
