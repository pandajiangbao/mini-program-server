package com.panda.animeStore.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.panda.animeStore.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author panda
 * @date 2019-03-05 21:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStarVO {
    private Integer id;

    private Integer userId;

    private Integer productId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date starTime;

    private Product product;
}
