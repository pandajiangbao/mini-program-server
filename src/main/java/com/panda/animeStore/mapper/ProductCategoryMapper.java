package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductCategoryMapper {
    @Delete({
        "delete from product_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_category (name, counts)",
        "values (#{name,jdbcType=VARCHAR}, #{counts,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ProductCategory record);

    @InsertProvider(type=ProductCategorySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ProductCategory record);

    @Select({
        "select",
        "id, name, counts",
        "from product_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="counts", property="counts", jdbcType=JdbcType.INTEGER)
    })
    ProductCategory selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, name, counts",
            "from product_category"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="counts", property="counts", jdbcType=JdbcType.INTEGER)
    })
    List<ProductCategory> selectAll();

    @UpdateProvider(type=ProductCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductCategory record);

    @Update({
        "update product_category",
        "set name = #{name,jdbcType=VARCHAR},",
          "counts = #{counts,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductCategory record);
}