package com.panda.animeStore.service.impl;

import com.panda.animeStore.entity.DTO.OrderDTO;
import com.panda.animeStore.entity.Order;
import com.panda.animeStore.entity.OrderDetail;
import com.panda.animeStore.entity.ShoppingCart;
import com.panda.animeStore.entity.VO.OrderVO;
import com.panda.animeStore.exceptionHandler.error.BusinessError;
import com.panda.animeStore.mapper.OrderDetailMapper;
import com.panda.animeStore.mapper.OrderMapper;
import com.panda.animeStore.mapper.ProductMapper;
import com.panda.animeStore.mapper.ShoppingCartMapper;
import com.panda.animeStore.service.OrderService;
import com.panda.animeStore.service.ProductService;
import com.panda.animeStore.service.ShoppingCartService;
import com.panda.animeStore.service.UserBonusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author panda
 * @date 2019-03-01 20:46
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserBonusService userBonusService;

    @Override
    public List<OrderVO> getOrderVOListByUserId(Integer userId) {
        return orderMapper.selectVOByUserId(userId);
    }

    @Override
    public OrderVO getOrderVOById(Integer Id) {
        return null;
    }

    @Override
    public Integer getOrderTotal() {
        return orderMapper.countTotal();
    }

    @Override
    public Integer createOrderFromBuy(OrderDTO orderDTO) {
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        //扣除优惠券
        if(orderDTO.getUserBonusId()!=null){
            userBonusService.deleteUserBonus(orderDTO.getUserBonusId());
        }
        //减库存
        orderDetailList.forEach(orderDetail -> {
            if (!productService.handleAmount(orderDetail.getProductId(), orderDetail.getProductAmount())) {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        });
        Order order = convertFromOrderDTO(orderDTO);
        //生成订单号
        String orderNo = UUID.randomUUID().toString();
        order.setOrderNo(orderNo);
        //送达时间
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        order.setReceiveTime(date);
        int result = orderMapper.insertSelective(order);
        if (result > 0) {
            int orderId = order.getId();
            orderDetailList.forEach(orderDetail -> {
                orderDetail.setOrderId(orderId);
                if (orderDetailMapper.insertSelective(orderDetail) == 0) {
                    throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
                }
            });
            return orderId;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public Integer createOrderFromShoppingCart(OrderDTO orderDTO) {
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        //扣除优惠券
        if(orderDTO.getUserBonusId()!=null){
            userBonusService.deleteUserBonus(orderDTO.getUserBonusId());

        }
        //减库存
        orderDetailList.forEach(orderDetail -> {
            if (!productService.handleAmount(orderDetail.getProductId(), orderDetail.getProductAmount())) {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }

        });
        List<ShoppingCart> shoppingCartList = orderDTO.getShoppingCartList();
        //删除相应购物车
        shoppingCartList.forEach(shoppingCart -> {
            if (!shoppingCartService.deleteShoppingCartById(shoppingCart.getId())) {
                throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
            }
        });
        Order order = convertFromOrderDTO(orderDTO);
        //生成订单号
        String orderNo = UUID.randomUUID().toString();
        order.setOrderNo(orderNo);
        //送达时间
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        order.setReceiveTime(date);
        int result = orderMapper.insertSelective(order);
        if (result > 0) {
            int orderId = order.getId();
            orderDetailList.forEach(orderDetail -> {
                orderDetail.setOrderId(orderId);
                if (orderDetailMapper.insertSelective(orderDetail) == 0) {
                    throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
                }
            });
            return orderId;
        } else {
            throw new RuntimeException(BusinessError.DATA_ACCESS_ERROR.getErrMsg());
        }
    }

    @Override
    public Boolean deleteOrder(Integer id) {
        return false;
    }

    private Order convertFromOrderDTO(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        return order;
    }

    private Order convertFromOrderVO(OrderVO orderVO) {
        if (orderVO == null) {
            return null;
        }
        Order order = new Order();
        BeanUtils.copyProperties(orderVO, order);
        return order;
    }
}
