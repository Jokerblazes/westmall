package com.beijing.westmall.controller;

import com.beijing.westmall.entity.Inventory;
import com.beijing.westmall.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Joker
 * @Description
 * @Date Create in 上午11:08 2018/5/19
 */
@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity updateCount(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory old = inventoryRepository.findOne(id);
        old.setCount(inventory.getCount());
        inventoryRepository.save(old);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
