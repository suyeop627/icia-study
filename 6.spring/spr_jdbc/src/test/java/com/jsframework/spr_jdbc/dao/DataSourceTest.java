package com.jsframework.spr_jdbc.dao;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class) //서버 ?
@SpringBootTest //스프링 부트를 테스트하기 위한 클래스임을 밝히는 클래스
@Log
public class DataSourceTest {
  @Autowired //내부적으로 인스턴스가 만들어진 걸 자동으로 끌고온다. 인스턴스를 생성할 필요없이 사용 가능
  DataSource dataSource;//spring framework 가 자동으로 인스턴스를 만들어서 가져오도록 함

  @Test//테스트 메서드 생성할때 사용하는 annotation
  public void testConnection(){ //MySQL(DB)와의 접속이 잘 되는지 테스트하는 메소드.
    try(Connection conn = dataSource.getConnection()) {
    log.info("접속성공");
    } catch (SQLException e) {
      //throw new RuntimeException(e);
      log.info("접속실패");
    }
  }
}
