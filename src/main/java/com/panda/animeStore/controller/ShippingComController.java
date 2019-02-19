package com.panda.animeStore.controller;

import com.panda.animeStore.service.ShippingComService;
import com.panda.animeStore.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panda
 * @date 2019-01-12 12:23 AM
 */
@Slf4j
@RestController
public class ShippingComController {
	@Autowired
	private ShippingComService shippingComService;

	@GetMapping("/shippingComs")
	public Object getShippingComList() {
		return Result.data(shippingComService.getShippingComList());
	}

	@GetMapping("/shippingComs/{id}")
	public Object getShippingComById(@PathVariable Integer id) {
		return Result.data(shippingComService.getShippingComListById(id));
	}
}
