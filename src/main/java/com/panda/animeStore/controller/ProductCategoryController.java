package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ProductCategory;
import com.panda.animeStore.service.ProductCategoryService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 13:53
 */
@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public List<ProductCategory> getAllCategories() {
        return productCategoryService.getAllProductCategory();
    }

    @PostMapping("/categories")
    public void addProductCategory(@RequestBody ProductCategory productCategory) {
        Result.status(productCategoryService.addProductCategory(productCategory));
    }

    @PutMapping("/categories/{id}")
    public void updateProductCategory(@PathVariable Integer id, @RequestBody ProductCategory productCategory) {
        Result.status(productCategoryService.updateProductCategoryById(id, productCategory));
    }

    @DeleteMapping("/categories/{id}")
    public void deleteProductCategory(@PathVariable Integer id) {
        Result.status(productCategoryService.deleteProductCategoryById(id));
    }
}