package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private Integer id;

    @NotNull(message = "收货人不能为空")
    private String receiver;

    @NotNull(message = "联系电话不能为空")
    private String phoneNumber;

    private String province;

    private String city;

    private String county;

    @NotNull(message = "住址细节不能为空")
    private String detail;

    @NotNull(message = "用户id不能为空")
    private Integer userId;
}