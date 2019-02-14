package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ShippingCom;
import com.panda.animeStore.util.ResultJson;
import com.panda.animeStore.service.ShippingComService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-12 12:23 AM
 */
@Slf4j
@RestController
@RequestMapping("/shippingComs")
public class ShippingComController {
	@Autowired
	private ShippingComService shippingComService;

	@GetMapping
	public ResultJson getShippingComList() {
		List<ShippingCom> shippingComList = shippingComService.getShippingComList();
		return ResultJson.result(shippingComList);
	}

	@GetMapping("/{id}")
	public ResultJson getShippingComById(@PathVariable Integer id) {
		ShippingCom shippingCom = shippingComService.getShippingComListById(id);
		return ResultJson.result(shippingCom);
	}
}
