package com.panda.animeStore.entity.VO;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.entity.UserBonus;
import com.panda.animeStore.entity.UserStared;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-29 12:52 AM
 * 用户视图对象
 */
public class UserVO {

    //用户id
    private Integer userId;

    //用户地址列表
    private List<UserAddress> userAddressList;

    //用户优惠券列表
    private List<UserBonus> userBonusList;

    //用户收藏列表
    private List<UserStared> userStaredList;
}
