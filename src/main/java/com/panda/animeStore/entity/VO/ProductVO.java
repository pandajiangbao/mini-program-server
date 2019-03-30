package com.panda.animeStore.entity.VO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.panda.animeStore.entity.ProductCategory;
import com.panda.animeStore.entity.UserStar;
import com.panda.animeStore.util.CustomBigDecimalSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author panda
 * @date 2019-01-29 12:53 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    private Integer id;

    private String title;

    @JsonSerialize(using = CustomBigDecimalSerialize.class)
    private BigDecimal price;

    private Integer sales;

    private Integer stock;

    private String img;

    private Integer categoryId;

    private ProductCategory productCategory;

    private List<UserStar> userStarList;
}
