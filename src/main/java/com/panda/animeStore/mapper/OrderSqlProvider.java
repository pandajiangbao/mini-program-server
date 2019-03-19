package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Order;
import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {

    public String insertSelective(Order record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("`order`");
        
        if (record.getOrderNo() != null) {
            sql.VALUES("order_no", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductPrice() != null) {
            sql.VALUES("product_price", "#{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getShippingPrice() != null) {
            sql.VALUES("shipping_price", "#{shippingPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getBonusPrice() != null) {
            sql.VALUES("bonus_price", "#{bonusPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.VALUES("total_price", "#{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAddressId() != null) {
            sql.VALUES("address_id", "#{addressId,jdbcType=INTEGER}");
        }
        
        if (record.getShippingComId() != null) {
            sql.VALUES("shipping_com_id", "#{shippingComId,jdbcType=INTEGER}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.VALUES("receive_time", "#{receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.VALUES("order_status", "#{orderStatus,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Order record) {
        SQL sql = new SQL();
        sql.UPDATE("order");
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getShippingPrice() != null) {
            sql.SET("shipping_price = #{shippingPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getBonusPrice() != null) {
            sql.SET("bonus_price = #{bonusPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalPrice() != null) {
            sql.SET("total_price = #{totalPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getAddressId() != null) {
            sql.SET("address_id = #{addressId,jdbcType=INTEGER}");
        }
        
        if (record.getShippingComId() != null) {
            sql.SET("shipping_com_id = #{shippingComId,jdbcType=INTEGER}");
        }
        
        if (record.getReceiveTime() != null) {
            sql.SET("receive_time = #{receiveTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOrderStatus() != null) {
            sql.SET("order_status = #{orderStatus,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}