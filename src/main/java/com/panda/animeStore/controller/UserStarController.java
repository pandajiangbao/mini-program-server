package com.panda.animeStore.controller;

import com.panda.animeStore.entity.UserStar;
import com.panda.animeStore.entity.VO.UserStarVO;
import com.panda.animeStore.service.UserStarService;
import com.panda.animeStore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<UserStarVO> getUserStarList(@PathVariable Integer userId) {
        Result.data();
        return userStarService.getUserStarVOByUserId(userId);
    }

    @PostMapping("/userStars")
    public ResponseEntity<String> addUserStar(@RequestBody UserStar userStar) {
        return Result.status(userStarService.addUserStar(userStar));
    }

    @DeleteMapping("/userStars/{id}")
    public ResponseEntity<String> deleteUserStar(@PathVariable Integer id) {
        return Result.status(userStarService.deleteUserStar(id));
    }
}
