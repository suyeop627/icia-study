package com.jsframe.membermanager.dto;

import lombok.Data;

@Data
public class MemberDto {
  //DB 테이블의 컬럼 이름과 개수와 동일하게 생성
  private String m_id;
  private String m_pwd;
  private String m_name;
  private String m_birth;
  private String m_phone;
}
