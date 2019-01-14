package com.panda.animeStore.controller;

import com.google.gson.JsonObject;
import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-13 10:08 PM
 */
@Slf4j
@RestController
public class UserAddressController {
	@Autowired
	private UserAddressService userAddressService;

	@GetMapping("/userAddresses/{userId}")
	public List<UserAddress> getUserAddressList(@PathVariable Integer userId){
		log.info("获取用户地址列表,请求开始");
		List<UserAddress> userAddressList=userAddressService.getUserAddressListByUserId(userId);
		log.info("返回用户地址列表,请求结束");
		return userAddressList;
	}

	@PostMapping("/userAddresses")
	public String addUserAddresses(@RequestBody UserAddress userAddress){
		log.info("添加用户地址,请求开始");
		JsonObject res=new JsonObject();
		System.out.println("userAddress = " + userAddress);
		if (userAddressService.addUserAddress(userAddress)){
			res.addProperty("status","success");
			res.addProperty("message","添加成功");
			log.info("添加成功,请求结束");
		}
		else {
			res.addProperty("status","failed");
			res.addProperty("message","添加失败");
			log.error("添加失败,请求结束");
		}
		return res.toString();
	}

	@PutMapping("userAddresses")
	public String updateAddress(@RequestBody UserAddress userAddress){
		log.info("修改用户地址,请求开始");
		JsonObject res=new JsonObject();
		if (userAddressService.updateUserAddress(userAddress)){
			res.addProperty("status","success");
			res.addProperty("message","修改成功");
			log.info("修改成功,请求结束");
		}
		else {
			res.addProperty("status","failed");
			res.addProperty("message","修改失败");
			log.error("修改失败,请求结束");
		}
		return res.toString();
	}

	@DeleteMapping("userAddresses/{id}")
	public String deleteAddress(@PathVariable Integer id){
		log.info("删除用户地址,请求开始");
		JsonObject res=new JsonObject();
		if (userAddressService.deleteUserAddress(id)){
			res.addProperty("status","success");
			res.addProperty("message","删除成功");
			log.info("删除成功,请求结束");
		}
		else {
			res.addProperty("status","failed");
			res.addProperty("message","删除失败");
			log.error("删除失败,请求结束");
		}
		return res.toString();
	}
}
