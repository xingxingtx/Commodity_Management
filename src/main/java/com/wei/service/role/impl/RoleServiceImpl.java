package com.wei.service.role.impl;

import com.wei.mapper.role.RoleMapper;
import com.wei.model.role.RoleModel;
import com.wei.service.role.IRoleService;
import com.wei.untils.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName:RoleServiceImpl
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/12/5 14:55
 * @Version: 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Map<String, Set<String>> selectResourceMapByUserId(Integer userId) {
        Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
        List<RoleModel> roleIdList = roleMapper.selectRoleIdListByUserId(userId);
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (RoleModel role : roleIdList) {
            List<Map<String, String>> resourceList = roleMapper.selectResourceListByRoleId(role.getId());
            if (resourceList != null && !resourceList.isEmpty()) {
                for (Map<String, String> map : resourceList) {
                    if (map != null && StringUtils.isNotBlank(map.get("url"))) {
                        urlSet.add(map.get("url"));
                    }
                }
            }
            RoleModel roleModel = roleMapper.selectById(role.getId());
            if (roleModel != null) {
                roles.add(roleModel.getRoleName());
            }
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
    }
}
