package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ShoppingCart;
import com.panda.animeStore.entity.VO.ShoppingCartVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    @Delete({
            "delete from shopping_cart",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into shopping_cart (user_id, product_amount, ",
            "price_sum, is_selected, ",
            "product_id, created_time)",
            "values (#{userId,jdbcType=INTEGER}, #{productAmount,jdbcType=INTEGER}, ",
            "#{priceSum,jdbcType=DECIMAL}, #{isSelected,jdbcType=BIT}, ",
            "#{productId,jdbcType=INTEGER}, #{createdTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(ShoppingCart record);

    @InsertProvider(type = ShoppingCartSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(ShoppingCart record);

    @Select({
            "select",
            "id, user_id, product_amount, price_sum, is_selected, product_id, created_time",
            "from shopping_cart",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_amount", property = "productAmount", jdbcType = JdbcType.INTEGER),
            @Result(column = "price_sum", property = "priceSum", jdbcType = JdbcType.DECIMAL),
            @Result(column = "is_selected", property = "isSelected", jdbcType = JdbcType.BIT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "created_time", property = "createdTime", jdbcType = JdbcType.TIMESTAMP)
    })
    ShoppingCart selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, user_id, product_amount, price_sum, is_selected, product_id, created_time",
            "from shopping_cart",
            "where product_id = #{productId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_amount", property = "productAmount", jdbcType = JdbcType.INTEGER),
            @Result(column = "price_sum", property = "priceSum", jdbcType = JdbcType.DECIMAL),
            @Result(column = "is_selected", property = "isSelected", jdbcType = JdbcType.BIT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "created_time", property = "createdTime", jdbcType = JdbcType.TIMESTAMP)
    })
    ShoppingCart selectByProductId(Integer id);

    @Select({
            "select",
            "id, user_id, product_amount, price_sum, is_selected, product_id, created_time",
            "from shopping_cart",
            "where user_id = #{user_id}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "product_amount", property = "productAmount", jdbcType = JdbcType.INTEGER),
            @Result(column = "price_sum", property = "priceSum", jdbcType = JdbcType.DECIMAL),
            @Result(column = "is_selected", property = "isSelected", jdbcType = JdbcType.BIT),
            @Result(column = "product_id", property = "productId", jdbcType = JdbcType.INTEGER),
            @Result(column = "created_time", property = "createdTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "product", column = "product_id",
                    one = @One(select = "com.panda.animeStore.mapper.ProductMapper.selectByPrimaryKey"))
    })
    List<ShoppingCartVO> selectVOByUserId(Integer userId);

    @UpdateProvider(type = ShoppingCartSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShoppingCart record);

    @Update({
            "update shopping_cart",
            " set product_amount = #{productAmount,jdbcType=INTEGER}",
             "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShoppingCart record);
}