package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.service.UserAddressService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-13 10:08 PM
 */
@RestController
@Api(value = "UserApi", description = "地址相关接口")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @ApiOperation(value = "获取用户地址")
    @GetMapping("/users/{userId}/userAddresses")
    public List<UserAddress> getUserAddressList(@PathVariable Integer userId) {
        Result.data();
        return userAddressService.getUserAddressByUserId(userId);
    }

    @ApiOperation(value = "添加用户地址")
    @PostMapping("/userAddresses")
    public ResponseEntity<String> addUserAddresses(@RequestBody UserAddress userAddress) {
        return Result.status(userAddressService.addUserAddress(userAddress));
    }

    @ApiOperation(value = "修改用户地址")
    @PutMapping("/userAddresses/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Integer id,@RequestBody UserAddress userAddress) {
        return Result.status(userAddressService.updateUserAddressById(id,userAddress));
    }

    @ApiOperation(value = "删除用户所有地址")
    @DeleteMapping("/users/{userId}/userAddresses")
    public ResponseEntity<String> deleteUserAllAddress(@PathVariable Integer userId) {
        return Result.status(userAddressService.deleteAllUserAddressByUserId(userId));
    }

    @ApiOperation(value = "删除用户地址")
    @DeleteMapping("/userAddresses/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        return Result.status(userAddressService.deleteUserAddress(id));
    }
}
