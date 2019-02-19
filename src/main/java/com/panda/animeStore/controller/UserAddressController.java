package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.service.UserAddressService;
import com.panda.animeStore.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author panda
 * @date 2019-01-13 10:08 PM
 */
@Slf4j
@RestController
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/users/{userId}/userAddresses")
    public Object getUserAddressList(@PathVariable Integer userId) {
        return Result.data(userAddressService.listUserAddressByUserId(userId));
    }

    @PostMapping("/userAddresses")
    public Object addUserAddresses(@RequestBody UserAddress userAddress) {
        return Result.status(userAddressService.addUserAddress(userAddress));
    }

    @PutMapping("/userAddresses")
    public Object updateAddress(@RequestBody UserAddress userAddress) {
        return Result.status(userAddressService.updateUserAddress(userAddress));
    }

    @DeleteMapping("/users/{userId}/userAddresses")
    public Object deleteUserAllAddress(@PathVariable Integer userId) {
        return Result.status(userAddressService.deleteAllUserAddressByUserId(userId));
    }

    @DeleteMapping("/userAddresses/{id}")
    public Object deleteAddress(@PathVariable Integer id) {
        return Result.status(userAddressService.deleteUserAddress(id));
    }
}
