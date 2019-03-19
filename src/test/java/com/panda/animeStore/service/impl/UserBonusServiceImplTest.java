package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.VO.UserBonusVO;
import com.panda.animeStore.service.UserBonusService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author panda
 * @date 2019-03-19 13:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserBonusServiceImplTest {
@Autowired
private UserBonusService userBonusService;
    @Test
    void getUserBonusVOByUserId() {
        for(UserBonusVO userBonusVO:userBonusService.getUserBonusVOByUserId(1)){
            System.out.println("userBonusVO = " + userBonusVO);
        }
    }

    @Test
    void bonusToNewUser() {
        userBonusService.bonusToNewUser(1);
    }

    @Test
    void addUserBonus() {
    }

    @Test
    void deleteUserBonus() {
    }
}