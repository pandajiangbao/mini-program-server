package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShoppingCart;
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
public interface ShoppingCartMapper {
    @Delete({
        "delete from shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into shopping_cart (user_id, product_amout, ",
        "price_sum, product_id, ",
        "created_time)",
        "values (#{userId,jdbcType=INTEGER}, #{productAmout,jdbcType=INTEGER}, ",
        "#{priceSum,jdbcType=DECIMAL}, #{productId,jdbcType=INTEGER}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ShoppingCart record);

    @Select({
        "select",
        "id, user_id, product_amout, price_sum, product_id, created_time",
        "from shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_amout", property="productAmout", jdbcType=JdbcType.INTEGER),
        @Result(column="price_sum", property="priceSum", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ShoppingCart selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_id, product_amout, price_sum, product_id, created_time",
        "from shopping_cart"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_amout", property="productAmout", jdbcType=JdbcType.INTEGER),
        @Result(column="price_sum", property="priceSum", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ShoppingCart> selectAll();

    @Update({
        "update shopping_cart",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "product_amout = #{productAmout,jdbcType=INTEGER},",
          "price_sum = #{priceSum,jdbcType=DECIMAL},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShoppingCart record);
}