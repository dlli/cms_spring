package com.dl.cms.base.controller;

import com.dl.cms.base.model.Users;
import com.dl.cms.base.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    UsersService usersService;

    @RequestMapping("/demo/index")
    public String index(){
        Users user = usersService.queryById(1);
        logger.error(usersService.toString());
        logger.warn(usersService.toString());
        logger.info(usersService.toString());
        return "/demo/index";
    }

}
