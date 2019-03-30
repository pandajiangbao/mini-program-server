package com.panda.animeStore.service;

import com.panda.animeStore.entity.Admin;
import com.panda.animeStore.entity.VO.AdminVO;

/**
 * @author panda
 * @date 2019-03-22 18:53
 */
public interface AdminService {
   public AdminVO validateLogin(String userName, String cryptPassword);
   public Admin getAdminById(Integer id);
}
