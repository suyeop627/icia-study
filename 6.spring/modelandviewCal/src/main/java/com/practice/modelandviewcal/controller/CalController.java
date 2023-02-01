package com.practice.modelandviewcal.controller;

import com.practice.modelandviewcal.dto.CalDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@Log
public class CalController {
    @RequestMapping("/")
    public String start(){
        return "index";
    }

    @RequestMapping("calProc")
    public ModelAndView cal(CalDto caldata){

        ModelAndView mv = new ModelAndView();
        int n1 =caldata.getNum1();
        int n2 = caldata.getNum2();
        String op = caldata.getOp();
        int res = 0;

        switch (op) {
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
        caldata.setResult(res);
        mv.addObject("caldata", caldata);
        mv.setViewName("result");
        return mv;
    }

}
