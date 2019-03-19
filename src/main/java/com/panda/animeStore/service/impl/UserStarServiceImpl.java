package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.UserStar;
import com.panda.animeStore.entity.VO.UserStarVO;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.UserStarMapper;
import com.panda.animeStore.service.UserStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panda
 * @date 2019-02-18 18:09
 */
@Service
public class UserStarServiceImpl implements UserStarService {
    @Autowired
    private UserStarMapper userStarMapper;

    @Override
    public List<UserStarVO> getUserStarVOByUserId(Integer userId) {
        return userStarMapper.selectVOByUserId(userId);
    }

    @Override
    public boolean addUserStar(UserStar userStar) {
        int result = userStarMapper.insertSelective(userStar);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean deleteUserStar(Integer id) {
        if (id != null) {
            int result = userStarMapper.deleteByPrimaryKey(id);
            if (result > 0) {
                return true;
            } else {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        } else {
            throw new RuntimeException(BusinessError.PARAMETER_ERROR.getErrMsg());
        }
    }
}
