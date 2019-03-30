package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Admin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AdminMapper {
    @Delete({
        "delete from admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin (admin_name, password, ",
        "create_time, last_login_time)",
        "values (#{adminName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{lastLoginTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Admin record);

    @InsertProvider(type=AdminSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Admin record);

    @Select({
        "select",
        "id, admin_name, password, create_time, last_login_time",
        "from admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Admin selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, admin_name, password, create_time, last_login_time",
            "from admin",
            "where admin_name = #{userName,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Admin selectByUserName(String userName);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Admin record);

    @Update({
        "update admin",
        "set admin_name = #{adminName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "last_login_time = #{lastLoginTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);
}