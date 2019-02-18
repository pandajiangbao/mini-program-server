package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ProductCategory;
import com.panda.animeStore.service.ProductCategoryService;
import com.panda.animeStore.util.ResultJson;
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
    public ResultJson getAllCategories(){
        return ResultJson.result(productCategoryService.getAllProductCategory());
    }

    @PostMapping("/categories")
    public ResultJson addProductCategory(@RequestBody ProductCategory productCategory) {
        if (productCategoryService.addProductCategory(productCategory)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }

    @PutMapping("/categories/{id}")
    public ResultJson updateProductCategory(@PathVariable Integer id, @RequestBody ProductCategory productCategory) {
        if (productCategoryService.updateProductCategoryById(id, productCategory)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResultJson deleteProductCategory(@PathVariable Integer id) {
        if (productCategoryService.deleteProductCategoryById(id)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }
}
