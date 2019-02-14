package com.panda.animeStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;

    private String title;

    @Min(value = 0,message = "价格必须大于0")
    private BigDecimal price;

    private Integer sales;

    private Integer stock;

    private String img;

    private Integer categoryId;
}