package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserBonus;
import org.apache.ibatis.jdbc.SQL;

public class UserBonusSqlProvider {

    public String insertSelective(UserBonus record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_bonus");
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpiredTime() != null) {
            sql.VALUES("expired_time", "#{expiredTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBonusId() != null) {
            sql.VALUES("bonus_id", "#{bonusId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserBonus record) {
        SQL sql = new SQL();
        sql.UPDATE("user_bonus");
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpiredTime() != null) {
            sql.SET("expired_time = #{expiredTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBonusId() != null) {
            sql.SET("bonus_id = #{bonusId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}