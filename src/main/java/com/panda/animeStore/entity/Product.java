package com.panda.animeStore.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.panda.animeStore.util.CustomBigDecimalSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;

    private String title;

    @JsonSerialize(using = CustomBigDecimalSerialize.class)
    private BigDecimal price;

    private Integer sales;

    private Integer stock;

    private String img;

    private Integer categoryId;
}