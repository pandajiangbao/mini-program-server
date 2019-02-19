package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ProductCategory;
import com.panda.animeStore.service.ProductCategoryService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author panda
 * @date 2019-02-18 13:53
 */
@RestController
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public Object getAllCategories() {
        return Result.data(productCategoryService.getAllProductCategory());
    }

    @PostMapping("/categories")
    public Object addProductCategory(@RequestBody ProductCategory productCategory) {
        return Result.status(productCategoryService.addProductCategory(productCategory));
    }

    @PutMapping("/categories/{id}")
    public Object updateProductCategory(@PathVariable Integer id, @RequestBody ProductCategory productCategory) {
        return Result.status(productCategoryService.updateProductCategoryById(id, productCategory));
    }

    @DeleteMapping("/categories/{id}")
    public Object deleteProductCategory(@PathVariable Integer id) {
        return Result.status(productCategoryService.deleteProductCategoryById(id));
    }
}