package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Order;
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
public interface OrderMapper {
    @Delete({
        "delete from order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into order (receive_time, user_id, ",
        "payment_time, created_time, ",
        "shipping_com_id, address_id, ",
        "shipping_price, bonus_price, ",
        "total_price, order_status, ",
        "procuct_price)",
        "values (#{receiveTime,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
        "#{paymentTime,jdbcType=TIMESTAMP}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{shippingComId,jdbcType=INTEGER}, #{addressId,jdbcType=INTEGER}, ",
        "#{shippingPrice,jdbcType=DECIMAL}, #{bonusPrice,jdbcType=DECIMAL}, ",
        "#{totalPrice,jdbcType=DECIMAL}, #{orderStatus,jdbcType=VARCHAR}, ",
        "#{procuctPrice,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Order record);

    @Select({
        "select",
        "id, receive_time, user_id, payment_time, created_time, shipping_com_id, address_id, ",
        "shipping_price, bonus_price, total_price, order_status, procuct_price",
        "from order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="shipping_com_id", property="shippingComId", jdbcType=JdbcType.INTEGER),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_price", property="shippingPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="bonus_price", property="bonusPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="procuct_price", property="procuctPrice", jdbcType=JdbcType.DECIMAL)
    })
    Order selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, receive_time, user_id, payment_time, created_time, shipping_com_id, address_id, ",
        "shipping_price, bonus_price, total_price, order_status, procuct_price",
        "from order"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="payment_time", property="paymentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="shipping_com_id", property="shippingComId", jdbcType=JdbcType.INTEGER),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_price", property="shippingPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="bonus_price", property="bonusPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="procuct_price", property="procuctPrice", jdbcType=JdbcType.DECIMAL)
    })
    List<Order> selectAll();

    @Update({
        "update order",
        "set receive_time = #{receiveTime,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "payment_time = #{paymentTime,jdbcType=TIMESTAMP},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "shipping_com_id = #{shippingComId,jdbcType=INTEGER},",
          "address_id = #{addressId,jdbcType=INTEGER},",
          "shipping_price = #{shippingPrice,jdbcType=DECIMAL},",
          "bonus_price = #{bonusPrice,jdbcType=DECIMAL},",
          "total_price = #{totalPrice,jdbcType=DECIMAL},",
          "order_status = #{orderStatus,jdbcType=VARCHAR},",
          "procuct_price = #{procuctPrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}