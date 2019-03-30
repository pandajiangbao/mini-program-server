package com.panda.animeStore.controller;

import com.panda.animeStore.entity.VO.UserBonusVO;
import com.panda.animeStore.service.UserBonusService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-19 16:46
 */
@RestController
@Api(value = "UserBonusApi", description = "用户优惠券相关接口")
public class UserBonusController {
    @Autowired
    private UserBonusService userBonusService;

    @ApiOperation(value = "获取用户优惠券列表")
    @GetMapping("/users/{userId}/userBonuses")
    public List<UserBonusVO> getUserBonusVOList(@PathVariable Integer userId){
        Result.data();
        return userBonusService.getUserBonusVOByUserId(userId);
    }

    @ApiOperation(value = "发放新用户优惠券", notes = "新用户第一次登陆后发放优惠券")
    @PostMapping("/users/{userId}/userBonuses/bonusToNewUser")
    public ResponseEntity<String> bonusToNewUser(@PathVariable Integer userId){
        return Result.status(userBonusService.bonusToNewUser(userId));
    }

    @ApiOperation(value = "添加用户优惠券")
    @PostMapping("/userBonuses")
    public ResponseEntity<String> addUserBonusVO(@RequestBody UserBonusVO userBonusVO) {
        return Result.status(userBonusService.addUserBonusVO(userBonusVO));
    }

    @ApiOperation(value = "删除用户优惠券")
    @DeleteMapping("/userBonuses/{id}")
    public ResponseEntity<String> deleteUserBonus(@PathVariable Integer id) {
        return Result.status(userBonusService.deleteUserBonus(id));
    }

}
