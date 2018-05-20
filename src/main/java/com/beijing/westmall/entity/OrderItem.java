package com.beijing.westmall.entity;

import com.fasterxml.jackson.annotation.*;

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
    @JsonIgnore
    private int orderId;
    @Transient
    @JsonIgnore
    private Long productId;
    private int purchaseCount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.product.setId(this.productId);
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
