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
        "insert into user_bonus (created_time, expired_time, ",
        "bonus_id, user_id)",
        "values (#{createdTime,jdbcType=TIMESTAMP}, #{expiredTime,jdbcType=TIMESTAMP}, ",
        "#{bonusId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserBonus record);

    @InsertProvider(type=UserBonusSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(UserBonus record);

    @Select({
        "select",
        "id, created_time, expired_time, bonus_id, user_id",
        "from user_bonus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expired_time", property="expiredTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bonus_id", property="bonusId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    UserBonus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserBonusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserBonus record);

    @Update({
        "update user_bonus",
        "set created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "expired_time = #{expiredTime,jdbcType=TIMESTAMP},",
          "bonus_id = #{bonusId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserBonus record);
}