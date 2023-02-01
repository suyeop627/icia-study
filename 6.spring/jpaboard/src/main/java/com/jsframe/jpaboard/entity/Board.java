package com.jsframe.jpaboard.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

//게시글 저장
@Entity
@Table(name="boardtbl")  //boardtbl(테이블)과 board(Entity) 매핑
@Data
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long bnum;

  @Column(nullable = false,length = 45)
  private String btitle;

  @Column(nullable = false, length = 20)
  private String bwriter;

  @Column(nullable = false, length = 20)
  private String bpwd;

  @Column(nullable = false)
  private String bcontent;

  @Column
  @CreationTimestamp
  private Timestamp rdate;
}
