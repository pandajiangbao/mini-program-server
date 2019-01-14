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

    private Date receiveTime;

    private Integer userId;

    private Date paymentTime;

    private Date createdTime;

    private Integer shippingComId;

    private Integer addressId;

    private BigDecimal shippingPrice;

    private BigDecimal bonusPrice;

    private BigDecimal totalPrice;

    private String orderStatus;

    private BigDecimal productPrice;
}