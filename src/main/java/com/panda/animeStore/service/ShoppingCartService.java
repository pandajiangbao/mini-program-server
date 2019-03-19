package com.panda.animeStore.service;

import com.panda.animeStore.entity.ShoppingCart;
import com.panda.animeStore.entity.VO.ShoppingCartVO;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-20 12:31
 */
public interface ShoppingCartService {
    ShoppingCart getShoppingCartById(Integer id);
    List<ShoppingCartVO> getShoppingCartVOListByUserId(Integer userId);
    boolean addShoppingCart(ShoppingCart shoppingCart);
    boolean updateShoppingCartById(Integer id,ShoppingCart shoppingCart);
    boolean updateShoppingCartBatch(List<ShoppingCartVO> shoppingCartVOList);
    boolean deleteShoppingCartById(Integer id);
}
