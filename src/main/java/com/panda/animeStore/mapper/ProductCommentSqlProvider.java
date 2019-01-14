package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ProductComment;
import org.apache.ibatis.jdbc.SQL;

public class ProductCommentSqlProvider {

    public String insertSelective(ProductComment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_comment");
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGood() != null) {
            sql.VALUES("good", "#{good,jdbcType=INTEGER}");
        }
        
        if (record.getBad() != null) {
            sql.VALUES("bad", "#{bad,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProductComment record) {
        SQL sql = new SQL();
        sql.UPDATE("product_comment");
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGood() != null) {
            sql.SET("good = #{good,jdbcType=INTEGER}");
        }
        
        if (record.getBad() != null) {
            sql.SET("bad = #{bad,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}