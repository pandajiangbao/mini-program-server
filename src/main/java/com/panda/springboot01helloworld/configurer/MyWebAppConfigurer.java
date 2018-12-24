package com.panda.springboot01helloworld.configurer;

/**
 * @author panda
 * @date 2018-12-24 2:55
 */

import com.panda.springboot01helloworld.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
	// 将拦截器注入为Bean
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
	}

}