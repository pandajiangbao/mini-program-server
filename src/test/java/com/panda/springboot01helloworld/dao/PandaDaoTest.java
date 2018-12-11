package com.panda.springboot01helloworld.dao;

import com.panda.springboot01helloworld.entity.Panda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author panda
 * @date 2018-12-10 0:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PandaDaoTest {
    @Autowired
    private PandaDao pandaDao;
    @Test
    public void deleteByPrimaryKey() {
        int result7=pandaDao.deleteByPrimaryKey(7);
        int result8=pandaDao.deleteByPrimaryKey(8);
        int result9=pandaDao.deleteByPrimaryKey(9);
        System.out.println("result7 = " + result7);
        System.out.println("result8 = " + result8);
        System.out.println("result9 = " + result9);
    }

    @Test
    public void insert() {
        Panda panda=new Panda();
        panda.setTitle("panda12");
        panda.setDate(new Date());
        panda.setUrl("/static/image/index/panda5.JPG");
        panda.setDetail("你好");
        int result=pandaDao.insert(panda);
        System.out.println("result = " + result);
        System.out.println(panda.getId());
    }

    @Test
    public void selectByPrimaryKey() {
        Panda panda=pandaDao.selectByPrimaryKey(11);
        System.out.println("panda = " + panda);
    }

    @Test
    public void selectAll() {
        List<Panda> pandaList=pandaDao.selectAll();
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
        int result= pandaDao.updateByPrimaryKey(panda);
        System.out.println("result = " + result);

    }
}