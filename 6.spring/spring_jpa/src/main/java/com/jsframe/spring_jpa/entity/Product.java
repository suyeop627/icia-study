package com.jsframe.spring_jpa.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity //@Entity 추가하면 idattribute(기본키 설정)필요하다는 문제 발생
@Table(name = "producttbl")//클래스명과 동일하게 테이블 명을 지정할 경우, @Table은 넣지 않아도 된다.
@Data
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long pnum;  //자동증가하는 값이 커질 수 있어서 자료형은 long으로 설정.
  @Column(nullable = false, length = 45)  //null을 허용하지 않고, 글자수는 45자로.
  private String pname;
  @Column(nullable = false)
  private int price;
  @Column(nullable = false)
  private int amount;
  @Column
  @CreationTimestamp  //insert시점의 일시를 저장
  private Timestamp rdate;    //@CreationTimestamp 어노테이션 사용시, 자료형은 java.sql의 Timestamp 사용.

}
