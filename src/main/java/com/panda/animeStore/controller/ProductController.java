package com.panda.animeStore.controller;

import com.github.pagehelper.PageHelper;
import com.panda.animeStore.entity.Product;
import com.panda.animeStore.service.ProductService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author panda
 * @date 2019-01-15 10:21 AM
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Object getAllProduct(@RequestParam(required = false, defaultValue = "1") int pageNo,
                              @RequestParam(required = false, defaultValue = "0") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return Result.data(productService.getAllProduct());
    }

    @GetMapping("/categories/{categoryId}/products")
    public Object getProductByCategoryId(@PathVariable Integer categoryId) {
        return Result.data(productService.getProductByCategoryId(categoryId));
    }

    @PostMapping("/products")
    public Object addProduct(@RequestBody Product product) {
        return Result.status(productService.addProduct(product));
    }

    @PutMapping("/products/{id}")
    public Object updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return Result.status(productService.updateProductById(id, product));
    }

    @DeleteMapping("/products/{id}")
    public Object deleteProduct(@PathVariable Integer id) {
        return Result.status(productService.deleteProductById(id));
    }
}
