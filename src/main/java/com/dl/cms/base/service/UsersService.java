package com.dl.cms.base.service;

import com.dl.cms.base.dao.UsersMapper;
import com.dl.cms.base.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;


    public Users queryById(Integer id){
        return usersMapper.selectByPrimaryKey(id);
    }



}
