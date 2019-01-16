package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.User;
import com.panda.animeStore.mapper.UserMapper;
import com.panda.animeStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author panda
 * @date 2018-12-19 20:51
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public int checkUserByOpenId(String openId) {
		User user = userMapper.selectByOpenId(openId);
		if (user != null) {
			return user.getId();
		}
		return 0;
	}

	@Override
	public boolean addUser(User user) {
		if (user.getOpenid() != null && !"".equals(user.getOpenid())) {
			int result = userMapper.insert(user);
			if (result > 0) {
				return true;
			} else {
				throw new RuntimeException("插入用户信息失败");
			}
		} else {
			throw new RuntimeException("用户信息不能为空");
		}
	}
}
