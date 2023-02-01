package com.jsframe.react_server.controller;

import com.jsframe.react_server.dto.DataDto;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log
public class ReactController {
  @GetMapping("getData")
  public String getData() {
    log.info("getData()");
    return "서버로부터의 메세지 : 잘 됨.";
  }

  @GetMapping("getObject")
  public DataDto getObject(){
    log.info("getObject()");
    DataDto data = new DataDto();
    data.setStr("메세지");
    data.setNumber(100);
    return data;
  }
  @GetMapping("getList")
  public List<DataDto> getList(){
    log.info("getList()");
    //List는 인터페이스로, 생성할땐 ArrayList같은 구현체를 사용하여 인스턴스를 만든다.
    List<DataDto> dList = new ArrayList<>();
    for(int i = 1; i<=5;i++){
      DataDto data= new DataDto();
      data.setStr("문자열" + i);
      data.setNumber(10*i);
      dList.add(data);
    }
    return dList;
  }

  @GetMapping("sendData")
  public String sendData(@RequestParam String data,
                         @RequestParam String second){
    log.info("sendData()");
    log.info("data : " + data);
    log.info("second : "+ second);
    return "ok";
  }

  @PostMapping("sendObject")
  public String sendObject(@RequestBody DataDto data){
    log.info("sendObject()");
    log.info(data.getStr() + ", "+data.getNumber());
    return "ok2";
  }
}//class end
