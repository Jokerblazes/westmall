package com.beijing.westmall.repository;

import com.beijing.westmall.entity.Inventory;
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
import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.junit.Assert.*;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午4:43 2018/5/14
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        //本地启动mysql，创建employee_db数据库
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://192.168.1.100:3307/westmall","root","123456");
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void testAddProduct() {
        Product product = createProduct();
        Product save = productRepository.save(product);
        Long resultId = save.getId();
        assertNotNull(resultId);
        assertNotNull(save.getInventory().getId());
    }

    @Test
    public void testFindProductById() {
        Product product = productRepository.findOne((long) 1);
        assertNotNull(product);
        assertNotNull(product.getInventory());
    }

    @Test
    public void testFindProductsByName() {
        List<Product> products = productRepository.findProductsByName("test1");
        assertNotNull(products);
        assertEquals(products.size(),1);
        assertEquals(products.get(0).getName(),"test1");
    }

    @Test
    public void testFindProductsByNameLikeAndDescriptionLike() {
        List<Product> products = productRepository.findProductsByNameContainsAndDescriptionContains("t", "t");
        assertNotNull(products);
        assertEquals(products.size(),1);
        assertEquals(products.get(0).getName(),"test1");
    }


    private Product createProduct() {
        Product product = new Product();
        product.setName("name1");
        product.setDescription("this is name1");
        product.setPrice(new BigDecimal(100));
        Inventory inventory = new Inventory();
        inventory.setCount(1);
        inventory.setLockedCount(1);
        product.setInventory(inventory);
        return product;
    }

}
