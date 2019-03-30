package com.panda.animeStore.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.panda.animeStore.entity.OrderDetail;
import com.panda.animeStore.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author panda
 * @date 2019-03-17 02:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;

    private String orderNo;

    private Integer userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    private BigDecimal productPrice;

    private BigDecimal shippingPrice;

    private BigDecimal bonusPrice;

    private BigDecimal totalPrice;

    private Integer addressId;

    private Integer shippingComId;

    private Date receiveTime;

    private String orderStatus;

    private Integer userBonusId;

    private List<ShoppingCart> shoppingCartList;

    private List<OrderDetail> orderDetailList;
}
