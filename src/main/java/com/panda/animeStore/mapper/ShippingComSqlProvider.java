package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShippingCom;
import org.apache.ibatis.jdbc.SQL;

public class ShippingComSqlProvider {

    public String insertSelective(ShippingCom record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("shipping_com");
        
        if (record.getComName() != null) {
            sql.VALUES("com_name", "#{comName,jdbcType=VARCHAR}");
        }
        
        if (record.getComPrice() != null) {
            sql.VALUES("com_price", "#{comPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.VALUES("phone_number", "#{phoneNumber,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ShippingCom record) {
        SQL sql = new SQL();
        sql.UPDATE("shipping_com");
        
        if (record.getComName() != null) {
            sql.SET("com_name = #{comName,jdbcType=VARCHAR}");
        }
        
        if (record.getComPrice() != null) {
            sql.SET("com_price = #{comPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{phoneNumber,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}