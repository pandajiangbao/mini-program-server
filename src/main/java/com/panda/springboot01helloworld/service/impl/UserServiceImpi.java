package com.panda.springboot01helloworld.service.impl;

import com.panda.springboot01helloworld.entity.User;
import com.panda.springboot01helloworld.mapper.UserMapper;
import com.panda.springboot01helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author panda
 * @date 2018-12-19 20:51
 */
@Service
public class UserServiceImpi implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean checkUserByOpenId(String openId) {
        if (userMapper.selectByOpenId(openId)!=null){
            return true;
        }
        return  false;
    }

    @Override
    public boolean addUser(User user) {
        if (user.getOpenid()!=null&&!"".equals(user.getOpenid())){
            try {
                int result = userMapper.insert(user);
                if (result>0){
                    return true;
                }else {
                    throw new RuntimeException("插入用户信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入用户信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("用户信息不能为空");
        }
    }
}
