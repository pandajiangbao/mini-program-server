package com.panda.animeStore.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.panda.animeStore.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author panda
 * @date 2019-03-01 19:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date receiveTime;

    private String orderStatus;

    private List<OrderDetail> orderDetailList;
}
