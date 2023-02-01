package com.jsframe.spr_jdbc2.dao;

import com.jsframe.spr_jdbc2.dto.DataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataDao {
  //mybatis에서는 insert했을때 따로 리턴값이 없다.
  //insert는 try catch문 을 사용해서, 예외발생 유무로 입력 성공 실패를 구분.
  void insertData(DataDto data);

  List<DataDto> selectList();

  //하나의 정보를 가져오는 메소드
  DataDto selectData(int code);

  //데이터 수정용 메소드
  //기존데이터에서 수정하지 않은 부분이 있더라도 전체를 수정하는 방식으로 처리하는게 편하다.
  void updateData(DataDto data);

  //데이터 삭제용 메서드
  void deleteData(int code);


}
