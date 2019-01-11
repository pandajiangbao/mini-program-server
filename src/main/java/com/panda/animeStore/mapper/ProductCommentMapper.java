package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.ProductComment;
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

    @Select({
        "select",
        "id, content, create_time, good, bad, product_id, user_id",
        "from product_comment"
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
    List<ProductComment> selectAll();

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