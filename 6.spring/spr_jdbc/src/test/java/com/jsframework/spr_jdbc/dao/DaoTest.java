package com.jsframework.spr_jdbc.dao;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class DaoTest {
  @Autowired
  DataDao dDao; //autowired로 인스턴스를 생성해서, 해당 인스턴스의 메서드를 테스트 해볼 수 있게 한다.

  @Test
  public void getCountTest(){
    try{
      int n = dDao.getCount();
      log.info("갯수 : " + n);
    } catch (Exception e) {
      log.info("처리 실패");
    }
  }
}
