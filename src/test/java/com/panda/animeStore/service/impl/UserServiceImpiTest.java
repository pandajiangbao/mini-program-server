package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.User;
import com.panda.animeStore.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author panda
 * @date 2019-01-14 7:36 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImpiTest {
	@Autowired
	private UserService userService;
	@Test
	void checkUserByOpenId() {
	}

	@Test
	void addUser() {
		User user=new User();
		user.setOpenid("sadafzd25g1251adsf");
		userService.addUser(user);
		System.out.println("user.getId() = " + user.getId());
	}
}