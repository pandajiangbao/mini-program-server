package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserAddress;
import org.apache.ibatis.jdbc.SQL;

public class UserAddressSqlProvider {

    public String insertSelective(UserAddress record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_address");
        
        if (record.getReceiver() != null) {
            sql.VALUES("receiver", "#{receiver,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.VALUES("phone_number", "#{phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.VALUES("province", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.VALUES("city", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getCounty() != null) {
            sql.VALUES("county", "#{county,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.VALUES("detail", "#{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserAddress record) {
        SQL sql = new SQL();
        sql.UPDATE("user_address");
        
        if (record.getReceiver() != null) {
            sql.SET("receiver = #{receiver,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{phoneNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("province = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.SET("city = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getCounty() != null) {
            sql.SET("county = #{county,jdbcType=VARCHAR}");
        }
        
        if (record.getDetail() != null) {
            sql.SET("detail = #{detail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}