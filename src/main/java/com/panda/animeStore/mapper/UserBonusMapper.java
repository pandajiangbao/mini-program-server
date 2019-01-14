package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserBonus;
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
public interface UserBonusMapper {
    @Delete({
        "delete from user_bonus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_bonus (reduce_amount, target_amount, ",
        "outdate_time, category_id, ",
        "user_id)",
        "values (#{reduceAmount,jdbcType=DECIMAL}, #{targetAmount,jdbcType=DECIMAL}, ",
        "#{outdateTime,jdbcType=TIMESTAMP}, #{categoryId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserBonus record);

    @InsertProvider(type=UserBonusSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(UserBonus record);

    @Select({
        "select",
        "id, reduce_amount, target_amount, outdate_time, category_id, user_id",
        "from user_bonus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reduce_amount", property="reduceAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="target_amount", property="targetAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="outdate_time", property="outdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    UserBonus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserBonusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserBonus record);

    @Update({
        "update user_bonus",
        "set reduce_amount = #{reduceAmount,jdbcType=DECIMAL},",
          "target_amount = #{targetAmount,jdbcType=DECIMAL},",
          "outdate_time = #{outdateTime,jdbcType=TIMESTAMP},",
          "category_id = #{categoryId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserBonus record);
}