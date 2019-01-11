package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShippingCom;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface ShippingComMapper {
    @Delete({
        "delete from shipping_com",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into shipping_com (com_name, com_price, ",
        "phone_number)",
        "values (#{comName,jdbcType=VARCHAR}, #{comPrice,jdbcType=DECIMAL}, ",
        "#{phoneNumber,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ShippingCom record);

    @Select({
        "select",
        "id, com_name, com_price, phone_number",
        "from shipping_com",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="com_name", property="comName", jdbcType=JdbcType.VARCHAR),
        @Result(column="com_price", property="comPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR)
    })
    ShippingCom selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, com_name, com_price, phone_number",
        "from shipping_com"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="com_name", property="comName", jdbcType=JdbcType.VARCHAR),
        @Result(column="com_price", property="comPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR)
    })
    List<ShippingCom> selectAll();

    @Update({
        "update shipping_com",
        "set com_name = #{comName,jdbcType=VARCHAR},",
          "com_price = #{comPrice,jdbcType=DECIMAL},",
          "phone_number = #{phoneNumber,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShippingCom record);
}