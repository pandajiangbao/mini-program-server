package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserStar;
import com.panda.animeStore.service.UserStarService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 18:15
 */
@RestController
public class UserStarController {
    @Autowired
    private UserStarService userStarService;

    @GetMapping("/users/{userId}/userStars")
    public List<UserStar> getUserAddressList(@PathVariable Integer userId) {
        return userStarService.getUserStarByUserId(userId);
    }

    @PostMapping("/userStars")
    public void addProduct(@RequestBody UserStar userStar) {
        Result.status(userStarService.addUserStar(userStar));
    }

    @DeleteMapping("/userStars/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        Result.status(userStarService.deleteUserStar(id));
    }
}
