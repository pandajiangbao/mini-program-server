package com.panda.animeStore.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductComment {
    private Integer id;

    private String content;

    private Date createTime;

    private Integer good;

    private Integer bad;

    private Integer productId;

    private Integer userId;
}