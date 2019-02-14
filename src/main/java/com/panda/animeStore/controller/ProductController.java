package com.panda.animeStore.controller;

import com.panda.animeStore.entity.Product;
import com.panda.animeStore.service.ProductService;
import com.panda.animeStore.util.ResultJson;
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
	public ResultJson getAllProduct() {
		List<Product> productList = productService.getAllProduct();
		return ResultJson.result(productList);
	}

	@PostMapping
	public ResultJson addProduct(@RequestBody Product product) {
		if (productService.addProduct(product)) {
			return ResultJson.success();
		} else {
			return ResultJson.failed();
		}
	}

	@PutMapping
	public ResultJson updateProduct(@RequestBody Product product) {
		if (productService.updateProduct(product)) {
			return ResultJson.success();
		} else {
			return ResultJson.failed();
		}
	}

	@DeleteMapping("/{id}")
	public ResultJson deleteProduct(@PathVariable Integer id) {
		if (productService.deleteProduct(id)) {
			return ResultJson.success();
		} else {
			return ResultJson.failed();
		}
	}
}
