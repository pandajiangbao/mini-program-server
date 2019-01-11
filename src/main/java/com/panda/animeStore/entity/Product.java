package com.panda.animeStore.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Integer categotyId;

    private String info;
}