package com.panda.animeStore.service;

import com.panda.animeStore.entity.UserStar;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 18:05
 */
public interface UserStarService {
    List<UserStar> getUserStarByUserId(Integer userId);
    boolean addUserStar(UserStar userStar);
    boolean deleteUserStar(Integer id);
}
