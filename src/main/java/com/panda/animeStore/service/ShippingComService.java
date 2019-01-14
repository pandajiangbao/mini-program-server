package com.panda.animeStore.service;

import com.panda.animeStore.entity.ShippingCom;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-12 8:56 AM
 */
public interface ShippingComService {
	List<ShippingCom> getShippingComList();
	ShippingCom getShippingComListById(Integer id);
}
