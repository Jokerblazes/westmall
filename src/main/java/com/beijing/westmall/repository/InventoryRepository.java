package com.beijing.westmall.repository;

import com.beijing.westmall.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午2:33 2018/5/18
 */
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
