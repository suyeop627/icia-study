package com.dao;


import com.dto.DataDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDao {
  //DB 연동에 필요한 정보를 작성.
  private String drv = "com.mysql.cj.jdbc.Driver";
  private String url = "jdbc:mysql://localhost:3306/datadb";
  private String user = "dev01";
  private String pass = "12341234";

  //DB 연동 관련 객체
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;

  //드라이버 로드 -> 생성자로 처리
  public DataDao() {
    try {
      Class.forName(drv);
    } catch (ClassNotFoundException e) {
      //
    }
  }//생성자 end

  //메모리 해제 메소드(각 DB 처리 메소드의 finally 부분에서 사용)
  private void close() {
    try {
      if (rs != null) rs.close();
      if (pstmt != null) pstmt.close();
      if (conn != null) conn.close();
    } catch (SQLException e) {
    }
  }


  public int insertData(DataDto data) {
    int result = 0;   //0이면 삽입 실패, 0이 아니면 성공.

    String query = "INSERT INTO datatbl VALUES "
      + "(null, ?,?,?)";

    //드라이버 로드는 생성자로 처리했으므로, 바로 연결시작함

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      //쿼리문의 '?'부분 채우기
      pstmt.setString(1, data.getM_str());
      pstmt.setInt(2, data.getM_int());
      pstmt.setDate(3, Date.valueOf(data.getM_date())); //String으로 된 것을 DATE형식으로 바꿔서 입력함.


      //쿼리문 실행 및 실행 결과 받기
      result = pstmt.executeUpdate();

    } catch (SQLException e) {
      result = 0; //삽입 실패 시, 0 반환 하도록함. 실패의 경우 : 기본키에 같은 값이 들어가거나, 타입이 다르거나.
    }

    return result; //실행 결과를 service로 전달.
  }

  public List<DataDto> selectList() {
    List<DataDto> dList = null;
    String query = "SELECT * FROM datatbl";
    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      rs = pstmt.executeQuery();

      //처리할(가져올)행이 없으면, rs.next()는 false를 반환한다.
      while (rs.next()) {
        if (dList == null) {//목록이 없을 때만 생성.//////----------------------------------어제랑 다른 부분
          dList = new ArrayList<>();
        }
        //DTO를 목록 추가.
        DataDto data = new DataDto();
        data.setM_code(rs.getInt("m_code"));    // 컬럼명을 직접 적을 수 도 있다.
        data.setM_str(rs.getString(2));         // 컬럼 인덱스로 찾기
        data.setM_int(rs.getInt(3));
        data.setM_date(rs.getString(4));

        dList.add(data);

      }
    } catch (SQLException e) {
      dList = null;
    }


    //service로 목록 전달(데이터가 없을 경우 null 전달)
    return dList;

  }

  public DataDto selectData(int code) {
    DataDto data = null;

    String query = "SELECT * FROM datatbl WHERE m_code = ?";

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, code);

      //쿼리 실행
      rs = pstmt.executeQuery();

      //rs의 행이 여러개일때는 while문, 키를 가지고 하나만 가져올 땐 if문 사용
      if (rs.next()) {
        data = new DataDto();
        data.setM_code(rs.getInt(1)); //검색해서 가져온 첫번째 컬럼은, 입력받은 code와 같은 값이므로, rs.getInt(code)의 형식으로 작성할 수 있다.
        data.setM_str(rs.getString(2));
        data.setM_int(rs.getInt(3));
        data.setM_date(rs.getString(4));   //db안에서 date타입은 문자열로 취급해서 가져올 수 있지만, 집어 넣을때는 date type으로 변환해서 넣어야 한다.
      }
    } catch (SQLException e) {
      //e.printStackTrace();  예외가 발생하고 그 원인을 알아내야 할 수도 있으므로, 일단 적어놓고 주석처리. 문제발생시 주석 해제.
      data = null;
    } finally {
      close();
    }


    return data;
  }

  public int updateData(DataDto data) { //data에 모든 변수에는 값이 채워진 상태. (수정전 값이 유지됐거나, 수정됐거나.)
    int result = 0;

    String query = "UPDATE datatbl "
      +"SET m_str = ?, m_int = ?, m_date = ? "
      +"WHERE m_code = ?";

    try{
      conn = DriverManager.getConnection(url, user,pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, data.getM_str());
      pstmt.setInt(2, data.getM_int());
      pstmt.setString(3, data.getM_date());
      pstmt.setInt(4, data.getM_code());

      result = pstmt.executeUpdate();

    }catch(SQLException e){
      //e.printStackTrace();
      result = 0;
    }finally {
      close();
    }


    return result;
  }

  public int deleteData(int code) {
    int result =0;
    String query = "DELETE FROM datatbl WHERE m_code = ?";

    try{
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1,code);

      result = pstmt.executeUpdate();
    }catch (SQLException e) {
      //e.printStackTrace();
      result = 0;
    }finally {
      close();
    }
  return result;
  }
}//class end
