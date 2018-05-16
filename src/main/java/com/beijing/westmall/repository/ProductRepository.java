package com.beijing.westmall.repository;

import com.beijing.westmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:45 2018/5/14
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findProductsByName(@Param("name") String name);

    public List<Product> findProductsByNameContainsAndDescriptionContains(@Param("name") String name,@Param("description") String description);
}
