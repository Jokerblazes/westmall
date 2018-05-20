package com.beijing.westmall.entity;

import com.beijing.westmall.common.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

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
    private Long userId;

    public static Order createOrder(List<OrderItem> orderItems) {
        Order order = new Order();
        order.setCreateTime(Utils.createNowTime());
        order.setStatus("unPaid");
        order.setOrderItems(orderItems);
        order.setUserId((long) 1);
        order.calcluteTotalMoney();
        return order;
    }
    @OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId",referencedColumnName = "id")
    @JsonProperty("purchaseItemList")
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

    public void calcluteTotalMoney() {
        totalPrice = new BigDecimal(0);
        for (OrderItem orderItem :
                orderItems) {
            BigDecimal multiple = new BigDecimal(orderItem.getPurchaseCount());
            BigDecimal multiply = orderItem.getProduct().getPrice().multiply(multiple);
            totalPrice = totalPrice.add(multiply);
        }
    }
}
