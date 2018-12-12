package com.wei.controller.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.wei.untils.define.StatusDefine;
import com.wei.untils.define.StatusDefineMessage;
import com.wei.untils.jdbc.JdbcUtils;
import com.wei.untils.jdbc.TableInfo;
import com.wei.untils.json.JsonResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName:GeneratorController
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/11 10:18
 * @Version: 1.0
 */
@Api("代码生成")
@RestController
public class GeneratorController {
    /**
     * 注入swagger
     */
     private final Logger logger = LoggerFactory.getLogger(this.getClass());
     @Autowired
     private AutoGenerator generator;
     @Autowired
     private StrategyConfig strategyConfig;
     @Autowired
     private JdbcUtils utils;


    @RequestMapping(value = "/api/generator",method = RequestMethod.GET )
    @ApiOperation(value = "代码生成", httpMethod = "GET", response = String.class,
            notes = "代码生成，供后台代码生成使用")
    public String generator(
            @ApiParam(value = "表集合") @RequestParam(required = false,value ="tableNames" ) String[] tableNames,
            @ApiParam(value = "生成代码路径") @RequestParam(required = false,value ="baseDir" ) String baseDir
            ){
        logger.debug("表集合:"+ tableNames);
        logger.debug("生成代码路径" + baseDir);
        try {
            generator.execute();
            return new JsonResponseData(true,
                    StatusDefineMessage.GetMessage(StatusDefine.SUCCESS), StatusDefine.SUCCESS,
                    "代码生成成功", null).toString();
        }catch (Exception e){
            return new JsonResponseData(false,
                    StatusDefineMessage.GetMessage(StatusDefine.FAILURE), StatusDefine.FAILURE,
                    "代码生成失败", null).toString();
        }
    }


    @RequestMapping(value = "/api/getAllTable",method = RequestMethod.GET )
    @ApiOperation(value = "获取所有表信息", httpMethod = "GET", response = String.class,
            notes = "代码生成，供后台代码生成使用")
    public String getAllTable(
            @ApiParam(required = false,value = "tableName")@RequestParam(required = false,value = "tableName")String tableName
            ){
        logger.debug("tableName"+ tableName);
        try {
            List<TableInfo> tableInfo = utils.getTableInformation(tableName);
            return new JsonResponseData(true,
                    StatusDefineMessage.GetMessage(StatusDefine.SUCCESS), StatusDefine.SUCCESS,
                    "查询成功", tableInfo).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResponseData(false,
                    StatusDefineMessage.GetMessage(StatusDefine.FAILURE), StatusDefine.FAILURE,
                    "查询成功失败", null).toString();
        }
    }


}
