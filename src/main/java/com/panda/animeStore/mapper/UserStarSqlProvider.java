package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserStar;
import org.apache.ibatis.jdbc.SQL;

public class UserStarSqlProvider {

    public String insertSelective(UserStar record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_stared");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getStarTime() != null) {
            sql.VALUES("stared_time", "#{staredTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserStar record) {
        SQL sql = new SQL();
        sql.UPDATE("user_stared");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getStarTime() != null) {
            sql.SET("stared_time = #{staredTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}