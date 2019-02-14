package com.panda.animeStore.service.impl;

import com.panda.animeStore.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author panda
 * @date 2019-02-14 04:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    void getUserByOpenId() {
        System.out.println(userService.getUserByOpenId("o_m850nEAP373WGvhZoLTYsqfZd8"));
    }
}