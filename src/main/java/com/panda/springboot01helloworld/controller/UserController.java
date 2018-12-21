package com.panda.springboot01helloworld.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.panda.springboot01helloworld.entity.User;
import com.panda.springboot01helloworld.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author panda
 * @date 2018-12-20 10:42
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(String code){
        log.info("AnimeStore登陆开始");
        if (code==null){
            log.info("缺少必要参数");
            throw new RuntimeException("缺少必要参数");
        }
        String appId="wx0a4307063c6524ac";
        String secret="79bdbf42acfa4486a0e12ee7d708051d";
        String grant_type="authorization_code";
        String url="https://api.weixin.qq.com/sns/jscode2session?"+"appid=" + appId + "&secret=" + secret + "&js_code=" +code+"&grant_type"+grant_type;
        log.info("接口请求开始");
        JsonObject jsonObject=new Gson().fromJson(new RestTemplate().getForObject(url, String.class),JsonObject.class);
        if(jsonObject.has("errorcode")){
            log.error("微信登陆接口请求失败");
            throw new RuntimeException("微信登陆接口请求失败:"+jsonObject);
        }
        log.info("微信接口请求成功");
        User user=new Gson().fromJson(jsonObject,User.class);
        String session_key=jsonObject.get("session_key").toString();
        String openid= user.getOpenid();
        if (userService.checkUserByOpenId(openid)){
            log.info("用户已存在");

        }else {
            log.info("添加用户");
            userService.addUser(user);
        }
        return user;
    }
}
