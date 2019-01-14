package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.OrderDetail;
import org.apache.ibatis.jdbc.SQL;

public class OrderDetailSqlProvider {

    public String insertSelective(OrderDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_detail");
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductAmount() != null) {
            sql.VALUES("product_amount", "#{productAmount,jdbcType=INTEGER}");
        }
        
        if (record.getProductSinglePrice() != null) {
            sql.VALUES("product_single_price", "#{productSinglePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductTotalPrice() != null) {
            sql.VALUES("product_total_price", "#{productTotalPrice,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("order_detail");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductAmount() != null) {
            sql.SET("product_amount = #{productAmount,jdbcType=INTEGER}");
        }
        
        if (record.getProductSinglePrice() != null) {
            sql.SET("product_single_price = #{productSinglePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductTotalPrice() != null) {
            sql.SET("product_total_price = #{productTotalPrice,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}