package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.UserStar;
import com.panda.animeStore.service.UserStarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 18:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserStarServiceImplTest {
    @Autowired
    private UserStarService userStarService;
    @Test
    void getUserStarByUserId() {
        List<UserStar> userStarList=userStarService.getUserStarByUserId(1);
        userStarList.forEach(System.out::println);
    }

    @Test
    void addUserStar() {
    }

    @Test
    void deleteUserStar() {
    }
}