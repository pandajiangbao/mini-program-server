package com.panda.animeStore.controller;

import com.alibaba.fastjson.JSONObject;
import com.panda.animeStore.entity.User;
import com.panda.animeStore.entity.VO.LoginVO;
import com.panda.animeStore.util.ResJson;
import com.panda.animeStore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author panda
 * @date 2018-12-20 10:42
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @PostMapping("/login")
    public ResJson login(String code,
                         String rawData,
                         String oldToken) {
        log.info("AnimeStore登陆开始");

        LoginVO loginVO = new LoginVO();
        //check session timeout
        if (redisTemplate.opsForValue().get(oldToken) != null) {
            log.info("token未过期,登录成功");
            String openid = (String) redisTemplate.opsForValue().get(oldToken);
            String token = UUID.randomUUID().toString();
            log.info("生成新token", token);
            log.info("刷新token,存入新token,过期时间90分钟");
            redisTemplate.opsForValue().set(token, openid, 90, TimeUnit.MINUTES);
            loginVO.setToken(token);
            loginVO.setUserId(userService.getUserByOpenId(openid).getId());
            return ResJson.result(loginVO);
        }

        log.info("token不存在或已过期");

        if (StringUtils.isEmpty(code)) {
            log.info("缺少必要参数");
            throw new RuntimeException("缺少必要参数");
        }

        log.info("调用微信第三方登录api");

        JSONObject response = userService.loginApi(code);
        String openid = response.get("openid").toString();
        String sessionKey = response.get("session_key").toString();
        log.info("openid:{},session_key:{}", openid, sessionKey);

        String token = UUID.randomUUID().toString();
        log.info("生成新token:{}", token);
        log.info("存入redis,过期时间90分钟");
        redisTemplate.opsForValue().set(token, openid, 90, TimeUnit.MINUTES);

        User user = userService.getUserByOpenId(openid);
        Integer userId= user.getId();
        JSONObject userInfo= JSONObject.parseObject(rawData);
        System.out.println("userInfo = " + userInfo);

        if (user == null) {
            log.info("用户不存在,注册新用户");

            user.setOpenid(openid);
            user.setNickName(userInfo.getString("nickName"));
            user.setGender(userInfo.getInteger("gender"));
            user.setCity(userInfo.getString("city"));
            user.setProvince(userInfo.getString("province"));
            user.setCountry(userInfo.getString("country"));
            user.setAvatarUrl(userInfo.getString("avatarUrl"));
            user.setCreateTime(new Date());

            userService.addUser(user);
            userId = user.getId();

        } else {
            log.info("用户已存在,更新用户信息");

            user.setNickName(userInfo.getString("nickName"));
            user.setGender(userInfo.getInteger("gender"));
            user.setCity(userInfo.getString("city"));
            user.setProvince(userInfo.getString("province"));
            user.setCountry(userInfo.getString("country"));
            user.setAvatarUrl(userInfo.getString("avatarUrl"));

            //todo
        }

        log.info("返回新token");

        loginVO.setToken(token);
        loginVO.setUserId(userId);
        return ResJson.result(loginVO);

    }
}
