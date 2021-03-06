package com.panda.animeStore.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author panda
 * @date 2019-03-22 19:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO {
    private String token;
    private Integer id;
    private String adminName;
    private Date createTime;
    private Date lastLoginTime;
}
