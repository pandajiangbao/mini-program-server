package com.panda.animeStore.entity;

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

    private BigDecimal price;

    private Integer sales;

    private Integer stock;

    private String img;

    private Integer categoryId;

    private String info;
}