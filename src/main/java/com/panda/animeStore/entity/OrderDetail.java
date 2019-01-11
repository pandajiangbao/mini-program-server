package com.panda.animeStore.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    private Integer id;

    private Integer orderId;

    private Integer productId;

    private Integer productAmout;

    private BigDecimal productSinglePrice;

    private BigDecimal productTotalPrice;
}