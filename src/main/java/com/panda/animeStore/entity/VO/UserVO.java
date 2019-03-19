package com.panda.animeStore.entity.VO;

import com.panda.animeStore.entity.UserAddress;
import com.panda.animeStore.entity.UserStar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author panda
 * @date 2019-01-29 12:52 AM
 * 用户视图对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    //用户id
    private Integer userId;

    //用户地址列表
    private List<UserAddress> userAddressList;

    //用户收藏列表
    private List<UserStar> userStarList;
}
