package com.beijing.westmall.controller;

import com.beijing.westmall.common.Utils;
import com.beijing.westmall.entity.Order;
import com.beijing.westmall.entity.OrderItem;
import com.beijing.westmall.entity.Product;
import com.beijing.westmall.repository.OrderRepository;
import com.beijing.westmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 上午10:44 2018/5/19
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody List<OrderItem> orderItems) {
        for (OrderItem orderItem :
                orderItems)
            orderItem.setProduct(productRepository.findOne(orderItem.getProductId()));
        Order order = Order.createOrder(orderItems);
        Order actualOrder = orderRepository.save(order);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", createLocation(actualOrder));
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity updateOrderStatus(@PathVariable Long id, @Param("orderStatus") String orderStatus) {
        Order order = orderRepository.findOne(id);
        order.setStatus(orderStatus);
        Order actualOrder = orderRepository.save(order);
        return new ResponseEntity<Object>(actualOrder,HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getOrderByUserId(@Param("userId") Long userId) {
        return orderRepository.findOrdersByUserId(userId);
    }

    private String createLocation(Order actualOrder) {
        InetAddress inetAddress = Utils.getInetAddress();
        return "http://" + inetAddress.getHostAddress() + ":8083/orders/" + actualOrder.getId();
    }




}
