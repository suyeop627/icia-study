package com.jsframe.spring_jpa.repository;

import com.jsframe.spring_jpa.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
  //CrudRepository<테이블명, 기본키의 wrapper클래스)를 상속받는다.
}
