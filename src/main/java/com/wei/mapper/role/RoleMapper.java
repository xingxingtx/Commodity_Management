package com.wei.mapper.role;

import com.wei.model.role.RoleModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:RoleMapper
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/6 10:57
 * @Version: 1.0
 */
@Component
@Mapper
public interface RoleMapper {

    List<RoleModel> selectRoleIdListByUserId(@Param("userId") Integer userId);

    List<Map<String, String>> selectResourceListByRoleId(@Param("roleId")Integer roleId);

    RoleModel selectById(@Param("roleId")Integer roleId);
}
