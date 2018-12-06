package com.wei.model.role;

import com.wei.model.base.BaseModel;
import lombok.Data;

/**
 * @ClassName:RoleModel
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/6 10:59
 * @Version: 1.0
 */
@Data
public class RoleModel extends BaseModel{
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色简介
     */
    private String description;
}
