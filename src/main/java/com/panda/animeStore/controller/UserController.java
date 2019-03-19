package com.panda.animeStore.controller;

import com.alibaba.fastjson.JSONObject;
import com.panda.animeStore.entity.User;
import com.panda.animeStore.entity.VO.LoginVO;
import com.panda.animeStore.service.UserService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author panda
 * @date 2018-12-20 10:42
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "UserApi", description = "用户相关接口")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @ApiOperation(value = "用户登陆并信息入库", notes = "登陆成功后返回Token并入库用户信息")
    @PostMapping("/login")
    public LoginVO login(String code,
                            String rawData,
                            String oldToken) {
        log.info("AnimeStore登陆开始");


        LoginVO loginVO = new LoginVO();
        //解析用户非敏感数据
        JSONObject userInfo = JSONObject.parseObject(rawData);

        //检查token是否超时
        if (redisTemplate.opsForValue().get(oldToken) != null) {
            log.info("token未过期,登录成功");
            String openid = (String) redisTemplate.opsForValue().get(oldToken);

            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(token, openid, 90, TimeUnit.MINUTES);

            User user = userService.getUserByOpenId(openid);
            user.setNickName(userInfo.getString("nickName"));
            user.setGender(userInfo.getInteger("gender"));
            user.setCity(userInfo.getString("city"));
            user.setProvince(userInfo.getString("province"));
            user.setCountry(userInfo.getString("country"));
            user.setAvatarUrl(userInfo.getString("avatarUrl"));
            userService.updateUser(user);

            log.info("刷新token:{},更新用户数据", token);
            log.info("返回并存入新token,过期时间90分钟");

            loginVO.setToken(token);
            loginVO.setUserId(userService.getUserByOpenId(openid).getId());
            return loginVO;
        }

        log.info("token不存在或已过期");

        if (StringUtils.isEmpty(code)) {
            log.info("缺少必要参数");
            throw new RuntimeException("缺少必要参数");
        }

        log.info("调用微信第三方登录api");

        JSONObject response = userService.loginApi(code);
        String openid = response.get("openid").toString();

        String token = UUID.randomUUID().toString();
        log.info("生成新token:{}", token);
        log.info("存入redis,过期时间90分钟");
        redisTemplate.opsForValue().set(token, openid, 90, TimeUnit.MINUTES);
        //确认用户是否存在
        User user = userService.getUserByOpenId(openid);

        if (user == null) {
            log.info("用户不存在,注册新用户");

            user = new User();
            user.setOpenid(openid);
            user.setNickName(userInfo.getString("nickName"));
            user.setGender(userInfo.getInteger("gender"));
            user.setCity(userInfo.getString("city"));
            user.setProvince(userInfo.getString("province"));
            user.setCountry(userInfo.getString("country"));
            user.setAvatarUrl(userInfo.getString("avatarUrl"));
            user.setCreateTime(new Date());

            userService.addUser(user);
            loginVO.setIsNew(true);
        } else {
            log.info("用户已存在,更新用户信息");

            user.setNickName(userInfo.getString("nickName"));
            user.setGender(userInfo.getInteger("gender"));
            user.setCity(userInfo.getString("city"));
            user.setProvince(userInfo.getString("province"));
            user.setCountry(userInfo.getString("country"));
            user.setAvatarUrl(userInfo.getString("avatarUrl"));

            userService.updateUser(user);
        }

        log.info("返回新token");

        loginVO.setToken(token);
        loginVO.setUserId(user.getId());
        return loginVO;
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/{id}")
    private User getUserById(@PathVariable Integer id) {
        Result.data();
        return userService.getUserById(id);
    }
}
