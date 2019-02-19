package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserStar;
import com.panda.animeStore.service.UserStarService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author panda
 * @date 2019-02-18 18:15
 */
@RestController
public class UserStarController {
    @Autowired
    private UserStarService userStarService;

    @GetMapping("/users/{userId}/userStars")
    public Object getUserAddressList(@PathVariable Integer userId) {
        return Result.data(userStarService.getUserStarByUserId(userId));
    }

    @PostMapping("/userStars")
    public Object addProduct(@RequestBody UserStar userStar) {
        return Result.status(userStarService.addUserStar(userStar));
    }

    @DeleteMapping("/userStars/{id}")
    public Object deleteProduct(@PathVariable Integer id) {
        return Result.status(userStarService.deleteUserStar(id));
    }
}
