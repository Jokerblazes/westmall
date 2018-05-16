package com.beijing.westmall.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午2:30 2018/5/14
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    @ManyToOne(targetEntity = Inventory.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "inventoryId", referencedColumnName = "id")
    private Inventory inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

