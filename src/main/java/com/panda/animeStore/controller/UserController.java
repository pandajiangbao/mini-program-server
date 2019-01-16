package com.panda.animeStore.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.panda.animeStore.entity.User;
import com.panda.animeStore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	public String login(String code, String oldToken) {
		log.info("AnimeStore登陆开始");
		JsonObject jsonObject = new JsonObject();
		//check session timeout
		if (redisTemplate.opsForValue().get(oldToken) != null) {
			log.info("token未过期");
			log.info("返回旧token:{}", oldToken);
			jsonObject.addProperty("token", oldToken);
			return jsonObject.toString();
		}

		log.info("token不存在或已过期");

		if (StringUtils.isEmpty(code)) {
			log.info("缺少必要参数");
			throw new RuntimeException("缺少必要参数");
		}
		log.info("登录code:{}", code);
		String appId = "wx0a4307063c6524ac";
		String secret = "79bdbf42acfa4486a0e12ee7d708051d";
		String grant_type = "authorization_code";
		String url = "https://api.weixin.qq.com/sns/jscode2session?" + "appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type" + grant_type;
		log.info("微信登陆接口请求开始");
		JsonObject response = new Gson().fromJson(new RestTemplate().getForObject(url, String.class), JsonObject.class);
		if (response.has("errcode")) {
			log.error("微信登陆接口请求失败");
			throw new RuntimeException("微信登陆接口请求失败");
		} else {
			log.info("微信登陆接口请求成功");
			//response transfer to user
			User user = new Gson().fromJson(response, User.class);
			String openid = user.getOpenid();
			String token = UUID.randomUUID().toString();
			log.info("生成新token:{}", token);
			//set timeout 2 hours
			log.info("存入redis,过期时间2小时");
			redisTemplate.opsForValue().set(token, openid, 7200, TimeUnit.SECONDS);
			System.out.println("user = " + user);
			Integer userId= userService.checkUserByOpenId(openid);
			if (userId> 0) {
				log.info("用户已存在");

			} else {
				log.info("添加新用户");
				userService.addUser(user);
				userId=user.getId();
			}
			log.info("返回新token");
			jsonObject.addProperty("token", token);
			jsonObject.addProperty("userId", userId);
			return jsonObject.toString();
		}
	}
}
