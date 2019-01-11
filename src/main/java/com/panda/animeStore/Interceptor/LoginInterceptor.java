package com.panda.animeStore.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author panda
 * @date 2018-12-24 2:21
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		String token = request.getHeader("token");
		if (StringUtils.isEmpty(token)) {
			log.error("403:{}", "没有设置token");
			response.setStatus(403);
			response.setHeader("errMsg","no set token");
			return false;
		}
		log.info("token:{}", token);
		if (redisTemplate.opsForValue().get(token) != null) {
			log.info("用户openId:{}发出请求", redisTemplate.opsForValue().get(token));
			return true;
		}
		log.error("403:{}", "用户token错误或失效");
		response.setStatus(403);
		response.setHeader("errMsg","token invalid or timeout");
		return false;
	}
}

