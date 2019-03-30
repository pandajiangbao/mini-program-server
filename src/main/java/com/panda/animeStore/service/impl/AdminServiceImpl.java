package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Admin;
import com.panda.animeStore.entity.VO.AdminVO;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.AdminMapper;
import com.panda.animeStore.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author panda
 * @date 2019-03-22 18:58
 */
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public AdminVO validateLogin(String userName, String cryptPassword) {
        log.info("AnimeStore管理员登陆开始");
        Admin admin = adminMapper.selectByUserName(userName);
        if (admin == null) {
            throw new RuntimeException(BusinessError.USER_NOT_EXIST.getErrMsg());
        }
        try {
            if (!cryptPassword.equals(admin.getPassword())) {
                throw new RuntimeException(BusinessError.LOGIN_FAILED.getErrMsg());
            }
        } catch (Exception e) {
            throw new RuntimeException(BusinessError.LOGIN_FAILED.getErrMsg());
        }
        log.info("登录校验成功,刷新最近登录时间");
        admin.setLastLoginTime(new Date());
        adminMapper.updateByPrimaryKeySelective(admin);
        String token = UUID.randomUUID().toString();
        log.info("生成token:{}", token);
        AdminVO adminVO = convertFromAdmin(admin);
        adminVO.setToken(token);
        log.info("存入redis,过期时间90分钟");
        redisTemplate.opsForValue().set(token, admin.getId(), 90, TimeUnit.MINUTES);
        log.info("返回token");
        return adminVO;
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    private AdminVO convertFromAdmin(Admin admin){
        if(admin==null){
            return null;
        }
        AdminVO adminVO=new AdminVO();
        BeanUtils.copyProperties(admin,adminVO);
        return adminVO;
    }
}
