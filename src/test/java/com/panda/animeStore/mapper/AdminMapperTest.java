package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Admin;
import com.panda.animeStore.util.MD5crypt;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author panda
 * @date 2019-03-22 18:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AdminMapperTest {
    @Autowired
    AdminMapper adminMapper;

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() throws Exception {
        Admin admin = new Admin();
        admin.setAdminName("panda");
        admin.setPassword(MD5crypt.getMD5Str("panda"));
        admin.setLastLoginTime(new Date());
        System.out.println(adminMapper.insertSelective(admin));
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}