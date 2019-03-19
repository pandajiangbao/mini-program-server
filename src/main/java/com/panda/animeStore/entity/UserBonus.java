package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBonus {
    private Integer id;

    private Date createdTime;

    private Date expiredTime;

    private Integer bonusId;

    private Integer userId;
}