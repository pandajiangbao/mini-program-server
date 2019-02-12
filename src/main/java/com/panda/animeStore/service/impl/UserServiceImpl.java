package com.panda.animeStore.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.panda.animeStore.entity.User;
import com.panda.animeStore.entity.VO.UserVO;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.UserMapper;
import com.panda.animeStore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author panda
 * @date 2018-12-19 20:51
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.selectByOpenid(openId);
    }

    @Override
    public boolean addUser(User user) {
        if (user.getOpenid() != null && !"".equals(user.getOpenid())) {
            int result = userMapper.insert(user);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        } else {
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean updateUser(User user) {
        if (user.getId() != null) {
            int result = userMapper.updateByPrimaryKeySelective(user);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        } else {
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean deleteUser(User user) {
        //todo
        return false;
    }

    @Override
    public JSONObject loginApi(String code) {
        log.info("登录code:{}", code);
        String appId = "wx0a4307063c6524ac";
        String secret = "79bdbf42acfa4486a0e12ee7d708051d";
        String grant_type = "authorization_code";
        String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type" + grant_type;
        log.info("微信登陆接口请求开始");

        JSONObject response = JSON.parseObject(new RestTemplate().getForObject(url, String.class));
        System.out.println("response = " + response);
        if (response.containsKey("errcode")) {
            log.error("微信登陆接口请求失败");
            throw new RuntimeException("微信登陆接口请求失败");
        } else {
            log.info("微信登陆接口请求成功");
            return response;
        }
    }

    @Override
    public UserVO getUserVO(Integer id) {
        return null;
    }
}
