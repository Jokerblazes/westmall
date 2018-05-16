package com.beijing.westmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午5:08 2018/5/15
 */
@Entity
@Table(name = "Order_Product")
public class OrderItem {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne
    @JoinColumn(name = "productId",referencedColumnName = "id")
    @JsonUnwrapped
    private Product product;
    private int purchaseCount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
