package com.panda.animeStore.mapper;

import com.panda.animeStore.entity.UserAddress;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserAddressMapper {
    @Delete({
        "delete from user_address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

	@Delete({
			"delete from user_address",
			"where user_id = #{userId,jdbcType=INTEGER}"
	})
	int deleteAllByUserId(Integer userId);

    @Insert({
        "insert into user_address (receiver, phone_number, ",
        "province, city, ",
        "county, detail, ",
        "user_id)",
        "values (#{receiver,jdbcType=VARCHAR}, #{phoneNumber,jdbcType=VARCHAR}, ",
        "#{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
        "#{county,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserAddress record);

    @InsertProvider(type=UserAddressSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(UserAddress record);

    @Select({
        "select",
        "id, receiver, phone_number, province, city, county, detail, user_id",
        "from user_address",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="receiver", property="receiver", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="county", property="county", jdbcType=JdbcType.VARCHAR),
        @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    UserAddress selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, receiver, phone_number, province, city, county, detail, user_id",
            "from user_address",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="receiver", property="receiver", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="county", property="county", jdbcType=JdbcType.VARCHAR),
            @Result(column="detail", property="detail", jdbcType=JdbcType.VARCHAR),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<UserAddress> selectListByUserId(Integer userId);

    @UpdateProvider(type=UserAddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAddress record);

    @Update({
        "update user_address",
        "set receiver = #{receiver,jdbcType=VARCHAR},",
          "phone_number = #{phoneNumber,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "county = #{county,jdbcType=VARCHAR},",
          "detail = #{detail,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserAddress record);
}