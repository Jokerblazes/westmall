package com.beijing.westmall.repository;

import com.beijing.westmall.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:49 2018/5/15
 */
public interface OrderRepository extends JpaRepository<Order,Long>{
    public List<Order> findOrdersByUserId(@Param("userId") long userId);
}
