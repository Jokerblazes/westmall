package com.beijing.westmall.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午2:30 2018/5/14
 */
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal totalPrice;
    private String createTime;
    private String finishTime;
    private String paidTime;
    private String withdrawnTime;

    @OneToMany(fetch = FetchType.EAGER )
    @JoinColumn(table = "Order_Product",referencedColumnName = "order_id",name = "productId")
    private List<Product> products;
    private String status;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    public String getWithdrawnTime() {
        return withdrawnTime;
    }

    public void setWithdrawnTime(String withdrawnTime) {
        this.withdrawnTime = withdrawnTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", createTime='" + createTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", paidTime='" + paidTime + '\'' +
                ", withdrawnTime='" + withdrawnTime + '\'' +
                ", products=" + products +
                ", status='" + status + '\'' +
                '}';
    }
}
