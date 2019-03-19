package com.panda.animeStore.controller;

import com.panda.animeStore.entity.DTO.ShoppingCartBatch;
import com.panda.animeStore.entity.ShoppingCart;
import com.panda.animeStore.entity.VO.ShoppingCartVO;
import com.panda.animeStore.service.ShoppingCartService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-21 16:13
 */
@RestController
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/shoppingCarts/{id}")
    public ShoppingCart getShoppingCartById(@PathVariable Integer id) {
        Result.data();
        return shoppingCartService.getShoppingCartById(id);
    }

    @GetMapping("/user/{userId}/shoppingCarts")
    public List<ShoppingCartVO> getShoppingCartVOListByUserId(@PathVariable Integer userId) {
        Result.data();
        return shoppingCartService.getShoppingCartVOListByUserId(userId);
    }

    @PostMapping("/shoppingCarts")
    public ResponseEntity<String> addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return Result.status(shoppingCartService.addShoppingCart(shoppingCart));
    }

    @PutMapping("/shoppingCarts/{id}")
    public ResponseEntity<String> updateShoppingCart(@PathVariable Integer id, @RequestBody ShoppingCart shoppingCart) {
        return Result.status(shoppingCartService.updateShoppingCartById(id, shoppingCart));
    }

    @PutMapping("/shoppingCarts")
    public ResponseEntity<String> updateShoppingCartBatch(@RequestBody ShoppingCartBatch shoppingCartBatch) {
        return Result.status(shoppingCartService.updateShoppingCartBatch(shoppingCartBatch.getShoppingCartVOList()
        ));
    }

    @DeleteMapping("/shoppingCarts/{id}")
    public ResponseEntity<String> deleteShoppingCart(@PathVariable Integer id) {
        return Result.status(shoppingCartService.deleteShoppingCartById(id));
    }
}
