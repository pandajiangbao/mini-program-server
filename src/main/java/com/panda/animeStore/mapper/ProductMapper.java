package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Product;
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
public interface ProductMapper {
    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product (title, price, ",
        "sales, stock, img, ",
        "categoty_id, info)",
        "values (#{title,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{sales,jdbcType=INTEGER}, #{stock,jdbcType=INTEGER}, #{img,jdbcType=VARCHAR}, ",
        "#{categotyId,jdbcType=INTEGER}, #{info,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Product record);

    @Select({
        "select",
        "id, title, price, sales, stock, img, categoty_id, info",
        "from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="sales", property="sales", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="categoty_id", property="categotyId", jdbcType=JdbcType.INTEGER),
        @Result(column="info", property="info", jdbcType=JdbcType.LONGVARCHAR)
    })
    Product selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, title, price, sales, stock, img, categoty_id, info",
        "from product"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="sales", property="sales", jdbcType=JdbcType.INTEGER),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="categoty_id", property="categotyId", jdbcType=JdbcType.INTEGER),
        @Result(column="info", property="info", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Product> selectAll();

    @Update({
        "update product",
        "set title = #{title,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "sales = #{sales,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "img = #{img,jdbcType=VARCHAR},",
          "categoty_id = #{categotyId,jdbcType=INTEGER},",
          "info = #{info,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}