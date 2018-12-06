package com.wei.service.user.impl;

import com.wei.mapper.user.UserMapper;
import com.wei.model.user.UserModel;
import com.wei.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:UserServiceImpl
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/5 14:57
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper mapper;
    @Override
    public List<UserModel> selectByLoginName(UserModel model) {

        return mapper.selectByLoginName(model);
    }
}
