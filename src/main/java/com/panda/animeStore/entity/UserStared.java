package com.panda.animeStore.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStared {
    private Integer id;

    private Integer userId;

    private Integer productId;

    private Date staredTime;
}