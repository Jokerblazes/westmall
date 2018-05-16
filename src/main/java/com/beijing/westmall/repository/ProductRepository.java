package com.beijing.westmall.repository;

import com.beijing.westmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:45 2018/5/14
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
