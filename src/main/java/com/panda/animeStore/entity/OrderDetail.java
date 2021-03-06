package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private Integer productId;

    private String productTitle;

    private Integer productAmount;

    private String productImg;

    private BigDecimal productSinglePrice;

    private BigDecimal productTotalPrice;
}