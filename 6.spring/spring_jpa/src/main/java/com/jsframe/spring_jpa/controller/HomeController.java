package com.jsframe.spring_jpa.controller;

import com.jsframe.spring_jpa.entity.Product;
import com.jsframe.spring_jpa.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log
public class HomeController {
  ModelAndView mv;

  @Autowired
  ProductService pServ;

  @GetMapping("/")
  public ModelAndView home() {
    log.info("home()");
    log.info("home()");
    //페이지가 열리면, Iterable 받아와서, List로 변환시킨 것을 조회
    mv=pServ.getList();
    return mv;
  }

  @GetMapping("inputProd")
  public String inputProd(Product product) {
    log.info("inputProd()");
    String view = pServ.inputProduct(product);

    return view;
  }

}
