package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Bonus;
import com.panda.animeStore.entity.UserBonus;
import com.panda.animeStore.entity.VO.UserBonusVO;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.BonusMapper;
import com.panda.animeStore.mapper.UserBonusMapper;
import com.panda.animeStore.service.UserBonusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author panda
 * @date 2019-03-19 12:46
 */
@Service
public class UserBonusServiceImpl implements UserBonusService {
    @Autowired
    private BonusMapper bonusMapper;
    @Autowired
    private UserBonusMapper userBonusMapper;

    @Override
    public List<UserBonusVO> getUserBonusVOByUserId(Integer userId) {
        return userBonusMapper.selectVOByUserId(userId);
    }

    @Override
    public boolean bonusToNewUser(Integer userId) {
        for (Bonus bonus : bonusMapper.selectAll()) {
            UserBonusVO userBonusVO = new UserBonusVO();
            userBonusVO.setUserId(userId);
            userBonusVO.setBonusId(bonus.getId());
            userBonusVO.setBonus(bonus);
            if (!addUserBonusVO(userBonusVO)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addUserBonusVO(UserBonusVO userBonusVO) {
        UserBonus userBonus = convertFromUserBonusVO(userBonusVO);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, userBonusVO.getBonus().getValidity());
        userBonus.setExpiredTime(calendar.getTime());
        int result = userBonusMapper.insertSelective(userBonus);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean deleteUserBonus(Integer id) {
        int result = userBonusMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    private UserBonus convertFromUserBonusVO(UserBonusVO userBonusVO) {
        if (userBonusVO == null) {
            return null;
        }
        UserBonus userBonus = new UserBonus();
        BeanUtils.copyProperties(userBonusVO, userBonus);
        return userBonus;
    }
}
