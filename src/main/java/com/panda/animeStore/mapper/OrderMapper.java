package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Order;
import com.panda.animeStore.entity.VO.OrderVO;
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
public interface OrderMapper {
    @Delete({
        "delete from `order`",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into `order` (order_no, user_id,",
        "created_time, product_price,",
        "shipping_price, bonus_price,",
        "total_price, address_id,",
        "shipping_com_id, receive_time,",
        "order_status)",
        "values (#{orderNo,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER},",
        "#{createdTime,jdbcType=TIMESTAMP}, #{productPrice,jdbcType=DECIMAL},",
        "#{shippingPrice,jdbcType=DECIMAL}, #{bonusPrice,jdbcType=DECIMAL},",
        "#{totalPrice,jdbcType=DECIMAL}, #{addressId,jdbcType=INTEGER},",
        "#{shippingComId,jdbcType=INTEGER}, #{receiveTime,jdbcType=TIMESTAMP},",
        "#{orderStatus,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Order record);

    @Select({
        "select",
        "id, order_no, user_id, created_time, product_price, shipping_price, bonus_price, ",
        "total_price, address_id, shipping_com_id, receive_time, order_status",
        "from `order`",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="shipping_price", property="shippingPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="bonus_price", property="bonusPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.INTEGER),
        @Result(column="shipping_com_id", property="shippingComId", jdbcType=JdbcType.INTEGER),
        @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR)
    })
    Order selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, order_no, user_id, created_time, product_price, shipping_price, bonus_price, ",
            "total_price, address_id, shipping_com_id, receive_time, order_status",
            "from `order`",
            "where user_id = #{user_id}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="shipping_price", property="shippingPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="bonus_price", property="bonusPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_price", property="totalPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="address_id", property="addressId", jdbcType=JdbcType.INTEGER),
            @Result(column="shipping_com_id", property="shippingComId", jdbcType=JdbcType.INTEGER),
            @Result(column="receive_time", property="receiveTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR),
            @Result(property = "orderDetailList", column = "id",
                    many = @Many(select = "com.panda.animeStore.mapper.OrderDetailMapper.selectByOrderId"))
    })
    List<OrderVO> selectVOByUserId(Integer userId);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update order",
        "set order_no = #{orderNo,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "shipping_price = #{shippingPrice,jdbcType=DECIMAL},",
          "bonus_price = #{bonusPrice,jdbcType=DECIMAL},",
          "total_price = #{totalPrice,jdbcType=DECIMAL},",
          "address_id = #{addressId,jdbcType=INTEGER},",
          "shipping_com_id = #{shippingComId,jdbcType=INTEGER},",
          "receive_time = #{receiveTime,jdbcType=TIMESTAMP},",
          "order_status = #{orderStatus,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}