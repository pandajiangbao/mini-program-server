package com.panda.animeStore.dao;

import com.panda.animeStore.entity.Panda;
import com.panda.animeStore.mapper.PandaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author panda
 * @date 2018-12-10 0:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PandaMapperTest {
    @Autowired
    private PandaMapper pandaMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Test
    public void deleteByPrimaryKey() {
        int result7=pandaMapper.deleteByPrimaryKey(7);
        int result8=pandaMapper.deleteByPrimaryKey(8);
        int result9=pandaMapper.deleteByPrimaryKey(9);
        System.out.println("result7 = " + result7);
        System.out.println("result8 = " + result8);
        System.out.println("result9 = " + result9);
    }

    @Test
    public void insert() {
        Panda panda=new Panda();
        panda.setTitle("panda13");
        panda.setDate(new Date());
        panda.setUrl("/static/image/index/panda5.JPG");
        panda.setDetail("你好");
        int result=pandaMapper.insert(panda);
        System.out.println("result = " + result);
        System.out.println(panda.getId());
    }

    @Test
    public void selectByPrimaryKey() {
        Panda panda=pandaMapper.selectByPrimaryKey(11);
        System.out.println("panda = " + panda);
    }

    @Test
    public void selectAll() {
        List<Panda> pandaList=pandaMapper.selectAll();
        pandaList.forEach(panda -> System.out.println(panda));
    }

    @Test
    public void updateByPrimaryKey() {
        Panda panda=new Panda();
        panda.setId(11);
        panda.setTitle("panda11");
        panda.setUrl("/static/image/index/panda5.JPG");
        panda.setDate(new Date());
        panda.setDetail("你好,胖达酱!");
        int result= pandaMapper.updateByPrimaryKey(panda);
        System.out.println("result = " + result);

    }

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("aaa", "111");
        System.out.println(redisTemplate.opsForValue().get("aaa"));
    }
}