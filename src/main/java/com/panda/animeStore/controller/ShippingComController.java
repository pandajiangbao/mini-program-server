package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ShippingCom;
import com.panda.animeStore.service.ShippingComService;
import com.panda.animeStore.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-12 12:23 AM
 */
@RestController
@Api(value = "ShippingComApi", description = "快递公司相关接口")
public class ShippingComController {
	@Autowired
	private ShippingComService shippingComService;

    @ApiOperation(value = "获取快递公司列表")
    @GetMapping("/shippingComs")
	public List<ShippingCom> getShippingComList() {
		Result.data();
		return shippingComService.getShippingComList();
	}

    @ApiOperation(value = "获取单个快递公司")
    @GetMapping("/shippingComs/{id}")
	public ShippingCom getShippingComById(@PathVariable Integer id) {
		Result.data();
		return shippingComService.getShippingComListById(id);
	}
}
