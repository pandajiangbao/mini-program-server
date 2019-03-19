package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;

    private String orderNo;

    private Integer userId;

    private Date createdTime;

    private BigDecimal productPrice;

    private BigDecimal shippingPrice;

    private BigDecimal bonusPrice;

    private BigDecimal totalPrice;

    private Integer addressId;

    private Integer shippingComId;

    private Date receiveTime;

    private String orderStatus;
}