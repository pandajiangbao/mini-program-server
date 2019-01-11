package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private Integer id;

    private String receiver;

    private String phoneNumber;

    private String province;

    private String city;

    private String county;

    private String detail;

    private Integer userId;
}