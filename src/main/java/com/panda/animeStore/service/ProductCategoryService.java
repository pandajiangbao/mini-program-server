package com.panda.animeStore.service;

import com.panda.animeStore.entity.ProductCategory;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 13:41
 */
public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategory();
    boolean addProductCategory(ProductCategory productCategory);
    boolean updateProductCategoryById(Integer id,ProductCategory productCategory);
    boolean deleteProductCategoryById(Integer id);
}
