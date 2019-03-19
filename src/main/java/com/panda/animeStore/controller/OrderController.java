package com.panda.animeStore.controller;

import com.panda.animeStore.entity.DTO.OrderDTO;
import com.panda.animeStore.entity.VO.OrderVO;
import com.panda.animeStore.service.OrderService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-03 14:40
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/user/{userId}/orders")
    public List<OrderVO> getOrderVOList(@PathVariable Integer userId){
        Result.data();
        return orderService.getOrderVOListByUserId(userId);
    }

    @PostMapping("/orders")
    public Integer createOrder(@RequestParam(required = false,defaultValue = "false") boolean solo,@RequestBody OrderDTO orderDTO) {
        Result.data();
        if (solo){
            return orderService.createOrderFromBuy(orderDTO);
        }
        else {
            return orderService.createOrderFromShoppingCart(orderDTO);
        }
    }
}
