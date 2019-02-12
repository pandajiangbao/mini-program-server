package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserStared;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserStaredMapper {
    @Delete({
            "delete from user_stared",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into user_stared (user_id, product_id, ",
            "stared_time)",
            "values (#{userId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
            "#{staredTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(UserStared record);

    @InsertProvider(type = UserStaredSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(UserStared record);

    @Select({
            "select",
            "id, user_id, product_id, stared_time",
            "from user_stared",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "stared_time", property = "staredTime", jdbcType = JdbcType.TIMESTAMP)
    })
    UserStared selectByPrimaryKey(Integer id);

    @UpdateProvider(type = UserStaredSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserStared record);

    @Update({
            "update user_stared",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "stared_time = #{staredTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserStared record);
}