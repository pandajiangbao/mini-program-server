package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.service.UserAddressService;
import com.panda.animeStore.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<UserAddress> getUserAddressList(@PathVariable Integer userId) {
        return userAddressService.listUserAddressByUserId(userId);
    }

    @PostMapping("/userAddresses")
    public void addUserAddresses(@RequestBody UserAddress userAddress) {
        Result.status(userAddressService.addUserAddress(userAddress));
    }

    @PutMapping("/userAddresses")
    public void updateAddress(@RequestBody UserAddress userAddress) {
        Result.status(userAddressService.updateUserAddress(userAddress));
    }

    @DeleteMapping("/users/{userId}/userAddresses")
    public void deleteUserAllAddress(@PathVariable Integer userId) {
        Result.status(userAddressService.deleteAllUserAddressByUserId(userId));
    }

    @DeleteMapping("/userAddresses/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        Result.status(userAddressService.deleteUserAddress(id));
    }
}
