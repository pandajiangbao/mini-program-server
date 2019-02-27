package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShoppingCart;
import org.apache.ibatis.jdbc.SQL;

public class ShoppingCartSqlProvider {

    public String insertSelective(ShoppingCart record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("shopping_cart");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getProductAmount() != null) {
            sql.VALUES("product_amount", "#{productAmount,jdbcType=INTEGER}");
        }
        
        if (record.getPriceSum() != null) {
            sql.VALUES("price_sum", "#{priceSum,jdbcType=DECIMAL}");
        }
        
        if (record.getIsSelected() != null) {
            sql.VALUES("is_selected", "#{isSelected,jdbcType=BIT}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ShoppingCart record) {
        SQL sql = new SQL();
        sql.UPDATE("shopping_cart");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getProductAmount() != null) {
            sql.SET("product_amount = #{productAmount,jdbcType=INTEGER}");
        }
        
        if (record.getPriceSum() != null) {
            sql.SET("price_sum = #{priceSum,jdbcType=DECIMAL}");
        }
        
        if (record.getIsSelected() != null) {
            sql.SET("is_selected = #{isSelected,jdbcType=BIT}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}