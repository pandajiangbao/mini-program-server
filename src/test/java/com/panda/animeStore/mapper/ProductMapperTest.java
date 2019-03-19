package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-01 21:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    void test1() {
    }

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
    void selectByCategoryId() {
    }

    @Test
    void selectByQuery() {
        List<Product> productList=productMapper.selectByQuery("福袋");
        productList.forEach(System.out::println);
    }

    @Test
    void selectAll() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void handleAmount() {
    }
}