package com.dao;


import com.dto.DataDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDao {
  //DB 접속을 위한 사전준비
  private String drv = "com.mysql.cj.jdbc.Driver"; //jdbc에도 driver가 있긴 하지만, cj에 있는 driver가 더 최신화 된 것이다.
  private String url = "jdbc:mysql://localhost:3306/datadb";
  private String user = "dev01";
  private String pass = "12341234";

  //DB 관련 객체
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;

  //드라이버 로드(생성자)
  public DataDao(){
    try {
      Class.forName(drv);
    } catch(ClassNotFoundException e){
      System.out.println("드라이버 로드 실패");
    }
  }

  private void close(){
    try {
      if(rs !=null)rs.close();
      if(pstmt !=null)pstmt.close();
      if(conn !=null)conn.close();
    } catch (SQLException e) {

    }
  }//close end


  //기능별 CRUD 메소드 작성
  public int insertData(DataDto data){
    int result = 0; //0아니면 삽입 성공, 0이면 삽입 실패.

    String query = "INSERT INTO datatbl VALUES "+
                  "(null, ?, ?, ?)";
    try {
      conn = DriverManager.getConnection(url, user, pass);

      pstmt = conn.prepareStatement(query);
      pstmt.setString(1, data.getM_str());
      pstmt.setInt(2, data.getM_int());
      pstmt.setDate(3, Date.valueOf(data.getM_date()));//날짜 형식으로 변환 후 저장.(Date.valueOf())

      result = pstmt.executeUpdate();    //한건을 처리하므로, 1이 반환된다.
    } catch (SQLException e) {
      result = 0;                         //입력 실패시 0 반환
    } finally{
      close();
    }
    return result;
  }//insertData end

  //테이블의 전체 목록을 가져오는 메소드
  public List<DataDto> selectList(){
    //DB에서 테이블의 내용을 모두 가져와서 List(목록)에 저장
    //저장할 목록 생성
    List<DataDto> dList = new ArrayList<>();  //변수는 부모클래스, 인스턴스는 자식클래스로

    //전체 목록을 가져오는 쿼리 작성.
    String query = "SELECT * FROM datatbl";

    try {
      conn = DriverManager.getConnection(url, user,pass);

      pstmt = conn.prepareStatement(query);

      rs = pstmt.executeQuery();
      //여러개의 결과값이 rs에 포함되어 있음-> 반복문(while)으로 처리.
      //결과값이 하나일 경우(ex, 아이디에 일치하는 비밀번호 찾는 경우.) -> if문으로 처리)
      while(rs.next()){   // next() : 데이터가 있을 땐 출력, 데이터가 없을 땐 false를 반환하는 매소드
        //행 단위로 처리 -> 각 행은 DTO로 저장된다.
        DataDto data = new DataDto();
        data.setM_code(rs.getInt(1));     //인자는 각 컬럼의 인댁스
        data.setM_str(rs.getString(2));
        data.setM_int(rs.getInt(3));
        data.setM_date(rs.getString(4));

        dList.add(data);  //목록에 한 행 데이터 추가.
      }
    } catch (SQLException e) {
      dList=null; //문제 발생 시 목록을 비운다.
    } finally{
      close();
    }
    return dList;
  }///selectList end


  //코드를 입력받아, 그에 해당하는 하나의 데이터 출력.
  public DataDto getData(int code) {
    DataDto data = null;    // 데이터가 아직 없으므로, 선언만 하고 생성은 하지 않음.
    String query = "SELECT * FROM datatbl WHERE m_code = ?";

    try {
      conn = DriverManager.getConnection(url, user,pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, code);

      rs = pstmt.executeQuery();

      if(rs.next()){
        data = new DataDto();     //데이터가 있을 때, DataDto 인스턴스 생성
        data.setM_code(rs.getInt(1));     //인자는 각 컬럼의 인댁스
        data.setM_str(rs.getString(2));
        data.setM_int(rs.getInt(3));
        data.setM_date(rs.getString(4));
      }
    } catch (SQLException e) {
      data = null;
    } finally{
      close();
    }
    return data;
  }


  public int deleteData(int code) {
    int result = 0;

    String query = "DELETE FROM datatbl WHERE m_code = ?";  //WHERE 절 미작성 시, 전체삭제.

    try {
      conn = DriverManager.getConnection(url, user, pass);
      pstmt = conn.prepareStatement(query);
      pstmt.setInt(1, code);

      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      result = 0;
    }



    return result;
  }
}
