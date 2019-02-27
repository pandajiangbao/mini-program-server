package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ShippingCom;
import com.panda.animeStore.service.ShippingComService;
import com.panda.animeStore.util.Result;
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
public class ShippingComController {
	@Autowired
	private ShippingComService shippingComService;

	@GetMapping("/shippingComs")
	public List<ShippingCom> getShippingComList() {
		Result.data();
		return shippingComService.getShippingComList();
	}

	@GetMapping("/shippingComs/{id}")
	public ShippingCom getShippingComById(@PathVariable Integer id) {
		Result.data();
		return shippingComService.getShippingComListById(id);
	}
}
