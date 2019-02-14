package com.panda.animeStore.service;

import com.alibaba.fastjson.JSONObject;
import com.panda.animeStore.entity.User;
import com.panda.animeStore.entity.VO.UserVO;

/**
 * @author panda
 * @date 2018-12-19 14:53
 */
public interface UserService {
    User getUserById(Integer id);
    User getUserByOpenId(String openId);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Integer id);
    JSONObject loginApi(String code);
    UserVO getUserVO(Integer id);
}
