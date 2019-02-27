package com.panda.animeStore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.panda.animeStore.util.CustomBigDecimalSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
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

    @Min(value = 1,message = "商品数量不能少于1")
    private Integer productAmount;

    @JsonSerialize(using = CustomBigDecimalSerialize.class)
    private BigDecimal priceSum;

    private Boolean isSelected;

    private Integer productId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
}