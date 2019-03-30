package com.panda.animeStore.controller;

import com.panda.animeStore.entity.DTO.OrderDTO;
import com.panda.animeStore.entity.VO.OrderVO;
import com.panda.animeStore.service.OrderService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panda
 * @date 2019-03-03 14:40
 */
@RestController
@Api(value = "OrderApi", description = "订单相关接口")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "获取用户订单列表")
    @GetMapping("/users/{userId}/orders")
    public List<OrderVO> getOrderVOList(@PathVariable Integer userId){
        Result.data();
        return orderService.getOrderVOListByUserId(userId);
    }

    @ApiOperation(value = "获取用户订单总数")
    @GetMapping("/orders/total")
    public String getOrderTotal(){
        Map<String,Integer> map=new HashMap<>();
        map.put("total",orderService.getOrderTotal());
        Result.data();
        return map.toString();
    }

    @ApiOperation(value = "创建订单")
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
