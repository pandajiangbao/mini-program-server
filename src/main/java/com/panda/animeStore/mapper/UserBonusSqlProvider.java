package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserBonus;
import org.apache.ibatis.jdbc.SQL;

public class UserBonusSqlProvider {

    public String insertSelective(UserBonus record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_bonus");
        
        if (record.getReduceAmount() != null) {
            sql.VALUES("reduce_amount", "#{reduceAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTargetAmount() != null) {
            sql.VALUES("target_amount", "#{targetAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOutdateTime() != null) {
            sql.VALUES("outdate_time", "#{outdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserBonus record) {
        SQL sql = new SQL();
        sql.UPDATE("user_bonus");
        
        if (record.getReduceAmount() != null) {
            sql.SET("reduce_amount = #{reduceAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTargetAmount() != null) {
            sql.SET("target_amount = #{targetAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getOutdateTime() != null) {
            sql.SET("outdate_time = #{outdateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}