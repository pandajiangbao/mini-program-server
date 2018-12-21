package com.panda.springboot01helloworld.service;

import com.panda.springboot01helloworld.entity.User;

/**
 * @author panda
 * @date 2018-12-19 14:53
 */
public interface UserService {
    boolean checkUserByOpenId(String openId);
    boolean addUser(User user);
}
