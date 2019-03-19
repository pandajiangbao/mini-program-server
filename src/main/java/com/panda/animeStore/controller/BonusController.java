package com.panda.animeStore.controller;

import com.panda.animeStore.entity.Bonus;
import com.panda.animeStore.service.BonusService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-19 20:03
 */
@RestController
@Api(value = "BonusApi", description = "优惠券相关接口")
public class BonusController {
    @Autowired
    private BonusService bonusService;

    @ApiOperation(value = "获取所有优惠券")
    @GetMapping("/bonuses")
    public List<Bonus> getAllBonus(){
        Result.data();
        return bonusService.getBonusAll();
    }

    @ApiOperation(value = "添加优惠券")
    @PostMapping("/bonuses")
    public ResponseEntity<String> addBonus(@RequestBody Bonus bonus){
        return Result.status(bonusService.addBonus(bonus));
    }

    @ApiOperation(value = "删除优惠券")
    @PostMapping("/bonuses/{id}")
    public ResponseEntity<String> deleteBonus(Integer id){
        return Result.status(bonusService.deleteBonus(id));
    }
}
