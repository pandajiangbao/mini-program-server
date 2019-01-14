package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserStared;
import org.apache.ibatis.jdbc.SQL;

public class UserStaredSqlProvider {

    public String insertSelective(UserStared record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_stared");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getStaredTime() != null) {
            sql.VALUES("stared_time", "#{staredTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserStared record) {
        SQL sql = new SQL();
        sql.UPDATE("user_stared");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getStaredTime() != null) {
            sql.SET("stared_time = #{staredTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}