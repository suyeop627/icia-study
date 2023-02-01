package com.jsframe.springjsp01.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String id;
    private String pwd;
    private String name;
    private int age;    //jsp에서는 문자열이지만, spring이 자동으로 정수 변환.(dto를 사용하지 않으면 형변환 따로 해야하지만, dto를 사용하면 자동으로 해준다)
}
