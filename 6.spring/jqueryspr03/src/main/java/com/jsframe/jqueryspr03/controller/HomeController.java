package com.jsframe.jqueryspr03.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {
  @GetMapping("/")
  public String home() {
    log.info("home()");
    return "home";
  }

  @GetMapping("addRemove")
  public String addRemove() {
    log.info("addRemove()");
    return "addRemove";
  }

  @GetMapping("guest")
  public String guest() {
    log.info("guest()");
    return "guest";
  }

  @GetMapping("relation")
  public String relation() {
    log.info("relation()");
    return "relation";
  }

  @GetMapping("relation_ch")
  public String relation_ch() {
    log.info("relation_ch()");
    return "relation_ch";
  }

  @GetMapping("sibling")
  public String sibling() {
    log.info("sibling()");
    return "sibling";
  }

  @GetMapping("filtering")
  public String filtering() {
    log.info("filtering()");
    return "filtering";
  }
  @GetMapping("addScore")
  public String addScore() {
    log.info("addScore()");
    return "addScore";
  }  @GetMapping("hacksa")
  public String hacksa() {
    log.info("hacksa()");
    return "hacksa";
  }

}
