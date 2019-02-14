package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.service.UserAddressService;
import com.panda.animeStore.util.ResultJson;
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
@RequestMapping("/userAddresses")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/users/{userId}")
    public ResultJson getUserAddressList(@PathVariable Integer userId) {
        List<UserAddress> userAddressList = userAddressService.listUserAddressByUserId(userId);
        return ResultJson.result(userAddressList);
    }

    @PostMapping
    public ResultJson addUserAddresses(@RequestBody UserAddress userAddress) {
        if (userAddressService.addUserAddress(userAddress)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }

    @PutMapping
    public ResultJson updateAddress(@RequestBody UserAddress userAddress) {
        if (userAddressService.updateUserAddress(userAddress)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }

    @DeleteMapping("/{id}")
    public ResultJson deleteAddress(@PathVariable Integer id) {
        if (userAddressService.deleteUserAddress(id)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }

    @DeleteMapping("/users/{userId}")
    public ResultJson deleteUserAllAddress(@PathVariable Integer userId){
        if (userAddressService.deleteAllUserAddressByUserId(userId)) {
            return ResultJson.success();
        } else {
            return ResultJson.failed();
        }
    }
}
