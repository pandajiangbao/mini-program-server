package com.panda.animeStore.service;

import com.panda.animeStore.entity.Product;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-15 10:04 AM
 */
public interface ProductService {
	List<Product> getAllProduct();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Integer id);
	boolean handleAmount(Integer id,Integer amount);
}
