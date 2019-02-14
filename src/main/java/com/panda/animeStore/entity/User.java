package com.panda.animeStore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    private String openid;

    private String nickName;

    private Integer gender;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}