package com.jsframework.spr_jdbc.dao;

import com.jsframework.spr_jdbc.dto.DataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataDao {

  //interface는 public static abstract 제어자가 기본으로 붙는다(생략가능)
  int getCount();

  int insertData(DataDto data);

  //Dao에서 메서드 명 정할때, 쿼리에서 사용할 키워드를 넣어서 작성하는게 가독성이 좋다
  List<DataDto> selectList();
}
