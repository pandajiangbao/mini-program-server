package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author panda
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private Integer id;

    @NotBlank(message = "收货人不能为空")
    private String receiver;

	@NotBlank(message = "电话号码不能为空")
    private String phoneNumber;

    private String province;

    private String city;

    private String county;

    private String detail;

    @NotEmpty(message = "所属用户不能为空")
    private Integer userId;
}