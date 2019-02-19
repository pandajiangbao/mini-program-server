package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Product;
import com.panda.animeStore.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-19 13:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @Test
    void getProductByCategoryId() {
        List<Product> productList= productService.getProductByCategoryId(6);
        productList.forEach(System.out::println);
    }

    @Test
    void getAllProduct() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void updateProductById() {
    }

    @Test
    void deleteProductById() {
    }

    @Test
    void handleAmount() {
    }
}