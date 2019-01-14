package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Product;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {

    public String insertSelective(Product record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product");
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getSales() != null) {
            sql.VALUES("sales", "#{sales,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getImg() != null) {
            sql.VALUES("img", "#{img,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getInfo() != null) {
            sql.VALUES("info", "#{info,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Product record) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getSales() != null) {
            sql.SET("sales = #{sales,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getImg() != null) {
            sql.SET("img = #{img,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryId() != null) {
            sql.SET("category_id = #{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getInfo() != null) {
            sql.SET("info = #{info,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}