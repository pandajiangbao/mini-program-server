package com.panda.animeStore.controller;

import com.github.pagehelper.PageHelper;
import com.panda.animeStore.entity.Product;
import com.panda.animeStore.service.ProductService;
import com.panda.animeStore.util.ResultJson;
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
    public ResultJson getAllProduct(@RequestParam(required = false, defaultValue = "1") int pageNo,
                                    @RequestParam(required = false, defaultValue = "8") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return ResultJson.result(productService.getAllProduct());
    }

    @GetMapping("/category/{categoryId}/products")
    public ResultJson getProductByCategoryId(@PathVariable Integer categoryId) {
        return ResultJson.result(productService.getProductByCategoryId(categoryId));
    }

    @PostMapping("/products")
    public ResultJson addProduct(@RequestBody Product product) {
        if (productService.addProduct(product)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }

    @PutMapping("/products/{id}")
    public ResultJson updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        if (productService.updateProductById(id, product)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }

    @DeleteMapping("/products/{id}")
    public ResultJson deleteProduct(@PathVariable Integer id) {
        if (productService.deleteProductById(id)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }
}
