package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Order;
import com.panda.animeStore.entity.VO.OrderVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author panda
 * @date 2019-03-03 12:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    void deleteByPrimaryKey() {
        orderMapper.deleteByPrimaryKey(2);
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
        Order order = new Order();
        order.setOrderNo(UUID.randomUUID().toString());
        order.setUserId(1);
        order.setProductPrice(new BigDecimal(790.00));
        order.setShippingPrice(new BigDecimal(10.00));
        order.setBonusPrice(new BigDecimal(20.00));
        order.setTotalPrice(new BigDecimal(800.00));
        order.setAddressId(1);
        order.setShippingComId(2);
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        order.setReceiveTime(date);
        System.out.println(order);
        int result = orderMapper.insertSelective(order);
    }

    @Test
    void selectByUserId() {
        List<OrderVO> orderVOList=orderMapper.selectVOByUserId(1);
        orderVOList.forEach(System.out::println);

    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}