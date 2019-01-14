package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserAddress;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author panda
 * @date 2019-01-13 7:13 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserAddressMapperTest {
	@Autowired
	private UserAddressMapper userAddressMapper;

	@Test
	void deleteByPrimaryKey() {
	}

	@Test
	void insert() {
		UserAddress userAddress = new UserAddress();
		userAddress.setUserId(2);
		int result=userAddressMapper.insert(userAddress);
		System.out.println(userAddressMapper.selectByPrimaryKey(3));
	}

	@Test
	void selectByPrimaryKey() {
	}

	@Test
	void selectListByUserId() {
		userAddressMapper.selectListByUserId(1).forEach(userAddress -> System.out.println(userAddress));
	}

	@Test
	void selectAll() {
	}

	@Test
	void updateByPrimaryKey() {
	}
}