package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.OrderDetail;
import com.panda.animeStore.entity.VO.OrderVO;
import com.panda.animeStore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author panda
 * @date 2019-03-03 00:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    void createOrder() {
        OrderDetail o1 = new OrderDetail();
        o1.setProductId(1);
        o1.setProductAmount(5);
        o1.setProductSinglePrice(new BigDecimal(79.00));
        o1.setProductTotalPrice(new BigDecimal(395.00));
        OrderDetail o2 = new OrderDetail();
        o2.setProductId(2);
        o2.setProductAmount(5);
        o2.setProductSinglePrice(new BigDecimal(79.00));
        o2.setProductTotalPrice(new BigDecimal(395.00));
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(o1);
        orderDetailList.add(o2);
        OrderVO orderVO = new OrderVO();
        orderVO.setUserId(1);
        orderVO.setProductPrice(new BigDecimal(790.00));
        orderVO.setShippingPrice(new BigDecimal(10.00));
        orderVO.setBonusPrice(new BigDecimal(20.00));
        orderVO.setTotalPrice(new BigDecimal(800.00));
        orderVO.setAddressId(1);
        orderVO.setShippingComId(2);
        orderVO.setOrderDetailList(orderDetailList);
        System.out.println(orderVO);
    }

    @Test
    void getOrderVOListByUserId() {
    }

    @Test
    void getOrderVOById() {
    }

    @Test
    void createOrder1() {
    }

    @Test
    void deleteOrder() {
    }
}