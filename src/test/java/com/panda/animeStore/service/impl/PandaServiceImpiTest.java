package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Panda;
import com.panda.animeStore.service.PandaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author panda
 * @date 2018-12-12 14:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PandaServiceImpiTest {
    @Autowired
    private PandaService pandaService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    @Test
    public void getPandaList() {
        List<Panda> pandaList=pandaService.getPandaList();
        pandaList.forEach(panda -> System.out.println(panda));
    }

    @Test
    public void getPandaById() {
    }

    @Test
    public void addPanda() {
    }

    @Test
    public void updatePandaById() {
    }

    @Test
    public void deletePandaById() {
    }

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("test","panda",10, TimeUnit.SECONDS);
    }
}