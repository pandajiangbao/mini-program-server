package com.panda.animeStore.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.panda.animeStore.entity.Product;
import com.panda.animeStore.util.CustomBigDecimalSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author panda
 * @date 2019-01-29 12:53 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartVO {
    private Integer id;

    private Integer userId;

    private Integer productAmount;

    @JsonSerialize(using = CustomBigDecimalSerialize.class)
    private BigDecimal priceSum;

    private Boolean isSelected;

    private Integer productId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    private Product product;
}
