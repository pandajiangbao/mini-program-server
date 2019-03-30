package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ProductComment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductCommentMapper {
    @Delete({
        "delete from product_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_comment (content, create_time, ",
        "good, bad, product_id, ",
        "user_id)",
        "values (#{content,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{good,jdbcType=INTEGER}, #{bad,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ProductComment record);

    @InsertProvider(type=ProductCommentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ProductComment record);

    @Select({
        "select",
        "id, content, create_time, good, bad, product_id, user_id",
        "from product_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="good", property="good", jdbcType=JdbcType.INTEGER),
        @Result(column="bad", property="bad", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    ProductComment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProductCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductComment record);

    @Update({
        "update product_comment",
        "set content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "good = #{good,jdbcType=INTEGER},",
          "bad = #{bad,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductComment record);
}