package com.panda.animeStore.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.panda.animeStore.entity.Bonus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author panda
 * @date 2019-03-19 13:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBonusVO {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiredTime;

    private Integer bonusId;

    private Bonus bonus;

    private Integer userId;
}
