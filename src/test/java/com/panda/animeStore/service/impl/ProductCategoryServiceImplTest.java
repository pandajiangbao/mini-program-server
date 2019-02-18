package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.ProductCategory;
import com.panda.animeStore.service.ProductCategoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 13:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    void getAllProductCategory() {
        List<ProductCategory> productCategoryList= productCategoryService.getAllProductCategory();
        productCategoryList.forEach(System.out::println);
    }

    @Test
    void addProductCategory() {
    }

    @Test
    void updateProductCategory() {
    }

    @Test
    void deleteProductCategory() {
    }
}