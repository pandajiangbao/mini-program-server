package com.panda.animeStore.service;

import com.panda.animeStore.entity.Bonus;

import java.util.List;

/**
 * @author panda
 * @date 2019-03-19 20:06
 */
public interface BonusService {
    List<Bonus> getBonusAll();
    boolean addBonus(Bonus bonus);
    boolean deleteBonus(Integer id);
}
