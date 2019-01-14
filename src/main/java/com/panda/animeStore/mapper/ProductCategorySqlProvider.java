package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ProductCategory;
import org.apache.ibatis.jdbc.SQL;

public class ProductCategorySqlProvider {

    public String insertSelective(ProductCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_category");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCounts() != null) {
            sql.VALUES("counts", "#{counts,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProductCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("product_category");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCounts() != null) {
            sql.SET("counts = #{counts,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}