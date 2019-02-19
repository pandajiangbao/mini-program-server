package com.panda.animeStore.Interceptor;

import com.panda.animeStore.entity.User;
import com.panda.animeStore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
    private UserService userService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    //请求处理前进行调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        String token = request.getHeader("token");

        if (StringUtils.isEmpty(token)) {
            log.error("403:{}", "权限认证失败,token为空");
            response.setStatus(403);
            response.getWriter().append("token is empty");
            return false;
        }

        try {
            String openid = (String) redisTemplate.opsForValue().get(token);
            User user = userService.getUserByOpenId(openid);
            log.info("用户Id:{},昵称{},{} {}请求开始",
                    user.getId(),
                    user.getNickName(),
                    request.getServletPath(),
                    request.getMethod());
            return true;
        } catch (NullPointerException e) {
            log.error("403:{}", "权限认证失败,用户token错误或失效");
            response.getWriter().append("token invalid or timeout");
            return false;
        }
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

