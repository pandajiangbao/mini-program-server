package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.Bonus;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.BonusMapper;
import com.panda.animeStore.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-19 20:17
 */
@Service
public class BonusServiceImpl implements BonusService {
    @Autowired
    private BonusMapper bonusMapper;

    @Override
    public List<Bonus> getBonusAll() {
        return bonusMapper.selectAll();
    }

    @Override
    public boolean addBonus(Bonus bonus) {
        int result = bonusMapper.insertSelective(bonus);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public boolean deleteBonus(Integer id) {
        int result = bonusMapper.deleteByPrimaryKey(id);
        if (result > 0) {
            return true;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }
}
