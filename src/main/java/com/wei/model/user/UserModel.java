package com.wei.model.user;

import com.wei.model.base.BaseModel;
import lombok.Data;

/**
 * @ClassName:UserModel
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/4 16:23
 * @Version: 1.0
 */
@Data
public class UserModel extends BaseModel{
    private String name;
    private String loginName;
    private String password;
    private String sex;
    private String phone;
    private String idNumber;
    /** 密码加密盐 */
    private String salt;
}
