package com.panda.animeStore.service;

import com.panda.animeStore.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author panda
 * @date 2019-01-15 10:04 AM
 */
public interface ProductService {
	List<Product> getProductByCategoryId(Integer categoryId);
	List<Product> getProductByQuery(String query);
	List<Product> getAllProduct();
	boolean addProduct(Product product);
	String  saveProductImg(MultipartFile multipartFile) throws IOException;
	boolean updateProductById(Integer id,Product product);
	boolean deleteProductById(Integer id);
	boolean handleAmount(Integer id,Integer amount);
}
