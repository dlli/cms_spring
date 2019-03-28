package com.dl.cms.base.dao;

import com.dl.cms.base.model.Users;
import org.apache.ibatis.jdbc.SQL;

public class UsersSqlProvider {

    public String insertSelective(Users record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("users");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getLoginName() != null) {
            sql.VALUES("login_name", "#{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginPwd() != null) {
            sql.VALUES("login_pwd", "#{loginPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getNick() != null) {
            sql.VALUES("nick", "#{nick,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Users record) {
        SQL sql = new SQL();
        sql.UPDATE("users");
        
        if (record.getLoginName() != null) {
            sql.SET("login_name = #{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginPwd() != null) {
            sql.SET("login_pwd = #{loginPwd,jdbcType=VARCHAR}");
        }
        
        if (record.getNick() != null) {
            sql.SET("nick = #{nick,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}