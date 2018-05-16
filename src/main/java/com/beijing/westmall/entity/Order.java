package com.beijing.westmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午2:30 2018/5/14
 */
@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal totalPrice;
    private String createTime;
    private String finishTime;
    private String paidTime;
    private String withdrawnTime;
    @JsonIgnore
    private Long userId;

    @OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId",referencedColumnName = "id")
//    @JoinTable(
//            name="Order_Product",                    //中间表的名字
//            joinColumns= {@JoinColumn(name="orderId")},        //外键的字段
//            inverseJoinColumns= {@JoinColumn(name="productId")})    //反转控制字段的名字
    private List<OrderItem> orderItems;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
