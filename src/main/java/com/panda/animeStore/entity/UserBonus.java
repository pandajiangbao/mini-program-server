package com.panda.animeStore.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBonus {
    private Integer id;

    private BigDecimal reduceAmount;

    private BigDecimal targetAmount;

    private Date outdateTime;

    private Integer categoryId;

    private Integer userId;
}