package com.panda.animeStore.controller;

import com.panda.animeStore.entity.Product;
import com.panda.animeStore.service.ProductService;
import com.panda.animeStore.util.ResJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-15 10:21 AM
 */
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResJson getAllProduct() {
		log.info("获取所有商品列表,请求开始");
		List<Product> productList = productService.getAllProduct();
		log.info("返回所有商品列表,请求结束");
		return ResJson.result(productList);
	}

	@PostMapping
	public ResJson addProduct(@RequestBody Product product) {
		log.info("添加商品,请求开始");
		if (productService.addProduct(product)) {
			return ResJson.success("addProduct");
		} else {
			return ResJson.failed("addProduct");
		}
	}

	@PutMapping
	public ResJson updateProduct(@RequestBody Product product) {
		log.info("修改商品,请求开始");
		if (productService.updateProduct(product)) {
			return ResJson.success("updateProduct");
		} else {
			return ResJson.failed("updateProduct");
		}
	}

	@DeleteMapping("/{id}")
	public ResJson deleteProduct(@PathVariable Integer id) {
		log.info("删除商品请求开始");
		if (productService.deleteProduct(id)) {
			return ResJson.success("deleteProduct");
		} else {
			return ResJson.failed("deleteProduct");
		}
	}
}
