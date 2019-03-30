package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer id;

    private String adminName;

    private String password;

    private Date createTime;

    private Date lastLoginTime;
}