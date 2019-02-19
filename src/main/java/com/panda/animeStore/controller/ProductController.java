package com.panda.animeStore.controller;

import com.github.pagehelper.PageHelper;
import com.panda.animeStore.entity.Product;
import com.panda.animeStore.service.ProductService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-15 10:21 AM
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProduct(@RequestParam(required = false, defaultValue = "1") int pageNo,
                                       @RequestParam(required = false, defaultValue = "0") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return productService.getAllProduct();
    }

    @GetMapping("/categories/{categoryId}/products")
    public List<Product> getProductByCategoryId(@PathVariable Integer categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        Result.status(productService.addProduct(product));
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Result.status(productService.updateProductById(id, product));
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        Result.status(productService.deleteProductById(id));
    }
}
