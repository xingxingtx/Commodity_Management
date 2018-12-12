package com.wei.untils.jdbc;

import lombok.Data;

import java.util.List;

/**
 * @ClassName:TableInfo
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/12 10:24
 * @Version: 1.0
 */
@Data
public class TableInfo {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表的字段属性集合
     */
    private List<TableInformation> tableInformation;
}
