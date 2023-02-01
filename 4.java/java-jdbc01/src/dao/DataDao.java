package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataDao {
  public static void main(String[] args) {
    Connection conn = null;
    try {

      Class.forName("com.mysql.cj.jdbc.Driver");  //이 라인 작성하면 forName에 밑줄이 그어지는데, 예외사항이 발생할 수 있어서 생긴 밑줄임.
      //1. 드라이버 로드
      //드라이버 매니저 : 외부 프로그램과 네트워크로 접속할 때 접속용 드라이버 라이브러리를 관리하는 객체.
      //Class.forName : 드라이버 매니저에게 해당 클래스에 대한걸 넘겨주는 객체.(필기 보충)


      System.out.println("드라이버 로드 성공.");


      //2. DB에 접속 : 접속 관리 객체 Connection
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devdb", "dev01", "12341234" ); //getConnection 매서드에서 예외가 발생될 수 있으므로, catch문 추가.
        //매니저 드라이버를 사용해서 접속하기 때문에, DriverManager 객체를 사용.    //드라이버매니저가 연결통로를 만들면, 커낵션객체가 연결한다.
        //매개변수로 주소와 id password가 필요하다.
        //실습에서 url은 localhost(또는 127.0.0.1) 사용.(실제로는 ip주소:port/db명   의 형식을 갖춘다.)
        //id, password : workbench에서 만들었던 계정의 아이디(username)와 비밀번호 사용
      System.out.println("접속 성공.");


    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("드라이버 로드 실패");
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println("접속 실패.");
    } finally{
      //통로를 해제하는 작업 수행
      try {
        conn.close();
      } catch (SQLException e) {
        System.out.println("접속 해제 성공 : ");
      }


      //connection을 끊지 않으면 보안상의 문제가 발생할 수 있다.
      //DBMS용 드라이버 로드를 제외한, DBMS접속, 요청 및 응답처리, 접속해제(2~3)은 필요할 때마다 반복적으로 수행해야 한다.(1회성 접속)
    }
  }
}
