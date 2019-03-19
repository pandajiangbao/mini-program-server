package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Bonus;
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
public interface BonusMapper {
    @Delete({
        "delete from bonus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into bonus (reduce_amount, target_amount, ",
        "validity)",
        "values (#{reduceAmount,jdbcType=DECIMAL}, #{targetAmount,jdbcType=DECIMAL}, ",
        "#{validity,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Bonus record);

    @InsertProvider(type=BonusSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Bonus record);

    @Select({
        "select",
        "id, reduce_amount, target_amount, validity",
        "from bonus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reduce_amount", property="reduceAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="target_amount", property="targetAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="validity", property="validity", jdbcType=JdbcType.INTEGER)
    })
    Bonus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BonusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Bonus record);

    @Update({
        "update bonus",
        "set reduce_amount = #{reduceAmount,jdbcType=DECIMAL},",
          "target_amount = #{targetAmount,jdbcType=DECIMAL},",
          "validity = #{validity,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Bonus record);
}