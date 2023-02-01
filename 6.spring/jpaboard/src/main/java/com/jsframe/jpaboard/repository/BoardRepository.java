package com.jsframe.jpaboard.repository;

import com.jsframe.jpaboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {//<entity, pk의 type(wrapperClass>
  //페이지 처리된 목록을 가져오는 메서드
  //findBy(select에 기준이 되는 컬럼(entity멤버))
  // GraterThan : SQL의 limit과 유사한 기능을 하는 메서드
  Page<Board> findByBnumGreaterThan(long bnum, Pageable pageable);

}
