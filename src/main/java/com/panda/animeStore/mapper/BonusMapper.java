package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Bonus;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
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

    @Select({
            "select",
            "id, reduce_amount, target_amount, validity",
            "from bonus"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="reduce_amount", property="reduceAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="target_amount", property="targetAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="validity", property="validity", jdbcType=JdbcType.INTEGER)
    })
    List<Bonus> selectAll();

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