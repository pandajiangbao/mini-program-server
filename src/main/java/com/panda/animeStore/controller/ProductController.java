package com.panda.animeStore.controller;

import com.github.pagehelper.PageHelper;
import com.panda.animeStore.entity.Product;
import com.panda.animeStore.service.ProductService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author panda
 * @date 2019-01-15 10:21 AM
 */
@RestController
@Api(value = "ProductApi", description = "商品相关接口")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取商品列表")
    @GetMapping("/products")
    public List<Product> getAllProduct(
            @RequestParam(required = false, defaultValue = "1") int pageNo,
            @RequestParam(required = false, defaultValue = "0") int pageSize,
            @RequestParam(required = false) String query) {
        if (query!=null){
            return productService.getProductByQuery(query);
        }
        PageHelper.startPage(pageNo, pageSize);
        Result.data();
        return productService.getAllProduct();
    }

    @ApiOperation(value = "获取该分类下商品列表")
    @GetMapping("/categories/{categoryId}/products")
    public List<Product> getProductByCategoryId(@PathVariable Integer categoryId) {
        Result.data();
        return productService.getProductByCategoryId(categoryId);
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        return Result.status(productService.addProduct(product));
    }

    @ApiOperation(value = "上传商品图片")
    @PostMapping("/products/upload")
    public String uploadProductImg(@RequestParam("file") MultipartFile file) throws IOException {
        Result.data();
        return productService.saveProductImg(file);
    }

    @ApiOperation(value = "修改商品")
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return Result.status(productService.updateProductById(id, product));
    }

    @ApiOperation(value = "删除商品")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        return Result.status(productService.deleteProductById(id));
    }
}
