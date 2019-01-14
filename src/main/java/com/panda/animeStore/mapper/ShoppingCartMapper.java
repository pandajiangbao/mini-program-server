package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShoppingCart;
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
public interface ShoppingCartMapper {
    @Delete({
        "delete from shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into shopping_cart (user_id, product_amount, ",
        "price_sum, product_id, ",
        "created_time)",
        "values (#{userId,jdbcType=INTEGER}, #{productAmount,jdbcType=INTEGER}, ",
        "#{priceSum,jdbcType=DECIMAL}, #{productId,jdbcType=INTEGER}, ",
        "#{createdTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ShoppingCart record);

    @InsertProvider(type=ShoppingCartSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ShoppingCart record);

    @Select({
        "select",
        "id, user_id, product_amount, price_sum, product_id, created_time",
        "from shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column= "product_amount", property="productAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="price_sum", property="priceSum", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ShoppingCart selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ShoppingCartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShoppingCart record);

    @Update({
        "update shopping_cart",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "product_amount = #{productAmount,jdbcType=INTEGER},",
          "price_sum = #{priceSum,jdbcType=DECIMAL},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShoppingCart record);
}