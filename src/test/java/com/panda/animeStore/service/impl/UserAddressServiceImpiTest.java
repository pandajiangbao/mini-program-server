package com.panda.animeStore.service.impl;

import com.panda.animeStore.service.UserAddressService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author panda
 * @date 2019-01-14 2:15 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserAddressServiceImpiTest {
	@Autowired
	private UserAddressService userAddressService;
	@Test
	void getUserAddressListByUserId() {
		System.out.println(userAddressService.getUserAddressListByUserId(1));
	}

	@Test
	void addUserAddress() {
	}

	@Test
	void updateUserAddress() {
	}

	@Test
	void deleteUserAddress() {
	}
}