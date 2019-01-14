package com.panda.animeStore.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author panda
 * @date 2018-12-24 2:21
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	//请求处理前进行调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String token = request.getHeader("token");
		if (StringUtils.isEmpty(token)) {
			log.error("403:{}", "token为空");
			response.setStatus(403);
			response.setHeader("errMsg", "token is empty");
			return false;
		}
		log.info("token:{}", token);
		if (redisTemplate.opsForValue().get(token) != null) {
			log.info("用户openId:{}发出请求", redisTemplate.opsForValue().get(token));
			return true;
		}
		log.error("403:{}", "用户token错误或失效");
		response.setStatus(403);
		response.setHeader("errMsg", "token invalid or timeout");
		return false;
	}

	//请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) {
	}

	//在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
	}

}

