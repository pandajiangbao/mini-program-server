package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Admin;
import org.apache.ibatis.jdbc.SQL;

public class AdminSqlProvider {

    public String insertSelective(Admin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("admin");
        
        if (record.getAdminName() != null) {
            sql.VALUES("admin_name", "#{adminName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.VALUES("last_login_time", "#{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Admin record) {
        SQL sql = new SQL();
        sql.UPDATE("admin");
        
        if (record.getAdminName() != null) {
            sql.SET("admin_name = #{adminName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastLoginTime() != null) {
            sql.SET("last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}