package com.panda.animeStore.service;

import com.panda.animeStore.entity.User;

/**
 * @author panda
 * @date 2018-12-19 14:53
 */
public interface UserService {
    boolean checkUserByOpenId(String openId);
    boolean addUser(User user);
}
