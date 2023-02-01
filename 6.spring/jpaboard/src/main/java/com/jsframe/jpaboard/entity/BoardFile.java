package com.jsframe.jpaboard.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "boardfiletbl")
@Data
public class BoardFile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long bfnum;

  //외래키 설정 (1:n)
  @ManyToOne
  @JoinColumn(name = "bfbid")//JoinColumn으로 넣어야 외래키로 생성된다.
  private Board bfbid;    //관계를 수립할 테이블의 Entity를 type으로 설정
                            //Board테이블의 pk가 long이므로, bfbid 컬럼도 long으로 생성된다.

  @Column(nullable = false, length = 50)
  private String bfsysname;

  @Column(nullable = false, length = 50)
  private String bforiname;


}
