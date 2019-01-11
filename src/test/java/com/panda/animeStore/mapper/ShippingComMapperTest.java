package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShippingCom;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author panda
 * @date 2019-01-11 10:16 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ShippingComMapperTest {
	@Autowired
	private ShippingComMapper shippingComMapper;
	@Test
	void deleteByPrimaryKey() {
	}

	@Test
	void insert() {
	}

	@Test
	void selectByPrimaryKey() {
		System.out.println(shippingComMapper.selectByPrimaryKey(1));
	}

	@Test
	void selectAll() {
		shippingComMapper.selectAll().forEach(shippingCom -> System.out.println(shippingCom));
	}

	@Test
	void updateByPrimaryKey() {
		ShippingCom shippingCom=shippingComMapper.selectByPrimaryKey(1);
		shippingCom.setComName("胖达快递");
		int result=shippingComMapper.updateByPrimaryKey(shippingCom);
		System.out.println(shippingComMapper.selectByPrimaryKey(1));
	}
}