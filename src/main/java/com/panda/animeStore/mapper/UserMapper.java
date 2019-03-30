package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (openid, nick_name, ",
        "gender, city, province, ",
        "country, avatar_url, ",
        "create_time)",
        "values (#{openid,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=INTEGER}, #{city,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{country,jdbcType=VARCHAR}, #{avatarUrl,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(User record);

    @Select({
        "select",
        "id, openid, nick_name, gender, city, province, country, avatar_url, create_time",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, openid, nick_name, gender, city, province, country, avatar_url, create_time",
            "from user",
            "where openid = #{openid}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
            @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
            @Result(column="gender", property="gender", jdbcType=JdbcType.INTEGER),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
            @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByOpenid(String openid);


    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set openid = #{openid,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "city = #{city,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "country = #{country,jdbcType=VARCHAR},",
          "avatar_url = #{avatarUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}