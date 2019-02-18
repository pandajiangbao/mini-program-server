package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Product;
import com.panda.animeStore.entity.ProductCategory;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.ProductCategoryMapper;
import com.panda.animeStore.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 13:43
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> getAllProductCategory() {
        return productCategoryMapper.selectAll();
    }

    @Override
    public boolean addProductCategory(ProductCategory productCategory) {
        int result = productCategoryMapper.insertSelective(productCategory);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean updateProductCategoryById(Integer id, ProductCategory productCategory) {
        if (id != null) {
            productCategory.setId(id);
            int result = productCategoryMapper.updateByPrimaryKeySelective(productCategory);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        } else {
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean deleteProductCategoryById(Integer id) {
        if (id != null) {
            int result = productCategoryMapper.deleteByPrimaryKey(id);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        } else {
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
    }
}
