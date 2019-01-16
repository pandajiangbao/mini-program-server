package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Product;
import com.panda.animeStore.mapper.ProductMapper;
import com.panda.animeStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-15 10:09 AM
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

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
			throw new RuntimeException("插入商品失败");
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		if (product.getId() != null) {
			int result = productMapper.updateByPrimaryKeySelective(product);
			if (result > 0) {
				return true;
			} else {
				throw new RuntimeException("更新商品失败");
			}
		} else {
			throw new RuntimeException("商品id不能为空");
		}
	}

	@Override
	public boolean deleteProduct(Integer id) {
		if (id != null) {
			int result = productMapper.deleteByPrimaryKey(id);
			if (result > 0) {
				return true;
			} else {
				throw new RuntimeException("删除商品失败");
			}
		} else {
			throw new RuntimeException("删除商品所需id不能为空");
		}
	}
}
