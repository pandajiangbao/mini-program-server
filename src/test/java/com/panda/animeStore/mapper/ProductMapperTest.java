package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author panda
 * @date 2019-01-15 9:39 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductMapperTest {
	@Autowired
	private ProductMapper productMapper;
	@Test
	void deleteByPrimaryKey() {
		productMapper.deleteByPrimaryKey(5);
		productMapper.selectAll().forEach(System.out::println);
	}

	@Test
	void insert() {
		Product product=new Product();
		product.setTitle("test1");
		product.setPrice(new BigDecimal(55.00));
		product.setSales(20);
		product.setStock(644);
		product.setImg("/static/image/index/panda1.JPG");
		product.setCategoryId(2);
		productMapper.insert(product);
		productMapper.selectAll().forEach(System.out::println);
	}

	@Test
	void insertSelective() {
	}

	@Test
	void selectByPrimaryKey() {
	}

	@Test
	void selectAll() {
		productMapper.selectAll().forEach(System.out::println);
	}

	@Test
	void updateByPrimaryKeySelective() {
	}

	@Test
	void updateByPrimaryKeyWithBLOBs() {
	}

	@Test
	void updateByPrimaryKey() {
	}


}