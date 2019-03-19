package com.panda.animeStore.controller;

import com.panda.animeStore.entity.DTO.ShoppingCartBatch;
import com.panda.animeStore.entity.ShoppingCart;
import com.panda.animeStore.entity.VO.ShoppingCartVO;
import com.panda.animeStore.service.ShoppingCartService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-21 16:13
 */
@RestController
@Api(value = "ShoppingCartApi", description = "购物车相关接口")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation(value = "获取单个购物车")
    @GetMapping("/shoppingCarts/{id}")
    public ShoppingCart getShoppingCartById(@PathVariable Integer id) {
        Result.data();
        return shoppingCartService.getShoppingCartById(id);
    }

    @ApiOperation(value = "获取用户购物车列表")
    @GetMapping("/user/{userId}/shoppingCarts")
    public List<ShoppingCartVO> getShoppingCartVOListByUserId(@PathVariable Integer userId) {
        Result.data();
        return shoppingCartService.getShoppingCartVOListByUserId(userId);
    }

    @ApiOperation(value = "添加购物车")
    @PostMapping("/shoppingCarts")
    public ResponseEntity<String> addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return Result.status(shoppingCartService.addShoppingCart(shoppingCart));
    }

    @ApiOperation(value = "修改购物车")
    @PutMapping("/shoppingCarts/{id}")
    public ResponseEntity<String> updateShoppingCart(@PathVariable Integer id, @RequestBody ShoppingCart shoppingCart) {
        return Result.status(shoppingCartService.updateShoppingCartById(id, shoppingCart));
    }

    @ApiOperation(value = "批量修改购物车")
    @PutMapping("/shoppingCarts")
    public ResponseEntity<String> updateShoppingCartBatch(@RequestBody ShoppingCartBatch shoppingCartBatch) {
        return Result.status(shoppingCartService.updateShoppingCartBatch(shoppingCartBatch.getShoppingCartVOList()
        ));
    }

    @ApiOperation(value = "删除单个购物车")
    @DeleteMapping("/shoppingCarts/{id}")
    public ResponseEntity<String> deleteShoppingCart(@PathVariable Integer id) {
        return Result.status(shoppingCartService.deleteShoppingCartById(id));
    }
}
