package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ProductCategory;
import com.panda.animeStore.service.ProductCategoryService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 13:53
 */
@RestController
@Api(value = "ProductCategoryApi", description = "商品分类相关接口")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation(value = "获取分类列表")
    @GetMapping("/categories")
    public List<ProductCategory> getAllCategories() {
        Result.data();
        return productCategoryService.getAllProductCategory();
    }

    @ApiOperation(value = "添加分类")
    @PostMapping("/categories")
    public ResponseEntity<String> addProductCategory(@RequestBody ProductCategory productCategory) {
        return Result.status(productCategoryService.addProductCategory(productCategory));
    }

    @ApiOperation(value = "修改分类")
    @PutMapping("/categories/{id}")
    public ResponseEntity<String> updateProductCategory(@PathVariable Integer id, @RequestBody ProductCategory productCategory) {
        return Result.status(productCategoryService.updateProductCategoryById(id, productCategory));
    }

    @ApiOperation(value = "删除分类")
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteProductCategory(@PathVariable Integer id) {
        return Result.status(productCategoryService.deleteProductCategoryById(id));
    }
}