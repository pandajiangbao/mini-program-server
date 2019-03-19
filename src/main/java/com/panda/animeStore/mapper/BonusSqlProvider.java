package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Bonus;
import org.apache.ibatis.jdbc.SQL;

public class BonusSqlProvider {

    public String insertSelective(Bonus record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("bonus");
        
        if (record.getReduceAmount() != null) {
            sql.VALUES("reduce_amount", "#{reduceAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTargetAmount() != null) {
            sql.VALUES("target_amount", "#{targetAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getValidity() != null) {
            sql.VALUES("validity", "#{validity,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Bonus record) {
        SQL sql = new SQL();
        sql.UPDATE("bonus");
        
        if (record.getReduceAmount() != null) {
            sql.SET("reduce_amount = #{reduceAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getTargetAmount() != null) {
            sql.SET("target_amount = #{targetAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getValidity() != null) {
            sql.SET("validity = #{validity,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}