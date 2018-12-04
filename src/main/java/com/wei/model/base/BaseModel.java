package com.wei.model.base;

import com.wei.untils.define.StatusDefine;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName:基础实体类
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/4 16:35
 * @Version: 1.0
 */
@Data
public class BaseModel implements Serializable{
    /**主键id*/
    private Integer id;
    /**创建人*/
    private String createUser;
    /**创建时间*/
    private String createTime;
    /**修改人*/
    private String updateUser;
    /**修改时间*/
    private String updateTime;
    /**状态0-删除，1-未删除*/
    private Integer state = StatusDefine.STATE_ABLE;

}
