package com.panda.springboot01helloworld.mapper;

import com.panda.springboot01helloworld.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {
    @Delete({
            "delete from user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into user (openid)",
            "values (#{openid,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(User record);

    @Select({
            "select",
            "id, openid",
            "from user",
            "where openid = #{openid,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "openid", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    User selectByOpenId(String openid);

    @Select({
            "select",
            "id, openid",
            "from user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "openid", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, openid",
            "from user"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "openid", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<User> selectAll();
}