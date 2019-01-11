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
 * @date 2019-01-11 9:03 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserAddressMapperTest {
	@Autowired
	private  UserAddressMapper userAddressMapper;
	@Test
	void deleteByPrimaryKey() {
	}

	@Test
	void insert() {
		UserAddress userAddress=new UserAddress();
		userAddress.setReceiver("胖达酱");
		userAddress.setPhoneNumber("18520554670");
		userAddress.setCounty("天河区");
		userAddress.setDetail("华南农业大学华山区14栋302");
		userAddress.setUserId(1);
		System.out.println("userAddress = " + userAddress);
		int result=userAddressMapper.insert(userAddress);
		System.out.println("result = " + result);
		System.out.println(userAddressMapper.selectByPrimaryKey(1));
	}

	@Test
	void selectByPrimaryKey() {
		System.out.println(userAddressMapper.selectByPrimaryKey(2));
	}

	@Test
	void selectAll() {
	}

	@Test
	void updateByPrimaryKey() {
	}
}