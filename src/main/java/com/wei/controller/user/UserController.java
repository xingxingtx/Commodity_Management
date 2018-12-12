package com.wei.controller.user;/**
 * Created by Administrator on 2018/11/29.
 */


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName:UserController
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/11/29 15:12
 * @Version: 1.0
 */
@Api("用户管理")
@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private DocumentationCache documentationCache;
    /**
     * 用户管理功能
     * @param
     * @param
     * @return
     */
    @RequestMapping("/user")
    @ApiOperation(value = "用户管理", httpMethod = "GET", response = String.class, notes = "用户管理操作，提供用户管理")
    public String sendEmail(@ApiParam(value = "userId", required = true ) @RequestParam( value = "userId" ) String userId,
                            HttpServletRequest request) {
        logger.info("userId:"+userId );

        return  null;
    }
    @RequestMapping("/generator/document")
    public Documentation getDocument() {
        Documentation documentation = documentationCache.documentationByGroup("default");
        System.out.println(documentation);
        return documentation;
    }

}
