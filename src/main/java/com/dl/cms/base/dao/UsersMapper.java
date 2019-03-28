package com.dl.cms.base.dao;

import com.dl.cms.base.model.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UsersMapper {
    @Delete({
        "delete from users",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into users (user_id, login_name, ",
        "login_pwd, nick)",
        "values (#{userId,jdbcType=INTEGER}, #{loginName,jdbcType=VARCHAR}, ",
        "#{loginPwd,jdbcType=VARCHAR}, #{nick,jdbcType=VARCHAR})"
    })
    int insert(Users record);

    @InsertProvider(type=UsersSqlProvider.class, method="insertSelective")
    int insertSelective(Users record);

    @Select({
        "select",
        "user_id, login_name, login_pwd, nick",
        "from users",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_pwd", property="loginPwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick", property="nick", jdbcType=JdbcType.VARCHAR)
    })
    Users selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=UsersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Users record);

    @Update({
        "update users",
        "set login_name = #{loginName,jdbcType=VARCHAR},",
          "login_pwd = #{loginPwd,jdbcType=VARCHAR},",
          "nick = #{nick,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Users record);
}