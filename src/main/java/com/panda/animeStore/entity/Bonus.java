package com.panda.animeStore.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bonus {
    private Integer id;

    private BigDecimal reduceAmount;

    private BigDecimal targetAmount;

    private Integer validity;
}