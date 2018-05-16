package com.beijing.westmall.repository;

import com.beijing.westmall.entity.Order;
import com.beijing.westmall.entity.OrderItem;
import com.beijing.westmall.entity.Product;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.junit.Assert.*;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午3:48 2018/5/15
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Before
    public void setUp() throws Exception {
        //本地启动mysql，创建employee_db数据库
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/westmall","root","123456");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void testGetOrder() {
        Order one = orderRepository.findOne((long) 1);
        System.out.println(one);
    }

    @Test
    public void testAddOrder() {
        Order order = createOrder();
        Order actual = orderRepository.save(order);
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertNotNull(actual.getOrderItems());
        assertEquals(actual.getOrderItems().size(),1);
        assertEquals(actual.getOrderItems().get(0).getId(),actual.getId());
    }

    private Order createOrder() {
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setPurchaseCount(1);
        Product product = new Product();
        product.setId((long) 1);
        orderItem.setProduct(product);
        orderItems.add(orderItem);
        Order order = new Order();
        order.setCreateTime("2018-05-15 15:53:33");
        order.setStatus("unPaid");
        order.setTotalPrice(new BigDecimal(100));
        order.setOrderItems(orderItems);
        order.setUserId((long) 1);
        return order;
    }

    @Test
    public void testFindOrdersByUserId() {
        List<Order> orders = orderRepository.findOrdersByUserId(1);
        assertNotNull(orders);
        assertEquals(orders.size(),1);
    }

}
