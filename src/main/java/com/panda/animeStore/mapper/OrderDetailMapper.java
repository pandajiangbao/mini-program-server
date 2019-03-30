package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.OrderDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDetailMapper {
    @Delete({
        "delete from order_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into order_detail (order_id, product_id, ",
        "product_title, product_amount, ",
        "product_img, product_single_price, ",
        "product_total_price)",
        "values (#{orderId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{productTitle,jdbcType=VARCHAR}, #{productAmount,jdbcType=INTEGER}, ",
        "#{productImg,jdbcType=VARCHAR}, #{productSinglePrice,jdbcType=DECIMAL}, ",
        "#{productTotalPrice,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OrderDetail record);

    @InsertProvider(type=OrderDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(OrderDetail record);

    @Select({
        "select",
        "id, order_id, product_id, product_title, product_amount, product_img, product_single_price, ",
        "product_total_price",
        "from order_detail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_title", property="productTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_amount", property="productAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="product_img", property="productImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_single_price", property="productSinglePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_total_price", property="productTotalPrice", jdbcType=JdbcType.DECIMAL)
    })
    OrderDetail selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, order_id, product_id, product_title, product_amount, product_img, product_single_price, ",
            "product_total_price",
            "from order_detail",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_title", property="productTitle", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_amount", property="productAmount", jdbcType=JdbcType.INTEGER),
            @Result(column="product_img", property="productImg", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_single_price", property="productSinglePrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="product_total_price", property="productTotalPrice", jdbcType=JdbcType.DECIMAL)
    })
    List<OrderDetail> selectByOrderId(Integer orderId);

    @UpdateProvider(type=OrderDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderDetail record);

    @Update({
        "update order_detail",
        "set order_id = #{orderId,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "product_title = #{productTitle,jdbcType=VARCHAR},",
          "product_amount = #{productAmount,jdbcType=INTEGER},",
          "product_img = #{productImg,jdbcType=VARCHAR},",
          "product_single_price = #{productSinglePrice,jdbcType=DECIMAL},",
          "product_total_price = #{productTotalPrice,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderDetail record);
}