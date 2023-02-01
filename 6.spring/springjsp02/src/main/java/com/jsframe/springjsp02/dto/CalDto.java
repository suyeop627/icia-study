package com.jsframe.springjsp02.dto;

import lombok.Data;

@Data
public class CalDto {
    // dto를 만들 때, form의 input의 name과 같은 변수명을 사용한다.
    //view에서 input의 name에 꼭 1:1로 매칭되야하는 것은 아니며, 필요한 것들 넣어서 복합적으로 처리하며 된다.
    //result는 입력받을 때는 필요 없지만, 계산 결과를 출력할때 필요하므로 추가.
        private int num1;
        private int num2;
        private int result;
        private String op;
}
