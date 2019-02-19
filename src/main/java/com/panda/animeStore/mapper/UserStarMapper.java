package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserStar;
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

import java.util.List;

@Mapper
public interface UserStarMapper {
    @Delete({
            "delete from user_star",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into user_star (user_id, product_id, ",
            "star_time)",
            "values (#{userId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
            "#{starTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(UserStar record);

    @InsertProvider(type = UserStarSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(UserStar record);

    @Select({
            "select",
            "id, user_id, product_id, star_time",
            "from user_star",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "star_time", property = "starTime", jdbcType = JdbcType.TIMESTAMP)
    })
    UserStar selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, user_id, product_id, star_time",
            "from user_star",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "star_time", property = "starTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<UserStar> selectByUserId(Integer userId);

    @UpdateProvider(type = UserStarSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserStar record);

    @Update({
            "update user_star",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "star_time = #{starTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserStar record);
}