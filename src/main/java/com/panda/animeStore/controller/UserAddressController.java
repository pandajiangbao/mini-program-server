package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.service.UserAddressService;
import com.panda.animeStore.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-13 10:08 PM
 */
@RestController
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/users/{userId}/userAddresses")
    public List<UserAddress> getUserAddressList(@PathVariable Integer userId) {
        Result.data();
        return userAddressService.listUserAddressByUserId(userId);
    }

    @PostMapping("/userAddresses")
    public ResponseEntity<String> addUserAddresses(@RequestBody UserAddress userAddress) {
        return Result.status(userAddressService.addUserAddress(userAddress));
    }

    @PutMapping("/userAddresses")
    public ResponseEntity<String> updateAddress(@RequestBody UserAddress userAddress) {
        return Result.status(userAddressService.updateUserAddress(userAddress));
    }

    @DeleteMapping("/users/{userId}/userAddresses")
    public ResponseEntity<String> deleteUserAllAddress(@PathVariable Integer userId) {
        return Result.status(userAddressService.deleteAllUserAddressByUserId(userId));
    }

    @DeleteMapping("/userAddresses/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id) {
        return Result.status(userAddressService.deleteUserAddress(id));
    }
}
