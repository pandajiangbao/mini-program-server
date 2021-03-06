package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShoppingCart;
import com.panda.animeStore.entity.VO.ShoppingCartVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author panda
 * @date 2019-02-21 18:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ShoppingCartMapperTest {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void selectVOByUserId() {
        List<ShoppingCartVO> shoppingCartVOList = shoppingCartMapper.selectVOByUserId(1);
        shoppingCartVOList.forEach(System.out::println);
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(34);
        shoppingCart.setProductAmount(1);
        shoppingCartMapper.updateByPrimaryKey(shoppingCart);
    }
}