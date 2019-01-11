package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.Panda;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

@Mapper
public interface PandaMapper {
    @Delete({
            "delete from panda",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into panda (date, title, ",
            "url, detail)",
            "values (#{date,jdbcType=TIMESTAMP}, #{title,jdbcType=VARCHAR}, ",
            "#{url,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Panda record);

    @Select({
            "select",
            "id, date, title, url, detail",
            "from panda",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "date", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "detail", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    Panda selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, date, title, url, detail",
            "from panda"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "date", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "url", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "detail", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<Panda> selectAll();

    @Update({
            "update panda",
            "set date = #{date,jdbcType=TIMESTAMP},",
            "title = #{title,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},",
            "detail = #{detail,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Panda record);
}