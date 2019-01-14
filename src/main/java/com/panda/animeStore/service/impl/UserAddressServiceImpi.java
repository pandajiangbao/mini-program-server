package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.mapper.UserAddressMapper;
import com.panda.animeStore.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-13 9:09 PM
 */
@Service
public class UserAddressServiceImpi implements UserAddressService {
	@Autowired
	private UserAddressMapper userAddressMapper;

	@Override
	public List<UserAddress> getUserAddressListByUserId(Integer userId) {
		return userAddressMapper.selectListByUserId(userId);
	}

	@Override
	public boolean addUserAddress(UserAddress userAddress) {
		try {
			int result = userAddressMapper.insertSelective(userAddress);
			if (result > 0) {
				return true;
			} else {
				throw new RuntimeException("插入用户地址失败");
			}
		} catch (Exception e) {
			throw new RuntimeException("插入用户地址失败" + e.getMessage());
		}
	}

	@Override
	public boolean updateUserAddress(UserAddress userAddress) {
		if (ObjectUtils.isEmpty(userAddress)) {
			try {
				int result = userAddressMapper.updateByPrimaryKeySelective(userAddress);
				if (result > 0) {
					return true;
				} else {
					throw new RuntimeException("更新用户地址失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("更新用户地址失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("用户地址id不能为空");
		}
	}

	@Override
	public boolean deleteUserAddress(Integer id) {
		if (id != null) {
			try {
				int result = userAddressMapper.deleteByPrimaryKey(id);
				if (result > 0) {
					return true;
				} else {
					throw new RuntimeException("删除用户地址失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除用户地址失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("删除地址所需id不能为空");
		}
	}

	@Override
	public boolean deleteAllUserAddressByUserId(Integer userId) {
		if (userId != null) {
			try {
				int result = userAddressMapper.deleteAllByUserId(userId);
				if (result > 0) {
					return true;
				} else {
					throw new RuntimeException("删除用户所有地址失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除用户所有地址失败" + e.getMessage());
			}
		} else {
			throw new RuntimeException("删除用户所有地址所需用户id不能为空");
		}
	}
}
