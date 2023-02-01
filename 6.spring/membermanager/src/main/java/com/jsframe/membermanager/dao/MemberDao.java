package com.jsframe.membermanager.dao;

import com.jsframe.membermanager.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
  void insertMember(MemberDto member);
  MemberDto selectMember(String m_id);
  String selectPwd(String m_id);
  void updateMember(MemberDto member);
  void deleteMember(String m_id);
}
