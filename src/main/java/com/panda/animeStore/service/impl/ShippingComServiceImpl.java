package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.ShippingCom;
import com.panda.animeStore.mapper.ShippingComMapper;
import com.panda.animeStore.service.ShippingComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-12 8:59 AM
 */
@Service
public class ShippingComServiceImpl implements ShippingComService {
	@Autowired
	private ShippingComMapper shippingComMapper;
	@Override
	public List<ShippingCom> getShippingComList() {
		return shippingComMapper.selectAll();
	}

	@Override
	public ShippingCom getShippingComListById(Integer id) {
		return shippingComMapper.selectByPrimaryKey(id);
	}
}
