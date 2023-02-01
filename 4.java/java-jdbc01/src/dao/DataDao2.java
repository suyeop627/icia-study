package dao;


import dto.MemberDto;

import java.sql.*;

public class DataDao2 {

  //필요 문자열 작성(드라이버, 접속 주소, 사용자 계정, 비밀 번호)
  private String drv = "com.mysql.cj.jdbc.Driver";
  private String url = "jdbc:mysql://127.0.0.1:3306/devdb"; //콜론 사용하는거 주의.
  private String user = "dev01";
  private String pwd = "12341234";

  //접속 관리 객체
  Connection conn; //멤버변수인 객체이므로, 자동으로 null로 초기화된다.

  //SQL 실행 객체
  Statement stmt;   //기본객체이긴 하지만, 이거보다 PreparedStatement 사용하는 게 더 편함
  PreparedStatement pstmt;

  //결과 집합 저장 객체
  ResultSet rs;


  //드라이버 로드의 경우, 최초 1회만 실행하면 된다. (생성자에서 처리)
  public DataDao2() {
    try {
      Class.forName(drv);
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로드 실패");
    }
  }//생성자 끝


  //해제 전문 매소드 close(통로를 유지하려면 메모리가 소모된다.)
  public void close() {
    try {
      //rs, stmt, conn은 가비지 컬렉션이 처리하지 못하므로, 아래처럼 직접 처리해서 메모리에서 내려야 한다.
      if (rs != null) rs.close();
      if (stmt != null) stmt.close();
      //접속 관리 객체가 null이 아닌 경우에만 해제한다. -- 접속객체가 만들어졌을때만 conn.close();실행.
      if (conn != null) conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }//close end

  //접속 테스트 메소드

  public void connectionTest() {
    try {
      conn = DriverManager.getConnection(url, user, pwd);
      System.out.println("접속 성공");
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("접속 실패");
    } finally {
      close();  // 해제 메소드 사용
    }

  }


  //비밀번호를 검색해오는 메소드(3. 요청 및 응답처리)
//3. 요청 및 응답 처리

  //비밀번호를 검색해오는 메소드
  public String selectPwd(String m_id) {
    String dbpwd = null;
    try {
      //DB 접속
      conn = DriverManager.getConnection(url, user, pwd);

      //SQL 실행 객체
      stmt = conn.createStatement();  //무분별한 실행을 막기 위해, 접속된 상태 전용인 실행객체.
      //singleton과 유사한 개념이다.

      //SQL 쿼리문장을 작성(작성할 문장 : SELECT m_pwd FROM member WHERE m_id = '입력값' )
      String query = "SELECT m_pwd FROM member " +
        "WHERE m_id ='" + m_id + "'";
      //""으로 묶은 문장에서 줄바꿈을 할 경우, 앞이든 뒤든 " " 공백을 넣어줘야, 개행 앞 뒤 문자에 공백이 반영된다.
      //query문 자체에는 세미 콜론을 찍지 않는다.(workbench에서 사용한 쿼리 그대로 복붙할때 주의)

      rs = stmt.executeQuery(query); //Query 실행 메소드.
      //받아오는 값이 pwd하나 더라도, 값을 받아올때 집합(테이블)의 형태로 받아오기 때문에 문자열로 값을 저장할 수 없다.
      //resultset으로만 받을 수 있음.

      if (rs.next()) {      //rs.next(); : select 결과가 있을 경우 true, 없을 경우 false 반환.
        dbpwd = rs.getString(1); //getString(컬럼순번 또는 컬럼명)
        //dbpwd = rs.getString("m_id")
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("접속 실패");
    }
    return dbpwd;
  }


  public void insertMember(MemberDto md) {

    try {
      conn = DriverManager.getConnection(url, user, pwd);
    /*
      Statement에서 문자열 입력하려면 ""안에 ''를 넣어서 문자열임을 나타내야 한다.
      이런 불편함을 방지하기 위해 preparedStatement가 있음.
      PreparedStatement pstmt; 의 자식클래스로 편의성을 높인 클래스이다.
      쿼리 문장에서 사용자의 입력값이 위치하는 곳에 '?'작성, PreparedStatement의 메소드인 setString으로 ?위치에 들어갈 값을 제공한다.
    */
      
      //미완성의 쿼리문 작성
      String query = "INSERT INTO member " + "VALUES(?,?,?,?,?,default, default)";
      //사용자의 입력값이 위치하는 곳에 '?'로 작성.
      //?위치에 문자열일 경우, 자동으로''를 붙여주며, 숫자값일 경우 ''없이 추가된다.

      //실행객체 생성
      pstmt = conn.prepareStatement(query);

      //미완성 부분 채워넣기
      pstmt.setString(1, md.getM_id());
      pstmt.setString(2, md.getM_pwd());
      pstmt.setString(3, md.getM_name());
      pstmt.setInt(4, md.getM_age());
      pstmt.setString(5, md.getM_job());

      int r = pstmt.executeUpdate();
      //insert, update, delete 작업은 모두 executeUpdate()로 실행한다. 작없 실패시 0을 반환.
      //+) rs = pstmt.executeQuery();  <-select전용 메소드

      if (r != 0) {
        System.out.println("입력 성공");
      } else {
        System.out.println("입력실패");
      }
    } catch (SQLException e) {
      System.out.println("DB 처리 실패");
    }
  }
}//class end
