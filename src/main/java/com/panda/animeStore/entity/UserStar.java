package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStar {
    private Integer id;

    private Integer userId;

    private Integer productId;

    private Date starTime;
}