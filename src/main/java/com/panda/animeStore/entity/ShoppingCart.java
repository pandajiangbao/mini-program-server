package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author panda
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private Integer id;

    private Integer userId;

    private Integer productAmount;

    private BigDecimal priceSum;

    private Integer productId;

    private Date createdTime;
}