package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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
        "category_id, info)",
        "values (#{title,jdbcType=VARCHAR}, #{price,jdbcType=DECIMAL}, ",
        "#{sales,jdbcType=INTEGER}, #{stock,jdbcType=INTEGER}, #{img,jdbcType=VARCHAR}, ",
        "#{categoryId,jdbcType=INTEGER}, #{info,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Product record);

    @Select({
        "select",
        "id, title, price, sales, stock, img, category_id, info",
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
        @Result(column= "category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="info", property="info", jdbcType=JdbcType.LONGVARCHAR)
    })
    Product selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, title, price, sales, stock, img, category_id, info",
            "from product"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="sales", property="sales", jdbcType=JdbcType.INTEGER),
            @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
            @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
            @Result(column= "category_id", property="categoryId", jdbcType=JdbcType.INTEGER),
            @Result(column="info", property="info", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Product> selectAll();

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set title = #{title,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "sales = #{sales,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "img = #{img,jdbcType=VARCHAR},",
          "category_id = #{categoryId,jdbcType=INTEGER},",
          "info = #{info,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Product record);

    @Update({
        "update product",
        "set title = #{title,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "sales = #{sales,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "img = #{img,jdbcType=VARCHAR},",
          "category_id = #{categoryId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}