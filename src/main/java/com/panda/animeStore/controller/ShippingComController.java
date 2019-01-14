package com.panda.animeStore.controller;

import com.panda.animeStore.entity.ShippingCom;
import com.panda.animeStore.service.ShippingComService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
	public List<ShippingCom> getShippingComList() {
		log.info("获取快递公司列表,请求开始");
		List<ShippingCom> shippingComList = shippingComService.getShippingComList();
		shippingComList.forEach(shippingCom -> System.out.println("shippingCom = " + shippingCom));
		log.info("返回快递公司列表,请求结束");
		return shippingComList;
	}

	@GetMapping("/shippingComs/{id}")
	public ShippingCom getShippingComById(@PathVariable Integer id) {
		log.info("获取快递公司,请求开始");
		ShippingCom shippingCom = shippingComService.getShippingComListById(id);
		log.info("返回快递公司,请求结束");
		return shippingCom;
	}
}