package com.panda.animeStore.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author panda
 * @date 2019-02-12 14:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private String token;
    private Integer userId;
    private Boolean isNew;
}
