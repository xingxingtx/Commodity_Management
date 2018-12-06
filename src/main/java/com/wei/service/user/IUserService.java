package com.wei.service.user;

import com.wei.model.user.UserModel;

import java.util.List;

/**
 * @ClassName:IUserService
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/5 14:54
 * @Version: 1.0
 */
public interface IUserService {
    List<UserModel> selectByLoginName(UserModel model);
}
