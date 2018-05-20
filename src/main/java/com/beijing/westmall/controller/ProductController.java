package com.beijing.westmall.controller;

import com.beijing.westmall.entity.Inventory;
import com.beijing.westmall.entity.Product;
import com.beijing.westmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @Author Joker
 * @Description
 * @Date Create in 下午2:37 2018/5/18
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody Product product) {
        Inventory inventory = createDefaultInventory();
        product.setInventory(inventory);
        Product actualProduct = productRepository.save(product);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", createLocation(actualProduct));
        ResponseEntity responseEntity = new ResponseEntity(httpHeaders,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id,@RequestBody Product product) {
        Product oldProduct = productRepository.findOne(id);
        if (oldProduct == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        oldProduct.setPrice(product.getPrice());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setName(product.getName());
        productRepository.save(oldProduct);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts(@RequestParam(name = "name",required = false) String name,@RequestParam(name = "description",required = false) String description) {
        if (name != null && description != null)
            return productRepository.findProductsByNameContainsAndDescriptionContains(name,description);
        if (name != null)
            return productRepository.findProductsByName(name);
        return productRepository.findAll();
    }


    private String createLocation(Product actualProduct) {
        InetAddress inetAddress = getInetAddress();
        return "http://" + inetAddress.getHostAddress() + ":8083/products/" + actualProduct.getId();
    }

    private InetAddress getInetAddress() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return inetAddress;
    }

    private Inventory createDefaultInventory() {
        Inventory inventory = new Inventory();
        inventory.setCount(113);
        inventory.setLockedCount(107);
        return inventory;
    }
}
