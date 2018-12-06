package com.wei.mapper.user;

import com.wei.model.user.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName:UserMapper
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/5 17:39
 * @Version: 1.0
 */

@Mapper
@Component
public interface UserMapper {
    List<UserModel> selectByLoginName(UserModel model);
}
