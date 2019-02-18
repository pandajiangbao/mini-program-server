package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Product;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.ProductMapper;
import com.panda.animeStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-15 10:09 AM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductByCategoryId(Integer categoryId) {
        return productMapper.selectByCategoryId(categoryId);
    }

    @Override
    public List<Product> getAllProduct() {
        return productMapper.selectAll();
    }

    @Override
    public boolean addProduct(Product product) {
        int result = productMapper.insertSelective(product);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean updateProductById(Integer id,Product product) {
        if (id != null) {
            product.setId(id);
            int result = productMapper.updateByPrimaryKeySelective(product);
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
    public boolean deleteProductById(Integer id) {
        if (id != null) {
            int result = productMapper.deleteByPrimaryKey(id);
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
    public boolean handleAmount(Integer id, Integer amount) {
        if (id != null && amount > 0) {
            int result= productMapper.handleAmount(id,amount);
            if (result>0){
                return true;
            }else {
                throw new RuntimeException((BusinessError.STOCK_ERROR.getErrMsg()));
            }
        }
        throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
    }
}
