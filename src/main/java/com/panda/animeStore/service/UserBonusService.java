package com.panda.animeStore.service;

import com.panda.animeStore.entity.VO.UserBonusVO;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-19 12:41
 */
public interface UserBonusService {
    List<UserBonusVO> getUserBonusVOByUserId(Integer userId);
    boolean bonusToNewUser(Integer userId);
    boolean addUserBonusVO(UserBonusVO userBonusVO);
    boolean deleteUserBonus(Integer id);
}
