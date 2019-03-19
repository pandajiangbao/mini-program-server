package com.panda.animeStore.service;

import com.panda.animeStore.entity.UserAddress;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-12 10:34 AM
 */
public interface UserAddressService {
	List<UserAddress> listUserAddressByUserId(Integer userId);
	boolean addUserAddress(UserAddress userAddress);
	boolean updateUserAddressById(Integer id,UserAddress userAddress);
	boolean deleteUserAddress(Integer id);
	boolean deleteAllUserAddressByUserId(Integer userId);
}
