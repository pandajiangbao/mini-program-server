package com.panda.animeStore.service;

import com.panda.animeStore.entity.DTO.OrderDTO;
import com.panda.animeStore.entity.VO.OrderVO;

import java.util.List;


/**
 * @author panda
 * @date 2019-03-01 20:16
 */
public interface OrderService {
    List<OrderVO> getOrderVOListByUserId(Integer userId);
    OrderVO getOrderVOById(Integer Id);
    Integer getOrderTotal();
    Integer createOrderFromBuy(OrderDTO orderDTO);
    Integer createOrderFromShoppingCart(OrderDTO orderDTO);
    Boolean deleteOrder(Integer id);
}
