package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.mapper.UserAddressMapper;
import com.panda.animeStore.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-13 9:09 PM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserAddressServiceImpl implements UserAddressService {
	@Autowired
	private UserAddressMapper userAddressMapper;

	@Override
	public List<UserAddress> listUserAddressByUserId(Integer userId) {
		return userAddressMapper.selectListByUserId(userId);
	}

	@Override
	public boolean addUserAddress(UserAddress userAddress) {
		int result = userAddressMapper.insertSelective(userAddress);
		if (result > 0) {
			return true;
		} else {
			throw new RuntimeException("插入用户地址失败");
		}
	}

	@Override
	public boolean updateUserAddressById(Integer id,UserAddress userAddress) {
		if (id != null) {
			userAddress.setId(id);
			int result = userAddressMapper.updateByPrimaryKeySelective(userAddress);
			if (result > 0) {
				return true;
			} else {
				throw new RuntimeException("更新用户地址失败");
			}
		} else {
			throw new RuntimeException("用户地址id不能为空");
		}
	}

	@Override
	public boolean deleteUserAddress(Integer id) {
		if (id != null) {
			int result = userAddressMapper.deleteByPrimaryKey(id);
			if (result > 0) {
				return true;
			} else {
				throw new RuntimeException("删除用户地址失败");
			}
		} else {
			throw new RuntimeException("删除地址所需id不能为空");
		}
	}

	@Override
	public boolean deleteAllUserAddressByUserId(Integer userId) {
		if (userId != null) {
			int result = userAddressMapper.deleteAllByUserId(userId);
			if (result > 0) {
				return true;
			} else {
				throw new RuntimeException("删除用户所有地址失败");
			}
		} else {
			throw new RuntimeException("删除用户所有地址所需用户id不能为空");
		}
	}
}
