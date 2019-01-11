package com.panda.animeStore.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private Integer id;

    private Integer userId;

    private Integer productAmout;

    private BigDecimal priceSum;

    private Integer productId;

    private Date createdTime;
}