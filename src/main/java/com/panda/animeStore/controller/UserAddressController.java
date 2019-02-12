package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.service.UserAddressService;
import com.panda.animeStore.util.ResJson;
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

    @GetMapping("/{userId}")
    public ResJson getUserAddressList(@PathVariable Integer userId) {
        log.info("获取用户地址列表,请求开始");
        List<UserAddress> userAddressList = userAddressService.listUserAddressByUserId(userId);
        log.info("返回用户地址列表,请求结束");
        return ResJson.result(userAddressList);
    }

    @PostMapping
    public ResJson addUserAddresses(@RequestBody UserAddress userAddress) {
        log.info("添加用户地址,请求开始");
        if (userAddressService.addUserAddress(userAddress)) {
            return ResJson.success("addUserAddresses");
        } else {
            return ResJson.failed("addUserAddresses");
        }
    }

    @PutMapping
    public ResJson updateAddress(@RequestBody UserAddress userAddress) {
        log.info("修改用户地址,请求开始");
        if (userAddressService.updateUserAddress(userAddress)) {
            return ResJson.success("updateAddress");
        } else {
            return ResJson.failed("updateAddress");
        }
    }

    @DeleteMapping("/{id}")
    public ResJson deleteAddress(@PathVariable Integer id, @RequestParam String state) {
        if (state.equals("id")) {
            log.info("删除用户地址,请求开始");
            if (userAddressService.deleteUserAddress(id)) {
                return ResJson.success("deleteAddress");
            } else {
                return ResJson.failed("deleteAddress");
            }
        } else if (state.equals("userId")) {
            log.info("删除该用户下所有地址,请求开始");
            if (userAddressService.deleteAllUserAddressByUserId(id)) {
                return ResJson.success("deleteAddress");
            } else {
                return ResJson.failed("deleteAddress");
            }
        } else {
            throw new RuntimeException("请设置删除用户地址id参数的状态");
        }
    }
}
